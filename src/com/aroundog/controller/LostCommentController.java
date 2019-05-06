package com.aroundog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aroundog.model.domain.FreeComment;
import com.aroundog.model.domain.LostComment;
import com.aroundog.model.service.LostCommentService;

@Controller
public class LostCommentController {
   @Autowired
   private LostCommentService lostCommentService;

   @RequestMapping(value="/user/lostboardcomment/write", method=RequestMethod.POST)
   //��� ���
   public String lostBoardCommentRegist(LostComment lostComment) {
//      lostCommentService.insert(lostComment);
//      int lostboard_id=lostComment.getLostboard_id();
//      return "redirect:/user/lostboard/lostboarddetail/"+lostboard_id;
      
      int lostboard_id2=lostComment.getLostboard_id();
		List<LostComment> free=lostCommentService.selectByboardId(lostboard_id2);
		System.out.println(free);
		if(free==null) {	
			System.out.println("ù���");
			lostCommentService.insertFirst(lostComment);
		}else {
			System.out.println("�������");
			lostCommentService.insert(lostComment);
		}
		int lostboard_id=lostComment.getLostboard_id();
		return "redirect:/user/lostboard/lostboarddetail/"+lostboard_id;
      
      
   }
   
   //����� ��� ���
   @RequestMapping(value="/user/lostcomment/add", method=RequestMethod.POST)
   public String lostCommentAdd(LostComment lostComment) {
      lostCommentService.commentAdd(lostComment);
      int lostboard_id=lostComment.getLostboard_id();
      return "redirect:/user/lostboard/detail/regist/"+lostboard_id;
   }
   
   //���delete by team
   @RequestMapping(value="/user/lostcomment/del/{team}", method=RequestMethod.GET)
   public String lostCommentDelByTeam(LostComment lostcomment,@PathVariable("team") int team) {
      lostCommentService.deleteByTeam(lostcomment);
      return "redirect:/user/lostboard/lostboarddetail/"+lostcomment.getLostboard_id();      
   }
   //���delete by comment_id
   @RequestMapping(value="/user/lostcommentreply/del/{lostcomment_id}", method=RequestMethod.GET)
   public String lostCommentDelByCommentId(int lostboard_id,@PathVariable("lostcomment_id") int lostcomment_id) {
      lostCommentService.deleteByCommentId(lostcomment_id);
      return "redirect:/user/lostboard/lostboarddetail/"+lostboard_id;
   }
   
}