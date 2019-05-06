package com.aroundog.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aroundog.common.exception.DeleteFailException;
import com.aroundog.common.exception.RegistFailException;
import com.aroundog.model.domain.LostComment;
import com.aroundog.model.repository.LostCommentDAO;

@Service
public class LostCommentServiceImpl implements LostCommentService{

   @Autowired
   private LostCommentDAO lostCommentDAO;
   
   
   @Override
   public void insert(LostComment lostComment) throws RegistFailException{
      int result = lostCommentDAO.insert(lostComment);
      if(result==0){
         throw new RegistFailException("��� ��� ����");
      }
   }

   @Override
   public List selectAll() {
      return lostCommentDAO.selectAll();
   }

   @Override
   public void delete(int lostcomment_id) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void commentAdd(LostComment lostComment) throws RegistFailException{
      int result = lostCommentDAO.commentAdd(lostComment);
      if(result==0) {
         throw new RegistFailException("����� ��� ��� ����");
      }
      
   }

   @Override
   public void deleteByLostBoardId(int lostboard_id){
      int result = lostCommentDAO.deleteByLostBoardId(lostboard_id);
      //����� 0���϶� �����ϸ� result�� 0�̳���
        if(result==0) { throw new DeleteFailException("���� ���� byLostBoardId"); }
       
      
   }

   @Override
   public void deleteByTeam(LostComment lostcomment) throws DeleteFailException{
      int result = lostCommentDAO.deleteByTeam(lostcomment);
      if(result==0) {
         throw new DeleteFailException("���� ���� byTeam");
      }
   }

   @Override
   public void deleteByCommentId(int lostcomment_id) throws DeleteFailException{
      int result = lostCommentDAO.deleteByCommentId(lostcomment_id);
      if(result ==0) {
         throw new DeleteFailException("���� ���� by lostcomment_id");
      }
   }
   
   public List select(int lostboard_id) {
      return lostCommentDAO.select(lostboard_id);
   }

@Override
public List selectByboardId(int lostboard_id) {
	List lostList=lostCommentDAO.selectByboardId(lostboard_id);
	return lostList;
}

@Override
public void insertFirst(LostComment lostComment) throws DeleteFailException{
	int result = lostCommentDAO.insertFirst(lostComment);
    if(result ==0) {
       throw new DeleteFailException("���� ���� by lostcomment_id");
    }
	
}
}