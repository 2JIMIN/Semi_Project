<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/KGG/resources/css/user_joinStyle.css">
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
            <div id="content_1">
                <h3 id="join">회원가입</h3> <br>
            </div>
            <div id="content_2">
                <hr>
            </div>
            <div id="content_3">
                <p>
                    쉽고 빠른 항공예약 <br>
                    <strong style="color: #30449c; font-size: 20px;">킹갓제너럴투어</strong>에<br>
                    오신 것을 환영합니다. <br>
                </p>
            </div>
            <div id="content_4">
                신규 회원 가입은 간편 정보 등록 또는 <br>
                연결로 쉽게 하실 수 있습니다.
            </div>
            <div id="content_5">
                <button type="button" id="btn" onclick="enrollPage();">간편 회원가입</button>
            </div>
            <script>
            function enrollPage(){
                location.href="/KGG/enrollPage2.us";
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