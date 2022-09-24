<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.Date, java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/KGG/resources/css/adminReservationStyle.css">
</head>
<body>
	<%@ include file="../common/admin/admin.jsp"%>
		<div id="content_2">
	        <div id="customer">
	            <p><b>예약관리</b></p>
	        </div>
	        <div id="notice_1">
	            <p><b>예약회원관리</b></p>
	        </div>
	        <div id="notice_4">
	            <form action="<%=contextPath%>/reservationCheck.re" method="post">
					<br>
					<table id="content_3_2">
						<tr>
							<td align="center">예약번호 </td>
							<td align="center"><input type="text" name="reservtionCheck" id="reservtionCheck" size="40" height="20"></td>
							<td><button type="submit" class="btn">조회</button></td>
						</tr>
					</table>
				</form>
	        </div>
            <br>
            <div id="notice_2"></div>
            <div id="notice_3">
            
           	</div>
        </div>
	</div>
</body>
</html>