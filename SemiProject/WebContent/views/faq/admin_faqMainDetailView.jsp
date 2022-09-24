<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.board.model.vo.*"%>
    <%
    	Board b = (Board)request.getAttribute("b");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 faq상세보기</title>
<link rel="stylesheet" href="/KGG/resources/css/admin_faqMainStyle.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body>
    <%@ include file="../common/admin/admin.jsp" %>
		<div id="customer">
	        <p><b>고객센터관리</b></p>
	    </div>
	     <hr>
        <div id="notice_1">
            <p><b>FAQ</b></p>
        </div>
        <div style="margin-left: 17%;">
        <table  border="1px" id="detail-area" width="90%" hegiht="100%"   >
        	<tr >
                <th width="10%" >종류</th>
                <td width="87%" colspan="4"><%=b.getCategoryName() %></td>
            </tr>
            <tr >
                <th>제목</th>
                <td colspan="4"><%=b.getFaqTitle() %></td>
            </tr>
            <tr >
                <th >작성일</th>
                <td colspan="3" >
                	<%=b.getCreateDate() %>
                </td>
            </tr>
            <tr >
                <th >내용</th>
                <td colspan="3" >
                    <%=b.getFaqContent() %>
                </td>
            </tr>
        </table>
        </div>
            <br>
            <div align="center" id="notice_2">
                <a href="<%=contextPath%>/faqmain.fm" class="btn"style="background-color: rgb(234, 234, 234);">목록으로</a>
                <a href="<%=contextPath%>/updateForm.bo?bno=<%=b.getFaqNo()%>" class="btn"style="background-color: rgb(234, 234, 234);">수정하기</a> 
                <a href="<%=contextPath%>/delete.bo?bno=<%=b.getFaqNo() %>" class="btn btn-danger">삭제하기</a>
            </div>
    </div>

    <script>
      
    </script>



</body>
</html>