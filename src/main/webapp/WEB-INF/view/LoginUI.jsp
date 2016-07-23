<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project-P Login UI</title>
</head>
<body>
	
	<form action="main" method="post">
		이메일 텍스트 : ${Login_Email_Text} <br> 
		비밀번호 텍스트 : ${Login_PW_Text} <br>
		
		이메일 저장 <input type="checkbox" name="Login_Save_Email_Check"> <br>
		
		<input type="submit" value="로그인"/><br><br>
	</form>
	
	페이스북 로그인 <br>
	카카오톡 로그인 <br><br>
	
	<form action="regist/main" method="post">
		<input type="submit" value="회원가입"/>
	</form>
	
	<form action="PW_Search/main" method="post">
		<input type="submit" value="비밀번호 찾기">
	</form>
</body>
</html>