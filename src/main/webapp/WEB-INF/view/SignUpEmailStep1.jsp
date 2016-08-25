<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/regist.css" type="text/css" media="screen" />
<meta charset="UTF-8">
<title>회원가입 페이지(약관동의)</title>
</head>
<body>
	<div class="wrapper">
		<div class="main">
			<div class="logo">
				<a href="/Project-P/index">
					<img src="${pageContext.request.contextPath}/resources/images/logo2.png" />
				</a>
			</div>
			<div class="box">
				<div class="SignUpEmailStep1_title">
					<img src="${pageContext.request.contextPath}/resources/images/SignUpEmailStep1Title.png"/>
				</div>
				<form action="/Project-P/regist/SignUpEmail/step2">
					<div class="access_term1_title">
						서비스 이용약관 동의(필수)
					</div>
					<div class="access_term1_check">
						<input type="checkbox" name="agree1" value="true">
					</div>
					<div class="access_term1_content">
						<textarea readonly disabled>
							서비스 이용약관 동의(필수)에 관련된 내용입니다.
							수정이 불가능하고 읽기만 됩니다.
						</textarea>
					</div>
					<div class="access_term2_title">
						개인정보 수집 및 이용동의(필수)
					</div>
					<div class="access_term2_check">
						<input type="checkbox" name="agree2" value="true">
					</div>
					<div class="access_term2_content">
						<textarea readonly disabled>
							개인정보 수집 및 이용동의(필수)에 관련된 내용입니다.
							수정이 불가능하고 읽기만 됩니다.
						</textarea>
					</div>
					<input type="submit" value="다음">
				</form>

				<form action="Project-P/regist/main">
					<input type="submit" value="가입취소">
				</form>
			</div>
		</div>
	</div>
</body>
</html>