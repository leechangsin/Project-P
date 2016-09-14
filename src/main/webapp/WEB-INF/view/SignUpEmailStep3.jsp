<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/SignUpEmailStep3.css" type="text/css" media="screen" />
<meta charset="UTF-8">
<title>회원가입(계정정보 입력)</title>
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
				<img src="${pageContext.request.contextPath}/resources/images/SignUpEmailStep3Title.png"/>
			</div>
			<div class="box">
				<form:form action="/Project-P/regist/SignUpEmail/step4" commandName="member" enctype="multipart/form-data">
					<div class="pictureUpload">
						<label> 사진을 업로드 해주세요 <input type="file" name="pictureFile"></label>
					</div>
					<div class="nickname">
						<label>닉네임*</label><br><br>
						<form:input path="nickname" placeholder="닉네임을 입력해주세요.(최대 14자)" maxlength="14"/>
						<form:errors path="nickname"/>
						
					</div>
					<div class="introduce">
						<label>자기소개*</label><br><br>
						<form:input path="intro" placeholder="자신을 표현해주세요.(최대 17자)" maxlength="17"/>
						<form:errors path="intro"/>
					</div>
					<input type="submit" id="next" value="다음">
				</form:form>
				<form action="/Project-P/regist/main">
					<input type="submit" id="cancle" value="가입취소">
				</form>
			</div>
		</div>
	</div>
</body>
</html>