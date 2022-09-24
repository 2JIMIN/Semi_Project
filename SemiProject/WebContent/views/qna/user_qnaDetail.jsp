<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.kh.board.model.vo.*"%>
<%
	QnA_Board b = (QnA_Board)request.getAttribute("b");
	ArrayList<Reply> list = (ArrayList<Reply>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/KGG/resources/css/user_qnaDetailStyle.css">
<title> | 킹갓제너럴투어</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div id="content">
		<%@ include file="/views/common/content1_cs.jsp" %>
		<div id="content_2">
			<div id="content_2_2">상담문의</div>
			<hr>
			<div id="content_2_3" style="height:45px; padding-top: 10px;">
				<table style="width: 100%;">
					<td width="77"><b><%=b.getBoardTitle() %></b></td>
					<td width="7%"><span><b><%=b.getUserId() %></b></span></td>
					<td width="7%"><span><b><%=b.getCategoryName() %></b></span></td>
<!-- 					<td>&nbsp;</td> -->
					<td width="9%"><span><%=b.getCreateDate() %></span></td>
				</table>
			</div>
			<div id="content_2_4"><%=b.getBoardContent() %></div>
			<div id="content_2_4_1">
			<%if(list!=null){ %>
				<%for(Reply r : list){ %>
				<span>
					<b>관리자</b> &nbsp&nbsp&nbsp&nbsp<%=r.getReplyContent() %><br><br>
				</span>
					<span><%=r.getCreateDate() %></span>
				<%} %>
			<%} %>
			</div>
			<div id="content_2_5">
			
				<span class="btn" style="background-color: rgb(134, 134, 134); color:white" onclick="location.href='<%=contextPath%>/updateForm.qo?qno=<%=b.getRnum()%>'"><addr title="수정하기"> 수정</addr></span>
				<span id="nolist" class="btn" style="background-color: rgb(234, 234, 234)" onclick="location.href='<%=contextPath%>/list.qo?kpage=1'"><addr title="목록">목록</addr></span>
				<button class="btn" style="background-color: rgb(64, 64, 64); color: white" onclick="if(confirm('정말로 삭제하시겠습니까?')){return location.href='<%=contextPath%>/delete_qo?qno=<%=b.getBoardNo()%>';}"><addr title="삭제하기">삭제 </addr></button>
			</div>
		</div>
		<%@ include file="../common/footer.jsp" %>
	</div>s
	<script>
	$(function(){
		$("#content_2_5 span").hover(function(){
			$(this).css({"cursor":"pointer", "color":"rgb(154, 222, 226)"});
			$(this).addClass("style");
		}, function(){
			$(this).css({"cursor":"", "color":""});
			$(this).removeClass("style");
		});
	});
	</script>
</body>
</html>