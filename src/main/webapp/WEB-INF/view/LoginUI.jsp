<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project-P Login UI</title>
</head>
<body>

	<form action="/Project-P/main/showMain" method="post">
		<input type="submit" name="go_Main" value="Logo_Main"> <br>
	</form>

	<form action="loginRequest" method="post">
		이메일 텍스트 : <input type="email" name="email_Text" placeholder="이메일을 입력하세요." required autofocus> <br>
		<form:errors path="email"/>//에러메세지를 출력하는 form:errors 태그
		비밀번호 텍스트 : <input type="password" name="PW_Text" placeholder="비밀번호를 입력하세요." required> <br>
		<form:errors path="password"/>//에러메세지를 출력하는 form:errors 태그
		이메일 저장 <input type="checkbox" name="Login_Save_Email_Check"> <br> <input type="submit" value="로그인" /><br> <br>
	</form>

	페이스북 로그인 <br> 
	카카오톡 로그인 <br> <br>

	<form action="/Project-P/regist/main" method="post">
		<input type="submit" value="회원가입" />
	</form>

	<form action="/Project-P/PW_Search/main" method="post">
		<input type="submit" value="비밀번호 찾기">
	</form>
</body>
</html>