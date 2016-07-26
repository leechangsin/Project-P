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
	
	<form:form commandName="cmd">
	<p>
	<label>검색: <form:input path="search"/></label>
	<input type="submit" value="검색">
	
	</p>
	</form:form>
	
	<c:if test="${! empty members }">
	닉네임 : ${mem.nickname } <br>
	자기소개 : %{mem.intro}<br><br>
	
	
	
	</c:if>
	
	<!-- 검색하는 영역 -->
	검색하는 영역
	<input type="text" name="search" id="search">
	
	<br><br>
	<%-- <form:input path="search" /> --%>

	<!-- 출력하는 영역 -->
	 <%@ include file="Search_item.jsp" %> 
	
</body>
</html>