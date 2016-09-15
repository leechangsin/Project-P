<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/PW_Search.css" type="text/css" media="screen" />
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
		<div class="top">
			<div class="logo">
				<a href="/Project-P/index">
					<img src="${pageContext.request.contextPath}/resources/images/logo2.png" />
				</a>
			</div>
		</div>
		<div class="bottom">
			<div class="box">
				<div class="titlebox">
					<label>회원님이 가입하신 이메일 계정을 입력하세요.</label>
				</div>
				<div class="emailbox">
					<form action="/Project-P/inputCode">
						<input type="text" id="firstEmail">
						<label>@</label>
						<input type="text" id="secondEmail"><br>
						<input type="submit" id="next" value="다음">
					</form>
				</div>
				<form action="/Proejct-P/login/main">
					<input type="submit" id="cancle" value="취소">
				</form>
			</div>
		</div>
	</div>
</body>
</html>