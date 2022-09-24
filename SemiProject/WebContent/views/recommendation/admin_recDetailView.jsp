<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.recommendation.model.vo.Recommendation" %>
<% 
	Recommendation r = (Recommendation)request.getAttribute("recommendation");
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

<link rel="stylesheet" href="/KGG/resources/css/admin_recDetailViewStyle.css">
</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
				<div id="content_2">
            <form id="enrollForm" action="/KGG/adInsert.re" method="post">
	        <div id="customer">
	            <p><b>추천여행지관리</b></p>
	        </div>
	        <div id="notice_1">
	            <p><b>게시글 상세보기</b></p>
	        </div>
   
            <div id="notice_3">
            	<a href="<%=contextPath %>/adList.re?kpage=1" class="btn" style="background-color: rgb(234, 234, 234);">목록</a>
                <a href="<%=contextPath %>/adUpdateForm.re?bno=<%=r.getBoardNo() %>" class="btn" style="background-color: rgb(154, 222, 226); color:white">수정</a>
                <a onclick="if(confirm('삭제하시겠습니까?')){return location.href='<%=contextPath %>/adDelete.re?bno=<%=r.getBoardNo() %>';}" class="btn" style="background-color: rgb(64, 64, 64); color: white;">삭제</a>          	                    		
            </div>
	        <br>
	        
	        <div id="notice_2">
	            <table class="insert-table">
                    <tr>
                        <th width="25%" height="10%">글번호</th>
                        <td width="75%" class="input-textarea">
                            &ensp;<%=r.getBoardNo() %>
                        </td>
                    </tr>
                    <tr>
                        <th height="10%">구분</th>
                        <td class="input-textarea">
                            &ensp;<%=r.getContinent() %>
                        </td> 
                    </tr>
                    <tr>
                        <th height="10%">제목</th>
                        <td class="input-textarea">
                            &ensp;<%=r.getBoardTitle() %>
                        </td>
                    </tr>
                    <tr>
                        <th height="10%%" class="noneBorder">내용</th>
                        <td class="input-textarea" class="noneBorder">
                            <div>
                        	<%=r.getBoardContent() %>
                        	</div>
                        </td>
                    </tr>
            </table>
	        </div>

   	 </form>
	</div>
	</body>
</html>