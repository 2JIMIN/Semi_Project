<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.io.*, java.util.Date, java.util.Enumeration" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/KGG/resources/css/adminReservationReservationStyle.css">
</head>
	<%@ include file="../common/admin/admin.jsp" %>
        <div id="content_2"></div>
        <div id="content_3">
            <table id="adminReservePage">
                <td>예약관리</td>
            </table>
            <hr>
            <br>
            <table id="adminReserve">
            <tr>
            	<td>예약회원관리</td>
            </tr>                        
            <tr>
                <td id="reservtionNum">예약번호 :
                <input type="text" id="reservtionCheck" size="40" height="20"><button type="submit">조회</button> 
                </td>
            </tr>
            <tr>
            	<td>조회결과</td>
            </tr>            
        </table>
        </div>
        <div id="content_4"></div>
    </div>
</body>
</html>