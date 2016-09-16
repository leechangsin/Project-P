<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" type="text/css" media="screen" />
<meta charset="UTF-8">
<title>Project-P Login UI</title>
</head>
<body>
    <div class="wrapper">
        <div class="main">
            <div class="logo">
                <a href="/Project-P/index">
                	<img src="${pageContext.request.contextPath}/resources/images/logo2.png" />
                </a>
            </div>
			<div class="login_box">
				<form:form action="loginRequest" commandName="authInfo">
					<div class="input_email">
						<label>이메일 : </label>
						<form:input path="email" placeholder="이메일을 입력해주세요!" />
						<form:errors path="email" />
					</div>
					<div class="input_PW">
						<label>비밀번호 : </label>
						<form:password path="passwd" placeholder="비밀번호를 입력해주세요!" />
						<form:errors path="passwd" />
					</div>
					<div class="check">
						<label><input type="checkbox">이메일 저장</label>
					</div>
					<div class="login_btn">
						<input type="submit" id="submit" value="로그인">
					</div>
				</form:form>
				<div class="fb_login">
					<input type="submit" value="페이스북 로그인(미구현)">
				</div>
				<div class="kakao_login">
					<input type="submit" value="카카오톡 로그인(미구현)">
				</div>

				<div class="last">
					<div class="join">
						<a href="/Project-P/regist/main">회원가입</a>
					</div>
					<div class="PW_search">
						<a href="/Project-P/PW_Search/main">비밀번호 찾기</a>
					</div>
				</div>
			</div>
		</div>
    </div>
</body>
</html>