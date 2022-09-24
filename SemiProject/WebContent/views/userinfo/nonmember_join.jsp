<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String alertMsg = (String)request.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
<link rel="stylesheet" href="/KGG/resources/css/nomemberJoin.css">
</head>
<body>
	<script>
		var msg = "<%=alertMsg%>"; //" " /"null"
	
		if(msg!="null"){
			alert(msg);
			<%session.removeAttribute("alertMsg");%>
		}
	</script>
    <div class="wrap">
        <div id="header">
            <div id="header_1"></div>
            <div id="header_2">
                <img src="/KGG/resources/images/KGG투어로고.png" alt="" id="logo">
            </div>
            <div id="header_3"></div>
        </div>
        <div id="content">
            <div id="content_1">
                <div id="content_1_1">
                    <h4 id="person">회원 로그인</h4>
                </div>
                	<form action="<%=contextPath%>/login.us" method="post">
	                <div id="content_1_2" style="width: 500px;">
	                    <input type="text" id="id" name="userId" placeholder="아이디">
	                </div>
	                <div id="content_1_3" style="width: 500px;">
	                    <input type="password" id="pwd" name ="userPwd" placeholder="비밀번호">
	                </div>
	                <div id="content_1_4" style="padding-bottom: 5px;">
	                    <input type="checkbox" name="" id="">아이디 저장
	                </div>
	                <div id="content_1_5" style="padding-bottom: 10px;">
	                    <button type="submit" id="btn">로그인</button>
	                </div>
                </form>
                <div id="content_1_6">
                    <a href="<%=contextPath %>/idSerchPage.us" id="serchid">아이디 찾기</a> | <a href="<%=contextPath %>/pwdSerchPage.us" id="serchid">비밀번호 찾기</a> | <a href="" id="serchid">회원가입</a>
                </div>
            </form>
            </div>
            <div id="content_2">
                <div id="content_2_1">
                    <h4 id="person">비회원 예약 확인</h4>
                </div>
                <form action="<%=contextPath%>/nomemberJoin.us" method="post">
	                <div id="content_2_2" style="width: 500px;">
	                    <input type="text" name="userName" placeholder="이름" id="bid">
	                </div>
	                <div id="content_2_3" style="width: 500px;">
	                    <input type="text" name="email" placeholder="이메일" id="bid">
	                </div>
	                <div id="content_2_4" style="width: 500px;">
                        <input type="text" name="phone" placeholder="휴대폰 번호(-포함)" id="bid">
	                </div>
                    <div id="content_2_5">
	                    <input type="submit" id="btn2" value="비회원 예약"> 
	                </div>
                </form>
                <div id="content_2_5"></div>
            </div>
        </div>
        <div id="footer">
            <p id="f1">
                Copyleft ©️ 2022-2022 King God General Tour All Right Reserved<br>
            </p>
        </div>
    </div>
</body>
</html>