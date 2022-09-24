<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.arrival.model.vo.*,java.util.ArrayList"%>
<%
	String contextPath = request.getContextPath();
	
	ArrayList<Arrival> list1 = (ArrayList<Arrival>)request.getAttribute("list1");
	ArrayList<Arrival> list2 = (ArrayList<Arrival>)request.getAttribute("list2");
	ArrayList<Arrival> list3 = (ArrayList<Arrival>)request.getAttribute("list3");
	ArrayList<Arrival> list4 = (ArrayList<Arrival>)request.getAttribute("list4");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
    .outer{
        width: 600px;
        height: 200px;
        margin: auto;
        box-sizing: border-box;
    }
    table{
        width: 100%;
        height: 50%;
        border: 1px solid lightgrey;
        text-align: center;
        font-size: 18px;
    }
    .continent{
        border-right: 1px solid lightgrey;
    }
    .city:hover{
        font-weight: bold;
        cursor: pointer;
    }
    .footer{
        width: 600px;
        height: 90px;
        margin: auto;
        border: 1px solid lightgrey;
    }
    #result{
        width: 100%;
        height: 40px;
        padding-top: 10px;
        font-size: 20px;
        font-weight: bold;
    }
    #submitBtn{
        
        width: 20%;
        height: 30px;
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
    <div class="outer">
        <h3 align="center">도착지 선택 후 다음 버튼을 눌러주세요</h3>
        <table>
            <tr>
                <td width="25%" class="continent">동북아시아</td>
                <%for(Arrival a : list1){ %>
                	<td width="15%" class="city"><%=a.getArrivalCity() %></td>
                <%} %>
            </tr>
            <tr>
                <td class="continent">동남아시아</td>
                <%for(Arrival a : list2){ %>
                	<td class="city"><%=a.getArrivalCity() %></td>
                <%} %>
            </tr>
            <tr>
                <td class="continent">미주/대양주</td>
                <%for(Arrival a : list3){ %>
                	<td class="city"><%=a.getArrivalCity() %></td>
                <%} %>
            </tr>
            <tr>
                <td class="continent">유럽</td>
                <%for(Arrival a : list4){ %>
                	<td class="city"><%=a.getArrivalCity() %></td>
                <%} %>
            </tr>
        </table>
    </div>
    <script>
    	$(function(){
    		
    		$("#arrivalCityResult :submit").attr("disabled", true);
    		
	        $(".city").click(function(){
	            
	        	var arrivalCity = $(this).text();
	            var city = arrivalCity + " 선택하셨습니다";
	            $("#result").html(city);
	            $("#arrivalCity").val(arrivalCity);
	            
	            $.ajax({
	                url : "quarantineInfo.qu",
	                data : {arrivalCity : $(this).text()},
	                type : "post",
	                success : function(result){
	                	
	                    $("#countryKor").val(result.countryKor);
	                    $("#countryEng").val(result.countryEng);
	                    $("#depVyPcr").val(result.depVyPcr);
	                    $("#depVnPcr").val(result.depVnPcr);
	                    $("#arrVyPcr").val(result.arrVyPcr);
	                    $("#arrVnPcr").val(result.arrVnPcr);
	                    $("#arrVySelf").val(result.arrVySelf);
	                    $("#arrVnSelf").val(result.arrVnSelf);
	                    
	                    $("#arrivalCityResult :submit").removeAttr("disabled");
	                },
	                error : {}
	            });
	        });
    	});
    </script>
    <div class="footer" align="center">
        <form action="<%=contextPath%>/userQuarantineInfoDetail.qu" id="arrivalCityResult" method="post">
            <div id="result"></div>
            <input type="hidden" name="arrivalCity" id="arrivalCity">
            <input type="hidden" name="countryKor" id="countryKor">
            <input type="hidden" name="countryEng" id="countryEng">
            <input type="hidden" name="depVyPcr" id="depVyPcr">
            <input type="hidden" name="depVnPcr" id="depVnPcr">
            <input type="hidden" name="arrVyPcr" id="arrVyPcr">
            <input type="hidden" name="arrVnPcr" id="arrVnPcr">
            <input type="hidden" name="arrVySelf" id="arrVySelf">
            <input type="hidden" name="arrVnSelf" id="arrVnSelf">
            
           	<button type="submit" id="submitBtn">다음</button>
        </form>
    </div>
</body>
</html>