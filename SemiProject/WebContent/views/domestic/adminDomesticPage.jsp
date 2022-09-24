<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/KGG/resources/css/adminReservationStyle.css">
</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
		<div id="content_2">
		    <div id="content_2_1"><h1>페이지 관리</h1></div>
		    <div id="content_2_2"><h2>국내예약관리</h2></div>
		    <div id="content_2_3">
		        <form action="" id="addContent">
		            <h2>내용추가</h2>
		            <table id="addContent_1">
		                <tr>
		                    <td width="20%">카테고리 선택</td>
		                    <td width="5%"><input type="radio" name="category" value="category1">1번</td>
		                    <td width="5%"><input type="radio" name="category" value="category2">2번</td>
		                    <td width="20%">파일 업로드</td>
		                    <td width="50%" colspan="3"><input type="file" name="file"></td>
		                    <!--<td width="5%"></td>
		                    <td width="15%"></td>-->
		
		                </tr>
		                <tr>
		                    <td>카테고리명</td>
		                    <td colspan="4"><input type="text" name="categoryName" class="textArea" required></td>
		                    <td></td>
		                </tr>
		                <tr>
		                    <td>상품설명</td>
		                    <td colspan="4"><input type="text" name="productTitle" class="textArea" required></td>
		                    <td></td>
		                </tr>
		                <tr>
		                    <td>상품상세설명1</td>
		                    <td colspan="2"><input type="text" name="productSub1" class="textArea" required></td>
		                    <td>상품상세설명2</td>
		                    <td><input type="text" name="productSub2"></td>
		                    <td id="addBtnArea">
		                        <button type="submit" id="addBtn">추가</button>
		                    </td>
		                </tr>
		            </table>
		        </form>
		    </div>
		    <div id="content_2_4">
		        <form action="" id="updateContent">
		            <h2>내용변경</h2>
		            <table id="updateContent_1">
		                <tr>
		                    <td width="20%">카테고리 선택</td>
		                    <td width="5%"><input type="radio" name="category" value="category1">1번</td>
		                    <td width="5%"><input type="radio" name="category" value="category2">2번</td>
		                    <td width="20%">파일 업로드</td>
		                    <td width="50%" colspan="3"><input type="file" name="file"></td>
		
		                </tr>
		                <tr>
		                    <td>카테고리명</td>
		                    <td colspan="4"><input type="text" name="categoryName" class="textArea" required></td>
		                    <td></td>
		                </tr>
		                <tr>
		                    <td>상품설명</td>
		                    <td colspan="4"><input type="text" name="productTitle" class="textArea" required></td>
		                    <td></td>
		                </tr>
		                <tr>
		                    <td>상품상세설명1</td>
		                    <td colspan="2"><input type="text" name="productSub1" class="textArea" required></td>
		                    <td>상품상세설명2</td>
		                    <td><input type="text" name="productSub2"></td>
		                    <td id="updateBtnArea">
		                        <button type="submit" id="updateBtn">변경</button>
		                    </td>
		                </tr>
		            </table>
		        </form>
		    </div>
		    <div id="content_2_5">
		        <form action="" id="deleteContent">
		            <h2>내용삭제</h2>
		            <table id="deleteContent_1">
		                <tr>
		                    <td width="15%">카테고리 선택</td>
		                    <td width="12%"><input type="radio" name="category" value="category1">1번</td>
		                    <td width="12%"><input type="radio" name="category" value="category2">2번</td>
		                    <td width="15%"></td>
		                    <td width="37%"></td>
		                    <td width="9%"></td>
		                </tr>
		                <tr>
		                    <td>상품선택</td>
		                    <td colspan="3">
		                        <select name="type" id="selectCategory">
		                            <option value="category1">1번</option>
		                            <option value="category2">2번</option>
		                        </select>
		                    </td>
		                    <td></td>
		                    <td id="deleteBtnArea">
		                        <button type="submit" id="deleteBtn">삭제</button>
		                    </td>
		                </tr>
		            </table>
		        </form>
		    </div>
		</div>
	</div>
</body>
</html>