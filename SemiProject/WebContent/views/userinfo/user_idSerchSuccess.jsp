<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String userId = (String)request.getAttribute("userId");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/user_idSerchSuccess.css">
    <title>Document</title>
</head>
<body>
    <div class="wrap">
        <div id="header">
            <div id="header_1"></div>
            <div id="header_2">
                <a href="<%=contextPath%>"><img src="/KGG/resources/images/KGG투어로고.png" alt="" id="logo"></a>
            </div>
            <div id="header_3"></div>
        </div>
        <div id="content">
            <div id="content_1"></div>
            <div id="content_2">
                <hr>
            </div>
            <div id="content_3">
                <p id="text">
                    <strong style="color: #30449c; font-size: 20px;">회원님의 아이디는</strong><br>
                    <strong style="font-size:20px"><%=userId%>입니다.</strong><br>
                </p>
            </div>
            <div id="content_5" style="float: left;">
                <button type="button" id="btn" onclick="loginHome()">로그인</button>
            </div>
            <div id="content_6" style="float: left;">
                <button type="button" id="btn2" onclick="pwdHome()">비밀번호 찾기</button>
            </div>
            <script>
            	function loginHome(){
            		location.href="http://localhost:8889/KGG/loginPage.us";
            	}
            	function pwdHome(){
            		location.href="http://localhost:8889/KGG/pwdSerchPage.us";
            	}
            </script>
        </div>
        <div id="footer">
            <p id="f1">
                Copyleft ©️ 2022-2022 King God General Tour All Right Reserved<br>
            </p>
        </div>
    </div>
</body>

</html>
    
</body>
</html>