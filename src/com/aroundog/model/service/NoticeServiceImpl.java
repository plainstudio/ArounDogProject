package com.aroundog.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aroundog.common.exception.DeleteFailException;
import com.aroundog.common.exception.EditFailException;
import com.aroundog.common.exception.RegistFailException;
import com.aroundog.model.domain.Notice;
import com.aroundog.model.repository.NoticeDAO;
@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeDAO noticeDAO;
	@Override
	public List selectAll() {
		List noticeList=noticeDAO.selectAll();
		return noticeList;
	}

	@Override
	public void delete(int notice_id) throws DeleteFailException{
		int result=noticeDAO.delete(notice_id);
		if (result == 0) {
	         throw new DeleteFailException("�������� ���� ����!!");
	    }	
	}

	@Override
	public void insert(Notice notice) throws RegistFailException{
		int result=noticeDAO.insert(notice);
		if (result == 0) {
	         throw new RegistFailException("�������� ��� ����!!");
	    }			
	}

	@Override
	public void update(Notice notice) throws EditFailException{
		int result=noticeDAO.update(notice);
		if (result == 0) {
	         throw new EditFailException("�������� ���� ����!!");
	    }			
	}

	@Override
	public Notice select(int notice_id) {
		Notice notice=noticeDAO.select(notice_id);
		return notice;
	}

	@Override
	public void updateHitCnt(int notice_id) {
		int result=noticeDAO.updateHitCnt(notice_id);
		if (result == 0) {
	         throw new EditFailException("�������� ��Ʈ ī��Ʈ ���� ����!!");
	    }		
	}

}
