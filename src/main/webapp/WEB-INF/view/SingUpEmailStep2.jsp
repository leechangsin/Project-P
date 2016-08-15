<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입(개인정보 입력)</title>
</head>
<body>
<form action="step3" method="post">
	<p> <label>이메일 : <input type="email" name="email" id="email"> </label> </p>
	<p> <label>비밀번호 : <input type="password" name="pw" id="pw"> </label> </p>
	<p> <label>비밀번호 확인 : <input type="password" name="confirmPW" id="confirmPW"> </label>
	<p> <label>생년월일 : <input type="text" name="birth_date" id="birth_date"> </label>
	<p> <label>성별 : <input type="text" name="sex" id="sex"> </label>
	
	<input type="submit" value="다음">
</form>

<form action="/Project-P/regist/main">
	<input type="submit" value="가입취소"> <br>
</form>

</body>
</html>