package com.aroundog.common.file;

import java.io.File;

import org.springframework.stereotype.Component;

//�߸����̾����..
@Component
public class FileManager {
	private ReNameSercurity rs = new ReNameSercurity();

	//���ϸ� �� Ȯ���� �����Ͽ� ��ȯ�ϴ� �޼���
	public  String getExt(String path){
		int lastIndex=path.lastIndexOf(".");
		return path.substring(lastIndex+1, path.length());
	}
	
	//������ ��ο� ������ �����ϴ� �޼���!!
		public boolean save() {
			return false;
		}
		
	//���ϸ� �ٲٱ� : ������ ���ο� ���ϸ��� ��¥�� �̿��Ѵ�
	public String reNameByDate(File ori, String dir) {
		long time=System.currentTimeMillis();
		String filename=time+"."+getExt(ori.getName()); //�����̸�
		boolean result=ori.renameTo(new File(dir+"/"+filename));
		/*
		 * if(result==false) { filename=null; }
		 */
		return filename;
	}
	
	public String reNameByHash(File ori,String dir) {
		String hash = rs.textToHash(ori.getName());
		String filename = hash+"."+getExt(ori.getName());
		boolean result = ori.renameTo(new File(dir+"/"+filename));      
		return filename;
	}
    public void deleteFile(String[] fileList,String dir) {
        for(int i=0;i<fileList.length;i++) {
           File file = new File(dir+"/"+fileList[i]);
           if(file.exists()) {
              if(file.delete()) {
                 System.out.println(fileList[i]+" ���� ���� ����");
              }else {
                 System.out.println(fileList[i]+" ���� ���� ����");
              }
           }else {
              System.out.println("������ �������� �ʽ��ϴ�.");
           }
        }
     }
    //1�� ���� �����
    public void deleteFile(String fileName, String dir) {
          File file = new File(dir+"/"+fileName);
          if(file.exists()) {
             if(file.delete()) {
                System.out.println(file+" ���� ���� ����");
             }else {
                System.out.println(file+" ���� ���� ����");
             }
          }else {
             System.out.println("������ �������� �ʽ��ϴ�.");
          }
    }
		
		/*
		public static void main(String[] args) {
			FileManager fm=new FileManager();
			System.out.println(fm.getExt("��������.jpg")); 
		}
		*/
}
