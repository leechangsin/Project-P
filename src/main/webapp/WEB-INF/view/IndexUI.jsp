<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>여러분들과 함께하는 펫</title>
</head>
<body>
<!-- Login에 성공하면 LoginUI_Controller에서 Login_Email_Text로 값이 넘어옴 -->

<div id='mainUI'>
	<!-- Head 영역 -->
	<div id='Head'><%@ include file="HeadUI.jsp" %></div>
	<!-- Aside 영역 -->
	<div id='Aside'><%@ include file="AsideUI.jsp" %></div>
	<!-- Contents 영역 -->
	<div id='Contents'><%@ include file="ContentsUI.jsp" %></div>
	<div id='Head_Contents'><%@ include file="Head_ContentsUI.jsp" %></div>
	<!-- Category 영역 -->
	<div id='Category'><%@ include file="CategoryUI.jsp" %></div>
	<!-- Footer 영역 -->
	<div id='Footer'><%@ include file="FooterUI.jsp" %></div>

</div>

</body>
</html>