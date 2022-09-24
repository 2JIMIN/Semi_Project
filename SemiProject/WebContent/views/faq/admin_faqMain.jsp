<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.kh.board.model.vo.Board" %>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/KGG/resources/css/admin_faqMainStyle.css">
<!-- Latest compiled JavaScript -->

</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
		<div id="content_2">
	    <div id="customer">
	        <p><b>고객센터관리</b></p>
	    </div>
	     <hr>
	        <div id="notice_1">
	            <p><b>FAQ</b></p>
	        </div>
	       
	            <table id="tt" width="700" height="150" class="table-hover" >
	                <thead>
	                    <tr style="background-color: lightgray;">
	                        <td style="width: 7%;"></td>
	                        <td style="width: 79%" align="center"><b>질문제목</b></td>
	                        <td style="width: 7%;"></td>
							<td style="width: 7%;"></td>
	                    </tr>
	                </thead>
	                <tbody class="td" >
	                
	                <%if(list.isEmpty()){ %>
	                		<tr>
	                			<td></td>
	                			<td>존재하는 공지사항이 없습니다.</td>
	                			<td></td>
	                			<td></td>
	                		</tr>
	                <%}else{ %>
	                
	                
	                <%for(Board b : list) {%>
	                    <tr id="slide">
	                    	<input type="hidden" value="<%=b.getFaqNo()%>">
	                        <th style="text-align: center"><%=b.getRnum() %></th>
	                        <th><%=b.getFaqTitle() %></th>
	                        <th style="text-align: center"><a href="<%=contextPath%>/updateForm.bo?bno=<%=b.getFaqNo()%>" class="btn" style="background-color: rgb(154, 222, 226); color:white" >수정</a></th>
	                        <th style="text-align: center"><a href="<%=contextPath%>/delete.bo?bno=<%=b.getFaqNo()%>" class="btn" style="background-color: rgb(64, 64, 64); color: white;">삭제</a></th>
	                    </tr>
					<%} %>	
				<%} %>
				
	                </tbody>
	            </table>
	        	<br>
		        <div style="border: none; text-align: right; padding-right: 14%;">
					<a href="<%=contextPath %>/enrollForm.bo" class="btn btn-info">글 작성</a>
				</div>   
	       
		</div>
	</div>

	<script>
	
        $(function(){
           $(".table-hover>tbody>tr").click(function(){

        	   var bno =  $(this).children().eq(0).val();

				location.href='<%=contextPath%>/detail.bo?bno='  +  bno;
			});
        }); 
    
    </script>
 


</body>
</html>