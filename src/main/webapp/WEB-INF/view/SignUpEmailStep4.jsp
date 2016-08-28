<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
</head>
<body>
	<div class="welcomeMSG">
		<label> 가입이 완료되었습니다. </label>
		<label> 더 즐겁게 펫시를 이용하실 수 있습니다.</label>
	</div>

	<div class="confirmMSG">
		<label>${ nickName}</label> <label>님의 이메일은</label>
		<label>${ email}</label> <label>입니다.</label>
	</div>

	<div class="startBtn">
		<input type="button" value="시작하기">
	</div>

</body>
</html>