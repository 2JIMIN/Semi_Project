<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.userinfo.model.vo.*"%>
<%
	UserInfo ui = (UserInfo)request.getAttribute("ui");
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/KGG/resources/css/admin_userManagementStyle.css"> 
</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
	<div id="content_2" style="padding-top: 20px; padding-left: 50px; ">
		<div id="content_2_1">
	        <p><b>회원관리</b></p>
		</div>
	        <br>
	        <div class="search" style="background-color: rgb(244, 244, 244); padding: 15px; margin-top: 20px;">
	        
	        
	            <form action="<%=contextPath%>/searchCon.us" method="post">
	                	
	                	<button type="submit" class="btn" value="조회" style="width:80px;height:40px;float: right;
						color: white; background-color: #9ADEE2;">조회</button>
	                    
	              	이메일 : <input type="text" name="userEmail">
	              <!--   이름 : &nbsp;&nbsp;&nbsp;  <input type="text" name="userName">  <br>
	                아이디 : <input type="text" name="userId"> <br><br> -->
	            </form>
	        </div>
	        <br><br><br><br>
	        <div id="content_2_2" align="center">
	        	<p><b>조회결과</b></p>
	        </div>
	        <table align="center" style="width: 100%; margin-top: 20px;">
				<div>
	            <thead>
	                <tr align="center" id="t1">
	                    <th>NO.</th> <!-- th는 굵은 글씨로 나타남 -->
	                    <th>회원명</th>
	                    <th>아이디</th>
	                    <th>비밀번호</th>
	                    <th>이메일</th>
	                    <th>전화번호</th>
	                    <th>가입일</th>
	                </tr>
	            </thead>
	            <tbody align="center" id="tbody">
	                <%if(ui!=null){ %>
	                <tr>
	                    <td><%=ui.getUserNo() %></td>
	                    <td><%=ui.getUserName() %></td>
	                    <td><%=ui.getUserId() %></td>
	                    <td><%=ui.getUserPwd() %></td>
	                    <td><%=ui.getEmail() %></td>
	                    <td><%=ui.getPhone() %></td>
	                    <td><%=ui.getEnrollDate() %></td>
	                </tr>
	               <%} %>
	            </tbody>
	        </table>

		</div>

	    </div>
	</div>

	
</body>
</html>