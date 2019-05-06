package com.aroundog.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//================������ ����===================
	//��� ��Ϻ���
	/*
	 * @RequestMapping(value="/admin/member/list", method=RequestMethod.GET) public
	 * ModelAndView showMemberList() { System.out.println("/admin/member/list");
	 * List memberList=memberService.selectAll(); ModelAndView mav=new
	 * ModelAndView(); mav.setViewName("admin/member/index");
	 * //admin/member/index.jsp mav.addObject("memberList", memberList); return mav;
	 * }
	 */
	
	//��� �� ����
	@RequestMapping(value="/admin/member/detail", method=RequestMethod.GET)
	public ModelAndView detail(int member_id) {
		System.out.println("�Ѱ��� member_id "+member_id);
		Member member=memberService.select(member_id);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("admin/member/detail");
		mav.addObject("member", member);
		return mav;
	}		
	//��� ����
	@RequestMapping(value="/admin/member/edit", method=RequestMethod.POST)
	public ModelAndView edit(Member member) {
		memberService.update(member);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("admin/member/detail");
		mav.addObject("member", member);
		return mav;
	}
	//��� ����
	@RequestMapping(value="/admin/member/delete", method=RequestMethod.GET)
	public String del(int member_id) {
		memberService.delete(member_id);
		return "redirect:/admin/memberList";
	}
	
	//================���� ����===================
	//��� ����
	@RequestMapping(value="/user/member/regist", method=RequestMethod.POST)
	public String regist(Member member) {
		memberService.insert(member);
		return "redirect:/user/login/login.jsp"; //ȸ�� ���� �Ϸ� �������� ���� �ϴ°� ���??.jsp..�񵿱�..
	}
	//�ߺ����� Ȯ��
	@RequestMapping(value="/user/member/idCheck", method=RequestMethod.POST)
	public String idCheck(String id) {
		memberService.idCheck(id);
		return ""; //�񵿱�� ����Ʈ.. "��밡���� ���̵� �Դϴ�."
	}
	
	//��� �α��� ��û
	@RequestMapping(value="/user/member/login", method=RequestMethod.POST)
	public String Login(Member member, HttpServletRequest request) {
		Member obj=memberService.loginCheck(member);
		request.getSession().setAttribute("member", obj); //obj�� �α��� ������ member�̴�.
		return "redirect:/user/main";
	}
	
	//��� �α׾ƿ� ��û
	@RequestMapping(value="/user/member/logout", method=RequestMethod.GET)
	public String Logout() {
		return "redirect:/user/login/logout.jsp";
	}
	
	
	
	//================����ó��===================
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
