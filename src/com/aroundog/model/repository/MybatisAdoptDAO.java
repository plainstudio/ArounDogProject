package com.aroundog.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aroundog.model.domain.Adopt;

@Repository
public class MybatisAdoptDAO implements AdoptDAO{
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	// ���� : �Ծ� ��û �Ѱ� ����ϱ�
	public int insert(Adopt adopt) {	
		return sessionTemplate.insert("Adopt.insert", adopt);
	}
	
	// ������: �Ծ��û �Խñ� ��� ����
	public List selectAll() {
		return sessionTemplate.selectList("Adopt.selectAll");
	}
	
	// ������: �Ծ��û �Խñ� 1�� �󼼺���
	public Adopt select(int adopt_id) {
		return sessionTemplate.selectOne("Adopt.select", adopt_id);
	}
	
	// ������: �Ծ��û �Խñ� ���� & Ȯ�οϷ�
	public int update(Adopt adopt) {
		return sessionTemplate.update("Adopt.update", adopt);
	}
}