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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>
        table{
            width: 80%;
        }
        table>input{
            width: 100%;
        }
        #enrollForm input,#enrollForm textarea{
            width: 100%;
            box-sizing:border-box;
        }
        div{
        
        }
    </style>

</head>
<body>
    <%@ include file="../common/admin/admin.jsp" %>

    <div>
        <br> <h2 align="center">글작성</h2>
        <br><br>
        <form id="enrollForm"  action="<%=contextPath%>/insert.bo" method="post" >
        	
            <table align="center">
                <tr>
                    <th>카테고리</th>
                    <td>
                        <select name="category" >
                        	<%for(Category c : list) {%>
                        		<option value="<%=c.getCategoryNo() %>"><%=c.getCategoryName() %></option>
                        	<%} %>
                        </select>
                        <script>
                            
                        </script>
                    </td>
                </tr>
                <tr>
                    <th width="50px">제목</th>
                    <td width="400px"><input type="text" name="title" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>
                    <textarea name="content" id="" cols="30" rows="10" style="resize: none;" required></textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        
                    </td>
                </tr>
            </table>

            <div align="right" style="padding-right: 2.5%;">
                <button type="submit"style="background-color: rgb(154, 222, 226); color:white" class="btn">등록</button>
                <button type="button" class="btn" style="background-color: rgb(234, 234, 234);" onclick="history.back();">뒤로가기</button>
                
            </div>
        </form>
    </div>


</body>
</html>