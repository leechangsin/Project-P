<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/drawer.css" type="text/css" media="screen" />
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
				<input type="text" placeholder="검색하기" size="30">
				<a href="/Project-P/searchUI/main"><img src="${pageContext.request.contextPath}/resources/images/search.png"/></a>
			</div>
			<div class="login_area">
				<c:if test="${!empty member}">
					<a href="/Project-P/login/logout">
						로그아웃
						<img width="50px" height="50px" src="${pageContext.request.contextPath}/resources/images/logout.png">
					</a>
				</c:if>
				<c:if test="${empty member }">
					<a href="/Project-P/login/main">
						<img src="${pageContext.request.contextPath}/resources/images/header_icon.png"/>
						<img src="${pageContext.request.contextPath}/resources/images/login.png"/>
					</a>
				</c:if>
			</div>
		</div>
		<!-- sideinfo -->
		<div id="sideinfo">
			<div class="loginbox">
				<c:set var="nickName" value="${member.nickname}" />
				<div class="profile_image">
					<a href="/Project-P/Profile/main"><img src="/Project-P/Profile/getProfileImage"></a>
				</div>
				<div class="profile_nickName">
					<a href="/Project-P/Profile/main">${nickName}</a>
				</div>
				<div class="active">
					<div class="write">
						<a href="/Project-P/Profile/write"><img src="${pageContext.request.contextPath}/resources/images/write_icon.png">글쓰기</a>
					</div>
					<div class="drawer">
						<a href="/Project-P/Profile/drawer"><img src="${pageContext.request.contextPath}/resources/images/drawer_icon.png">보관함</a>
					</div>
					<div class="modify">
						<a href="/Project-P/Profile/modify"><img src="${pageContext.request.contextPath}/resources/images/cog_icon.png">정보수정</a>
					</div>
				</div>
			</div>
		</div>
		<!-- contents -->
		<div id="contents">
			<c:set var="email" value="${memberInfo.email}"/>
			<c:set var="birth_date" value="${memberInfo.birth_date}"/>
			<c:set var="sex" value="${memberInfo.sex}"/>
			<c:set var="nickname" value="${member.nickname}"/>
			<c:set var="intro" value="${member.intro}"/>
			<c:set var="reg_date" value="${memberInfo.reg_date}"/>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">이메일</h3>
				</div>
				<div class="panel-body">
					<label>${email}</label>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">생일</h3>
				</div>
				<div class="panel-body">
					<label>${birth_date}</label>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">성별</h3>
				</div>
				<div class="panel-body">
					<label>${sex}</label>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">닉네임</h3>
				</div>
				<div class="panel-body">
					<label>${nickname}</label>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">자기소개</h3>
				</div>
				<div class="panel-body">
					<label>${intro}</label>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">사진</h3>
				</div>
				<div class="panel-body">
					<div class="profile_image">
						<img src="/Project-P/Profile/getProfileImage">
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">가입일</h3>
				</div>
				<div class="panel-body">
					<label>${reg_date}</label>
				</div>
			</div>
		</div>
		<!-- footer -->
		<div id="footer">
			<div class="left_link">
				<div class="btn-group dropup">
					<button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
						More pet-si
						<span class="caret"></span> 
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">회사소개</a>
						<li><a href="#">이용약관</a>
						<li><a href="#">저작권</a>
						<li><a href="#">신고기능 안내</a>
						<li><a href="#">고객센터</a>
					</ul>
				</div>
			</div>
			<div class="center_link">
				<a href="#">광고 문의</a>
				<a href="#">제휴 문의</a>
				<a href="#">개인 정보 취급방침</a>
				<label class="AppDownload">App Download</label>
			</div>			
			<div class="right_link">
				<a href="#"><img src="${pageContext.request.contextPath}/resources/images/googleplay_icon.png"></a>
				<a href="#"><img src="${pageContext.request.contextPath}/resources/images/appstore_icon.png"></a>
			</div>
		</div>
	</div>
</body>
</html>