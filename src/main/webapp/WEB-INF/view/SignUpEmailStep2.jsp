<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/SignUpEmailStep2.css" type="text/css" media="screen" />
<meta charset="UTF-8">
<title>회원가입(개인정보 입력)</title>
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
			<!--
				일단 보류... 다른거 다 만들고 이미지 넣기
				<div class="SignUpEmailStep1_title">
					<img src="${pageContext.request.contextPath}/resources/images/SignUpEmailStep1Title.png"/>
				</div>
			-->
				<form action="/Project-P/regist/SignUpEmail/step3">
					<div class="email">
						<label>이메일*</label><br><br>
						<input type="email" required placeholder="이메일을 입력해주세요.">
						<input type="button" value="중복확인">
					</div>
					<div class="password">
						<label>비밀번호*</label><br><br>
						<input type="password" required placeholder="비밀번호를 입력해주세요.">
						<input type="checkbox" disabled="disabled">
					</div>
					<div class="confirmPW">
						<input type="password" required placeholder="비밀번호를 한번 더 입력해주세요.">
						<input type="checkbox" disabled="disabled">
					</div>
					<div class="birthday">
						<label>생년월일*</label><br><br>
						<input type="date" required>
					</div>
					<div class="sex">
						<label>성별*</label><br><br>
						<label><input type="radio" name="sex" value="man" checked="checked">남자</label>
						<label><input type="radio" name="sex" value="woman">여자</label>
					</div>
					<input type="submit" id="next" value="다음">
				</form>
				<form action="/Project-P/regist/main">
					<input type="submit" id="cancle" value="가입취소">
				</form>
			</div>
		</div>
	</div>
<!--
<form:form action="step3" commandName="memberInfo">
	<p> <label>이메일 : <form:input path="email"/> </label> </p>
	<form:errors path="email"/>
	<p> <label>비밀번호 : <form:password path="passwd"/> </label> </p>
	<form:errors path="passwd"/>
	<p> <label>비밀번호 확인 : <form:password path="confirmPasswd"/> </label>
	<form:errors path="confirmPasswd"/>
	<p> <label>생년월일 : <form:input path="birth_date"/> </label> </p>
	<form:errors path="birth_date"/>
	<p> <label>성별 : <form:input path="sex"/> </label> </p>
	<form:errors path="sex"/>

	<input type="submit" value="다음">
</form:form>
-->
</body>
</html>