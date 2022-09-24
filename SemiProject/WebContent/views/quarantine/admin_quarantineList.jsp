<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.PageInfo,java.util.ArrayList,com.kh.quarantine.model.vo.Quarantine"%>
<%
	PageInfo pi =(PageInfo)request.getAttribute("pi");
	ArrayList<Quarantine> list = (ArrayList<Quarantine>)request.getAttribute("list");
	
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
<link rel="stylesheet" href="/KGG/resources/css/admin_quarantineListStyle.css">
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
	            <p><b>방역현황관리</b></p>
	        </div>
	        <div id="notice_1">
	            <p><b>방역현황 내역</b></p>
	        </div>
	        <div id="notice_4">
	            <table class="table-hover">
	                <thead>
	                    <tr>
	                        <th width="20%">대륙명</th>
	                        <th width="20%">국가코드</th>
	                        <th width="20%">국가명</th>
	                        <th width="25%">업데이트일</th>
	                        <th width="15%"></th>
	                    </tr>
	                </thead>
	                <tbody>
	                   <%if(list.isEmpty()) {%>
                        	<tr><td colspan="4">등록된 정보가 없습니다.</td></tr>
                        <%} else {%>
							<%for(Quarantine q : list) {%>
								<tr>
									<td><%=q.getContinent()%></td>
									<td class="dtv1"><%=q.getCountryCode()%></td>
									<td class="dtv2"><%=q.getCountryKor()%></td>
									<td><%=q.getUpdateDate()%></td>
		                        <td>
		                        	<button onclick="location.href='<%=contextPath %>/adUpdateForm.qu?ccode=<%=q.getCountryCode() %>'" id="btn1">수정</button>
		                        	<button onclick="if(confirm('삭제하시겠습니까?')){return location.href='<%=contextPath %>/adDelete.qu?ccode=<%=q.getCountryCode() %>';}" id="btn2">삭제</button>
		                        </td>
	                    	</tr>
	                    	<%} %>
                        <%} %>
	                </tbody>
	            </table>
	        </div>
            <br>
            <div id="notice_2">
            	<a href="<%=contextPath %>/adEnrollForm.qu" type="button" class="btn" style="background-color: rgb(154, 222, 226); color:white">작성</a>
            </div>
            <div id="notice_3">    
       		<%if(currentPage!=1){ %>
            <button onclick="location.href='<%=contextPath%>/adList.qu?kpage=<%=currentPage-1%>'">&lt;</button>
            <%} %>
            
            <%for(int i =startPage; i<=endPage; i++){ %>
	 			<%if(i!=currentPage){ %>
	            	<button onclick="location.href='<%=contextPath%>/adList.qu?kpage=<%=i%>'"><%=i %></button>
                    <%}else{ %>
				  	<button disabled><%=i %></button>         
	            <%} %>
            <%} %>
            
            <%if(currentPage!=maxPage){ %>
            <button onclick="location.href='<%=contextPath%>/adList.qu?kpage=<%=currentPage+1%>'">&gt;</button>
       		<%} %>
           	</div>
        </div>
	    <script>
			$(function(){
                $(".dtv1").click(function(){
                    let ccode = $(this).text(); //국가코드 클릭시 본인의 text정보
                    //console.log(ccode);
                    location.href='/KGG/adDetail.qu?ccode='+ccode;
                });
            });
			$(function(){
                $(".dtv2").click(function(){
                    let ccode = $(this).prev().text(); //국가명 클릭시 본인앞 요소의 text정보
                    //console.log(ccode);
                    location.href='/KGG/adDetail.qu?ccode='+ccode;
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