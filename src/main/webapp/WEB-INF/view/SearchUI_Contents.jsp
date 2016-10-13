<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/searchContents.css" type="text/css" media="screen" />
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
				<a href="/Project-P/Search/main"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>검색하러가기</a>
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
				<c:if test="${!empty member}">
					<c:set var="nickName" value="${member.nickname}" />
					<div class="profile_image">
						<a href="/Project-P/Profile/main"><img src="/Project-P/Profile/getProfileImage"></a>
					</div>
					<div class="profile_nickName">
						<a href="/Project-P/Profile/main">${nickName}</a>
					</div>
					<div class="active">
						<div class="write">
							<a href="/Project-P/Profile/write">
								<img src="${pageContext.request.contextPath}/resources/images/write_icon.png">글쓰기
							</a>
						</div>
						<div class="drawer">
							<a href="/Project-P/Profile/drawer">
								<img src="${pageContext.request.contextPath}/resources/images/drawer_icon.png">보관함
							</a>
						</div>
						<div class="modify">
							<a href="/Project-P/Profile/modify">
								<img src="${pageContext.request.contextPath}/resources/images/cog_icon.png">정보수정
							</a>
						</div>
					</div>
				</c:if>
				<c:if test="${empty member}">
				<!-- 여기서 요청하고 로그인하고 나면 Index로 돌아가게된다... 요청한뷰(URL)를 알아내서 컨트롤러로 반환한 다음에 로그인 처리를 하고
				요청한 뷰로 돌아오도록 고쳐야한다. -->
					<div class="login_title">
						<label>로그인하세요.<br> 더욱 즐거워집니다!
						</label><br>
					</div>
					<div class="login_image">
						<a href="/Project-P/login/main">
							<img src="${pageContext.request.contextPath}/resources/images/login1.png">
						</a>
					</div>
					<div class="login_regist">
						<a href="/Project-P/regist/main">회원가입</a>
					</div>
				</c:if>
			</div>
		</div>
		<!-- contents -->
		<div id="contents">
			<form action="/Project-P/Search/search_users" method="post">
				<input type="text" name="keyword" required placeholder="검색어를 입력하세요.">
				<div class="btn-group btn-group-justified" role="group">
					<div class="btn-group" role="group">
						<button type="submit" name="requestType" value="사용자" class="btn btn-default">사용자</button>
					</div>
					<div class="btn-group" role="group">
						<button type="submit" name="requestType" value="게시물" class="btn btn-default" autofocus>게시물</button>
					</div>
				</div>
			</form>
			<div class="resultBox">
				<c:if test="${!empty results}">
					<c:forEach var="i" begin="0" end="${results.size()-1}">
						<c:set var="result" value="${results.get(i)}" />
						<div class="media">
							<div class="media-left">
								<img src="/Project-P/Search/getContentsImage?con_id=${result.con_id}">
							</div>
							<div class="media-body">
								<p><strong>제목 : </strong> ${result.title}</p>
								<p><strong>내용 : </strong> ${result.text}</p>
								<button class="btn btn-default" data-target="#layerpop${result.con_id}" data-toggle="modal">자세히보기</button>
								<div class="modal fade" id="layerpop${result.con_id}">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">×</button>
												<h4 id="modal-header-title">${result.title}</h4>
											</div>
											<div class="modal-body">
												<img src="/Project-P/Search/getContentsImage?con_id=${result.con_id}">
												<video controls src="/Project-P/Search/getContentsVideo?con_id=${result.con_id}"></video>
												<textarea rows="10" cols="78" disabled>${result.text}</textarea>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty results}">
					<img src="${pageContext.request.contextPath}/resources/images/not_found.png">
					<label> 검색결과가 없습니다.<br> 검색어를 확인바랍니다.
					</label>
				</c:if>
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