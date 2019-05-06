package com.aroundog.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aroundog.model.domain.Adoptboard;

@Repository
public class MybatisAdoptboardDAO implements AdoptboardDAO{
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	// ������ : �Ծ�  �Խù� �Ѱ� ����ϱ�
	public int insert(Adoptboard adoptboard) {
		return sessionTemplate.insert("Adoptboard.insert", adoptboard);
	}
	
	// ������: �Ծ� �Խù� ��� ����
	public List selectAll() {
		return sessionTemplate.selectList("Adoptboard.selectAll");
	}
	
	// ������: �Ծ� �Խù� 1�� �󼼺���
	public Adoptboard select(int adoptboard_id) {
		return sessionTemplate.selectOne("Adoptboard.select", adoptboard_id);
	}
	
	// ������: �Ծ� �Խù� ����
	public int update(Adoptboard adoptboard) {
		return sessionTemplate.update("Adoptboard.update", adoptboard);
	}
	
	// ������: �Ծ� �Խù� ����
	public int delete(int adoptboard_id) {
		return sessionTemplate.delete("Adoptboard.delete", adoptboard_id);
	}

}