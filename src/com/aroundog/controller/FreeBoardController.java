package com.aroundog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aroundog.common.exception.EditFailException;
import com.aroundog.commons.Pager;
import com.aroundog.model.domain.FreeBoard;
import com.aroundog.model.domain.FreeComment;
import com.aroundog.model.domain.Member;
import com.aroundog.model.service.FreeBoardService;
import com.aroundog.model.service.FreeCommentService;
import com.aroundog.model.service.MemberService;

@Controller
public class FreeBoardController {

	@Autowired
	private FreeBoardService freeBoardService;
	@Autowired
	private FreeCommentService freeCommentService;
	@Autowired
	private MemberService memberService;
	private Pager pager=new Pager();
	
	
	//�����Խ��� ������ ��������
	@Transactional("transactionManager")
	@RequestMapping(value="/user/freeboards",method=RequestMethod.GET)
	public ModelAndView freeBoardChangePage(@RequestParam(value="currentPage", defaultValue="1" , required=false) int currentPage,HttpServletRequest request) {	
		ModelAndView mav = new ModelAndView("user/freeboard/freeboard");
		List freeboardList=freeBoardService.selectAll();
		List fcList=freeCommentService.selectAll();
		pager.init(request, freeboardList.size());
		
		for(int i=0;i<freeboardList.size();i++) {
			FreeBoard freeBoard=(FreeBoard)freeboardList.get(i);
			int member_id=freeBoard.getMember_id();
			Member member=memberService.select(member_id);
			freeBoard.setMember(member);
		}
		
		mav.addObject("freeBoardList", freeboardList);
		mav.addObject("fcList", fcList);
		mav.addObject("pager", pager);
		return mav;
	}
	

	//�����Խ��ǿ��� �۵������ ȭ�� ��ȯ
	@RequestMapping(value="/freeboard/insert", method=RequestMethod.GET)
	public String insert() {		
		return "user/freeboard/regist";
	}
	
	//�����Խ��� ������ ����  Ʈ����� ó�� �ʿ�
	@Transactional("transactionManager")
	@RequestMapping(value="/user/freeboard/detail/{freeboard_id}", method=RequestMethod.GET)
	public ModelAndView detail(@PathVariable("freeboard_id") int freeboard_id) {
		List fcList = new ArrayList();
		freeBoardService.updateHitCnt(freeboard_id);//��Ʈī���� �ø���
		FreeBoard freeboard=freeBoardService.select(freeboard_id);
		List freeboardList=freeBoardService.selectAll();
		//���忡 ��� ���
		int member_id=freeboard.getMember_id();
		Member member=memberService.select(member_id);
		freeboard.setMember(member);
		
		List allfcList=freeCommentService.selectAll();
		
		//�� ���忡 ��� ��󳻱� ���Ͽ�
		for(int i=0;i<allfcList.size();i++) {
			FreeComment freeComment=(FreeComment)allfcList.get(i);
			if(freeComment.getFreeboard_id()==freeboard_id) {
				member_id=freeComment.getMember_id();
				member=memberService.select(member_id);
				freeComment.setMember(member);
				fcList.add(freeComment);
			}
		}	
		ModelAndView mav = new ModelAndView("user/freeboard/detail");
		mav.addObject("freeboard", freeboard);
		mav.addObject("fcList", fcList);
		mav.addObject("freeboardList", freeboardList);
		return mav;
	}
	
	
	//�����Խ��� �󼼿��� ��� ��� �� �ٽ� ��â����  Ʈ����� ó�� �ʿ�
	@Transactional("transactionManager")
	@RequestMapping(value="/user/freeboard/detail/regist/{freeboard_id}", method=RequestMethod.GET)
	public ModelAndView registAndDetail(@PathVariable("freeboard_id") int freeboard_id) {
		List fcList = new ArrayList();
		FreeBoard freeboard=freeBoardService.select(freeboard_id);
		//���忡 ��� ���
		int member_id=freeboard.getMember_id();
		Member member=memberService.select(member_id);
		freeboard.setMember(member);
		List freeboardList=freeBoardService.selectAll();
		List allfcList=freeCommentService.selectAll();
		
		//�� ���忡 ��� ��󳻱� ���Ͽ�
		for(int i=0;i<allfcList.size();i++) {
			FreeComment freeComment=(FreeComment)allfcList.get(i);
			if(freeComment.getFreeboard_id()==freeboard_id) {
				member_id=freeComment.getMember_id();
				member=memberService.select(member_id);
				freeComment.setMember(member);
				fcList.add(freeComment);
			}
		}	
		ModelAndView mav = new ModelAndView("user/freeboard/detail");
		mav.addObject("freeboard", freeboard);
		mav.addObject("fcList", fcList);
		mav.addObject("freeboardList", freeboardList);
		return mav;
	}
	
	//�����Խ��� ����ϱ�~
	@RequestMapping(value="/user/freeboard/regist", method=RequestMethod.POST)
	public String freeBoardRegist(FreeBoard freeboard) {
		freeBoardService.insert(freeboard);
		return "redirect:/user/freeboards";//����Ʈ�� �̵�
	}
	
	//�����Խ��� �Ѱ� �����ϱ� �ؿ� ��۵� �� ��������~(ĳ��ĳ�̵�� �ѹ濡 ����� ������ ������ ����Ű�� ���� ���س��� �ϳ��ϳ� ���������)
	//���߿� �����ϸ� ����������ۿ��� sql cascade�� �����ϸ� ��
	@Transactional("transactionManager")
	@RequestMapping(value="/user/freeboard/del/{freeboard_id}", method=RequestMethod.GET)
	public String freeBoardDel(@PathVariable("freeboard_id") int freeboard_id) {
		freeBoardService.delete(freeboard_id); //�����Խ��� �Ѱǻ���
		freeCommentService.deleteByFreeboardId(freeboard_id); //�����Խ��� �ؿ� ��� ����
		return "redirect:/user/freeboards";//����Ʈ�� �̵�
	}
	
	//�Ѱ� �����ϱ� ���� edit.jsp�� �������� ��Ƽ� �̵�
	@Transactional("transactionManager")
	@RequestMapping(value="/user/freeboard/edit/{freeboard_id}", method=RequestMethod.GET)
	public ModelAndView freeBoardEditPage(@PathVariable("freeboard_id") int freeboard_id) {
		ModelAndView mav = new ModelAndView("user/freeboard/edit");
		FreeBoard freeboard=freeBoardService.select(freeboard_id);
		int member_id=freeboard.getMember_id();
		Member member=memberService.select(member_id);
		freeboard.setMember(member);
		mav.addObject("freeboard", freeboard);
		return mav;//����Ʈ�� �̵�
	}
	//�����ϱ�
	@RequestMapping(value="/user/freeboard/edit", method=RequestMethod.POST)
	public String freeBoardEdit(FreeBoard freeboard) {
		int freeboard_id=freeboard.getFreeboard_id();
		freeBoardService.update(freeboard);
		return "redirect:/user/freeboard/detail/regist/"+freeboard_id;//����Ʈ�� �̵�
	}
	
	//�˻��ϱ�(����)
	@Transactional("transactionManager")
	@RequestMapping(value="/user/freeboard/searchTitle", method=RequestMethod.GET)
	public ModelAndView freeBoardSearchTitle(String category,String searchword,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("user/freeboard/freeboard");
		System.out.println(searchword);
		List searchList=null;
		List fcList=freeCommentService.selectAll();

		searchList=freeBoardService.selectByTitle(searchword);

		pager.init(request, searchList.size());
		for(int i=0;i<searchList.size();i++) {
			FreeBoard freeBoard=(FreeBoard)searchList.get(i);
			int member_id=freeBoard.getMember_id();
			Member member=memberService.select(member_id);
			freeBoard.setMember(member);
		}
		mav.addObject("freeBoardList", searchList);
		mav.addObject("fcList", fcList);
		mav.addObject("pager", pager);
		
		return mav;
	}
	
	//�˻��ϱ�(�ۼ���)
	@Transactional("transactionManager")
	@RequestMapping(value="/user/freeboard/searchWriter", method=RequestMethod.GET)
	public ModelAndView freeBoardSearchWriter(String category,String searchword,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("user/freeboard/freeboard");
		Member member=memberService.selectByName(searchword);
		List searchList=null;
		List fcList=freeCommentService.selectAll();
		int member_id=member.getMember_id();
		searchList=freeBoardService.selectByWriter(member_id);


		pager.init(request, searchList.size());
		for(int i=0;i<searchList.size();i++) {
			FreeBoard freeBoard=(FreeBoard)searchList.get(i);
			member_id=freeBoard.getMember_id();
			member=memberService.select(member_id);
			freeBoard.setMember(member);
		}
		mav.addObject("freeBoardList", searchList);
		mav.addObject("fcList", fcList);
		mav.addObject("pager", pager);
		
		return mav;
	}

	@ExceptionHandler(EditFailException.class)
	public ModelAndView freeBoardEditFail(EditFailException e) {
		ModelAndView mav= new ModelAndView("admin/error/lostError");
		mav.addObject("err", e.getMessage());
		return mav;
	}
	 
	
}
