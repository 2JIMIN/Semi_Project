<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.recommendation.model.vo.Recommendation"%>
<%
	Recommendation r = (Recommendation)request.getAttribute("r");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/KGG/resources/css/user_recDetailViewStyle.css">
</head>
<body>
	<div class="wrap">
    <%@ include file="../common/menubar.jsp" %>
    <div id="content">
        <div id="content_1">
            <%@ include file="user_recMenubar.jsp" %>
        </div>
        
        <div id="content_2">
	        <div id="pageName" style="font-size: x-large; border-bottom: 1px solid; padding: 1%">
	        	추천여행지 - <%=r.getContinent() %>
	        </div>  
	        <br><br>  
	            <div>
		            <h2><%=r.getBoardTitle() %></h2>
		        </div>
		        <br>
				<div class="">
					등록일 : <%=r.getCreateDate() %>
		            &ensp;&ensp;&ensp;
		            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M1.679 7.932c.412-.621 1.242-1.75 2.366-2.717C5.175 4.242 6.527 3.5 8 3.5c1.473 0 2.824.742 3.955 1.715 1.124.967 1.954 2.096 2.366 2.717a.119.119 0 010 .136c-.412.621-1.242 1.75-2.366 2.717C10.825 11.758 9.473 12.5 8 12.5c-1.473 0-2.824-.742-3.955-1.715C2.92 9.818 2.09 8.69 1.679 8.068a.119.119 0 010-.136zM8 2c-1.981 0-3.67.992-4.933 2.078C1.797 5.169.88 6.423.43 7.1a1.619 1.619 0 000 1.798c.45.678 1.367 1.932 2.637 3.024C4.329 13.008 6.019 14 8 14c1.981 0 3.67-.992 4.933-2.078 1.27-1.091 2.187-2.345 2.637-3.023a1.619 1.619 0 000-1.798c-.45-.678-1.367-1.932-2.637-3.023C11.671 2.992 9.981 2 8 2zm0 8a2 2 0 100-4 2 2 0 000 4z"></path></svg>
		            <%=r.getCount() %>
    		        &ensp;&ensp;&ensp;&ensp;&ensp;
		            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-printer" viewBox="0 0 16 16">
						<path d="M2.5 8a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1z"/>
						<path d="M5 1a2 2 0 0 0-2 2v2H2a2 2 0 0 0-2 2v3a2 2 0 0 0 2 2h1v1a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2v-1h1a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-1V3a2 2 0 0 0-2-2H5zM4 3a1 1 0 0 1 1-1h6a1 1 0 0 1 1 1v2H4V3zm1 5a2 2 0 0 0-2 2v1H2a1 1 0 0 1-1-1V7a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-1v-1a2 2 0 0 0-2-2H5zm7 2v3a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1v-3a1 1 0 0 1 1-1h6a1 1 0 0 1 1 1z"/>
					</svg>
					<span style="cursor: pointer" onclick="window.print()">인쇄</span>
					&ensp;
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bookmarks" viewBox="0 0 16 16">
						<path d="M2 4a2 2 0 0 1 2-2h6a2 2 0 0 1 2 2v11.5a.5.5 0 0 1-.777.416L7 13.101l-4.223 2.815A.5.5 0 0 1 2 15.5V4zm2-1a1 1 0 0 0-1 1v10.566l3.723-2.482a.5.5 0 0 1 .554 0L11 14.566V4a1 1 0 0 0-1-1H4z"/>
						<path d="M4.268 1H12a1 1 0 0 1 1 1v11.768l.223.148A.5.5 0 0 0 14 13.5V2a2 2 0 0 0-2-2H6a2 2 0 0 0-1.732 1z"/>
					</svg>
					<span style="cursor: pointer" onclick="clip(); return false;"> URL 주소복사</span>
				</div>
		        <br><br>
		        <div class="content-body">
		            <%=r.getBoardContent() %>    
		        </div>
     		    
     		    <div id="topPage">
					<a href="#" style="display:scroll; position:fixed; bottom:10px; right:20%">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-up" viewBox="0 0 16 16">
							<path fill-rule="evenodd" d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5z"/>
						</svg>
					</a>
				</div>
		        <br><br><br>
		        
		        <script>
			        function clip(){
	
			        	var url = '';
			        	var textarea = document.createElement("textarea");
			        	document.body.appendChild(textarea);
			        	url = window.document.location.href;
			        	textarea.value = url;
			        	textarea.select();
			        	document.execCommand("copy");
			        	document.body.removeChild(textarea);
			        	alert("URL이 복사되었습니다.")
			        }
		        </script>
        </div>
        <%@ include file="/views/common/content3.jsp" %>
    </div>
    </div>
</body>
</html>