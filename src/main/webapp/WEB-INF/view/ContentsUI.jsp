<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ContentsUI입니다.</title>
</head>
<body>
	<form action="/Project-P/contents/savePicture" method="POST" enctype="multipart/form-data">
		<input type="file" name="pictureFile" />
   		<input type="submit" value="서버전달"/>
	</form>
</body>
</html>