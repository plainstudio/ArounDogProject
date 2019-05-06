package com.aroundog.model.service;

import java.util.List;
import com.aroundog.model.domain.Member;


public interface MemberService {
	public Member idCheck(String id);
	public Member loginCheck(Member member);
	public Member selectByName(String name);

	public List selectAll();
	public Member select(int member_id);
	public void insert(Member member);
	public void update(Member member);
	public void delete(int member_id);
}
