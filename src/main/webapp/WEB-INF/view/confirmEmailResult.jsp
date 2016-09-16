<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.0.min.js"></script>

<c:if test="${result.equals(success)}">
    <script>
    	alert("사용이 가능한 이메일입니다.");
    	location.href="/Project-P/regist/SignUpEmail/step3";
    </script>
</c:if>
<c:if test="${result.equals(fail)}">
    <script>
    	alert("사용이 불가능한 이메일입니다.");
    	location.href="/Project-P/regist/SignUpEmail/step3";
    </script>
</c:if>