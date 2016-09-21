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
					<a href="/Project-P/Profile/main"><img src="${pageContext.request.contextPath}/resources/images/my_image.jpg"></a>
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
		
				<!-- 컨트롤러에서 이 값들을 가지고 값들이 변경됬는지 판단한다. 이메일, 닉네임이 변경되었다면 중복검사를, 비밀번호가 변경되었다면 비밀번호 확인란이 입력됬는지 
					그리고 비밀번호 확인란과 일치하는지 검사한다.-->
				<input type="hidden" name="orignalEmail" value="${커맨드 객체의 이메일 값이 들어간다}">
				<input type="hidden" name="orignalPasswd" value="${커맨드 객체의 패스워드 값이 들어간다}">
				<input type="hidden" name="orignalNickname" value="${커맨드 객체의 닉네임 값이 들어간다}">
				<div class="panel panel-default">
					<div class="panel-heading"><h3 class="panel-title">이메일*</h3></div>
					<div class="panel-body">
						<input type="text" value="커맨드 객체의 이메일 값이 들어간다.">
						<label>에러가 출력될 곳</label>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading"><h3 class="panel-title">비밀번호*</h3></div>
					<div class="panel-body"> 
						<input type="password" value="커맨드 객체의 비밀번호 값이 들어간다.">
						<label>에러가 출력될 곳</label>
					</div>
					<div class="panel-heading"><h3 class="panel-title">비밀번호 확인</h3></div>
					<div class="panel-body">
						<input type="password" value="커맨드 객체의 비밀번호 확인 값이 들어간다.">
						<label>에러가 출력될 곳</label>
					</div>
				</div>
				<div class="panel panel-default">
				<!-- 생일은 아직 보류... 현재 아이디어는 사용자가 가입당시 입력했던 생일을 읽어와서 forEach문을 돌리다가 
				if문으로 사용자가 입력했던 생일과 forEach의 특정 년, 월, 일과 맞는다면 그 값을 체크하는?-->
					<div class="panel-heading"><h3 class="panel-title">생일*</h3></div>
					<div class="panel-body">
						Panel content
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading"><h3 class="panel-title">성별*</h3></div>
					<div class="panel-body">
						<div class="radio">
							<label><input type="radio" name="optionsRadios" id="optionsRadios3" value="man"> 남자</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="optionsRadios" id="optionsRadios3" value="woman"> 여자</label>
						</div>
					</div>
				</div>
					<div class="panel panel-default">
					<div class="panel-heading"><h3 class="panel-title">닉네임*</h3></div>
					<div class="panel-body">
						<input type="text" value="커맨드 객체의 닉네임 값이 들어간다.">
						<label>에러가 출력될 곳</label>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading"><h3 class="panel-title">자기소개*</h3></div>
					<div class="panel-body">
						<input type="text" value="커맨드 객체의 자기소개 값이 들어간다.">
						<label>에러가 출력될 곳</label>	
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading"><h3 class="panel-title">사진</h3></div>
					<div class="panel-body">
					<!-- 이미 업로드 한 사진이 노출된다... 내가 선택한 파일이 올라가게 하고싶다... 부트스트랩에 미디어객체? 그거 쓰면 되지 않을까...-->
						<label>현재 사진이 업로드될 곳</label>
						<input type="file" value="사진 업로드">
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading"><h3 class="panel-title">가입일</h3></div>
					<div class="panel-body">
						<label>커맨드 객체의 가입일이 들어갈 곳/ 수정이 불가하므로 라벨로 표시...</label>
					</div>
				</div>
			<div class="btn-group btn-group-justified" role="group" aria-label="...">
				<div class="btn-group" role="group">
					<a href="/Project-P/Profile/modify"><button type="button" class="btn btn-default btn-custom">초기화</button></a>
				</div>
				<div class="btn-group" role="group">
					<a href="/Project-P/Profile/modifyProcess"><button type="button" class="btn btn-default btn-custom">정보수정</button></a>
				</div>
				<div class="btn-group" role="group">
					<a href="/Project-P/Profile/deleteProcess"><button type="button" class="btn btn-default">탈퇴</button></a>
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