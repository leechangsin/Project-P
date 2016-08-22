<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project-P Login UI</title>
</head>
<body>
    <div class="wrapper">        
        <div class="main">           
            <div class="logo">                                                                               
                <a href="/Project-P/index">
                	<img src="/images/images/logo2.png" />
                </a>
            </div>
            <div class="login_box">
            	<form:form action="loginRequest" commandName="memberInfo">
         			<div class="input_email">
         				<label>이메일 : </label> 
         				<form:input path="email" placeholder="이메일을 입력해주세요!" /> <br>
         				<form:errors path="email" /><!-- 에러메세지를 출력하는 form:errors 태그 -->
         			</div>
         			<div class="input_PW">
						<label>비밀번호 : </label> 
						<form:password path="passwd" placeholder="비밀번호를 입력해주세요!" /> <br>
						<form:errors path="passwd" /><!-- 에러메세지를 출력하는 form:errors 태그  -->
					</div>
					<div class="check">
                    	<label><input type="checkbox">이메일 저장</label>
               		</div>
               		<div class="login_btn">
						<input type="submit" id="submit" value="로그인">
					</div>
            	</form:form>
            </div>
            <div class="fb_login">
             	<input type="submit" value="페이스북 로그인(미구현)">
             </div>
             <div class="kakao_login">
                <input type="submit" value="카카오톡 로그인(미구현)">
             </div>
            <div class="last">
                <form class="join" action="/Project-P/regist/main" method="post">
                <!-- 원래는 a태그로 해서 텍스트를 눌렀을 경우 이동해야한다. 그럴려면 jquery를 알아야 하는듯... -->
                <!-- 나중에 수정하기...-->
					<input id="goRegistUI" type="submit" value="회원가입" />
				</form>
				<form class="search" action="/Project-P/PW_Search/main" method="post">
				<!-- 원래는 a태그로 해서 텍스트를 눌렀을 경우 이동해야한다. 그럴려면 jquery를 알아야 하는듯... -->
                <!-- 나중에 수정하기...-->
					<input id="goSearchPW" type="submit" value="비밀번호 찾기">
				</form>
            </div>
        </div>
    </div>
</body>
</html>