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
<link rel="stylesheet" href="/KGG/resources/css/admin_recListStyle.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
	
		<div id="content_2">
	        <div id="customer">
	            <p><b>추천여행지관리</b></p>
	        </div>
	        <div id="notice_1">
	            <p><b>게시글 내역</b></p>
	        </div>
	        <div id="notice_4">
	            <table class="table-hover">
	                <thead>
	                    <tr>
                            <th width="10%">글번호</th>
                            <th width="15%">구분</th>
                            <th width="30%">제목</th>
                            <th width="10%">조회수</th>
                            <th width="20%">등록일</th>
                            <th width="15%"></th>
	                    </tr>
	                </thead>
	                <tbody>
	                	<%if(list.isEmpty()) {%>
                        	<tr><td colspan="7">등록된 정보가 없습니다.</td></tr>
                        <%} else {%>
							<%for(Recommendation r : list) {%>
								<tr>
									<td><%=r.getBoardNo()%></td>
									<td><%=r.getContinent() %></td>
									<td class="dtv1"><%=r.getBoardTitle()%></td>
									<td><%=r.getCount()%></td>
									<td><%=r.getCreateDate()%></td>
									
		                        <td>
		                        	<button onclick="location.href='<%=contextPath %>/adUpdateForm.re?bno=<%=r.getBoardNo()%>'" id="btn1">수정</button>
		                        	<button onclick="if(confirm('삭제하시겠습니까?')){return location.href='<%=contextPath %>/adDelete.re?bno=<%=r.getBoardNo() %>';}" id="btn2">삭제</button>
		                        </td>
	                    	</tr>
	                    	<%} %>
                        <%} %>
	                </tbody>
	            </table>
	        </div>
            <br>
            <div id="notice_2">
            	<a href="<%=contextPath %>/adEnrollForm.re" type="button" class="btn" style="background-color: rgb(154, 222, 226); color:white">작성</a>
            </div>
            
            <div id="notice_3">    
       		<%if(currentPage!=1){ %>
            <button onclick="location.href='<%=contextPath%>/adList.re?kpage=<%=currentPage-1%>'">&lt;</button>
            <%} %>
            
            <%for(int i =startPage; i<=endPage; i++){ %>
	 			<%if(i!=currentPage){ %>
	            	<button onclick="location.href='<%=contextPath%>/adList.re?kpage=<%=i%>'"><%=i %></button>
                    <%}else{ %>
				  	<button disabled><%=i %></button>         
	            <%} %>
            <%} %>
  
            <%if(currentPage!=maxPage){ %>
            <button onclick="location.href='<%=contextPath%>/adList.re?kpage=<%=currentPage+1%>'">&gt;</button>
       		<%} %>
           	</div>
        </div>
	    <script>
			$(function(){
                $(".dtv1").click(function(){
                    let bno = $(this).prev().prev().text(); //제목 클릭시 본인앞앞 요소인 글번호 텍스트
                    //console.log(bno);
                    location.href='/KGG/adDetail.re?bno='+bno;
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


</body>
</html>