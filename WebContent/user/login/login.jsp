<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
   <!-- Mobile Specific Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
<!-- Author Meta -->
<meta name="author" content="codepixer">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Animal Shelter</title>

<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
   <!--
CSS
============================================= -->
   <link rel="stylesheet" href="/user/css/linearicons.css">
   <link rel="stylesheet" href="/user/css/font-awesome.min.css">
   <link rel="stylesheet" href="/user/css/bootstrap.css">
   <link rel="stylesheet" href="/user/css/magnific-popup.css">
   <link rel="stylesheet" href="/user/css/nice-select.css">                     
   <link rel="stylesheet" href="/user/css/animate.min.css">
   <link rel="stylesheet" href="/user/css/owl.carousel.css">
   <link rel="stylesheet" href="/user/css/main.css">
<!-- 자바스크립트 부분 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
   $($("input[type='button']")[0]).click(function(){ //로그인 버튼 이벤트
      login();
   });
   $($("input[type='button']")[1]).click(function(){//회원가입 버튼 이벤트
      regist();
   });
});
// 로그인 관련
function login(){
	 $("form").attr({
	      method:"post",
	      action:"/user/member/login"  
	   });
	   $("form").submit();
}
//가입하기 관련
function regist(){
	location.href="/user/member/regist.jsp";
}
</script>
<!-- 자바스크립트 부분 -->   
</head>
<body>
<%@include file="/user/inc/header.jsp" %>

<!-- start banner Area -->
<section class="banner-area relative" id="home">   
   <div class="overlay overlay-bg"></div>
   <div class="container">            
      <div class="row d-flex align-items-center justify-content-center">
         <div class="about-content col-lg-12">
            <h1 class="text-white">
               어라운드도그         
            </h1>   
            
         </div>   
      </div>
   </div>
</section>
<!-- End banner Area -->   
   
<!-- Start Volunteer-form Area -->
<section class="Volunteer-form-area section-gap">
   <div class="container">
      <div class="row d-flex justify-content-center">
         <div class="menu-content pb-60 col-lg-9">
            <div class="title text-center">
               <h1 class="mb-20">Want to login? </h1>
               <p>어라운드 도그의 회원이 되어 더욱 다양한 서비스를 이용해보세요!</p>
            </div>
         </div>
      </div>                  
      <div class="row justify-content-center">
         <form class="col-lg-9">
           <div class="form-group">
             <label for="first-name">ID</label>
             <input type="text" class="form-control" name="id" placeholder="아이디 입력" required>
           </div>
           <div class="form-group">
             <label for="last-name">PASSWORD</label>
             <input type="password" class="form-control" name="pass" placeholder="비밀번호 입력" required>
           </div>                    
           
            <input type="button" value="로그인" class="primary-btn float-right">   
           <input type="button" value="가입" class="primary-btn float-right">

         </form>
      </div>
   </div>   
</section>
<!-- End Volunteer-form Area -->
                                                            
<!-- start footer Area -->      
<%@include file="/user/inc/footer.jsp" %>
<!-- End footer Area -->   

      <script src="/user/js/vendor/jquery-2.2.4.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
      <script src="/user/js/vendor/bootstrap.min.js"></script>         
      <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
          <script src="/user/js/easing.min.js"></script>         
      <script src="/user/js/hoverIntent.js"></script>
      <script src="/user/js/superfish.min.js"></script>   
      <script src="/user/js/jquery.ajaxchimp.min.js"></script>
      <script src="/user/js/jquery.magnific-popup.min.js"></script>   
      <script src="/user/js/owl.carousel.min.js"></script>                  
      <script src="/user/js/jquery.nice-select.min.js"></script>                     
      <script src="/user/js/mail-script.js"></script>   
      <script src="/user/js/main.js"></script>   
   </body>
</html>