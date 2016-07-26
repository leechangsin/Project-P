<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<c:forEach items="${list}" var="boardVO">




 <tr>

  <td>${boardVO.bno}</td>

  <td>${boardVO.writer}</td>

  <td><span class="badge bg-red">${boardVO.viewcnt }</span></td>

 </tr>




</c:forEach>



	
</body>
</html>