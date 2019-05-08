# ArounDogProject
[ javaEE ] 유기견 보호 센터 팀 프로젝트_ 담당 업무 : (관리자) 회원, 입양 게시물 / (유저) 회원, 입양 게시물 


<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTY2/MDAxNTU3MjQxMzc5NDk2.HxAgqP2dJOv36ksHMjRP7zJmwUAbmn9mkPTBvegNHC0g.-bXVi1dEyOUHvpJdaetlrKOIC9BCiFi9b1_Pfxfhhbsg.PNG.kwjing93/AROUNDOG_1.png?type=w966">

1 관리자 회원관리 영역
<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfNzIg/MDAxNTU3MjQxMjc1Njcy.6Y2KqAISHJ-TOf_cHBrDEk7L9yx9j4qzZ6ZAXeoO_oQg.xafjhzVNidj1_hZoLBbwZxiVWfLYO4v49dDqIQ13BRwg.PNG.kwjing93/AROUNDOG_2.png?type=w966">

1) SHA 256을 이용한 비밀번호 암호화
2) AOP 기반 로그인 처리
3) Pager 클래스를 정의하여 페이징 처리

2 관리자 입양 게시물 관리 영역
<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTE0/MDAxNTU3MjQxMjc5MDcw.OJSCNScTqIUDlFT12HwEepDnu3i-cdV_O-omm27-vMwg.S4fdTxqEm_uy9okjrMsLLf7ZlXXYCX3Uu9IbXXKa_7sg.PNG.kwjing93/AROUNDOG_3.png?type=w966">

1) CommonsMultipartResolver를 통한 파일 업로드
fileManager 클래스 정의하여 사진 파일에 대해 uploader와 업무 분리
Uploader 클래스를 정의하여 controller와 파일 업로드 업무 분리
System객체를 사용해 날짜로 새로운 파일명 부여

2) Association, resultmap, selectKey를 활용해 join문 처리
어노테이션 기반 transaction 처리

3) Ckeditor 4버전 사용

3 유저 로그인, 가입 영역
<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfMTcw/MDAxNTU3MjQxMjgyMDgx.Xscd8D3gXz9vrw4KNqDvGY8xAG5yUJpBpnWNF8UBe0Ig.hCWXxuujM6lbtR2G7-4A_ESbhfPvYm3jACYsutpX8KYg.PNG.kwjing93/AROUNDOG_4.png?type=w966">

1) AOP 기반 로그인 처리
로그인 여부에 따라 [LOGOUT] 메뉴 생성

4 (화면)?
<img src="https://postfiles.pstatic.net/MjAxOTA1MDhfNTcg/MDAxNTU3MjQxMjg0NzQ1.piyiSAC6aYR84IUtQ7UkhPBZu-1qvYGxb2YQpEB4OKwg.DLL9lfe4SwCKqB38yhOMd4lraSyWYtreXz7Mak-sgyMg.PNG.kwjing93/AROUNDOG_5.png?type=w966">

