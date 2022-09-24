<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.PageInfo,java.util.ArrayList,com.kh.recommendation.model.vo.Recommendation"%>
<%
	PageInfo pi =(PageInfo)request.getAttribute("pi");
	ArrayList<Recommendation> list = (ArrayList<Recommendation>)request.getAttribute("list");
	
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
<link rel="stylesheet" href="/KGG/resources/css/user_recListStyle.css">

</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <div id="content">
        <div id="content_1">
            <%@ include file="user_recMenubar.jsp" %>
        </div>
        <div id="content_2">
        <div id="pageName" style="font-size: x-large; border-bottom: 1px solid; padding: 1%">추천여행지 - 동북아시아</div>  
        <br><br>  
	        
	        <div id="listTable">
	            <table class="table-hover">
	            <thead>
	                <tr>
	                    <th width="20%"></th>
	                    <th width="50%"></th>
	                    <th width="10%"></th>
	                    <th width="20%"></th>
	                </tr>
	            </thead>
	            <tbody>
	                <%if(!list.isEmpty()) {%>
		    			<%for(Recommendation r : list){ %>
			                <tr>
								<input type="hidden" value="<%=r.getBoardNo()%>">
			                    <td>
			                        <div class="thumbnail">
                     		            <%if(r.getThumbnailRoot()!=null) {%>
			                            	<img src="<%=r.getThumbnailRoot() %>" alt="Thumbnail" height="120px" width="120px" style="padding: 2%">
			                            <%}else {%>
			                           		<img src="/KGG/resources/board_upfiles/noimage2.png" alt="Thumbnail" height="120px" width="120px" style="padding: 2%">
			                            <%} %>
			                        </div>
			                    </td>
			                    <td class="dtv1"><%=r.getBoardTitle() %></td>
			                    <td>
			                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M1.679 7.932c.412-.621 1.242-1.75 2.366-2.717C5.175 4.242 6.527 3.5 8 3.5c1.473 0 2.824.742 3.955 1.715 1.124.967 1.954 2.096 2.366 2.717a.119.119 0 010 .136c-.412.621-1.242 1.75-2.366 2.717C10.825 11.758 9.473 12.5 8 12.5c-1.473 0-2.824-.742-3.955-1.715C2.92 9.818 2.09 8.69 1.679 8.068a.119.119 0 010-.136zM8 2c-1.981 0-3.67.992-4.933 2.078C1.797 5.169.88 6.423.43 7.1a1.619 1.619 0 000 1.798c.45.678 1.367 1.932 2.637 3.024C4.329 13.008 6.019 14 8 14c1.981 0 3.67-.992 4.933-2.078 1.27-1.091 2.187-2.345 2.637-3.023a1.619 1.619 0 000-1.798c-.45-.678-1.367-1.932-2.637-3.023C11.671 2.992 9.981 2 8 2zm0 8a2 2 0 100-4 2 2 0 000 4z"></path></svg>
			                        <%=r.getCount() %>
			                    </td>
			                    <td><%=r.getCreateDate() %></td>
			                </tr>
	                	<%} %>

	           	    <%} %>
	            </tbody>
	        </table>
        </div>	       
        
	        <br>
	        <div class="paging-area" align="center">
	       		<%if(currentPage!=1){ %>
	            <button onclick="location.href='<%=contextPath%>/list.re?kpage=<%=currentPage-1%>'" style="border:0px; background-color:white; color:#1a3d89;">&lt;</button>
	            <%} %>
	            
	            <%for(int i =startPage; i<=endPage; i++){ %>
		 			<%if(i!=currentPage){ %>
		            	<button onclick="location.href='<%=contextPath%>/list.re?kpage=<%=i%>'"><%=i %></button>
	                    <%}else{ %>
					  	<button disabled id="btn" style="background-color:#1a3d89; color:white; border-radius:3px;"><%=i %></button>         
		            <%} %>
	            <%} %>
	  
	            <%if(currentPage!=maxPage){ %>
	            	<button onclick="location.href='<%=contextPath%>/list.re?kpage=<%=currentPage+1%>'" style="border:0px; background-color:white; color:#1a3d89;">&gt;</button>
	       		<%} %>
	        </div>

	    <script>
			$(function(){
                $(".dtv1").click(function(){
                    let bno = $(this).prev().prev().val(); //제목 클릭시 본인앞앞 요소인 input의 value값
//                     console.log(bno);
                    location.href='/KGG/detail.re?bno='+bno;
                });
            });
	        $(function(){
	            $(".noticeTitle").hover(function(){
	                $(this).css({"cursor":"pointer", "fontWeight":"bold", "color":"rgb(29, 38, 134)"});
	                $(this).addClass("boldStyle");
	            }, function(){
	                $(this).css({"cursor":"", "fontWeight":"", "color":""})
	                $(this).removeClass("boldStyle");
	            });
	            $("tr").hover(function(){
	                $(this).css("backgroundColor", "rgb(240, 240, 240)");
	                $(this).addClass("backStyle");
	            }, function(){
	                $(this).css("backgroundColor", "");
	                $(this).removeClass("backStyle");
	            });
	        });
	    </script>
  	    </div>
        
        <%@ include file="/views/common/content3.jsp" %>
    </div>
    <%@ include file="/views/common/footer.jsp" %>
</body>
</html>