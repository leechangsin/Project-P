<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/modify.css" type="text/css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PetSi - 펫시</title>
</head>
<body>
	<div id="container">
		<!-- header -->
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
			<form:form action="/Project-P/Profile/writeProcess" commandName="writeForm" enctype="multipart/form-data">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">제목</h3>
					</div>
					<div class="panel-body">
						<form:input path="title" size="145" maxlegnth="20" placeholder="제목을 입력하세요."/>
						<input type="text" size="145" maxlength="20" placeholder="제목을 입력하세요.">
					</div>
					<div class="panel-heading">
						<h3 class="panel-title">내용</h3>
					</div>
					<div class="panel-body">
						<form:textarea path="contents" maxlength="100" rows="10" cols="145" placeholder="내용을 입력하세요.(100자 내)"/>
						<textarea maxlength="100" rows="10" cols="145" placeholder="내용을 입력하세요.(100자 내)"></textarea>
					</div>
					<div class="panel-heading">
						<h3 class="panel-title">동영상</h3>
					</div>
					<div class="panel-body">
						<input type="file" name="videoFile">
					</div>
					<div class="panel-heading">
						<h3 class="panel-title">사진</h3>
					</div>
					<div class="panel-body">
						<input type="file" name="pictureFile">
					</div>
					<div class="btn-group btn-group-justified" role="group">
						<div class="btn-group" role="group">
							<input type="submit" class="btn btn-default" value="글쓰기">
						</div>
						<div class="btn-group" role="group">
							<a href="/Project-P/Profile/main"><button type="button" class="btn btn-default">취소</button></a>
						</div>
					</div>
				</div>
			</form:form>
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