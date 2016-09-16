<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/SignUpEmailStep4.css" type="text/css" media="screen" />
<meta charset="UTF-8">
<title>회원가입 성공</title>
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
			<div class="step_title">
				<img src="${pageContext.request.contextPath}/resources/images/SignUpEmailStep4Title.png"/>
			</div>
			<div class="box">
				<div class="welcomeImage">
					<img src="${pageContext.request.contextPath}/resources/images/testImage.png">
				</div>
				
				<div class="welcomeMSG">
					<label> 가입이 완료되었습니다. </label><br>
					<label> 더 즐겁게 펫시를 이용하실 수 있습니다.</label>
				</div>

				<div class="confirmMSG">
					<label id="nickname">${nickName}</label> <label>님의 이메일은</label>
					<label id="email">${email}</label> <label>입니다.</label>
				</div>
				
				<form action="/Project-P/index">
					<div class="startBtn">
						<input type="submit" id="start" value="시작하기">
						<input type="hidden" id="email" value="${email}">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>