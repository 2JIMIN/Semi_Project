<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.admin.model.vo.*,java.util.ArrayList"%>
<%@ page import="java.io.*, java.util.Date, java.util.Enumeration"%>
<%
	ArrayList<Reservation> list = (ArrayList<Reservation>)request.getAttribute("list");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/KGG/resources/css/adminReservationStyle1.css">
</head>
<body>
	<%@ include file="../common/admin/admin.jsp"%>
	<div id="content_2">
		<div id="customer">
          <p><b>예약조회 결과</b></p>
      	</div>
      	<div id="notice_1">
	            <p><b>조회결과</b></p>
	    </div>
	    <div id="notice_4">
        	<form action="<%=contextPath%>/reservationDeleteC.re" method="post">
				<br>
				<div class="scroll">
				<table id="content_3_2">
					<tr>
						<%
						if (list.isEmpty()) {
					%>
					<tr>
						<td colspan="10" id="reservationNull"></td>
					</tr>

					<%
						} else {
					%>
					<%
						for (Reservation r : list) {
					%>

					<tr id="tr1">
						<td width=80;>등록번호</td>		
						<td width=60;>이름</td>
						<td width=100;>국내/해외</td>
						<td width=80;>예약번호</td>
						<td width=80;>항공편번호</td>
						<td width=80;>출발도시</td>
						<td width=80;>도착도시</td>
						<td width=100;>출발날짜</td>
						<td width=100;>도착날짜</td>
					</tr>
					<tr id="tr2">
						<td width=80;><%=r.getEnrollNo()%></td>
						<td width=60;><%=r.getUserName() %></td>
						<td width=100;><%=r.getIntDomId() %></td>
						<td width=80;><%=r.getBookingNo() %></td>
						<td width=80;><%=r.getFlightNo() %></td>
						<td width=80;><%=r.getDepCity() %></td>
						<td width=80;><%=r.getArrivalCity() %></td>
						<td width=100;><%=r.getDepDate() %></td>
						<td width=100;><%=r.getArrivalDate() %></td>
						<input type="hidden" name="reservationChangeR" value="<%=r.getBookingNo()%>">
					</tr>
					<%
						}
					%>
					<%
						}
					%>
					</tr>
				</table>
				</div>
				<br>
				<input type="submit" value="예약 취소" class="btn" id="reservationCancel">&nbsp;
				<button class="btn" id="submitBtn" type="submit">
					<a href="<%=contextPath%>/reservationDelete.re">예약취소 페이지로 이동</a>
				</button>
			</form>
        </div>
	<script>
		$(function(){
			if($("#reservationNull").is(":empty")==true){
				$("#reservationCancel").hide();
				// console.log("비어있음");
				$("#reservationNull").text("예약하신 정보가 없습니다.");
			};
			console.log($("#reservationNull").is(":empty"));
		});
	</script>
</body>
</html>