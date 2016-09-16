<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css" type="text/css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PetSi - 펫시</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<div class="logo_area">
				<a href="/Project-P/"><img src="${pageContext.request.contextPath}/resources/images/logo.png"/></a>
			</div>
			<div class="search_area">
				<input type="text" value="검색하기">
				<a href="/Project-P/searchUI/main"><img src="${pageContext.request.contextPath}/resources/images/search.png"/></a>
			</div>
			<div class="login_area">
				<a href="/Project-P/login/main"><img src="${pageContext.request.contextPath}/resources/images/header_icon.png"/></a>
				<a href="/Project-P/login/main"><img src="${pageContext.request.contextPath}/resources/images/login.png"/></a>
			</div>
		</div>
		<div id="content"></div>
		<div id="sideinfo"></div>
		<div id="footer">
			<div class="left_link">
				드랍다운 메뉴
			</div>
			<div class="center_link">
				<a href="#">광고 문의</a>
				<a href="#">제휴 문의</a>
				<a href="#">개인 정보 취급방침</a>
				<label>App Download</label>
			</div>			
			<div class="right_link">
				<a href="#">구글 링크</a>
				<a href="#">애플 링크</a>
			</div>
		</div>
	</div>
</body>
</html>

