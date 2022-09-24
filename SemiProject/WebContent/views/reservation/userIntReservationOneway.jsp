<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String flightNo = (String) request.getParameter("flightNo");
	String userNo = (String) request.getParameter("userNo");
	String depTime = (String) request.getParameter("depTime");
	String arrivalTime = (String) request.getParameter("arrivalTime");
	String price = (String) request.getParameter("price");
	String airline = (String) request.getParameter("airline");
	String depCode = (String) request.getParameter("depCode");
	String arrivalCode = (String) request.getParameter("arrivalCode");
	String depCity = (String) request.getParameter("depCity");
	String arrivalCity = (String) request.getParameter("arrivalCity");
	String person = (String) request.getParameter("person");
	String classtype = (String) request.getParameter("classtype");
	String depDate = (String) request.getParameter("depDate");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/KGG/resources/css/userReservationRoundStyle.css">
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<div id="content">
		<div id="content_1"></div>
		<div id="content_2">
			<div id="content_2_1">
				<table id="itenary" align="center">
                    <tr>
                        <td align="center" colspan="2" width="26%" style="font-size: 24px; border: 1px solid lightgrey; border-radius: 5px;">선택하신 항공편</td>
                        <td align="center" width="20%"></td>
                        <td align="center" width="15%"></td>
                        <td align="center" width="19%">여행기간</td>
                        <td align="center" width="1%"></td>
                        <td align="center" width="19%" id="depDate"><%=depDate %></td>
                    </tr>
                    <tr style="border-top: 1px solid lightgrey;">
                        <td align="center" rowspan="2"><%=airline %></td>
                        <td align="center"><%=depCity %>(<%=depCode %>)</td>
                        <td align="center" rowspan="2"><img src="/KGG/resources/images/우측방향화살표.png" alt="" width="150px" height="40px"></td>
                        <td align="center"><%=arrivalCity %>(<%=arrivalCode %>)</td>
                        <td width="15%" align="center" colspan="3">성인 <%=person %>명</td>
                        <td></td>
                    </tr>
                    <tr style="border-bottom: 1px solid lightgrey;">
                        <td align="center"><%=depTime %></td>
                        <td align="center"><%=arrivalTime %></td>
                        <td align="center" colspan="3"><%=classtype %> 클래스</td>
                        <td></td>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td align="center" colspan="3" style="font-size: 24px;">가격 : <%=price %>원</td>
                    </tr>
                </table>
                <script>
                        $(function(){
                            var depDate = $("#depDate").text();
                            var depYear = depDate.substr(0, 4);
                            var depMonth = depDate.substr(6, 1);
                            var depDay = depDate.substr(8, 10);

                            var allDepDate = depYear + "년 " + depMonth + "월 " + depDay + "일";

                            $("#depDate").html(allDepDate);
                        })
               </script>
			</div>
			<div id="content_2_2">
				<form id="reservation" action="<%=contextPath%>/intOneway.rd" method="post">
					<div id="content_2_2_1">
						<table id="passportInfo">
							<tr>
								<td style="font-size: 17px;"><b>여권 정보 입력</b></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>영문 성 입력</td>
								<td><input type="text" name="lastName" required></td>
								<td>영문 이름 입력</td>
								<td><input type="text" name="firstName" required></td>
							</tr>
							<tr>
								<td>여권번호</td>
								<td><input type="text" name="passportNo" required></td>
								<td>유효기간</td>
								<td><input type="text" name="validDate" required></td>
							</tr>
						</table>
					</div>
					<div id="content_2_2_2">
						<p>전자금융거래 기본 약관</p>
						<textarea name="agreement" id="agreement" cols="30" rows="10">
제 1조(목적)
이 약관은 (주)킹갓제너럴투어(전자상거래 사업자)가 운영하는 와이페이모어 사이버 몰(이하 "몰"라 한다)에서 제공하는 인터넷 관련 서비스 (이하 "서비스"라 한다)를 이용함에 있어 사이버 몰과 이용자의 권리ㆍ의무 및 책임사항을 규정함을 목적으로 합니다.
제 2조(정의)
① "몰" 이란 (주)킹갓제너럴투어가 재화 또는 용역(이하 "재화 등”이라 함)을 이용자에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 재화 등을 거래할 수 있도록 설정한 가상의 영업장을 말하며, 아울러 사이버몰을 운영하는 사업자의 의미로도 사용합니다.
② "이용자"란 "몰"에 접속하여 이 약관에 따라 "몰"이 제공하는 서비스를 받는 회원 및 비회원을 말합니다.
③ "회원"이라 함은 "몰"에 개인정보를 제공하여 회원등록을 한 자로서, "몰"의 정보를 지속적으로 제공받으며, "몰"이 제공하는 서비스를 계속적으로 이용할 수 있는 자를 말합니다.
④ "비회원"이라 함은 회원에 가입하지 않고 "몰"이 제공하는 서비스를 이용하는 자를 말합니다.
                        </textarea>
						<div id="agreeYN">
							<input id="agreeyn" type="checkbox">&nbsp<b>동의함</b>
						</div>
					</div>
					<div id="content_2_2_3">
						<div id="paymentArea">
							<input type="hidden" name="enrollNo" value="<%=loginUser.getUserNo()%>">
							<input type="hidden" name="depCode" value="<%=depCode%>">
							<input type="hidden" name="flightNo" value="<%=flightNo%>">
							<input type="hidden" name="depDate" value="<%=depDate%>">
							<input type="hidden" name="price" value="<%=price%>">
							<input type="hidden" name="userName" value="<%=loginUser.getUserName()%>">
							<input type="hidden" name="email" value="<%=loginUser.getEmail()%>">
							<input type="hidden" name="phone" value="<%=loginUser.getPhone()%>">
							<input type="submit" id="payment" value="결제하기">
						</div>
					</div>
				</form>
				<script>
					$(function() {
						$('#payment').attr('disabled', true);
					})
					$(document).on('click', '#agreeyn', function() {

						if ($('#agreeyn').is(':checked')) {
							$('#payment').removeAttr('disabled');
						} else {
							$('#payment').attr('disabled', true);
						}
					})
				</script>
			</div>
		</div>
		<%@ include file="../common/content3.jsp" %>
    </div>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>