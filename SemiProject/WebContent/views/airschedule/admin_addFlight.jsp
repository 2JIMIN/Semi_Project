<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/KGG/resources/css/admin_addFlightStyle.css">
</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
        <div id="content_2">
            <div id="content_2_1"><p><b>항공편 관리</b></p></div>
            <div id="content_2_2"><p><b>항공편 추가</b></p></div>
            <div id="content_2_3">
                <form action="<%=contextPath%>/addFlight.ai" id="addFlight" method="post">
                    <table>
                        <tr>
                            <td width="40%">항공편 번호(Flight Number)</td>
                            <td width="60%"><input type="text" name="flightNo" required></td>
                        </tr>
                        <tr>
                            <td>항공사</td>
                            <td><input type="text" name="airline" required></td>
                        </tr>
                        <tr>
                            <td>출발지 코드</td>
                            <td><input type="text" name="depCode" required></td>
                        </tr>
                        <tr>
                            <td>출발날짜</td>
                            <td><input type="text" name="depDate" required></td>
                        </tr>
                        <tr>
                            <td>출발시간</td>
                            <td><input type="text" name="depTime" required></td>
                        </tr>
                        <tr>
                            <td>도착지 코드</td>
                            <td><input type="text" name="arrivalCode" required></td>
                        </tr>
                        <tr>
                            <td>도착날짜</td>
                            <td><input type="text" name="arrivalDate" required></td>
                        </tr>
                        <tr>
                            <td>도착시간</td>
                            <td><input type="text" name="arrivalTime" required></td>
                        </tr>
                        <tr>
                            <td>소요시간</td>
                            <td><input type="text" name="wholeTime" required></td>
                        </tr>
                        <tr>
                            <td>가격</td>
                            <td><input type="text" name="price" required></td>
                        </tr>
                        <tr>
                            <td>직항/경유</td>
                            <td><input type="text" name="nonstopFlightYn" required></td>
                        </tr>
                        <tr>
                            <td>경유지</td>
                            <td><input type="text" name="transfer"></td>
                        </tr>
                        <tr>
                            <td>대기시간</td>
                            <td><input type="text" name="waitingTime"></td>
                        </tr>
                        <tr>
                            <th></th>
                            <td style="float:right" id="btnArea">
                                <input type="submit" class="btn" id="addFlightBtn" value="추가">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>
</html>