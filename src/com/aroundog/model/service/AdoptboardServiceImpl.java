package com.aroundog.model.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.aroundog.common.exception.AdoptboardRegistFailException;
import com.aroundog.common.exception.DeleteFailException;
import com.aroundog.common.exception.EditFailException;
import com.aroundog.common.exception.RegistFailException;
import com.aroundog.common.file.AdoptboardUploader;
import com.aroundog.common.file.FileManager;
import com.aroundog.model.domain.Adoptboard;
import com.aroundog.model.domain.Adoptdog;
import com.aroundog.model.repository.AdoptboardDAO;
import com.aroundog.model.repository.AdoptdogDAO;

@Service
public class AdoptboardServiceImpl implements AdoptboardService{
   
   @Autowired
   private AdoptboardDAO adoptboardDAO;
   @Autowired
   private AdoptdogDAO adoptdogDAO;
   
   private AdoptboardUploader uploader=new AdoptboardUploader();
   
   // ������ : �Ծ�  �Խù� �Ѱ� ����ϱ�
   @Transactional("transactionManager")
   public void insert(Adoptboard adoptboard, String realPath) throws AdoptboardRegistFailException{   //�������� �ѹ��Ŵ 
      String img=uploader.reNamePhoto(adoptboard, realPath); //����� ������ �̸� ��ü
      System.out.println("��ȯ�� �̹����� �̸�"+img);
      if(img!=null) {//�̸� ��ü �� �Ծ� �Խù� 1�� ���!
         adoptboard.getAdoptdog().setImg(img);
         int result=adoptdogDAO.insert(adoptboard.getAdoptdog());  //adoptdog�� pkä������ ��..
         int result2=adoptboardDAO.insert(adoptboard); //board ���
         if(result==0 || result2==0) {
               throw new AdoptboardRegistFailException("�Ծ�Խù� ��� ����");
         }else {
            uploader.insertUpload(adoptboard, realPath, img);//���� ���ε�!!
         }   
      }else{//���� �̸� ��ü ����
         System.out.println("�Ծ� �Խù��� �̸� ��ȯ ����");
         throw new AdoptboardRegistFailException("�Ծ�Խù� ��� ����");
      }
   }
   // ������: �Ծ� �Խù� ����
   @Transactional("transactionManager")
      public void update(Adoptboard adoptboard, String realPath) throws EditFailException{
          int result=adoptdogDAO.update(adoptboard.getAdoptdog());
         int result2=adoptboardDAO.update(adoptboard);
         
         if(result==0 || result2==0) {
            throw new EditFailException("�Ծ�Խù� ���� ����");
         }else {
            uploader.updateUpload(adoptboard, realPath); //���� ��ü!
         }
      }
   
   // ������: �Ծ� �Խù� ����
      @Transactional("transactionManager")
      public void delete(int adoptboard_id, String realPath) throws DeleteFailException{
         Adoptboard adoptboard=adoptboardDAO.select(adoptboard_id); //������ �Խù� ��������
         
         int result=adoptdogDAO.delete(adoptboard.getAdoptdog().getAdoptdog_id()); //������ �Խù��� ����� adoptdog ����
         int result2=adoptboardDAO.delete(adoptboard_id); //�Խù� ����
         if(result==0 || result2==0) {
            throw new DeleteFailException("�Ծ�Խù� ���� ����");
         }else {
            uploader.delete(adoptboard, realPath);
         }
      }
   
   // ������: �Ծ� �Խù� ��� ����
   public List selectAll() {
      return adoptboardDAO.selectAll();
   }
   
   // ������: �Ծ� �Խù� 1�� �󼼺���
   public Adoptboard select(int adoptboard_id) {
      return adoptboardDAO.select(adoptboard_id);
   }
   
}