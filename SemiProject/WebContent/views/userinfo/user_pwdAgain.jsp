<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String userPwd = (String)request.getAttribute("userPwd");
	String userId = (String)request.getAttribute("userId");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" href="/KGG/resources/css/user_pwdAgain.css">
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
                <h3 id="ph">비밀번호 재설정</h3> <br>
            </div>
            <form action="<%=contextPath %>/pwdAgain.us" method="post">
                <input type="hidden" id="userPwd" name="userPwd" value="<%=userPwd%>">
                <input type="hidden" name="userId" value="<%=userId%>" id="userId">
                <div id="content_2">
                    <input type="text" id="newPwd" class="c1" name="newPwd" placeholder="새 비밀번호">
                </div>
                <div id="content_3">
                    <input type="text" class="c1" name="newPwdCheck" placeholder="새 비밀번호 확인">
                </div>
                <div id="content_4">
                    <button type="submit" id="btn">확인</button>
                </div>
            </form>
        </div>
        <script>
        </script>
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