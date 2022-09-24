<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.kh.recommendation.model.vo.Recommendation"%>
<%
	Recommendation r  = (Recommendation)request.getAttribute("r");
	ArrayList<Recommendation> list = (ArrayList<Recommendation>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/KGG/resources/css/admin_recInsertStyle.css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- 페이지 상단 또는 하단에 라이브러리 추가 --> 
<script type="text/javascript" src="/KGG/resources/smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>

</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
		<div id="content_2">
			<form id="updateForm" action="<%=contextPath%>/adUpdate.re" method="post">
		        <div id="customer">
           			<p><b>추천여행지관리</b></p>
       			</div>
       			<div id="notice_1">
        			<p><b>게시글 수정</b></p>
       			</div>
	            <input type="hidden" name="bno" id="bno" value="<%=r.getBoardNo()%>">
				<table width="100%">
					<tr>
                     	  <th width="25%">구분</th>
                       	<td>
                        	<input list="countryList" name="cCode" id="countryCode" style="width:100%" value="<%=r.getCountryCode()%>">
                       		<datalist id="countryList">
                       			<!-- 리스트가 비어있는 경우 -->
		                        <%if(list.isEmpty()){%>
		                        	<option value="" label="">
		                        <%} else {%>
		                        <!-- 비어있지 않을 경우 -->
                          			<%for(Recommendation rlist : list) {%>
                                      		<option value="<%= rlist.getCountryCode()%>" label="<%= rlist.getCountryKor()%>(<%=rlist.getContinent() %>)">
                               		<%} %>
                          		<%} %>
                              		
                       		</datalist>
                       	</td>
                    </tr>
					<tr>
						<td>제목</td>
						<td><input type="text" id="title" name="title" style="width:650px" value="<%=r.getBoardTitle()%>"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea id="txtContent" name="content" rows="10" cols="100" style="width: 100%;">
						<%=r.getBoardContent()%>
						</textarea></td>
							</tr>
 		   		</table>		
	            <br>
	            <div id="notice_3">   	 
	                <button type="button" id="update" class="btn" onclick="contentNotNull();" style="background-color: rgb(154, 222, 226); color:white">수정</button>
	                <button type="button" onclick="history.back();" class="btn" style="background-color: rgb(234, 234, 234);">뒤로</button>
	            </div>
   	 </form>

	            <!-- 페이지 로딩 실행 -->
		        <script type="text/javascript"> 
					var oEditors = [];
					$(function(){
						
						function smartEditor(){
							
							nhn.husky.EZCreator.createInIFrame({ 
								oAppRef: oEditors, 
								elPlaceHolder: 'txtContent', //텍스트에디터 textare id명
								sSkinURI: '/KGG/resources/smarteditor2/SmartEditor2Skin.html', 
								fCreator: 'createSEditor2' 
							});
						}
						smartEditor();			
					});
					
					//내용입력 필수
					function contentNotNull(){
						
						  oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", [])
						  var data = oEditors.getById['txtContent'].getIR();
						  if(data == '<p><br></p>') {
							alert("내용을 입력해주세요.")
							oEditors.getById["txtContent"].exec("FOCUS")
							return
						  } else {
							console.log(data)
						  }
						}
					
					//저장버튼 클릭시 form 전송
				      $("#update").click(function(){
				          oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []);
				          $("#updateForm").submit();
				      });    
					</script>
	           </div>

</body>
</html>