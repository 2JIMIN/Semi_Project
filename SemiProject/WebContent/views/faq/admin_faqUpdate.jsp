<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.board.model.vo.*,java.util.ArrayList"%>
    
    <%
    	ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("clist");
    	Board b= (Board)request.getAttribute("b");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- Latest compiled JavaScript -->
<link rel="stylesheet" href="/KGG/resources/css/admin_faqUpdateStyle.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
	
</style>
</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
		<div id="customer">
	        <p><b>고객센터관리</b></p>
	    </div>
	    <div id="notice_1">
	            <p><b>FAQ 수정</b></p>
	        </div>
		    <br><br>
		    <form action="<%=contextPath %>/update.bo" method="post" id="update-form" enctype="multip"
		    onsubmit="return confirm('FAQ를 수정하시겠습니까?')" >
		    	<input type="hidden" name="bno" value="<%=b.getFaqNo()%>">
		        <div>
		            <table style=" padding-left: 50px;   font-size: 18px;">
		            <tr>구분 : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		            
		            	<select name="category" ><br><br>
		            		<%for(Category c : list) { %>
		            			<option value="<%=c.getCategoryNo() %>"><%=c.getCategoryName() %></option>
		            		<%} %>
		            	</select>
		            </tr>
		                <tr>
		                    <td width="13%">제목 : </td>
		                    <td width="87%">
								<textarea name="title" id="q1" cols="55" rows="1"  class="info" placeholder="(답변 입력창)" style="resize: none;"><%=b.getFaqTitle() %></textarea>
							</td>
		                </tr>
		                <tr><td>&nbsp;</td></tr>
		                <tr>
		                    <td>내용 : </td>
		                    <td colspan="2">
								<textarea name="content" id="q2" cols="55" rows="10"  class="info" placeholder="(답변 입력창)" style="resize: none;"><%=b.getFaqContent() %></textarea>
		                    </td>
		                </tr>
		            </table>
		        </div>
		        <div id="notice_2">
					<button type="submit" class="btn" style="background-color: rgb(154, 222, 226); color:white">등록</button>
		            <a href="<%=contextPath %>/faqmain.fm" class="btn" style="background-color: rgb(234, 234, 234);">취소</a>
		        </div>
		    </form>
		  
		</div>
	</div>
		            	 <script>
                            $(function(){
                                $("#update-form option").each(function(){
                                		 console.log($(this).text());
                                	
                                	 if($(this).text()=='<%=b.getCategoryName() %>'){
                                        $(this).prop("selected",true);
                                    }
                                })
                            })
                        </script>
</body>
</html>