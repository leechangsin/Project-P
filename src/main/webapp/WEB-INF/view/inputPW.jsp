<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/inputpw.css" type="text/css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 변경</title>
</head>
<body>
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
				<div class="titlebox">
					<label>새 비밀번호를 입력해주세요!!</label><br>
				</div>
				<div class="passwdbox">
					<form:form action="/Project-P/PW_Search/changePW" method="post" commandName="passwdSet">
						<form:password path="passwd" size="50" maxlength="16" placeholder="비밀번호를 입력"/>
						<form:errors path="passwd"/>
						<form:password path="confirmPasswd" size="50" maxlength="16" placeholder="비밀번호를 재입력"/>
						<form:errors path="confirmPasswd"/>
						<form:hidden path="emailAddress" value="${passwdSet.getEmailAddress()}"/>
						<input type="submit" id="next" value="다음">
					</form:form>
				</div>
				<form action="/Project-P/login/main">
					<input type="submit" id="cancle" value="취소">
				</form>
			</div>
		</div>
	</div>
</body>
</html>