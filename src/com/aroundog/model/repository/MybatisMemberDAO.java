
package com.aroundog.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aroundog.model.domain.Admin;
import com.aroundog.model.domain.Member;

@Repository
public class MybatisMemberDAO implements MemberDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	//���̵� �ߺ�üũ
	public Member idCheck(String id) {
		sqlSessionTemplate.selectOne("Member.idCheck", id);
		return null;
	}
	
	//��� �α��� üũ
	public Member loginCheck(Member member) {
		return sqlSessionTemplate.selectOne("Member.loginCheck", member);
	}

	//�̸����� �����ȸ
	public Member selectByName(String name) {
		Member member=sqlSessionTemplate.selectOne("Member.selectByName",name);
		return member;
	}
	
	
	//CRUD
	public List selectAll() {
		return sqlSessionTemplate.selectList("Member.selectAll");
	}

	public Member select(int member_id) {
		return sqlSessionTemplate.selectOne("Member.select", member_id);
	}

	public int insert(Member member) {
		return sqlSessionTemplate.insert("Member.insert", member);
	}

	public int update(Member member) {
		return sqlSessionTemplate.update("Member.update", member);
	}
	public int delete(int member_id) {
		return sqlSessionTemplate.delete("Member.delete", member_id);
	}
	
	
}
