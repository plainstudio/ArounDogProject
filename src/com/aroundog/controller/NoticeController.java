package com.aroundog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aroundog.commons.Pager;
import com.aroundog.model.domain.FreeComment;
import com.aroundog.model.domain.Notice;
import com.aroundog.model.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	private Pager pager=new Pager();
	//�������� ������ ��������
	@RequestMapping(value="/user/notices",method=RequestMethod.GET)
	public ModelAndView freeBoardChangePage(@RequestParam(value="currentPage", defaultValue="1" , required=false) int currentPage,HttpServletRequest request) {	
		ModelAndView mav = new ModelAndView("user/notice/notice");
		List noticeList=noticeService.selectAll();
		pager.init(request, noticeList.size());			
		mav.addObject("noticeList", noticeList);
		mav.addObject("pager", pager);
		return mav;
	}
	//�����Խ��� �󼼺���
	@RequestMapping(value="/user/notice/detail/{notice_id}", method=RequestMethod.GET)
	public ModelAndView detail(@PathVariable("notice_id") int notice_id) {
		noticeService.updateHitCnt(notice_id);//��Ʈī���� �ø���
		Notice notice=noticeService.select(notice_id);	
		ModelAndView mav = new ModelAndView("user/notice/detail");
		mav.addObject("notice", notice);
		return mav;
	}
	
}
