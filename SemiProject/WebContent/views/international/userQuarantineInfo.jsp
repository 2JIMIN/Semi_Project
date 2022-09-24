<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	
	String arrivalCity = (String)request.getAttribute("arrivalCity");
	String countryKor = (String)request.getAttribute("countryKor");
	String countryEng = (String)request.getAttribute("countryEng");
	String depVyPcr = (String)request.getAttribute("depVyPcr");
	String depVnPcr = (String)request.getAttribute("depVnPcr");
	String arrVyPcr = (String)request.getAttribute("arrVyPcr");
	String arrVnPcr = (String)request.getAttribute("arrVnPcr");
	String arrVySelf = (String)request.getAttribute("arrVySelf");
	String arrVnSelf = (String)request.getAttribute("arrVnSelf");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	.outer{
		width: 410px;
		height: 450px;
		margin: auto;
		box-sizing: border-box;
	}
	.table-content{
		width: 100%;
		height: 100%;
		background-color: rgb(248, 248, 248);
		padding: 1%;
		border-radius: 5px;
		display: inline-block;
		margin: 2%;
	}
	.national_kor{
		color: black;
		font-weight: 1000;
		font-size: large;
	}
	.national_eng{
		color: gray;
	}
	.covid_table{
		width: 90%;
		height: 90%;
		text-align: center;
		margin-left: auto;
		margin-right: auto;
		font-size: 13px;
		background-color: white;
	}
	.text_blue{
		color: blue;
	}
	.text_green{
		color: green;
	}
	.text_bold{
		font-weight: bold;
	}
	#contetn3_1_title, #updateDate{
		width: 50%;
		float: left;
	}
	#submitArea{
		width: 410px;
		height: 35px;
		margin: auto;
		box-sizing: border-box;
	}
	#submitBtn{
		height: 100%;
		background-color: rgb(86, 168, 179);
		color: white;
		border-color: white;
		border-radius: 5px;
		font-size: 18px;
	}
	#submitBtn:hover{
		font-weight: bold;
	}
</style>
</head>
<body>
	<h3 align="center">선택하신 도시의 국가에 대한 방역 정보입니다</h3>
	<div class="outer">
		<div class="table-content">
	       	<span class="national_kor"><%=countryKor %></span>
	        <span class="national_eng"><%=countryEng %></span>
	        <table class="covid_table" border="1px solid gray">
	        	<tbody>
	            	<tr>
	                 	<td width="16%" height="10%">&nbsp;</td>
	                 	<td width="42%" class="text_blue text_bold">백신 접종자</td>
	                 	<td width="42%" class="text_green text_bold">백신 미접종자</td>
	            	</tr>
	            	<!-- 여행불가 국가 -->
	            	<%
						if (depVyPcr.contains("여행불가")) {
					%>
					<tr>
						<td height="45%" class="text_bold">출발전</td>
						<td class="" rowspan="2" colspan="2"><%=depVyPcr%></td>
					</tr>
					<tr>
						<td height="45%" class="text_bold">도착후</td>
					</tr>
					<tr>
					</tr>
					<!-- 미접종자 입국불가 -->
					<%
						} else if (depVnPcr.contains("입국불가")) {
					%>
					<tr>
						<td height="45%" class="text_bold">출발전</td>
						<td class=""><%=depVyPcr%></td>
						<td class="" colspan="2" rowspan="3"><%=depVnPcr%></td>
					</tr>
					<tr>
						<td height="45%" rowspan="2" class="text_bold">도착후</td>
						<td class=""><%=arrVyPcr%></td>
					</tr>
					<tr>
						<td class=""><%=arrVySelf%></td>
					</tr>
					<!-- 그외(전체분리) -->
					<%
						} else {
					%>
               		<tr>
                		<td height="45%" class="text_bold">출발전</td>
                		<td class=""><%=depVyPcr %></td>
                		<td class=""><%=depVnPcr %></td>
					</tr>
	               	<tr>
						<td height="45%" rowspan="2" class="text_bold">도착후</td>
	                	<td class=""><%=arrVyPcr %></td>
	                    <td class=""><%=arrVnPcr %></td>
	                </tr>
	                <tr>
	                    <td class=""><%=arrVySelf %></td>
	                    <td class=""><%=arrVnSelf %></td>
	                </tr>
	                <%
						}
					%>
	            </tbody>
	        </table>
	   	</div>
	</div>
	<br>
	<div id="submitArea" align="center">
		<input type="hidden" name="arrivalCity" id="arrivalCity" value="<%=arrivalCity%>">
		<button id="submitBtn" onclick="selectCity();">확인 후 도착지 선택</button>
	</div>
	<script>
		function selectCity(){
			$("#search :submit", opener.document).removeAttr("disabled");
			$("#arrival", opener.document).val($("#arrivalCity").val());
			window.close();
		}
	</script>
</body>
</html>