package com.aroundog.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aroundog.common.exception.AdoptRegistFailException;
import com.aroundog.common.exception.DeleteFailException;
import com.aroundog.common.exception.EditFailException;
import com.aroundog.model.domain.Adopt;
import com.aroundog.model.domain.Adoptdog;
import com.aroundog.model.repository.AdoptDAO;
import com.aroundog.model.repository.AdoptdogDAO;

@Service
public class AdoptdogServiceImpl implements AdoptdogService{
	
	@Autowired 
	@Qualifier("mybatisAdoptdogDAO")
	private AdoptdogDAO adoptdogDAO;


	// ������: �Ծ� ������ ��� ����
	public List selectAll() {
		return adoptdogDAO.selectAll();
	}

	// ������: �Ծ� ������ 1�� �󼼺���
	public Adoptdog select(int adoptdog_id) {
		return adoptdogDAO.select(adoptdog_id);
	}

	// ������: �Ծ� ������ ����
	public void update(Adoptdog adoptdog) throws EditFailException{
		int result=adoptdogDAO.update(adoptdog);
		if(result==0) {
			throw new EditFailException("������ ���� ���� ����");
		}
	}

	// ������: �Ծ� ������ 1�� ����
	public void delete(int adoptdog_id) throws DeleteFailException{
		int result=adoptdogDAO.delete(adoptdog_id);
		if(result==0) {
			throw new DeleteFailException("������ ���� ���� ����");
		}
	}

	
}