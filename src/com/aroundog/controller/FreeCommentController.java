package com.aroundog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aroundog.model.domain.FreeComment;
import com.aroundog.model.service.FreeCommentService;

@Controller
public class FreeCommentController {
	@Autowired
	private FreeCommentService freeCommentService;
	
	
	//�����Խ���  ���  ����ϱ�~
	@RequestMapping(value="/user/freecomment/regist", method=RequestMethod.POST)
	public String freeBoardCommentRegist(FreeComment freeComment) {
		int freeboard_id2=freeComment.getFreeboard_id();
		List<FreeComment> free=freeCommentService.select(freeboard_id2);
		System.out.println(free);
		if(free==null) {	
			System.out.println("ù���");
			freeCommentService.insertFirst(freeComment);
		}else {
			System.out.println("�������");
			freeCommentService.insert(freeComment);
		}
		int freeboard_id=freeComment.getFreeboard_id();
		return "redirect:/user/freeboard/detail/regist/"+freeboard_id;
	}
	
	//�����Խ���  ����� ���  ����ϱ�~
	@RequestMapping(value="/user/freecomment/add", method=RequestMethod.POST)
	public String freeBoardCommentAdd(FreeComment freeComment) {
		freeCommentService.commentAdd(freeComment);
		int freeboard_id=freeComment.getFreeboard_id();
		return "redirect:/user/freeboard/detail/regist/"+freeboard_id;
	}
	
	//��� team���� ����
	@RequestMapping(value="/user/freecomment/del/{team}", method=RequestMethod.GET)
	public String freeCommentDelByTeam(FreeComment freeComment,@PathVariable("team") int team) {
		freeCommentService.deleteByTeam(freeComment);
		return "redirect:/user/freeboard/detail/"+freeComment.getFreeboard_id();//�ش� �Խ������� �̵��ؾ���/user/freeboard/detail/{freeboard_id}
	}
	
	//����� ��� �Ѱ� ����
	@RequestMapping(value="/user/freecommentreply/del/{freecomment_id}", method=RequestMethod.GET)
	public String freeCommentDelByCommentId(int freeboard_id,@PathVariable("freecomment_id") int freecomment_id) {
		freeCommentService.deleteByCommentId(freecomment_id);
		return "redirect:/user/freeboard/detail/"+freeboard_id;
	}
}
