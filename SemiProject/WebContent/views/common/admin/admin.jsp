<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- <link rel="stylesheet" href="/KGG/resources/css/admin_CommonStyle.css"> -->
</head>
<body>
<script>
	var msg = "<%=alertMsg%>"; //" " /"null"

	if(msg!="null"){
		alert(msg);
		<%session.removeAttribute("alertMsg");%>
	}
</script>
	<div id="header">
	    <div id="header_1">
	        <a href="/KGG/adminPage.ad"><img src="/KGG/resources/images/KGG투어로고.png" alt="" id="logo"></a>
	    </div>
	    <div id="header_2">
	        <p>관리자페이지</p>
	    </div>
	    <div id="header_3">
	        <div id="login">
	            <div>
	                <span>관리자님 환영합니다</span><br>
	            </div>
	            <div id="logout">
	                <a href="<%=contextPath%>/logout.us">로그아웃</a>
	            </div>
	        </div>
	    </div>
	</div>
    <div id="content">
        <div id="content_1">
            <div class="userMenu">
                <a href="/KGG/views/userinfo/admin_userManagement.jsp">회원관리</a>
            </div>
            <div class="menu">항공편관리</div>
            <p class="subarea">
                <a href="<%=contextPath%>/addFlightPage.ai">항공편추가</a><br>
                <a href="<%=contextPath%>/updateFlightPage.ai">항공편변경</a><br>
                <a href="<%=contextPath%>/deleteFlightPage.ai">항공편삭제</a>
            </p>
            <div class="menu">예약관리</div>
            <p class="subarea">
                <a href="<%=contextPath %>/reservationChange.re">예약회원관리</a><br>
                <a href="<%=contextPath %>/reservationDelete.re">예약취소</a>
            </p>
            <div class="menu">페이지관리</div>
            <p class="subarea">
                <a href="<%=contextPath %>/adList.qu?kpage=1">방역현황관리</a><br>
                <a href="<%=contextPath %>/adList.re?kpage=1">추천여행지관리</a>
            </p>
            <div class="menu">고객센터관리</div>
            <p class="subarea">
                <a href="<%=contextPath%>/adminlist.no?kpage=1">공지사항</a><br>
                <a href="<%=contextPath%>/admin.list.qo?kpage=1">Q&A</a><br>
                <a href="<%=contextPath%>/faqmain.fm">FAQ</a>
            </p>
            <script>
                $(function(){
                    $(".menu").click(function(){
                        var $answer = $(this).next();
                        if($answer.css("display") == "none"){
                            $(this).siblings(".subarea").slideUp();
                            $answer.slideDown();
                        }
                        else{
                            $answer.slideUp();
                        }
                    });
                });
            </script>
        </div>
</body>
</html>