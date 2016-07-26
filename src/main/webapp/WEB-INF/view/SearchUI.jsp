<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 검색하는 영역 -->
	검색하는 영역
	<input type="text" name="search" id="search">
	
	<br><br>
	<%-- <form:input path="search" /> --%>

	<!-- 출력하는 영역 -->
	 <%@ include file="Search_item.jsp" %> 
	
</body>
</html>