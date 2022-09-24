<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
String alertMsg = (String)request.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<script>
		var msg = "<%=alertMsg%>"; 
		
		if(msg!="null"){
			alert(msg);
			//알림창을 띄어준 후에 session에 담긴 msg를 지워주지 않으면
			//해당 페이지가 읽혀질때마다 alert 메세지가 뜨게된다.
			//지워줘야함
			<%request.removeAttribute("alertMsg");%>
		}
</script>
<script>
		$(document).ready(function(){
		location.href="<%=contextPath%>/updateFlightPage.ai";
	})
</script>

</body>
</html>