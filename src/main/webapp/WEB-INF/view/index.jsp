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
		<div id="sideinfo">
			<div class="loginbox">
				<c:if test="${!empty member}">
					<c:set var="nickName" value="${member.nickname}"/>
					<div class="profile_image">
						<a href="#"><img src="${pageContext.request.contextPath}/resources/images/my_image.jpg"></a>
					</div>
					<div class="profile_nickName">
						<a href="#">${nickName}</a>
					</div>
					<div class="active">
							<a href="#"><img src="${pageContext.request.contextPath}/resources/images/write_icon.png">글쓰기</a>
							<a href="#"><img src="${pageContext.request.contextPath}/resources/images/drawer_icon.png">보관함</a>
					</div>
				</c:if>
				<c:if test="${empty member }">
					<div class="login_title">
						<label>로그인하세요.<br> 더욱 즐거워집니다!
						</label><br>
					</div>
					<div class="login_image">
						<a href="/Project-P/login/main"><img src="${pageContext.request.contextPath}/resources/images/login1.png"></a>
					</div>
					<div class="login_regist">
						<a href="/Project-P/regist/main">회원가입</a>
					</div>
				</c:if>
			</div>
			<div class="categorybox">
				<div class="static_area">
					<a href="">홈</a><br>
					<a href="">피키툰</a><br>
				</div>
				<div class="dynamic_area">
					<label>골라보기</label><br>
					<a href=""># 애완동물 용품점</a><br>
					<a href=""># 페르시안 친칠라</a><br>
					<a href="">(symbol) 강아지 볼래?</a><br>
					<a href="">(symbol) 파충류도 되지</a><br>
					<a href="">(symbol) 이렇게 이 사이트는</a><br>
					<a href="">(symbol) 발전 가능성이 무궁구진</a><br>
					<a href="">(symbol) 반려동물은</a><br>
					<a href="">(symbol) 내가 키우면 반려동물</a><br>
					<a href="">(symbol) 종류의 제한은 없지</a><br>
					<a href="">(symbol) 이 사이트는</a><br>
					<a href="">(symbol) 반려동물의 사진, 동영상</a><br>
					<a href="">(symbol) 용품까지 모두 등록이</a><br>
					<a href="">(symbol) 되지</a><br>
					<a href="">(symbol) 이걸 꼭 상업화 시키고</a><br>
					<a href="">(symbol) 싶네</a><br>
					<a href="">(symbol) 잘 될텐데</a><br>
					<a href="">(symbol) 크쿄쿄쿄</a><br>
				</div>
			</div>
		</div>
		<div id="contents">
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="${pageContext.request.contextPath}/resources/images/carousel1.jpg">
						<div class="carousel-caption">캐러셀 테스트용 이미지1입니다.</div>
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/resources/images/carousel2.jpg">
						<div class="carousel-caption">캐러셀 테스트용 이미지2입니다.</div>
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/resources/images/carousel3.jpg">
						<div class="carousel-caption">캐러셀 테스트용 이미지3입니다.</div>
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			
			<c:forEach begin="0" end="31">
				<div class="content">
					<video src="https://www.youtube.com/watch?v=25y8-5hAAdU" controls preload="metadata"></video>
				</div>
			</c:forEach>
		</div>
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