package com.aroundog.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aroundog.model.domain.Adopt;
import com.aroundog.model.domain.Adoptdog;

@Repository
public class MybatisAdoptdogDAO implements AdoptdogDAO{
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	// ������ : �Ծ�  ������ �Ѱ� ����ϱ�
	public int insert(Adoptdog adoptdog) {
		return sessionTemplate.insert("Adoptdog.insert", adoptdog);
	}

	// ������: �Ծ� ������ ��� ����
	public List selectAll() {
		return sessionTemplate.selectList("Adoptdog.selectAll");
	}

	// ������: �Ծ� ������ 1�� �󼼺���
	public Adoptdog select(int adoptdog_id) {
		return sessionTemplate.selectOne("Adoptdog.select", adoptdog_id);
	}

	// ������: �Ծ� ������ ����
	public int update(Adoptdog adoptdog) {
		return sessionTemplate.update("Adoptdog.update", adoptdog );
	}

	// ������: �Ծ� ������ ����
	public int delete(int adoptdog_id) {
		return sessionTemplate.delete("Adoptdog.delete", adoptdog_id);
	}

	

}