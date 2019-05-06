package com.aroundog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.aroundog.common.exception.DeleteFailException;
import com.aroundog.common.file.FileManager;
import com.aroundog.commons.Pager;
import com.aroundog.model.domain.FreeBoard;
import com.aroundog.model.domain.FreeComment;
import com.aroundog.model.domain.LostBoard;
import com.aroundog.model.domain.LostBoardImg;
import com.aroundog.model.domain.LostComment;
import com.aroundog.model.domain.Member;
import com.aroundog.model.domain.Type;
import com.aroundog.model.service.LostBoardService;
import com.aroundog.model.service.LostCommentService;
import com.aroundog.model.service.MemberService;
import com.aroundog.model.service.TypeService;

@Controller
public class LostBoardController {
   @Autowired
   private TypeService typeService;
   @Autowired
   private LostBoardService lostBoardService;
   @Autowired
   private LostCommentService lostCommentService;
   @Autowired
   private MemberService memberService;
   @Autowired
   private FileManager fileManager;

   private Pager pager = new Pager();

   //�� �ۼ� ���� type �޾ƿ��鼭 write page ����
   @RequestMapping(value = "/user/lostboard/write", method = RequestMethod.GET)
   public ModelAndView goWrite() {
      ModelAndView mav = new ModelAndView("user/lostboard/write");
      List<Type> typeList = typeService.selectAll();
      mav.addObject("typeList", typeList);
      return mav;
   }
   //write���������� �Խñ� ��� 
   @RequestMapping(value = "/user/lostboard", method = RequestMethod.POST)
   public String insert(LostBoard lostBoard, LostBoardImg lostBoardImg, Type type, HttpServletRequest request) {
      lostBoard.setType(type);
      MultipartFile[] myFile = lostBoard.getMyFile();
      String realPath = request.getServletContext().getRealPath("/data");
      lostBoardService.insert(lostBoard);
      lostBoardService.insertImg(myFile, lostBoard, realPath);
      return "redirect:/user/lostboard/lostboardlist";
   }

   //�Խ��� ����Ʈ
   @RequestMapping(value = "/user/lostboard/lostboardlist", method = RequestMethod.GET)
   public ModelAndView goIndex(HttpServletRequest request) {
      List<LostBoard> lostBoardList = lostBoardService.selectAll();// ����Ʈ������
      List keyWordList = lostBoardService.getKeyWordList(lostBoardList);
      List<LostBoardImg> thumbList = (List) keyWordList.get(0);
      List<Integer> idList = (List) keyWordList.get(1);
      List lcList = lostCommentService.selectAll();
      pager.init(request, lostBoardList.size());
      
      for(int i=0;i<lostBoardList.size();i++) {
         LostBoard   lostBoard=(LostBoard)lostBoardList.get(i);
         int member_id=lostBoard.getMember_id();
         if(lostBoard.getMember_id()!=0) {
            Member member=memberService.select(member_id);
            lostBoard.setMember(member); 
         }
      }
      
      ModelAndView mav = new ModelAndView("user/lostboard/lostboardlist");
      mav.addObject("lcList", lcList);
      mav.addObject("pager", pager);
      mav.addObject("thumbList", thumbList);
      mav.addObject("idList", idList);
      mav.addObject("lostBoardList", lostBoardList);
      return mav;
   }

   //�Խñ� �󼼺���
   @RequestMapping(value = "/user/lostboard/lostboarddetail/{lostboard_id}", method = RequestMethod.GET)
   public ModelAndView select(@PathVariable("lostboard_id") int lostboard_id) {
     List lcList = new ArrayList();
      ModelAndView mav = new ModelAndView("user/lostboard/lostboarddetail");
      LostBoard lostBoard = lostBoardService.select(lostboard_id);
      lostBoardService.update(lostboard_id);//��ȸ�� ++
         
      List<LostBoardImg> imgList = lostBoardService.selectImg(lostboard_id);
      List alllcList = lostCommentService.selectAll();
      
     int member_id = lostBoard.getMember().getMember_id(); 
     Member member = memberService.select(member_id);
     for(int i=0;i<alllcList.size();i++) { 
           LostComment lostComment = (LostComment)alllcList.get(i);
           if(lostComment.getMember_id()!=0) {
              if(lostComment.getLostboard_id()==lostboard_id) { 
                 member_id = lostComment.getMember_id();              
                 member=memberService.select(member_id);
                 lostComment.setMember(member);
                 lcList.add(lostComment);
              }
           }
        }
       
       mav.addObject("lostBoard", lostBoard);
       mav.addObject("imgList", imgList);
       mav.addObject("lcList",lcList);
       return mav;
   }
   
   //��� ��� �� �ٽ� ����������
   @RequestMapping(value="/user/lostboard/detail/regist/{lostboard_id}", method=RequestMethod.GET)
   public ModelAndView registAndDetail(@PathVariable("lostboard_id") int lostboard_id) {
      List lcList = new ArrayList();
      LostBoard lostBoard=lostBoardService.select(lostboard_id);
      int member_id=lostBoard.getMember().getMember_id();
      Member member=memberService.select(member_id);
      
      lostBoard.setMember(member);
      List<LostBoardImg> imgList = lostBoardService.selectImg(lostboard_id);
      List alllcList=lostCommentService.selectAll();
      
      for(int i=0;i<alllcList.size();i++) {
         LostComment lostComment=(LostComment)alllcList.get(i);
         if(lostComment.getLostboard_id()==lostboard_id) {
            member_id=lostComment.getMember_id();
            member=memberService.select(member_id);
            lostComment.setMember(member);
            lcList.add(lostComment);
         }
      }   
      ModelAndView mav = new ModelAndView("user/lostboard/lostboarddetail");
      mav.addObject("lostBoard", lostBoard);
      mav.addObject("lcList", lcList);
      mav.addObject("imgList",imgList);
      return mav;
   }
   
   //�Խñ� 1�� ���� + �ش� �Խñ��� ��� ����
   @RequestMapping(value = "/user/lostboard/lostboarddetail/delete/{lostboard_id}", method = RequestMethod.GET)
   public String delete(@PathVariable("lostboard_id") int lostboard_id, HttpServletRequest request) {
      String realPath = request.getServletContext().getRealPath("/data");
      List<LostBoardImg> oriList = lostBoardService.selectImg(lostboard_id);
      List list = lostCommentService.select(lostboard_id);
      lostBoardService.delete(lostboard_id);
      lostBoardService.deleteImg(lostboard_id,oriList,realPath);
      if(list.size()!=0) {
         lostCommentService.deleteByLostBoardId(lostboard_id);
      }
      return "redirect:/user/lostboard/lostboardlist";
   }

   //���� ������ �������� �غ� + ��������������
   @RequestMapping(value="/user/lostboard/lostboarddetail/update/{lostboard_id}",method=RequestMethod.GET)
   public ModelAndView goEdit(@PathVariable("lostboard_id") int lostboard_id) {
      ModelAndView mav = new ModelAndView("user/lostboard/edit");
      LostBoard lostboard = lostBoardService.select(lostboard_id);
      List<Type> typeList = typeService.selectAll();
      mav.addObject("lostboard_id", lostboard_id);
      mav.addObject("typeList", typeList);
      mav.addObject("lostBoard", lostboard);
      return mav;
   }

   //�������������� ���� �� ����������
   @RequestMapping(value = "/user/lostboard/edit", method = RequestMethod.POST)
   public String doEdit(LostBoard lostBoard, LostBoardImg lostBoardImg, Type type, HttpServletRequest request) {
      lostBoard.setType(type);
      MultipartFile[] myFile = lostBoard.getMyFile();
      String realPath = request.getServletContext().getRealPath("/data");
      int lostboard_id = lostBoard.getLostboard_id();
      List<LostBoardImg> oriList = lostBoardService.selectImg(lostboard_id);
      lostBoardService.updateLostBoard(lostBoard);
      lostBoardService.updateLostBoardImg(myFile,oriList,lostBoard,realPath,lostboard_id);   
      return "redirect:/user/lostboard/lostboarddetail/"+lostboard_id;
   }

   /*-----------------------------------------������ : �ӽú�ȣ �Խ���------------------------------------------------*/
   // ������ : �ӽú�ȣ ����Ʈ ��û
   @RequestMapping(value = "/admin/lostboardList", method = RequestMethod.GET)
   public ModelAndView lostboardList(@RequestParam(value="currentPage", defaultValue="1" , required=false) int currentPage, HttpServletRequest request) {
      List lostboardList= lostBoardService.selectAll();
      pager.init(request, lostboardList.size());
      ModelAndView mav= new ModelAndView("admin/lostboard/index");
      mav.addObject("lostboardList", lostboardList);
      mav.addObject("pager", pager);
      return mav;
   }
   
   // ������ : �ӽú�ȣ�� 1�� �˻�
   @RequestMapping(value="/admin/lostboardSearch", method=RequestMethod.GET)
   public ModelAndView lostboardSearchId(int lostboard_id) {
      LostBoard lostboardSearch= lostBoardService.select(lostboard_id);
      ModelAndView mav= new ModelAndView("admin/lostboard/index");
      mav.addObject("lostboardSearch", lostboardSearch);
      return mav;
   }
   
   // ������ : �Խñ� 1�� �󼼺���
   @RequestMapping(value="/admin/lostboard", method=RequestMethod.GET)
   public ModelAndView lostboardDetail(int lostboard_id) {
      LostBoard lostboard= lostBoardService.select(lostboard_id);
      List lostCommentList = lostCommentService.select(lostboard_id);
      
      ModelAndView mav= new ModelAndView("admin/lostboard/detail");
      mav.addObject("lostboard", lostboard);
      mav.addObject("lostCommentList", lostCommentList);
      return mav;
   }
   
   @RequestMapping(value="/admin/lostboardDelete/{lostboard_id}", method=RequestMethod.GET)
   @ResponseBody
   public String deleteAll(@PathVariable("lostboard_id") int lostboard_id) {
      System.out.println("�ӽú�ȣ �Խ��� deleteAll ȣ��");
 
      // serviceImpl���� Ʈ����� ó����
      lostBoardService.deleteTransaction(lostboard_id);
      
      return "{\"resultCode\":1,\"msg\":\"���� ����\"}";
   }
   
   /*---------------------------------------------����ó��-------------------------------------------------------------*/

   @ExceptionHandler(DeleteFailException.class)
      public ModelAndView lostboardDeleteFail(DeleteFailException e) {
         ModelAndView mav = new ModelAndView("admin/error/lostboardError");
         mav.addObject("err", e.getMessage());
         return mav;
      }
}