<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <br>
<!-- 
<h4> 로고부분 </h4>
 -->
<h2><a href="/Project-P">Pet For you</a></h2>
<!--
<h1> 검색부분 </h1>
검색부분은 자바스크립트로 텍스트 내용 여부 확인체크하기
 -->
<form action="SearchUI" method="post">
	<input type="text" name="search" id="search">
	<input type="submit" value="검색">
</form>
<!--
<h1> 텍스트 부분</h1>
 -->
 <c:choose>
 <c:when test="${id!=null}">
 ${id} 님 안녕하세요.<br>
 <a href="logout"> 로그아웃 하겠습니까?<br></a>
 </c:when>
 <c:otherwise>
<a href="login/main">로그인하세요. 더욱 더 즐거워 집니다.</a>
</c:otherwise>
</c:choose>

<!--
<h1> 상단 메뉴부분</h1>
 -->
	<ul>
		<li><a href='#'>상단메뉴1</a></li>
		<li><a href='#'>상단메뉴2</a></li>
		<li><a href='#'>상단메뉴3</a></li>
	</ul>
 
 

 <br>
</body>
</html>