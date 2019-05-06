package com.aroundog.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import com.aroundog.common.exception.DeleteFailException;
import com.aroundog.common.exception.EditFailException;
import com.aroundog.common.exception.RegistFailException;
import com.aroundog.common.exception.UserNotFoundException;
import com.aroundog.model.domain.Admin;
import com.aroundog.model.domain.Member;
import com.aroundog.model.service.AdminService;
import com.aroundog.model.service.MemberService;

@RestController
@RequestMapping("/rest")
public class RestMemberController {
	@Autowired
	private MemberService memberService;
	
	//��� ����
	@RequestMapping(value="/uesr/member/regist", method=RequestMethod.POST)
	public String regist(Member member) {
		memberService.insert(member);
		return "result:1"; //ȸ�� ���� �Ϸ� �������� ���� �ϴ°� ���??.jsp
	}
	
	//��� �α��� ��û
	@RequestMapping(value="/user/member/login", method=RequestMethod.POST)
	public String Login(Member member, HttpServletRequest request) {
		Member obj=memberService.loginCheck(member);
		request.getSession().setAttribute("member", obj); //obj�� �α��� ������ member�̴�.
		return "redirect:/user/about.jsp";
	}
	
	
	
	//��� ��Ϻ���================��������������...===================
	@RequestMapping(value="/member/list", method=RequestMethod.GET)
	public ModelAndView showMemberList() {
		System.out.println("/member/listȣ��");
		List memberList=memberService.selectAll();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("admin/member/index"); //admin/member/index.jsp
		mav.addObject("memberList", memberList);
		return mav; //List<Member> memberList=(List)request.getParameter("memberList");
	}
	//��� �� ����
	@RequestMapping(value="/admin/member/detail", method=RequestMethod.GET)
	public ModelAndView detail(int member_id) {
		System.out.println("/admin/member/detail");
		System.out.println("list���� �Ѱܹ��� member_id:"+member_id);
		Member member=memberService.select(member_id);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("admin/member/detail");
		mav.addObject("member", member);
		return mav; //Member member=request.getParameter("member");
	}		
	//��� ����
	@RequestMapping(value="/admin/member/edit", method=RequestMethod.POST)
	public ModelAndView edit(Member member) {
		System.out.println("/admin/member/edittȣ��");
		memberService.update(member);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("admin/member/detail");
		mav.addObject("member", member);
		return mav;
	}
	//��� ����
	@RequestMapping(value="/admin/member/delete", method=RequestMethod.GET)
	public String del(int member_id) {
		System.out.println("/admin/member/delete ȣ��");
		memberService.delete(member_id);
		return "redirect:/member/list";
	}
	
	//����ó��
	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView handleException(UserNotFoundException e) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("err", e);
		System.out.println("UserNotFoundException�߻�!!");
		return mav;
	}
	@ExceptionHandler(RegistFailException.class)
	public ModelAndView registException(RegistFailException e) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("err", e);
		return mav;
	}
	@ExceptionHandler(EditFailException.class)
	public ModelAndView editException(EditFailException e) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("err", e);
		return mav;
	}
	@ExceptionHandler(DeleteFailException.class)
	public ModelAndView deleteException(DeleteFailException e) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("err", e);
		return mav;
	}
}
