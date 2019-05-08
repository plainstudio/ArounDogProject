# ArounDogProject
[ javaEE ] 유기견 보호 센터 팀 프로젝트_ 담당 업무 : (관리자) 회원, 입양 게시물 / (유저) 회원, 입양 게시물 


<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTY2/MDAxNTU3MjQxMzc5NDk2.HxAgqP2dJOv36ksHMjRP7zJmwUAbmn9mkPTBvegNHC0g.-bXVi1dEyOUHvpJdaetlrKOIC9BCiFi9b1_Pfxfhhbsg.PNG.kwjing93/AROUNDOG_1.png?type=w966">



<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTM4/MDAxNTU3MzE4Njk5OTU0.R13Ja4s9Y3fe82S4b1qand8Th4-AkCasVn_NvuxMGfog.TyCuPmlqTwUzjYhxKft1GeGYGipRP9a4gHXLPZZzVLog.PNG.kwjing93/AROUNDOG_2-1.png?type=w966">

◎관리자) 회원관리 영역<br/>
1) SHA 256을 이용한 비밀번호 암호화<br/>
2) AOP 기반 로그인 처리<br/>
3) Pager 클래스를 정의하여 페이징 처리<br/>




<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTA2/MDAxNTU3MzE4NzE3MTI2.E4BRZyP0BFfoopz6dG9Y3g6cv_DuFF6h2Wfj6PG32u4g.dAp53xEeJe3OdGwUvfJAE1hodg3bVM5PpMPh9C1MwPog.PNG.kwjing93/AROUNDOG_3-1.png?type=w966">
◎관리자) 입양 게시물 관리 영역<br/>
1) CommonsMultipartResolver를 통한 파일 업로드<br/>
   fileManager 클래스 정의하여 사진 파일에 대해 uploader와 업무 분리<br/>
   Uploader 클래스를 정의하여 controller와 파일 업로드 업무 분리<br/>
   System객체를 사용해 날짜로 새로운 파일명 부여<br/>

2) Association, resultmap, selectKey를 활용해 join문 처리<br/>
   어노테이션 기반 transaction 처리<br/>

3) Ckeditor 4버전 사용<br/>




<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTQw/MDAxNTU3MzI2ODA2MTE1.iW3Ay1HQuD7gKdvPo-z9dzT5y4KEIS2ixUJwOviV2Mcg.l9ZZX56aZXy4isalkc0oHmCTFKxlZvPghheRcYYkahAg.PNG.kwjing93/AROUNDOG_4-1(%EC%88%98%EC%A0%95).png?type=w966">
◎유저) 로그인, 가입 영역<br/>
1) 로그인 여부에 따라 [ LOGOUT ] [ MYPAGE ] 메뉴 생성<br/>

2) 중복 가입 방지를 위한 controller의 idCheck()메서드 구현

3) JSON parsing으로 결과값에 따라 가입조건에 부합한 유저만 가입진행


<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTI0/MDAxNTU3MzI2ODA3MTEw.d2Lnn64aNVv0i1f0LQr2b063HFJfS8TTuq8e_fPU1tEg.-c7sxtBNhuGiORQCHH0OWBHz2ha9wHjs1ZU4_RXRHg8g.PNG.kwjing93/AROUNDOG_5-1(%EC%88%98%EC%A0%95).png?type=w966">
◎유저) 입양 게시물 보기 영역<br/>
1) adoptboardPager 클래스를 정의하여 페이징 처리
2) Bootstrap4 icon을 적용
3) session 체크를 통해 회원의 경우 입양신청 버튼의 노출
4) ckeditor로 저장했던 값 DB에서 불러오기
5) controlle에서 List로 전체 목록을 받아와 이전, 다음 페이지 처리


