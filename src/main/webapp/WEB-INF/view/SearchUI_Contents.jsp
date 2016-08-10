<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="SearchModelContents">
		<form:input path="title" />
		<input type="submit" value="검색">
	</form:form>
	<c:if test="${empty contests}">
		검색결과가 없습니다.
	</c:if>

	<c:if test="${!empty contests}">
		<table>
			<tr>
				<th>게시글제목</th>
				<th>요약글</th>
				<th>작성자</th>
			</tr>
			<c:forEach var="con" items="${contests}">
				<tr>
					<td>${con.title}</td>
					<td>${con.summary}</td>
					<td>${con.writer}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>