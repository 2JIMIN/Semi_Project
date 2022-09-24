<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.userinfo.model.vo.*,java.util.ArrayList"%>
<%@ page import="java.io.*, java.util.Date, java.util.Enumeration"%>
<%
	ArrayList<Reservation> list = (ArrayList<Reservation>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/KGG/resources/css/UserinfoReservationStyle.css">
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<%
		String userId = loginUser.getUserId();
		String userName = (loginUser.getUserName() == null) ? "" : loginUser.getUserName();
	%>
	<div id="content">
		<div id="content_1">
			<div id="content_1_1">
				<a href="<%=contextPath%>/myPage.us">마이페이지</a>
			</div>
			<div id="content_1_2">
				<a href="<%=contextPath%>/update.us">회원정보수정</a>
			</div>
			<div id="content_1_3">
				<a href="<%=contextPath%>/updatePwd.us">비밀번호변경</a>
			</div>
			<div id="content_1_4">
				<a href="<%=contextPath%>/reservation.us">예약조회</a>
			</div>
			<div id="content_1_5">
				<a href="<%=contextPath%>/delete.us">회원탈퇴</a>
			</div>
			<div id="content_1_6"></div>
		</div>
		<div id="content_2">
			<form action="<%=contextPath%>/updateInfo.us" method="post">

				<div id="content_2_1">
					<p style="font-size: 20px; padding-left: 0; padding-top: 25px; margin: 0;"><b>마이페이지</b></p>
				</div>
				<br>
				<div class="scroll" style="overflow: auto;">
					<table id="content_2_2">
						<tr>
							<td>조회결과</td>
						</tr>
					</table>
					<table id="content_2_3">

						<%
							if (list.isEmpty()) {
						%>
						<tr>
							<td colspan="10">예약하신 정보가 없습니다.</td>
						</tr>

						<%
							} else {
						%>
						<%
							for (Reservation r : list) {
						%>

						<tr>
							<td width=80;>등록번호</td>
							<td width=60;>이름</td>
							<td width=100;>국내/해외</td>
							<td width=80;>예약번호</td>
							<td width=80;>항공번호</td>
							<td width=80;>출발도시</td>
							<td width=80;>도착도시</td>
							<td width=100;>출발날짜</td>
							<td width=100;>도착날짜</td>
						</tr>
						<tr>
							<td width=80;><%=r.getEnrollNo()%></td>
							<td width=60;><%=r.getUserName()%></td>
							<td width=100;><%=r.getIntDomId()%></td>
							<td width=80;><%=r.getBookingNo()%></td>
							<td width=80;><%=r.getFlightNo()%></td>
							<td width=80;><%=r.getDepCity()%></td>
							<td width=80;><%=r.getArrivalCity()%></td>
							<td width=100;><%=r.getDepDate()%></td>
							<td width=100;><%=r.getArrivalDate()%></td>
						</tr>
						<%
							}
						%>
						<%
							}
						%>

					</table>
				</div>
				<br>
				<button class="btn" type="button">
					<a href="<%=contextPath%>/myPage.us">마이페이지</a>
				</button>
			</form>
		</div>
		<%@ include file="../common/content3.jsp" %>
	</div>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>