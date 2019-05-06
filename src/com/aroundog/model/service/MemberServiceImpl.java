package com.aroundog.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aroundog.common.exception.DeleteFailException;
import com.aroundog.common.exception.EditFailException;
import com.aroundog.common.exception.LoginFailException;
import com.aroundog.common.exception.RegistFailException;
import com.aroundog.common.exception.UserNotFoundException;
import com.aroundog.common.file.FileManager;
import com.aroundog.common.file.ReNameSercurity;
import com.aroundog.model.domain.Member;
import com.aroundog.model.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	@Qualifier("mybatisMemberDAO")
	private MemberDAO memberDAO;
	//��й�ȣ ��ȣȭ
	private ReNameSercurity rs = new ReNameSercurity();
	
	//���̵� �ߺ� üũ
		public Member idCheck(String id) throws RegistFailException{
			Member user=memberDAO.idCheck(id);
			if(user!=null) {
				throw new RegistFailException("�ߺ��� ���̵� �Դϴ�.");
			}
			return user;
		}
		
	//��� �α��� üũ
	public Member loginCheck(Member member) throws LoginFailException{
		String pass=rs.textToHash(member.getPass());
		member.setPass(pass);
		Member user=memberDAO.loginCheck(member);
		if(user==null) {
			throw new LoginFailException("�α��� ����! ����Ȯ�� �����Դϴ�.");
		}
		return user;
	}
	
	//�̸����� �����ȸ
	public Member selectByName(String name) {
		Member member=memberDAO.selectByName(name);
		return member;
	}
	
	//CRUD
	public List selectAll() {
		return memberDAO.selectAll();
	}
	
	public Member select(int member_id) throws UserNotFoundException{
		Member member=memberDAO.select(member_id);
		if(member==null) {
			throw new UserNotFoundException("�������� �ʴ� �����Դϴ�.");
		}
		return memberDAO.select(member_id); //����ó�� �� ��� �ϱ�.. 0��ȯ..
	}

	public void insert(Member member) throws RegistFailException{
		String pass=rs.textToHash(member.getPass());
		member.setPass(pass);
		int result=memberDAO.insert(member);
			if(result==0) {
				throw new RegistFailException(" ����� ��ϵ��� �ʾҽ��ϴ�.");
			}
	}

	public void update(Member member) throws EditFailException{
		String pass=rs.textToHash(member.getPass());
		member.setPass(pass);
		int result=memberDAO.update(member);
		if(result==0) {
			throw new EditFailException("��� ���� ���� ����");
		}
	}
	public void delete(int member_id) throws DeleteFailException{
		int result=memberDAO.delete(member_id);
		if(result==0) {
			throw new DeleteFailException("��� ���� ����");
		}
	}



}
