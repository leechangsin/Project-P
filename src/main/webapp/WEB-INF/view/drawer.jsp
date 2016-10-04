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
			<div class="container-fluid">
				<div class="row">
					<c:forEach var="i" begin="0" end="${con_ids.size()-1}">
						<c:set var="con_id" value="${con_ids.get(i)}"/>
						<c:set var="title" value="${titles.get(i)}"/>
						<c:set var="text" value="${texts.get(i)}"/>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<div class="thumbnail">
								<img src="/Project-P/Profile/getContentsImage?con_id=${con_id}">
								<div class="caption">
									<p id="thumbnail_title">${title}</p>
								</div>
								<button class="btn btn-default" data-target="#layerpop${con_id}" data-toggle="modal">자세히 보기</button>
								<div class="modal fade" id="layerpop${con_id}">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">×</button>
												<h4 id="modal-header-title">${title}</h4>
											</div>
											<div class="modal-body">
												<img src="/Project-P/Profile/getContentsImage?con_id=${con_id}">
												<video controls src="/Project-P/Profile/getContentsVideo?con_id=${con_id}"></video>
												<textarea rows="10" cols="78" disabled>${text}</textarea>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
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

<script>
	$(document).ready(function(){
		
	})
</script>
</html>