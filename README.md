# ArounDogProject
[ javaEE ] 유기견 보호 센터 팀 프로젝트_ 담당 업무 : (관리자) 회원, 입양 게시물 / (유저) 회원, 입양 게시물 


<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTY2/MDAxNTU3MjQxMzc5NDk2.HxAgqP2dJOv36ksHMjRP7zJmwUAbmn9mkPTBvegNHC0g.-bXVi1dEyOUHvpJdaetlrKOIC9BCiFi9b1_Pfxfhhbsg.PNG.kwjing93/AROUNDOG_1.png?type=w966">



<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTM4/MDAxNTU3MzE4Njk5OTU0.R13Ja4s9Y3fe82S4b1qand8Th4-AkCasVn_NvuxMGfog.TyCuPmlqTwUzjYhxKft1GeGYGipRP9a4gHXLPZZzVLog.PNG.kwjing93/AROUNDOG_2-1.png?type=w966">
**관리자) 회원관리 영역**<br>
1) SHA 256을 이용한 비밀번호 암호화
2) AOP 기반 로그인 처리
3) Pager 클래스를 정의하여 페이징 처리




<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTA2/MDAxNTU3MzE4NzE3MTI2.E4BRZyP0BFfoopz6dG9Y3g6cv_DuFF6h2Wfj6PG32u4g.dAp53xEeJe3OdGwUvfJAE1hodg3bVM5PpMPh9C1MwPog.PNG.kwjing93/AROUNDOG_3-1.png?type=w966">
**관리자) 입양 게시물 관리 영역**<br>
1) CommonsMultipartResolver를 통한 파일 업로드
   fileManager 클래스 정의하여 사진 파일에 대해 uploader와 업무 분리
   Uploader 클래스를 정의하여 controller와 파일 업로드 업무 분리
   System객체를 사용해 날짜로 새로운 파일명 부여

2) Association, resultmap, selectKey를 활용해 join문 처리
   어노테이션 기반 transaction 처리

3) Ckeditor 4버전 사용




<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMjA0/MDAxNTU3MzE4NzE5NjUz.FPY7hvpKOFmYhzvXipDuRa3AcybZ9kKnIUQm2ph8coMg.vO_75keBF2nAiA3WW9EEdY7M0RdwVtm7vT4P1xQPhIwg.PNG.kwjing93/AROUNDOG_4-1.png?type=w966">
**유저) 로그인, 가입 영역**<br>
1) AOP 기반 로그인 처리
  로그인 여부에 따라 [LOGOUT] 메뉴 생성




<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTc4/MDAxNTU3MzE4NzIxNjg2.db-MH4uL5r3HvB_4EIjes8AO51g18wEAvsmLeUdxpfYg.KKuNYfm8Mtu04T9iVaIiXzzco9daebP4riw-HPB0ekUg.PNG.kwjing93/AROUNDOG_5-1.png?type=w966">
**유저) 입양 게시물 보기 영역**<br>
1) adoptboardPager 클래스를 정의하여 페이징 처리
2) bootstrap4 icon을 적용
3) ckeditor로 저장했던 값 DB에서 불러오기
4) controlle에서 List로 전체 목록을 받아와 이전, 다음 페이지 처리


