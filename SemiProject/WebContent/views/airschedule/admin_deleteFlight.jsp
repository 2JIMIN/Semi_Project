<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/KGG/resources/css/admin_deleteFlightStyle.css">
</head>
<body>
	<%@ include file="../common/admin/admin.jsp" %>
		<div id="content_2">
	        <div id="content_2_1"><p><b>항공편 관리</b></p></div>
            <div id="content_2_2"><p><b>항공편 삭제</b></p></div>
	        <div id="content_2_3">
<!-- 	            <form action="" id="searchFlight"> -->
	                <table id="searchFlight_1">
	                    <tr>
	                        <td width="40%">항공편 번호(Flight Number)</td>
	                        <td width="60%"><input type="text" id="flightNo" name="flightNo" required></td>
	                    </tr>
	                    <tr>
	                        <td>출발날짜</td>
	                        <td><input type="text" id="depDate" name="depDate" required></td>
	                    </tr>
	                    <tr>
	                        <td></td>
	                        <td style="float:right" id="searchBtnArea">
	                            <button type="submit" class="btn" id="searchFlightBtn">조회</button>
	                        </td>
	                    </tr>
	                </table>
<!-- 	            </form> -->
				<script>
		        	$(function(){
		        		$("#searchFlightBtn").click(function(){
		        			var flightNo = $("#flightNo").val();
		        			var depDate = $("#depDate").val();
		        			$.ajax({
		        				url : "searchFlight1.ai",
		        				data : {flightNo : $("#flightNo").val(), depDate : $("#depDate").val()},
		        				type : "post",
		        				success : function(result){
		        					
		        					if(result!=null){
		        						
			        					$("#flightNo1").html(result.flightNo);
			        					$("#depCode1").html(result.depCode);
			        					$("#arrivalCode1").html(result.arrivalCode);
			        					$("#depDate1").html(result.depDate);
			        					$("#depTime1").html(result.depTime);
			        					$("#arrivalDate1").html(result.arrivalDate);
			        					$("#arrivalTime1").html(result.arrivalTime);
			        					$("#price1").html(result.price);
			        					
			        					$("#flightNo2").val(result.flightNo);
			        					$("#depDate2").val(result.depDate);
		        					}
		        					else{
		        						alert("검색 결과가 없습니다.");
		        					}
		        				},
		        				error : {}
		        			})
		        		})
		        	})
		        </script>
	        </div>
            <div id="content_2_4"><p><b>조회 결과</b></p></div>
            <div id="content_2_5">
                <form action="<%=contextPath%>/deleteFlight.ai" id="deleteFlight">
                    <table id="deleteFlight_1" align="center">
                        <thead>
                            <tr id="flightListTitle">
                                <td>항공편 번호</td>
                                <td>출발지</td>
                                <td>도착지</td>
                                <td>출발날짜</td>
                                <td>출발시간</td>
                                <td>도착날짜</td>
                                <td>도착시간</td>
                                <td>가격</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr id="flightListContent">
	                            <td id="flightNo1"></td>
		                        <td id="depCode1"></td>
		                        <td id="arrivalCode1"></td>
		                        <td id="depDate1"></td>
		                        <td id="depTime1"></td>
		                        <td id="arrivalDate1"></td>
		                        <td id="arrivalTime1"></td>
		                        <td id="price1"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td id="deleteBtnArea">
                                	<input type="hidden" id="flightNo2" name="flightNo">
                                	<input type="hidden" id="depDate2" name="depDate">
                                    <input type="submit" class="btn" id="deleteFlightBtn" value="삭제">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
            <div id="content_2_6">
            </div>
		</div>
	</div>
</body>
</html>