<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/regist.css" type="text/css" media="screen" />
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<div class="wrapper">
		<div class="main">
			<div class="logo">
				<a href="/Project-P/index"> <img
					src="${pageContext.request.contextPath}/resources/images/logo2.png" />
				</a>
			</div>
			<div class="box">
				<div class="regist_announcement">원하시는 가입 유형을 선택해주세요.</div>
				<div class="regist_email">
					<form action="/Project-P/regist/SignUpEmail/step1">
						<input type="submit" value="이메일 계정 만들기">
					</form>
				</div>
				<div class="regist_facebook">
					<form action="#">
						<input type="submit" value="페이스북 계정 만들기(미구현)">
					</form>
				</div>
				<div class="regist_kakao">
					<form action="#">
						<input type="submit" value="카카오톡 계정 만들기(미구현)">
					</form>
				</div>
				<div class="last">
					이미 가입하셨나요? <a href="/Project-P/login/main">로그인하기</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>