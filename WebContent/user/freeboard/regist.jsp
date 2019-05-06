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
	<link rel="stylesheet" href="/user/css/free_bootstrap.css">
	<link rel="stylesheet" href="/user/css/magnific-popup.css">
	<link rel="stylesheet" href="/user/css/nice-select.css">							
	<link rel="stylesheet" href="/user/css/animate.min.css">
	<link rel="stylesheet" href="/user/css/owl.carousel.css">
	<link rel="stylesheet" href="/user/css/freeboard.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$($("input[type='button']")[0]).click(function(){
		insert();
	});
	$($("input[type='button']")[1]).click(function(){
		location.href="/user/freeboards";
	});
});

function insert(){
	setCheck();
	
	$("form").attr({
		action:"/user/freeboard/regist",
		method:"POST"
	});
	$("form").submit();
}


function setCheck(){
	if($("input[type='checkbox']").is(':checked')){
		$("input[name='secret']").val("true");
	}else if(!$("input[type='checkbox']").is(':checked')){
		$("input[name='secret']").val("false");
	}
}
</script>
</head>
<body>
<%@include file="/user/inc/header.jsp" %>

	<!-- start banner Area -->
	<section class="banner-area relative" id="home">	
		<div class="overlay overlay-bg"></div>
		<div class="container">				
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
				
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
						<h1 class="mb-20">유저들과 의사소통하세요</h1>
						<p>깨끗한 인터넷 문화를 위하여 에티켓을 지키며 이쁜말 고운말을 씁시다!!</p>
					</div>
				</div>
			</div>						
			<div class="row justify-content-center">
				<form class="col-lg-9">
					<div class="form-group">
						<div class="form-row">
					  	<div class="col-6 mb-0-i">
					  		<label for="City">카테고리</label>
					   		<div class="select-option" id="service-select"">
								<select name="category">
									<option value="일반" data-display="일반">일반</option>									
									<option value="입양질문">입양질문</option>
									<option value="제보">제보</option>
								</select>
							</div>	
					  	</div>
				  	</div>
					</div>
				  <div class="form-group">
				    <label for="first-name">제목</label>
				    <input type="hidden" class="form-control" name="hit" value="0">
				    <input type="hidden" class="form-control" name="member_id" value="<%=member.getMember_id()%>">
				    <input type="text" class="form-control" placeholder="제목 입력" name="title">
				  </div>
				  						  
				  <div class="form-group">
				    <label for="Address">내용</label>
				    <input type="textarea" class="form-control mb-20"  style=height:300px name="content">
				    
				  </div>						  

				  <fieldset class="form-group">
					<label for="day">비공개 글을 원하시면 체크해 주세요</label>
                          <div class="form-group ">
                              <div class="form-check form-check-inline">
                                  <label class="form-check-label">
                                      <input class="form-check-input" type="checkbox" id="inlineRadio1"> 비공개
                                      <input class="form-check-input" type="hidden" name="secret" id="inlineRadio1">
                                  </label>
                              </div>
                                                       
                          </div>
				  </fieldset>
				  <div class="table-row">
				  </div>
				  						  
				  <input type="button" class="primary-btn float-right" value="등록"></button>
				  <input type="button" class="primary-btn float-right mr-15" value="목록으로"></button>
				  
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
<!-- 	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script> -->
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