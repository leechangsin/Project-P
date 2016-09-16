<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="kor">
 <head>
  <meta charset="UTF-8">
  <title>petsi - 애완동물 모여라  </title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/basic.css"/>
 </head>
 <body>
 	<div id="header">
		<div class="header_w">
			<div class="logo">
				<a href="/Project-P/"><img src="${pageContext.request.contextPath}/resources/images/logo.png"/></a>
			</div>
			<div class="infolink">
				<a href="/Project-P/SearchUI/Main"><img src="${pageContext.request.contextPath}/resources/images/search.png"/></a>
			</div>
			<div class="login">
				<a href="/Project-P/login/main"><img src="${pageContext.request.contextPath}/resources/images/header_icon.png"/></a>
				<a href="/Project-P/login/main"><img src="${pageContext.request.contextPath}/resources/images/login.png"/></a>
			</div>
			<input id="text_box" type="text" placeholder="검색하기">
		</div>
	</div>
	<div class="cont">
        <div class="container">
			<img src="${pageContext.request.contextPath}/resources/images/mainlogin.png" />
        	<ul  class="inlogin1">
				<li><a href="#"><img src="${pageContext.request.contextPath}/resources/images/login1.png" /></a></li>
			</ul>
        	<ul  class="inlogin2">
				<li><a href="#"><img src="${pageContext.request.contextPath}/resources/images/login2.png" /></a></li>
			</ul>
		</div>
	</div>
	<div id="menu_aside">
     	<ul class="nav">
			<li class="group">
				<div class="title">펫시들의 영상보기</div>
					<ul class="sub">
						<li><a href="#">강아지 멍멍</a></li>
						<li><a href="#">고양이 야옹</a></li>
						<li><a href="#">다른 친구들보기</a></li>
					</ul>
				</li>
			<ul class="nav">
				<li class="group">
					<div class="title">펫시들의 이야기~~</div>
					<ul class="sub">
						<li><a href="#">펫시 뉴스</a></li>
						<li><a href="#">펫시가 알면 좋은것</a></li>
						<li><a href="#">왁자지껄 우리끼리</a></li>
					</ul>
				</li>
				<ul class="nav">
					<li class="group">
					<div class="title">펫시 정보~~</div>
						<ul class="sub">
							<li><a href="#">분양해요</a></li>
							<li><a href="#">사고팔기</a></li>
							<li><a href="#">펫시샵</a></li>
						</ul>
					</li>
				</ul>
		</div>
	<div id="wrapper">
  		<div id="firstVideo">
    		<iframe width="200" height="200" src="https://www.youtube.com/embed/9gTw2EDkaDQ" frameborder="0" allowfullscreen></iframe>
		</div>
  		<div id="secondVideo">
  			<iframe width="200" height="200" src="https://www.youtube.com/embed/9gTw2EDkaDQ" frameborder="0" allowfullscreen></iframe>
  		</div>
  	</div>
 </body>
</html>