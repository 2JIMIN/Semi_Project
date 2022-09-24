<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.quarantine.model.vo.Quarantine" %>
<% 
	Quarantine q = (Quarantine)request.getAttribute("quarantine");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="/KGG/resources/css/admin_quarantineDetailViewStyle.css">
</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
				<div id="content_2">
            <form id="enrollForm" action="/KGG/adInsert.qu" method="post">
	        <div id="customer">
	            <p><b>방역현황관리</b></p>
	        </div>
	        <div id="notice_1">
	            <p><b>방역현황 상세보기</b></p>
	        </div>
	        <div id="notice_2">
	            <table class="insert-table">
                    <tr>
                        <th width="25%">국가코드</th>
                        <td class="input-textarea">
                            <%=q.getCountryCode() %>
                        </td>
                    </tr>
                    <tr>
                        <th>출발전_접종_PCR</th>
                        <td class="input-textarea">
                            <%=q.getDepVyPcr() %>
                        </td> 
                    </tr>
                    <tr>
                        <th>출발전_미접종_PCR</th>
                        <td class="input-textarea">
                            <%=q.getDepVnPcr() %>
                        </td>
                    </tr>
                    <tr>
                        <th>도착후_접종_PCR</th>
                        <td class="input-textarea">
                            <%=q.getArrVyPcr() %>
                        </td>
                    </tr>
                    <tr>
                        <th>도착후_미접종_PCR</th>
                        <td class="input-textarea">
                            <%=q.getArrVnPcr() %>
                        </td>
                    </tr>
                    <tr>
                        <th>도착후_접종_격리</th>
                        <td class="input-textarea">
                            <%=q.getArrVySelf() %>
                        </td>
                    </tr>
                    <tr>
                        <th>도착후_미접종_격리</th>
                        <td class="input-textarea">
                            <%=q.getArrVnSelf() %>
                        </td>
                    </tr>
                    <tr>
                        <th>업데이트일</th>
                        <td class="input-textarea">
                            <%=q.getUpdateDate() %>
                        </td>
                    </tr>
            </table>
	        </div>
            <br>
            <div id="notice_3">
            	<a href="<%=contextPath %>/adList.qu?kpage=1" class="btn" style="background-color: rgb(234, 234, 234);">목록</a>
                <a href="<%=contextPath %>/adUpdateForm.qu?ccode=<%=q.getCountryCode() %>" class="btn" style="background-color: rgb(154, 222, 226); color:white">수정</a>
                <a href="if(confirm('삭제하시겠습니까?')){return location.href='<%=contextPath %>/adDelete.qu?ccode=<%=q.getCountryCode() %>';}" class="btn" style="background-color: rgb(64, 64, 64); color: white;">삭제</a>          	 
            </div>
           
   	 </form>
	</div>
</body>
</html>