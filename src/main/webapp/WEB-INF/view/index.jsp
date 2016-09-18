<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<input type="text" placeholder="검색하기" size="30">
				<a href="/Project-P/searchUI/main"><img src="${pageContext.request.contextPath}/resources/images/search.png"/></a>
			</div>
			<div class="login_area">
				<a href="/Project-P/login/main"><img src="${pageContext.request.contextPath}/resources/images/header_icon.png"/></a>
				<a href="/Project-P/login/main"><img src="${pageContext.request.contextPath}/resources/images/login.png"/></a>
			</div>
		</div>
		<div id="sideinfo">
			<div class="loginbox">
				<c:if test="${!empty member}">
					<c:set var="nickName" value="${member.nickname}"/>
					<label>${nickName}님 안녕하세요!</label>
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
			<c:forEach begin="0" end="31">
				<div class="content">
					<video src="https://www.youtube.com/watch?v=25y8-5hAAdU" controls preload="metadata"></video>
				</div>
			</c:forEach>
		</div>
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