<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.board.model.vo.*"%>
<%
	QnA_Board b = (QnA_Board)request.getAttribute("b");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/KGG/resources/css/admin_qnaDetailStyle.css">
</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
		<div id="content_2">
	        <div id="customer">
	            <p><b>고객센터관리</b></p>
	        </div>
	        <div id="qna_1">
	            <p><b>QnA</b></p>
	        </div>
	        <div id="qna_2">
	            <table>
	                <tr>
	                    <td class="qna_2_th">작성자</td>
	                    <td><%=b.getUserId() %></td>
	                    <td class="qna_2_th">이메일</td>
	                    <td><%=b.getEmail() %></td>
	                    <td class="qna_2_th">전화번호</td>
	                    <td><%=b.getPhone() %></td>
	                </tr>
	                <tr>
	                    <td class="qna_2_th">구분</td>
	                    <td><%=b.getCategoryName() %></td>
	                    <td class="qna_2_th">작성일</td>
	                    <td colspan="3"><%=b.getCreateDate() %></td>
	                </tr>
	                <tr>
	                    <td class="qna_2_th">제목</td>
	                    <td colspan="5"><%=b.getBoardTitle() %></td>
	                </tr>
	                <tr>
	                    <td class="qna_2_th">내용</td>
	                    <td colspan="5"><%=b.getBoardContent() %></td>
	                </tr>
	            </table>
	        </div>
	        <div id="reply-area">
	        	<table style="border:2px solid lightgray;">
	        		<thead>
	        			<tr>
	        				<th style="background-color: rgb(234, 234, 234); width: 50%; text-align: center; font-weight: bold; font-size: 17px;">댓글작성</th>
	        				<td>
	        					<textarea id="replyContent" cols="70" rows="3" style="resize:none; margin-top:7px; margin-right:5px;"></textarea>
	        				</td>
	        			</tr>
	        		</thead>
	        		<tbody>
	        		
	        		</tbody>
	        	</table>
	        	<script>
	        	function insertReply(){
                    $.ajax({
                        url : "replyInsert.qo",
                        data:{
                            content : $("#replyContent").val(),
                            bno : <%=b.getBoardNo()%>
                    		
                        },
                        type : "post",
                        success : function(result){ //result는 매개변수명
                        	console.log(result);
                        if(result>0){
                        	selectReply();
                        	$("#replyContent").val(""); //초기화
                        }

                        },
                        error : function(){
                            console.log("ajax 통신실패");
                        }
                    })
                }
// 	        	//댓글 조회 함수
 	               function selectReply(){
 	                $.ajax({
 	                    url : "replyList.qo",
 	                    data : {bno : <%=b.getBoardNo()%> }, 
 	                    success : function(result){ 
 	                        console.log(result);//[{},{},{}]
 	                        var row = "";
 	                        for(var i in result){
 	                        	row+= "<tr>" 
 	                        	+		"<td>"+result[i].createDate+"</td>"
 	                        	+		"<td>"+result[i].replyContent+"</td>"
 	                        	+	   "</tr>";
 	                        }
	                        $("#reply-area tbody").html(row);
	                    },
	                    error : function(){
 	                        console.log("ajax 통신 실패");
 	                    }
 	                })
 	               }
	        	</script>
	        	
	        </div>
	        <div id="qna_3">
	            <a href="<%=contextPath%>/admin.list.qo?kpage=1" class="btn" style="background-color: rgb(234, 234, 234);">목록</a>
	            <button onclick="insertReply();" class="btn" style="background-color: rgb(154, 222, 226); color:white">답변</button>
<!-- 	            <a href="#" class="btn" style="background-color: rgb(134, 134, 134); color:white">수정</a> -->
<!-- 	            <a href="#" class="btn" style="background-color: rgb(64, 64, 64); color: white;">삭제</a> -->
	        </div>
	        <br>
		</div>
	</div>
</body>
</html>