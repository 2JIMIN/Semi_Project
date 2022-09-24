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
		String userPwd = loginUser.getUserPwd();
		String phone = (loginUser.getPhone() == null) ? "" : loginUser.getPhone();
		String email = (loginUser.getEmail() == null) ? "" : loginUser.getEmail();
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
			<form action="<%=contextPath%>/deleteUser.us" method="post">
				<input type="hidden" name="userId" value="<%=userId%>">
				<div id="content_2_1">
					<p style="font-size: 20px; padding-left: 0; padding-top: 25px; margin: 0;"><b>마이페이지</b></p>
				</div>
				<br>
				<table id="content_2_2">
					<tr>
						<td>킹갓제너럴투어를 이용해주신 고객님께</td>
					</tr>
					<tr id="note">
						<td>회원 탈퇴시 유의사항</td>
					</tr>
					<tr id="note">
						<td>ㆍ회원탈퇴 시 회원님의 정보는 전자상거래상에서의 소비자보호법률에 의거한 개인정보취급방침에 따라
							관리됩니다.</td>
					</tr>
					<tr id="note">
						<td>ㆍ회원탈퇴후에도 회원님의 관한정보는 관련법령에 의거 일정기간 보관됩니다.</td>
					</tr>
				</table>
				<br>
				<table id="button">
					<button type="submit" class="btn" style="margin: 10px;">회원탈퇴</button>
					<button type="button" class="btn reset"  style="margin-top: 10px; border: 0px;">
						<a href="<%=contextPath%>/myPage.us">취소</a>
					</button>
				</table>
			</form>
		</div>
		<%@ include file="../common/content3.jsp" %>
	</div>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>