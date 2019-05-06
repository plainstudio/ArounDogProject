<%@page import="com.aroundog.model.domain.Member"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Member member=(Member)request.getSession().getAttribute("member");
%>
<header id="header" id="home">
   <div class="container main-menu">
   	<div class="row align-items-center justify-content-between d-flex">
      <div id="logo">
        <a href="/user/index.jsp"><img src="/user/img/logo/aroundog_02.png" alt="" title=""  style="width:100px"/></a>
      </div>
      <nav id="nav-menu-container">
        <ul class="nav-menu">
          <li class="menu-active"><a href="/user/main">Home</a></li>
          <li><a href="/user/about.jsp">About Us</a></li>
          <li><a href="/user/notices">Notice</a></li>
          <li><a href="/user/adopt/adoptboardList">Adoption</a></li>        
          
          <li class="menu-has-children"><a href="">Board</a>
            <ul>
            	<li><a href="/user/freeboards">Free board</a></li>
            	<li><a href="/user/lostboard/lostboardlist">Lost board</a></li>

            </ul>
          </li>
          
   
          <%if(member==null){ %>
               <li class="menu-has-children"><a href="/user/login/login.jsp">Login</a>
             <li><a href="/user/member/regist.jsp">Join us</a></li>
          <%}else{ %>   
           <li class="menu-has-children"><a href=""><%=member.getName() %> 님</a>
               <ul>
                 <li><a href="#">MyPage</a></li>   
                 <li><a href="/user/report/report.jsp">Report</a></li>
               </ul>
             </li>
            <li class="menu-has-children"><a href="/user/member/logout">[ Logout ]</a>
          <%} %>
          				              
        </ul>
      </nav><!-- #nav-menu-container -->		    		
   	</div>
   </div>
 </header><!-- #header -->