<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.board.model.vo.*, java.util.ArrayList"%>
<%
	QnA_Board b = (QnA_Board)request.getAttribute("b");
	ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("qlist");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/KGG/resources/css/user_qnaUpdateStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div id="content">
		<%@ include file="/views/common/content1_cs.jsp" %>
		<div id="content_2">
			<div id="content_2_2">상담문의</div>
			<hr>
			<form action="<%=contextPath %>/update.qo" id="update-form">
			<input type="hidden" name="qno" value="<%=b.getBoardNo()%>">
			<input type="hidden" name="rno" value="<%=b.getRnum() %>">
			<div id="content_2_3" style="height:45px;">
				<table style="width: 100%;">
					<td style="width: 65%; padding-left:10px;"><b><input type="text" style="height: 30px; width: 400px; float:left;" id="q1" name="title" value="<%=b.getBoardTitle() %>" class="info"></b></td>
					<td style="width: 15%; padding-left:100px;"><span><b><%=b.getUserId() %></b></span></td>
					<td style="width: 10%; padding-left:16px;" id="righttt"><span><b><select name="category">
						<%for(Category c : list) {%>
	                        <option value="<%=c.getCategoryNo() %>"><%=c.getCategoryName() %></option>
	                    <%} %>
					</td></b></span>						
					<script>
						$(function(){
							$("#update-form option").each(function(){
								if($(this).text()=='<%=b.getCategoryName()%>'){
									$(this).attr("selected",true);
								}
							})
						})
					</script>
					<td>&nbsp;</td>
					<td width="9%"><span><%=b.getCreateDate() %></span></td>
				</table>
			</div>
			<div id="content_2_4"><input type="text" style="height: 200px; width: 550px;" id="q2" name="content" value="<%=b.getBoardContent() %>" class="info" placeholder="(답변 입력창)"></div>
			<div id="content_2_4_1">답변</div>
			<div id="content_2_5">
				<input type="submit" class="btn btn2" style="background-color:#1a3d89; color:white;" value="등록">
<!-- 				<span onclick="location.href=''"><addr title="등록하기">등록 &gt;</addr></span> -->
				<button onclick=goback(); class="btn btn3" style="background-color: #dedede; color:white;">취소</button>			
			</div>
			</form>
		</div>
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>