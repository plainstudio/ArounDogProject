# ArounDogProject
[ javaEE ] 유기견 보호 센터 팀 프로젝트_ 담당 업무 : (관리자) 회원, 입양 게시물 / (유저) 회원, 입양 게시물 


<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTY2/MDAxNTU3MjQxMzc5NDk2.HxAgqP2dJOv36ksHMjRP7zJmwUAbmn9mkPTBvegNHC0g.-bXVi1dEyOUHvpJdaetlrKOIC9BCiFi9b1_Pfxfhhbsg.PNG.kwjing93/AROUNDOG_1.png?type=w966">



<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTM4/MDAxNTU3MzE4Njk5OTU0.R13Ja4s9Y3fe82S4b1qand8Th4-AkCasVn_NvuxMGfog.TyCuPmlqTwUzjYhxKft1GeGYGipRP9a4gHXLPZZzVLog.PNG.kwjing93/AROUNDOG_2-1.png?type=w966">

[ 관리자_회원관리 영역 ]
- (1) SHA 256을 이용한 비밀번호 암호화<br/>
- (2) AOP 기반 로그인 처리<br/>
- (3) Pager 클래스를 정의하여 페이징 처리<br/>




<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTA2/MDAxNTU3MzE4NzE3MTI2.E4BRZyP0BFfoopz6dG9Y3g6cv_DuFF6h2Wfj6PG32u4g.dAp53xEeJe3OdGwUvfJAE1hodg3bVM5PpMPh9C1MwPog.PNG.kwjing93/AROUNDOG_3-1.png?type=w966">
[ 관리자_입양 게시물 역역 ]

- (1) CommonsMultipartResolver를 적용한 파일 업로드<br/>
   L Controller의 업무 집중화를 분리시키기 위하여 파일 업로드를 처리하는 Uploader 클래스 정의
   L 파일 관련 공통 업무를 처리하기 위한 FileManager 클래스 정의
   L System객체를 사용한 파일명 정의

- (2) Mybatis의 association, resultmap, selectKey를 활용해 Join문 처리<br/>
   어노테이션 기반 Transaction 처리<br/>

- (3) Ckeditor 4버전 적용<br/>




<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTQw/MDAxNTU3MzI2ODA2MTE1.iW3Ay1HQuD7gKdvPo-z9dzT5y4KEIS2ixUJwOviV2Mcg.l9ZZX56aZXy4isalkc0oHmCTFKxlZvPghheRcYYkahAg.PNG.kwjing93/AROUNDOG_4-1(%EC%88%98%EC%A0%95).png?type=w966">
[ 유저_로그인, 가입 영역 ]

- (1) Session 속성을 이용한 로그인, 로그아웃 View 처리
- (2) 중복 가입 방지 처리
- (3) JQuery Ajax의 요청처리 결과를 JSON으로 parsing하여 결과값에 따라 가입조건에 부합한 유저만 가입진행


<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTI0/MDAxNTU3MzI2ODA3MTEw.d2Lnn64aNVv0i1f0LQr2b063HFJfS8TTuq8e_fPU1tEg.-c7sxtBNhuGiORQCHH0OWBHz2ha9wHjs1ZU4_RXRHg8g.PNG.kwjing93/AROUNDOG_5-1(%EC%88%98%EC%A0%95).png?type=w966">
[ 유저_입양 게시물 보기 영역 ]

- (1) AdoptboardPager 클래스를 정의하여 게시물에 대한 페이징 처리<br/>
- (2) Bootstrap4 Icon을 적용<br/>
- (3) 이전, 다음 게시물 가져오기 기능 구현


