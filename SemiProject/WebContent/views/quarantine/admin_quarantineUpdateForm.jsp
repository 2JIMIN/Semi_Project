<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.kh.quarantine.model.vo.Quarantine"%>
<%
	Quarantine q  = (Quarantine)request.getAttribute("q");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/KGG/resources/css/admin_quarantineUpdateFormStyle.css">
</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
		<div id="content_2">
            <form id="UpdateForm" action="<%=contextPath%>/adUpdate.qu" method="post">
		        <div id="customer">
		            <p><b>방역현황관리</b></p>
		        </div>
		        <div id="notice_1">
		            <p><b>방역현황 수정</b></p>
		        </div>
		        <div id="notice_2">
		            <table class="insert-table">
	                    <tr>
	                        <th width="25%">국가코드</th>
	                        <td>
	                            <input type="text" name="countryCode" id="countryCode" value="<%=q.getCountryCode()%>" readonly style="border:none;"> 
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>출발전_접종_PCR</th>
	                        <td class="input-textarea">
	                            <input type="text" name="depVyPcr" value="<%=q.getDepVyPcr()%>">
	                        </td> 
	                    </tr>
	                    <tr>
	                        <th>출발전_미접종_PCR</th>
	                        <td class="input-textarea">
	                            <input type="text" name="depVnPcr" value="<%=q.getDepVnPcr()%>">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>도착후_접종_PCR</th>
	                        <td class="input-textarea">
	                            <input type="text" name="arrVyPcr" value="<%=q.getArrVyPcr()%>">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>도착후_미접종_PCR</th>
	                        <td class="input-textarea">
	                            <input type="text" name="arrVnPcr" value="<%=q.getArrVnPcr()%>">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>도착후_접종_격리</th>
	                        <td class="input-textarea">
	                            <input type="text" name="arrVySelf" value="<%=q.getArrVySelf()%>">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>도착후_미접종_격리</th>
	                        <td class="input-textarea">
	                            <input type="text" name="arrVnSelf" value="<%=q.getArrVnSelf()%>">
	                        </td>
	                    </tr>
	            </table>
	        </div>
            <br>
            <div id="notice_3">   	 
                <button type="submit" class="btn" style="background-color: rgb(154, 222, 226); color:white">수정</button>
                <button type="button" onclick="history.back();" class="btn" style="background-color: rgb(234, 234, 234);">뒤로</button>
            </div>
           
   	 </form>
	</div>
</body>
</html>