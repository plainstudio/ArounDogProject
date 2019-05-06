package com.aroundog.common.file;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.aroundog.model.domain.Adoptboard;
import com.aroundog.model.domain.LostBoard;

public class AdoptboardUploader {
   private FileManager fileManager = new FileManager();
   
   //������: ������ �Ծ� �Խù� ���� �̸� �ٲٱ�
   public String reNamePhoto(Adoptboard adoptboard, String realPath) {
      //���� ó��
      String img=adoptboard.getAdoptdog().getMyFile().getOriginalFilename();
      System.out.println("���δ����� ��ȯ�� ������ �������� �̸�"+img);
      File uploadFile=new File(realPath+"/"+img);
      System.out.println("uploadFile"+uploadFile);
      System.out.println("uploadFile"+uploadFile.getName());
      img=fileManager.reNameByDate(uploadFile, realPath);
      System.out.println("���δ����� ��ȯ�� ������ �̸�"+img);
      
      return img;
   }
   //������: ������ �Ծ� �Խù� ���� ���δ�
   public void insertUpload(Adoptboard adoptboard, String realPath, String img) {
      MultipartFile myFile=adoptboard.getAdoptdog().getMyFile();
      //���� ó��
      try {
         myFile.transferTo(new File(realPath+"/"+img)); //���ε�!
      } catch (IllegalStateException | IOException e) {
         e.printStackTrace();
      }
   }
   
   //������: ������ �Ծ� �Խù� ���� ��ü
   public void updateUpload(Adoptboard adoptboard, String realPath) {
          //�����ϰ���� ����
       MultipartFile myFile=adoptboard.getAdoptdog().getMyFile();
       //���� ������ �̸�
       String img=adoptboard.getAdoptdog().getImg();
      
      try {
         myFile.transferTo(new File(realPath+"/"+img)); //������ ��ü!
      } catch (IllegalStateException | IOException e) {
         e.printStackTrace();
      }
   }
   //������: ������ �Ծ� �Խù� ���� 1�� ����
   public void delete(Adoptboard adoptboard, String realPath) {
     //������ ������ �̸�
      String fileName=adoptboard.getAdoptdog().getImg();
      fileManager.deleteFile(fileName, realPath);
   }

}