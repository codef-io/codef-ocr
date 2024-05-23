# Overview

codef-ocr은 CODEF OCR API 호출을 테스트하는 샘플 코드입니다.  
사용을 위해서는 [홈페이지](https://codef.io/) 가입 후 데모/정식 서비스 신청을 통해 자격 증명을 위한 클라이언트 정보 등을 발급받아야 하며  
사용 가능한 모든 OCR API의 엔드포인트와 요청/응답 항목은 모두 [개발가이드](https://developer.codef.io/)를 통해 확인할 수 있습니다.

---

# 사용법

#### 1. 홈페이지에서 발급받은 Client ID, Client Secret, Public Key 값을 EasyCodefClientInfo.java 에 등록합니다.

```java
	/**	
	 * TODO :	사용자는 코드에프 가입을 통해 발급 받은 클라이언트 정보와 RSA 공개키 정보를 설정해야 함.
	 *
	 */
	public static final String DEMO_CLIENT_ID = "코드에프 데모 서비스 신청 후 발급 받은 데모버전 클라이언트 아이디 설정";
	public static final String DEMO_CLIENT_SECRET = "코드에프 데모 서비스 신청 후 발급 받은 데모버전 클라이언트 시크릿 설정";
	
	public static final String CLIENT_ID = "코드에프 정식 서비스 신청 후 발급 받은 정식버전 클라이언트 아이디 설정";
	public static final String CLIENT_SECRET = "코드에프 정식 서비스 신청 후 발급 받은 정식버전 클라이언트 아이디 설정";

	public static final String PUBLIC_KEY = "코드에프 가입을 통해 발급 받은 본인 계정의 RSA 공개키 정보 설정";

```

#### 2. 로컬 서버 실행 후 모바일 브라우저를 통해 접속합니다.  
<img src="https://github.com/codef-io/codef-ocr/assets/43339893/530a409e-8e92-4215-9d58-9f006d6e5aee" width="400" height="500">
   
#### 3. 신분증 종류 선택 후 시작하기 버튼을 클릭합니다.
<img src="https://github.com/codef-io/codef-ocr/assets/43339893/e7d8ba89-26b7-4d29-ab69-952da149fd77" width="400" height="500">

#### 4. 노란 가이드선에 신분증을 맞춘 후 하단의 원 버튼을 클릭하여 촬영합니다.
#### 5. Response Data를 확인합니다.

---

# ETC
WebRTC의 경우 개발 지원이 불가능하며  
Reqeust 및 Response Data 등의 API 사용 문의는  
[홈페이지 문의게시판](https://codef.io/#/cs/inquiry)에 등록 부탁드립니다.