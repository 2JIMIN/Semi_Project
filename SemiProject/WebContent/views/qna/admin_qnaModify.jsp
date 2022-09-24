<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="/KGG/resources/css/admin_qnaEnrollStyle.css">
</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
		<div id="content_2">
	        <div id="customer">
	            <p><b>고객센터관리</b></p>
	        </div>
	        <div id="notice_1">
	            <p><b>QnA 답변등록</b></p>
	        </div>
	        <div id="notice_2">
	            <form action="">
                    <div>
                        <table>
                            <tr>
                                <td width="15%">제목: </td>
                                <td>
                                    <input type="text" size="78px">
                                </td>
                            </tr>
                            <tr><td>&nbsp;</td></tr>
                            <tr>
                                <td>내용: </td>
                                <td colspan="2">
                                    <textarea name="noticeContent" cols="80" rows="10" style="resize:none"></textarea>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="notice_3">
                        <a href="#" class="btn" style="background-color: rgb(154, 222, 226); color:white">등록</a>
                        <a href="#" class="btn" style="background-color: rgb(234, 234, 234);">취소</a>
                    </div>
                </form>
	        </div>
		</div>
	</div>
</body>
</html>