package com.aroundog.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aroundog.common.exception.AdoptRegistFailException;
import com.aroundog.model.domain.Adopt;
import com.aroundog.model.repository.AdoptDAO;

@Service
public class AdoptServiceImpl implements AdoptService{
	
	@Autowired 
	@Qualifier("mybatisAdoptDAO")
	private AdoptDAO adoptDAO;

	// ���� : �Ծ� ��û �Ѱ� ����ϱ�
	public void insert(Adopt adopt) throws AdoptRegistFailException{
		int result= adoptDAO.insert(adopt);
		if(result==0) {
			throw new AdoptRegistFailException("�Ծ��û ����� �������� �ʾҽ��ϴ�");
		}
	}
	
	// ������: �Ծ��û �Խñ� ��� ����
	public List selectAll() {
		return adoptDAO.selectAll();
	}
	
	// ������: �Ծ��û �Խñ� 1�� �󼼺���
	public Adopt select(int adopt_id) {
		return adoptDAO.select(adopt_id);
	}
	
	// ������: �Ծ��û �Խñ� ���� & Ȯ�οϷ�
	public void update(Adopt adopt) throws AdoptRegistFailException{
		int result= adoptDAO.update(adopt);
		if(result==0) {
			throw new AdoptRegistFailException("������ �����Ͽ����ϴ�");
		}
	}
}