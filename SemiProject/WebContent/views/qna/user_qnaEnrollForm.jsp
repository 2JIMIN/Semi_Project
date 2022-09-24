<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,com.kh.board.model.vo.Category"%>
<%
	ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/KGG/resources/css/user_qnaEnrollStyle.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<div id="content" style="width:1500px; height:500px;">
		<%@ include file="/views/common/content1_cs.jsp"%>
		<div id="content_2" style="width:1150px; height:650px;">
			<form action="<%=contextPath %>/insert.qo" method="post" id="formm">
			<input type="hidden" name="userNo" value="<%=loginUser.getUserNo() %>">
			<div id="content_3_1">문의하기</div>
			<div id="content_3_2">
				<div style="float: left; margin-right: 10px; padding-top: 15px;">
					<p class="form-control-static" style="margin:0px">구분</p>
				</div>
				<div style="float: left; padding-top: 20px;">
					<select style="width: 150px;" name="category">
						<%for(Category c : list) {%>
							<option value="<%=c.getCategoryNo() %>"><%=c.getCategoryName() %></option>
						<%} %>
<!-- 						<option value="40">스케줄</option> -->
<!-- 						<option value="41">환불</option> -->
<!-- 						<option value="42">기타</option> -->
					</select>
				</div>
			</div>
			<div id="content_3_3">
				<div style="float: left; margin-right: 10px; padding-top: 15px;">
					<p class="" style="margin:0px">제목</p>
				</div>
				<div style="float: left; padding-top: 15px;">
					<input type="text" id="TitleTK" class="form-control" maxlength="50" 
					placeholder="제목을 입력하세요" style="width: 500px; height: 30px;" name="title">
				</div>
			</div>
			<div id="content_3_4">
				<div style="float: left; margin-right: 10px; padding-top: 5px;">
					<p class="">
					<p class="">내용</p>
					</p>
				</div>
				<div style="float: left; padding-top: 20px;">
					<textarea id="" class="contextarea" placeholder="내용을 입력하세요." cols="68"
						rows="10" style="resize:none; border:1px solid rgb(180,179,179)" name="content"></textarea>
				</div>
			</div>
			<div id="content_3_5">
				<div id="content_3_5_1" style="float: left;  margin-right: 15px;">
					<div class="btn" class="btn3" style="background-color: #1a3d89; padding:0;">
	                    <input type="submit" id="btn2" class="btn" value="작성">
	            	</div>
				</div>
				<div id="content_3_5_2" style="float: left">
	                    <button onclick=goback(); class="btn btn3" style="background-color: #dedede; color:white;">취소</button>			
				</div>
			</div>
			</form>
		</div>
		 <%@ include file="../common/footer.jsp" %>
		 </div>
</body>
</html>