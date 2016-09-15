<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
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
					<form action="/Project-P/regist/changPW">
						<input type="password" name="passwd" size="50" maxlength="16" required placeholder="비밀번호를 입력"><br>
						<input type="password" name="rePasswd" size="50" maxlength="16" required placeholder="비밀번호를 재입력">
						<input type="submit" id="next" value="다음">
					</form>
				</div>
				<form action="/Proejct-P/login/main">
					<input type="submit" id="cancle" value="취소">
				</form>
			</div>
		</div>
	</div>
</body>
</html>