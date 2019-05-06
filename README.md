# ArounDogProject
[ javaEE ] 유기견 보호 센터 팀 프로젝트
[ 기술 명세 ]
#공통<br>
<br>- JQuery 사용
<br>- CRUD 구현
<br>- mybatis를 활용한 sql문 매핑
<br>- db연동 및 db 입출력
<br>- spring mvc 패턴 이용한 webapplication 제작 (mvc 2)
<br>- 어노테이션 기반 controller 구현
<br>- exception handler와 사용자 정의 runtimeException을 활용한 예외처리
<br>- 페이저 처리
<br>- 파일 업로더 처리
<br>==============================member============================<br>
- 로그인 처리
- hash함수를 활용해 비밀번호 암호화 처리
<br>============================adoptmanager=========================<br>
- 어노테이션 기반 트랜잭션 처리 구현
- association, resultmap, selectKey를 활용해 join문 처리
- multipart form-data를 이용한 파일 업로드, 불러오기
- fileManager를 활용해 파일 저장시 이름 변환 기능
- ckeditor 적용
<br>==============================아직!================================<br>
- EL & JSTL 적용
- restful 
- 외부 api (google map) 처리
- json, mail, 로그인 중복처리, 비밀번호 확인


<br>[관리자 UI]<br>
<img width="50%" src="https://postfiles.pstatic.net/MjAxOTA1MDZfMTg5/MDAxNTU3MTI3MjU1NjI0.5IGI4-eZcrNq4eo3P63-XtO2nQB_fLmfKaVU3E7mhrUg.1f5TXRpW4fSjwcupJCuHzbTX0M1aj-aUVOj_5DJba0sg.PNG.kwjing93/image.png?type=w966">

<img width="50%" src="https://postfiles.pstatic.net/MjAxOTA1MDZfMjU5/MDAxNTU3MTI3MzMyNDM4.EwMY-8areiKw4F2aqqQLfGIakmDPy4TyuOauuFmHeEkg.mTFoRwk-gAAl8Rp1CLYdwoMYCMIL8n8f6YkcPhVMHPkg.PNG.kwjing93/image.png?type=w966">

<img width="50%" src="https://postfiles.pstatic.net/MjAxOTA1MDZfMjU3/MDAxNTU3MTI3MzU2Mzc4.4pTRFInhogTyDOBkGEC6diyIrxrLlOCvDg3IIAqjNAkg.TO-LTWZ0Al3tavMCGpiG7PfpRdXM6OIquiwQqIt_YQYg.PNG.kwjing93/image.png?type=w966">

<img width="50%" src="https://postfiles.pstatic.net/MjAxOTA1MDZfMjE3/MDAxNTU3MTI3NTIyNDQ1.XoGf188WMH2h-afo17Hi8IFC2_8SiKbdXIa7Q7lRkegg.Mi97ieEweP1dszJrD7uOIXBTaODSzP9tHEfhHMDBJXcg.PNG.kwjing93/image.png?type=w966">

<img width="50%" src="https://postfiles.pstatic.net/MjAxOTA1MDZfOSAg/MDAxNTU3MTI3NTg0OTUx.1mgYVBhkjwgng5KouyqJUi3egDQKfx4-0IH2EugW6tkg.GbezqDCQkM4JvzKBszeJuARsGJmrF9yudoeanlYVRtcg.PNG.kwjing93/image.png?type=w966">

<img width="50%" src="https://postfiles.pstatic.net/MjAxOTA1MDZfMjM2/MDAxNTU3MTI3NjM1NzQ0.Ag5YjR3iJGiz1x5kscksna2Db1elUM-1Q9Iej0AljjAg.Rkr7X2huGovEe-HcO2CZnG4JqEpu6hi_Flh8-GoKXcsg.PNG.kwjing93/image.png?type=w966">

<br>[유저 UI]<br>
<img width="50%" src="https://postfiles.pstatic.net/MjAxOTA1MDZfMjU1/MDAxNTU3MTI3NjgwNTcy.SPEU5HmwgGdhb0eEkwSKd4cZcM_uSIMQZIWIYyi2p98g.-97G_57HhyIrAdI_MAjf6cHQSaRzIz8yTpmieF9yPqkg.PNG.kwjing93/image.png?type=w966">

<img width="50%" src="https://postfiles.pstatic.net/MjAxOTA1MDZfMTIx/MDAxNTU3MTI3NzA5NjY4.2dH80AWxSMVupOk6J5eFH3IA5QfRWdRWmsuis6CTD1kg.NiPo1CG7_nkMO89uFj6GiDnlyXQTIHOy6Xz_CzdSv0gg.PNG.kwjing93/image.png?type=w966">

<img width="50%" src="https://postfiles.pstatic.net/MjAxOTA1MDZfNjYg/MDAxNTU3MTI3NzU2NzM0.Wcrio3O_70yGNnLUyH8YPu6wHFExKJhKR9EpF2cF6Fwg.-xCVO79tYiPQdTdJlqYbbkKAPtUBlFoVvNbaCBoAxWIg.PNG.kwjing93/image.png?type=w966">

<img width="50%" src="https://postfiles.pstatic.net/MjAxOTA1MDZfMjQ0/MDAxNTU3MTI4MDcyMjg0.apW1XEy3QwoHWzT_mT6WkRrIXus4gAMPu31CQuhPLJ0g.U8p-2acf8bLPCrrSCAMlVKebyiaWfULk1HulMQi5efAg.PNG.kwjing93/image.png?type=w966">

<img width="50%" src="https://postfiles.pstatic.net/MjAxOTA1MDZfODYg/MDAxNTU3MTI4MTI0NzA3.C3hRtutkIHTyMQbizK5rKEt7qFBx_P2vCpKLoikOWjwg.p72SVRVzeK2S65BwG7YXYe6Vibe11668wRYHXGwE1e4g.PNG.kwjing93/image.png?type=w966">



