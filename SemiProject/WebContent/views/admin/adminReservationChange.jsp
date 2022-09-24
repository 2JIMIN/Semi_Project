<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.Date, java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/KGG/resources/css/adminReservationStyle.css">
</head>
<body>
		<%@ include file="../common/admin/admin.jsp"%>
		<div id="content_2">
	        <div id="customer">
	            <p><b>예약관리</b></p>
	        </div>
	        <div id="notice_1">
	            <p><b>예약취소</b></p>
	        </div>
	        <div id="notice_4">
	            <form action="<%=contextPath%>/reservationChangeR.re" method="post">
					<br>
					<table id="content_3_2">
						<tr>
							<td align="center">예약번호 </td>
							<td align="center"><input type="text" name="reservationChangeR" id="reservationChangeR" size="40" height="20"></td>
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
<!-- 	<div id="content_3"> -->
<%-- 	<form action="<%=contextPath%>/reservationChangeR.re" method="post"> --%>
<!-- 		<table id="content_3_1"> -->
<!-- 			<tr> -->
<!-- 				<td>예약관리</td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
<!-- 		<br> -->
<!-- 		<table id="content_3_2"> -->
<!-- 			<tr> -->
<!-- 				<td>예약번호 조회</td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>예약번호  -->
<!-- 				<br> -->
<!-- 				<input type="text" name="reservationChangeR" id="reservationChangeR" size="40" height="20"> -->
<!-- 					<button type="submit" class="btn">조회</button> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
<!-- 	</form> -->
<!-- 	</div> -->
<!-- 	<div id="content_4"></div> -->

	

</body>
</html>