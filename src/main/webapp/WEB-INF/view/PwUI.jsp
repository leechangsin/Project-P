<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/resultpage" commandName="password_change">
		<label>현재 비밀번호 </label> <form:input path="passwd_current" /> <br>
		<form:errors path="passwd" /> <br> <!-- 에러메세지를 출력하는 form:errors 태그 -->
		<label>변경할 비밀번호  </label> <form:password path="passwd_check01" /> <br>
		<form:errors path="passwd" /> <br> <!-- 에러메세지를 출력하는 form:errors 태그  -->
		<label>변경할 비밀번호 재확인  </label> <form:password path="passwd_check02" /> <br>
		<form:errors path="passwd" /> <br> <!-- 에러메세지를 출력하는 form:errors 태그  -->
		<input type="submit" value="변경하기">
	</form:form>

</body>
</html>