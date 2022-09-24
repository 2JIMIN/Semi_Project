<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.kh.quarantine.model.vo.Quarantine"%>
<%
	ArrayList<Quarantine> list = (ArrayList<Quarantine>)request.getAttribute("list");
	
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
<link rel="stylesheet" href="/KGG/resources/css/admin_quarantineEnrollFormStyle.css">
</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
		<div id="content_2">
            <form id="enrollForm" action="<%=contextPath%>/adInsert.qu" method="post">
	        <div id="customer">
	            <p><b>방역현황관리</b></p>
	        </div>
	        <div id="notice_1">
	            <p><b>방역현황 등록</b></p>
	        </div>
	        <div id="notice_2">
	            <table class="insert-table">
                    <tr>
                        <th width="25%">국가코드</th>
                        <td>
                            <input list="countryList" name="cCode" id="countryCode" placeholder="선택가능한 국가만 등록가능">
                            <datalist id="countryList">
                            	<!-- 리스트가 비어있는 경우 -->
                                <%if(list.isEmpty()){%>
                                     <option value="" label="">
                                <%} else {%>
                                <!-- 비어있지 않을 경우 -->
                                    <%for(Quarantine q : list) {%>
                                        <option value="<%= q.getCountryCode()%>" label="<%= q.getCountryKor()%>">
                                    <%} %>
                                <%} %>
                            </datalist>
                        </td>
                    </tr>
                    <tr>
                        <th>출발전_접종_PCR</th>
                        <td class="input-textarea">
                            <input type="text" name="depVyPcr">
                        </td> 
                    </tr>
                    <tr>
                        <th>출발전_미접종_PCR</th>
                        <td class="input-textarea">
                            <input type="text" name="depVnPcr">
                        </td>
                    </tr>
                    <tr>
                        <th>도착후_접종_PCR</th>
                        <td class="input-textarea">
                            <input type="text" name="arrVyPcr">
                        </td>
                    </tr>
                    <tr>
                        <th>도착후_미접종_PCR</th>
                        <td class="input-textarea">
                            <input type="text" name="arrVnPcr">
                        </td>
                    </tr>
                    <tr>
                        <th>도착후_접종_격리</th>
                        <td class="input-textarea">
                            <input type="text" name="arrVySelf">
                        </td>
                    </tr>
                    <tr>
                        <th>도착후_미접종_격리</th>
                        <td class="input-textarea">
                            <input type="text" name="arrVnSelf">
                        </td>
                    </tr>
            </table>
	        </div>
            <br>
            <div id="notice_3">
                <button type="reset" onclick="test();" class="btn" style="background-color: rgb(64, 64, 64); color: white;">취소</button>    	 
                <button type="submit" class="btn" style="background-color: rgb(154, 222, 226); color:white">등록</button>
                <button type="button" onclick="history.back();" class="btn" style="background-color: rgb(234, 234, 234);">목록</button>
            </div>
           
   	 </form>
	</div>
</body>
</html>