<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/inputcode.css" type="text/css" media="screen" />
<title>비밀번호 찾기</title>
</head>
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
					<label id="emailAddress">${emailAddress}</label><label>으로</label><br>
					<label> 새 비밀번호 설정을 위한 코드를 전송하였습니다.</label><br>
					<label> 이메일을 확인해주세요.</label>
				</div>
				<div class="codebox">
					<form action="/Project-P/inputPW">
						<input type="text" id="reciveCode" required placeholder="여기에 코드를 입력해주세요." size="80">
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