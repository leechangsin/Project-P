<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지(약관동의)</title>
</head>
<body>

<form action="/Project-P/regist/SignUpEmail/step2">
	<p>약관1 <br>
	<label> <input type="checkbox" name="agree1" value="true"> 약관동의</label>

	<p>약관2 <br>
	<label> <input type="checkbox" name="agree2" value="true"> 약관동의</label>
	
	<input type="submit" value="다음">
</form>

<form action="/Project-P/regist/main">
	<input type="submit" value="가입취소"> <br>
</form>

</body>
</html>