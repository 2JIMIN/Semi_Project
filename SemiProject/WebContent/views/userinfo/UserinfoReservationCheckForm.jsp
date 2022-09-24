<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.Date, java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/KGG/resources/css/UserinfoStyle.css">
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<%
		String userId = loginUser.getUserId();
	String userName = loginUser.getUserName();
	String userPwd = (loginUser.getUserPwd() == null) ? "" : loginUser.getUserPwd();
	String email = (loginUser.getEmail() == null) ? "" : loginUser.getEmail();
	String phone = (loginUser.getPhone() == null) ? "" : loginUser.getPhone();
	Date enrollDate = loginUser.getEnrollDate();
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
			<form action="<%=contextPath%>/reservationInquiry.us" method="post">
				<input type="hidden" name="userId" value="<%=userId%>">
				<div id="content_2_1">
					<p style="font-size: 20px; padding-left: 0; padding-top: 25px; margin: 0;"><b>마이페이지</b></p>
				</div>
				<br>
				<table id="content_2_2">
					<tr>
						<td>내 프로필</td>
					</tr>
					<tr>
						<td>이름</td>
						<td><%=userName%></td>
					</tr>
					<tr>
						<td>등록번호</td>
						<td><input type="text" name="bookingNo" id="bookingNo" required
							oninvalid="this.setCustomValidity('예약번호를 입력해주세요.')"
							oninput="setCustomValidity('')"></td>
					</tr>
					<tr>
						<td>항공편 번호</td>
						<td><input type="text" name="flightNo" id="flightNo" required
							oninvalid="this.setCustomValidity('항공편 번호를 입력해주세요.')"
							oninput="setCustomValidity('')"></td>
					</tr>
				</table>
				<br>
				<button type="submit" class="btn">조회하기</button>
			</form>
			<script>
				$("#flightNo").bind("keyup", function() {

					$(this).val($(this).val().toUpperCase());

				});
			</script>
		<%@ include file="../common/content3.jsp" %>
		</div>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>