<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath(); 
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/user_serchPwd.css">
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
            <div id="content_1">
                <h3 id="ph">등록한 정보로 인증</h3> <br>
            </div>
            <form action="<%=contextPath %>/pwdSerch.us" method="post">
                <div id="content_2">
                    <input type="text" name="userId" id="c1" placeholder="아이디">
                </div>
                <div id="content_3">
                    <input type="text" name="phone" id="c1" placeholder="휴대폰번호(-포함)">
                </div>
                <div id="content_4" style="float: left;">
                    <input type="submit" id="btn" value="비밀번호 찾기" >
                </div>
                <div id="content_5" style="float: left;">
                    <input type="reset" id="btn2" value="취소">

                </div>
            
            </form>
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