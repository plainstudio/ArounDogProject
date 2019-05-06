package com.aroundog.common.file;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.aroundog.model.domain.Report;
import com.aroundog.model.domain.ReportImg;

public class ReportImgUploader {
   private FileManager fileManager = new FileManager();

   public String[] returnFilename(MultipartFile[] myFile, Report report, String realPath) {
      String[] filenameList = new String[myFile.length];
      for (int i = 0; i < myFile.length; i++) {
         String filename = myFile[i].getOriginalFilename();
         File uploadFile = null;
         try {
            uploadFile = new File(realPath + "/" + filename);
            myFile[i].transferTo(new File(realPath + "/" + filename));
            filename = fileManager.reNameByHash(uploadFile, realPath);
            if (filename != null) {
               filenameList[i] = filename;
         } 
         }catch (IllegalStateException | IOException e) {
            System.out.println("�� ����ڴ� ������ ������� �ʾҽ��ϴ�");
         }
      }
      return filenameList;
   }
}