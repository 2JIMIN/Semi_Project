<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="/KGG/resources/css/user_loginStyle.css">
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
<!-- 	                <div id="content_1_4" style="padding-bottom: 5px;"> -->
<!-- 	                    <input type="checkbox" name="" id="">아이디 저장 -->
<!-- 	                </div> -->
	                <div id="content_1_5" style="padding-bottom: 10px;">
	                    <button type="submit" id="btn">로그인</button>
	                </div>
                </form>
                <div id="content_1_6">
                    <a href="<%=contextPath %>/idSerchPage.us" id="serchid">아이디 찾기</a> | <a href="<%=contextPath %>/pwdSerchPage.us" id="serchid">비밀번호 찾기</a> | <a href="<%=contextPath %>/enrollPage.us" id="serchid">회원가입</a>
                </div>
            </form>
            </div>
            <div id="content_2">
                <div id="content_2_1">
                    <h4 id="person">비회원 예약 확인</h4>
                </div>
                <form  action="<%=contextPath%>/nomemberlogin.us" method="post">
	                <div id="content_2_2" style="width: 500px;">
	                    <input type="text" placeholder="예약시 기재한 이메일주소" id="bid" name="email">
	                </div>
	                <div id="content_2_3" style="width: 500px;">
	                    <input type="text" placeholder="예약번호" id="bid" name="bookingNo">
	                </div>
	                <div id="content_2_4">
	                    <input type="submit" id="btn2" value="비회원 예약 확인">
	                </div>
                </form>
                <div id="content_2_5">
                
                </div>
            </div>
        </div>
        <div id="footer">
	        <div id="footer1">
	      		<div id="naver_id_login"></div>
  				<script type="text/javascript">
				  	var naver_id_login = new naver_id_login("2FMYwCYsXKQSTL4lyk51", "http://localhost:8889/KGG/views/userinfo/naver_logincallback.jsp");
				  	var state = naver_id_login.getUniqState();
				  	naver_id_login.setButton("white", 2,40);
				  	naver_id_login.setDomain("http://localhost:8889/KGG/loginPage.us");
				  	naver_id_login.setState(state);
// 				  	naver_id_login.setPopup();
				  	naver_id_login.init_naver_id_login();
				
				  	
				</script>
				
				
	        </div>
            <p id="f1">
                Copyleft ©️ 2022-2022 King God General Tour All Right Reserved<br>
            </p>
        </div>
    </div>
</body>
</html>