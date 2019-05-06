package com.aroundog.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aroundog.model.domain.Type;
import com.aroundog.model.repository.TypeDAO;

@Service
public class TypeServiceImpl implements TypeService{
	@Autowired
	@Qualifier("mybatisTypeDAO")
	private TypeDAO typeDAO;

	//������ Ÿ�� ��� �ҷ�����
	public List selectAll() {
		return typeDAO.selectAll();
	}

	//������ Ÿ�� 1�� �ҷ�����
	public Type select(int type_id) {
		return typeDAO.select(type_id);
	}
	
	
}
