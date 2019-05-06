package com.aroundog.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aroundog.common.exception.DeleteFailException;
import com.aroundog.common.exception.EditFailException;
import com.aroundog.common.exception.RegistFailException;
import com.aroundog.model.domain.FreeBoard;
import com.aroundog.model.repository.FreeBoardDAO;
@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	//��� �����Խ��� ��������
	public List selectAll() {
		List freeBoardList=freeBoardDAO.selectAll();
		return freeBoardList;
	}
	
	public void delete(int freeboard_id) throws EditFailException{
		int result=freeBoardDAO.delete(freeboard_id);
		if (result == 0) {
	         throw new EditFailException("���� ����!!");
	    }	
	}

	public void insert(FreeBoard freeboard) throws EditFailException{
		int result=freeBoardDAO.insert(freeboard);
		if (result == 0) {
	         throw new EditFailException("��� ����!!");
	    }	
	}

	public void update(FreeBoard freeboard) throws EditFailException{
		int result=freeBoardDAO.update(freeboard);
		if (result == 0) {
	         throw new EditFailException("�����Խ��� ���� ����!!");
	    }
		
	}

	public FreeBoard select(int freeboard_id) {
		FreeBoard freeboard=freeBoardDAO.select(freeboard_id);
		return freeboard;
	}

	public void updateHitCnt(int freeboard_id) throws EditFailException{
		int result=freeBoardDAO.updateHitCnt(freeboard_id);
		if (result == 0) {
	         throw new EditFailException("��Ʈ ī��Ʈ ������Ʈ ����!!");
	    }	
	}

	public List selectByWriter(int member_id) {
		List searchList=freeBoardDAO.selectByWriter(member_id);
		return searchList;
	}

	public List selectByTitle(String searchWord) {	
		List searchList=freeBoardDAO.selectByTitle(searchWord);
		return searchList;
	}

}
