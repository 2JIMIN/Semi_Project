<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.PageInfo,java.util.ArrayList,com.kh.board.model.vo.QnA_Board" %>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<QnA_Board> list = (ArrayList<QnA_Board>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/KGG/resources/css/admin_qnaMainStyle.css">
</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
		<div id="content_2">
	        <div id="customer">
	            <p><b>고객센터관리</b></p>
	        </div>
	        <div id="qna_1">
	            <p><b>QnA</b></p>
	        </div>
	        <div>
	            <table>
	                <thead>
	                    <tr>
	                        <th width="7%">No.</th>
	                        <th width="20%">구분</th>
	                        <th width="38%">제목</th>
	                        <th width="10%">작성자</th>
	                        <th width="15%">작성일</th>
	                        <th width="10%">상태</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <%if(list.isEmpty()) {%>
                        	<tr>
                        		<td colspan="4">등록된 Q&A가 없습니다.</td>
                        	</tr>
                         <%} else {%> 
                         	<%for(QnA_Board b : list) {%> 
	                            <tr>
	                                <td class="text-center" id="n_no"><%=b.getRnum() %></td>
	                                <td class="text-center"><%=b.getCategoryName()%></td>
	                                
	                               
	                                	<td class="text-center q_title"><%=b.getBoardTitle()%></td>
	                               	  
	                                                            		
	                                <td class="text-center"><%=b.getUserId()%></td>
	                                <td class="text-center"><%=b.getCreateDate()%></td>
	                                <td class="text-center"><%=b.getAnswerStatus()%></td>
	                            </tr>
                         <%} %>
                         <%} %> 
	                </tbody>
	            </table>
	            <div id="content_2_4" align="center" style= "padding-top:10px;"> 
                 <%if(currentPage!=1) {%>  
                 <button onclick="location.href='<%=contextPath%>/admin.list.qo?kpage=<%=currentPage-1%>'">&lt;</button>
                 <%} %> 
                  
                 <%for(int i=startPage; i<endPage+1; i++) {%>  
                 <%if(i != currentPage) {%>  
                 <button onclick="location.href='<%=contextPath%>/admin.list.qo?kpage=<%=i%>'"><%=i %></button> 
                 <%} else {%> 
                 	<button disabled id="btnn"><%=i %></button> 
                 <%} %> 
                 <%} %>
                 
                 <%if(currentPage != maxPage) {%> 
                 <button onclick="location.href='<%=contextPath%>/admin.list.qo?kpage=<%=currentPage+1%>'">&gt;</button> 
                 <%} %> 
                 </div> 
	            <script>
	                $(function(){
	                    $(".qnaTitle").hover(function(){
	                        $(this).css({"cursor":"pointer", "fontWeight":"bold", "color":"grey"});
	                        $(this).addClass("boldStyle");
	                    }, function(){
	                        $(this).css({"cursor":"", "fontWeight":"", "color":""})
	                        $(this).removeClass("boldStyle");
	                    });
	                    $("tr").hover(function(){
	                        $(this).css("backgroundColor", "rgb(234, 234, 234)");
	                        $(this).addClass("backStyle");
	                    }, function(){
	                        $(this).css("backgroundColor", "");
	                        $(this).removeClass("backStyle");
	                    });
	                });
	            </script>
 	            <script> -->
         	<%if(!list.isEmpty()) {%> 
         	$(function(){
         		$(".q_title").click(function(){
         			location.href = "<%=contextPath%>/admin.detail.qo?qno="+$(this).prev().prev().text(); 
        		});
         		$("td:contains('답변대기')").css("color","rgb(210,147,30)");
         		$("td:contains('답변완료')").css("color","rgb(89,196,202)");
         		$("tbody>tr").hover(function(){
         			$(this).css({"cursor":"pointer", "color":"lightblue"});
         			$(this).addClass("hoverStyle");
         		}, function(){
         			$(this).css({"cursor":"", "color":""});
         			$(this).removeClass("hoverStyle");
         		});
         	});
         <%}%> 
         </script> 
	        </div>
	        <br><br><br>
		</div>
	</div>
</body>
</html>