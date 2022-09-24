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
<title>공지사항 | 킹갓제너럴투어</title>
<link rel="stylesheet" href="/KGG/resources/css/user_qnaMainStyle.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div id="content">
		<%@ include file="/views/common/content1_cs.jsp" %>
            <div id="content_2">
                <div id="content_2_2">상담문의</div>
           <form action="<%=contextPath %>/list.qo?kpage=1" method="post">
                <div id="content_2_3">
                <div>
                    <table style="width: 1050px;">
                        <thead>
                            <tr>
                                <th class="text-center id" width="10%">No.</th>
                                <th class="text-center id" width="15%">구분</th>
                                <th class="text-center id" width="35%">제목</th>
                                <th class="text-center id" width="10%">작성자</th>
                                <th class="text-center id" width="10%">작성일</th>
                                <th class="text-center id" width="10%">상태</th>
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
               	</div>
                </div>
                <!-- 로그인한 회원만 보일 수 있도록 -->
                <%if(loginUser!=null) {%>
                	<div class="btn" style="background-color:#1a3d89; float: right; padding-top:10px;">
                		<a href="<%=contextPath%>/enrollForm.qo" style="color:white !important;  text-decoration: none; ">문의하기</a>
                	</div>
                <%} %>
                
                 <div id="content_2_4" align="center" style= "padding-top:10px;"> 
                 <%if(currentPage!=1) {%>  
                 <button onclick="location.href='<%=contextPath%>/list.qo?kpage=<%=currentPage-1%>'">&lt;</button>
                 <%} %> 
                  
                 <%for(int i=startPage; i<endPage+1; i++) {%>  
                 <%if(i != currentPage) {%>  
                 <button onclick="location.href='<%=contextPath%>/list.qo?kpage=<%=i%>'"><%=i %></button> 
                 <%} else {%> 
                 	<button disabled id="btnn"><%=i %></button> 
                 <%} %> 
                 <%} %>
                 
                 <%if(currentPage != maxPage) {%> 
                 <button onclick="location.href='<%=contextPath%>/list.qo?kpage=<%=currentPage+1%>'">&gt;</button> 
                 <%} %> 
                 </div> 
                 <div id="content_2_5">
<!-- 					<select name="keyField" > -->
<!-- 						<option value="title">제목</option> -->
<!--                             <option value="200">내용</option> -->
<!--                             <option value="writerId">작성자</option> -->
<!-- 					</select> -->
<!-- 					<input type="text" name="keyword" value=""> -->
<!-- 					<button  type="submit" class="btn"></button>          -->
                 </div>
           </form>
             </div> 
        </div>
        <div id="content_3"></div>
         <script>
         <%if(!list.isEmpty()) {%> 
      	$(function(){
      		$(".q_title").click(function(){
      			var userId2 = "";
      			var userId = $(this).next().text();  // 세션유지되어 있는 id
      			<%if(loginUser!=null){%>
      				userId2 = '<%=loginUser.getUserId()%>' 
      			<%}else{%>
      				location.href="/KGG/loginPage.us";
      			<%}%>
      			if(userId2 == userId){
      				location.href = "/KGG/detail.qo?qno="+$(this).prev().prev().text(); 
      			}
      			else{
      				alert("본인만 열람가능");
      			}
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
         <%@ include file="../common/footer.jsp" %>
      </div>
</body>
</html>