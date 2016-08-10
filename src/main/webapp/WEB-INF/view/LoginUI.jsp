<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project-P Login UI</title>
</head>
<body>

	<form action="/Project-P/index" method="post">
		<input type="submit" name="Logo_Main" value="Logo_Main"> <br>
	</form>

	<form:form action="loginRequest" commandName="memberInfo">
		<label>이메일 : </label> <form:input path="email" /> <br>
		<form:errors path="email" /> <br> <!-- 에러메세지를 출력하는 form:errors 태그 -->
		<label>비밀번호 : </label> <form:password path="passwd" /> <br>
		<form:errors path="passwd" /> <br> <!-- 에러메세지를 출력하는 form:errors 태그  -->
		<input type="submit" value="로그인">
	</form:form>

	페이스북 로그인
	<br> 카카오톡 로그인
	<br>
	<br>

	<form action="/Project-P/regist/main" method="post">
		<input type="submit" value="회원가입" />
	</form>

	<form action="/Project-P/PW_Search/main" method="post">

		<input type="submit" value="비밀번호 찾기">
	</form>
</body>
</html>