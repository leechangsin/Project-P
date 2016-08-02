<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>   

<form:form commandName="SearchModel">
<form:input path="nickname"/>
<input type="submit" value="검색">
</form:form>
<c:if test="${empty members}">
검색결과가 없습니다.
</c:if>

<c:if test="${!empty members}">
<table>
	<tr>
	<th>아이디</th><th>이메일</th><th>인트로</th>
	</tr>
	<c:forEach var="mem" items="${members}">
	<tr> 
		<td>${mem.nickname}</td>
		<td>${mem.email}</td>
		<td>${mem.intro}</td>
	</tr>
	</c:forEach>

</table>
</c:if>
</body>
</html>