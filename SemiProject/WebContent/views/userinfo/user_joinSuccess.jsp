<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.userinfo.model.vo.UserInfo"%>
<% 
	String contextPath = request.getContextPath();
	UserInfo loginUser = (UserInfo)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/KGG/resources/css/user_success.css">
</head>
<body>
    <div class="wrap">
        <div id="header">
            <div id="header_1"></div>
            <div id="header_2">
                <img src="/KGG/resources/images/KGG투어로고.png" alt="" id="logo">
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
                    <strong style="color: #30449c; font-size: 35px;">환영합니다!</strong><br>
                    <%=loginUser.getUserName() %>님,<br>회원가입을 축하드립니다.<br>킹갓제너럴의 새로운 아이디는<br>
                    <%=loginUser.getUserId() %> 입니다.<br>
                </p>
            </div>
            <div id="content_5">
                <button type="button" id="btn" onclick="startHome()">시작하기</button>
<!--                 <button type="button" id="btn2" onclick="insertHome()">회원가입 없이 서비스 이용</button> -->
            </div>
            <script>
            		function startHome(){
            			location.href="<%=contextPath%>";
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