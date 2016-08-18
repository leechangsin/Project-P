<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입(계정정보 입력)</title>
</head>
<body> 
<form:form action="step4" commandName="member" enctype="multipart/form-data">
	<p> <label>닉네임 : <form:input path="nickname"/> </label> </p>
	<form:errors path="nickname"/>
	<p> <label>자기소개 : <form:textarea path="intro"/> </label> </p>
	<p> <label>사진 : <input type="file" name="picture"/> </label> </p>
	
	<input type="submit" value="다음">
</form:form>

<!--  
<form action="step4">
	<input type="submit" value="다음">
</form>
-->
<form:form action="/Project-P/regist/main">
	<input type="submit" value="가입취소">
</form:form>
</body>
</html>