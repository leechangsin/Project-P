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
	
<c:if test="${! empty memberList}">
<form:form method="GET" commandName="searchParam">
    이름: <form:input path="name" />
    이메일: <form:input path="email" />
    <input type="submit" value="검색" />
</form:form>
	
	</c:if>
	
	 출력하기 -> ${greeting} <- 여기까지
	dd2d ${test1} ddd2
	
	<!-- 검색하는 영역 -->
	검색하는 영역
	<input type="text" name="search" id="search">
	
	<br><br>
	<%-- <form:input path="search" /> --%>

	<!-- 출력하는 영역 -->
	 <%@ include file="Search_item.jsp" %> 
	
</body>
</html>