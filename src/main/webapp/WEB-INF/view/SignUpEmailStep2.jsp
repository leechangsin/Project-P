<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입(개인정보 입력)</title>
</head>
<body>
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

<form:form action="/Project-P/regist/main">
	<input type="submit" value="가입취소">
</form:form>
</body>
</html>