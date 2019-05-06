package com.aroundog.commons;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// ȸ���� �α��� ������ �ʿ��� �������� ������ ���, �α��� ó�� �ߴ��� Ȯ���ϴ� �������
@Aspect
public class LoginCheck {
   
   
   /*------------------------------------------������ ������ �α��� üũ------------------------------------------------------*/
   @Pointcut("execution(public * com.aroundog.controller.AdminController.go*(..))")
   public void logincut() {} // ID����
   
   @Around("logincut()")
   public String sessionCheck(ProceedingJoinPoint jp) throws Throwable {
      String viewName=null;
      HttpServletRequest request=null;
      Object[] objArray= jp.getArgs(); // �޼��� ȣ��� ��� ������
      System.out.println("������ �α��� üũ : sessionCheck ȣ��!!!!!");
      
      // request���� ���� ����
      for(int i=0;i<objArray.length;i++) {
         if(objArray[i] instanceof HttpServletRequest) {
            request = (HttpServletRequest)objArray[i]; // ���� ������ ����ֱ�
            System.out.println("������ �α��� üũ : ��û��ü �߰�");
         }
      }
      
      // �������� �α��� �ߴ��� üũ
      if(request.getSession().getAttribute("admin")==null) { // �α��� ���� ���
         viewName="admin/error/loginError";
         System.out.println("������ �α��� üũ : �α��� ������");
      }else { // �α��� �� ���
         viewName=(String) jp.proceed();
         String methodName= jp.getSignature().getName();
         System.out.println("������ �α��� üũ : �α��� ����. ���� �޼��� ȣ��>>"+methodName);
      }
      return viewName;
   }
   
   /*--------------------------------------------------ȸ�� �α��� üũ------------------------------------------------------*/
   
   @Pointcut("execution(public * com.aroundog.controller.AdoptController.adoptRegist(..))")
   public void adoptCheck() {}
   @Pointcut("execution(public * com.aroundog.controller.ReportController.goReport(..))")
   public void reportCheck() {}
   
   @Around("adoptCheck() || reportCheck()")
   public String memberLoginCheck(ProceedingJoinPoint jp) throws Throwable {
      String viewName=null;
      HttpServletRequest request=null;
      System.out.println("���� �α��� üũ ȣ��!!!");
      
      Object[] args= jp.getArgs();
      // ���� üũ
      for(int i=0;i<args.length;i++) {
         Object obj= args[i];
         if(obj instanceof HttpServletRequest) {
            request= (HttpServletRequest)obj;
            String requestURL= request.getRequestURL().toString();
            System.out.println("���� �α��� üũ : ��û��ü �߰� >>>> ��ûURL : "+requestURL);
         }
      }
      
      // ���ǿ� �α��� ��ü ����ִ��� üũ
      if(request.getSession().getAttribute("member")==null) {
         viewName="user/error/loginError";
         System.out.println("���� �α��� üũ : �α��� �� ��");
      }else {
         String methodName= jp.getSignature().getName();
         viewName= (String)jp.proceed();
         System.out.println("���� �α��� üũ : �α��� �� >>> ���� �޼��� "+methodName+" ȣ��");
      }
      System.out.println("���� �α��� üũ >>> ������ȯ�Ǵ� viewName : "+viewName);
      return viewName;
   }
}









