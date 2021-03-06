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
	//비밀번호 암호화
	private ReNameSercurity rs = new ReNameSercurity();
	
	//아이디 중복 체크
		public Member idCheck(String id) throws RegistFailException{
			Member user=memberDAO.idCheck(id);
			if(user!=null) {
				throw new RegistFailException("중복된 아이디 입니다.");
			}
			return user;
		}
		
	//멤버 로그인 체크
	public Member loginCheck(Member member) throws LoginFailException{
		String pass=rs.textToHash(member.getPass());
		member.setPass(pass);
		Member user=memberDAO.loginCheck(member);
		if(user==null) {
			throw new LoginFailException("로그인 실패! 부정확한 정보입니다.");
		}
		return user;
	}
	
	//이름으로 멤버조회
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
			throw new UserNotFoundException("존재하지 않는 유저입니다.");
		}
		return memberDAO.select(member_id); //예외처리 할 사람 하기.. 0반환..
	}

	public void insert(Member member) throws RegistFailException{
		String pass=rs.textToHash(member.getPass());
		member.setPass(pass);
		int result=memberDAO.insert(member);
			if(result==0) {
				throw new RegistFailException(" 멤버가 등록되지 않았습니다.");
			}
	}

	public void update(Member member) throws EditFailException{
		String pass=rs.textToHash(member.getPass());
		member.setPass(pass);
		int result=memberDAO.update(member);
		if(result==0) {
			throw new EditFailException("멤버 정보 수정 실패");
		}
	}
	public void delete(int member_id) throws DeleteFailException{
		int result=memberDAO.delete(member_id);
		if(result==0) {
			throw new DeleteFailException("멤버 삭제 실패");
		}
	}



}
