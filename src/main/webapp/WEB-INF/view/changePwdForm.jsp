<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<form:form>
<spring:message code="crrentPassword" />
<form:input path="currentPassword"/><br>
<form:errors path="currentPassword"/>
<p>

<spring:message code="newPassword"/>
<form:password path="newPassword"/>
<form:errors path="newPassword"/>
<input type="submit" value="<spring:message code="change.btn"/>">
</p>
</form:form>

</body>
</html>