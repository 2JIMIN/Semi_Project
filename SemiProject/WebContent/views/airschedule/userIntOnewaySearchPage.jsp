<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.airschedule.model.vo.AirSchedule,java.util.ArrayList"%>
<%
	ArrayList<AirSchedule> list = (ArrayList<AirSchedule>) request.getAttribute("list");
	String ticket = (String) request.getAttribute("ticket");
	String depCity = (String) request.getAttribute("depCity");
	String arrivalCity = (String) request.getAttribute("arrivalCity");
	String perSon = (String) request.getAttribute("person");
	String classtYpe = (String) request.getAttribute("classType");
	String classtype = (String) request.getAttribute("classtype");
	String depDate = (String) request.getAttribute("depDate");
	String arrivalDate = (String) request.getAttribute("arrivalDate");
	String comingDate = (String) request.getAttribute("comingDate");
	int person = 0;
	int classType = 0;
	
	person = Integer.parseInt(perSon);
	classType = Integer.parseInt(classtYpe);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/KGG/resources/css/userOnewaySearchPageStyle.css">
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div id="content">
	    <div id="content_1"></div>
	    <div id="content_2">
            <div id="content_2_1">
                <div id="content_2_1_1">
                    <table id="itenary">
                        <tr>
                            <td rowspan="2" width="7.5%"><img src="/KGG/resources/images/검색버튼.png" alt="검색" width="65px" height="65px" id="searchImg"></td>
                            <td align="center" width="15%" style="font-size: 24px;">가는 편 선택</td>
                            <td align="center" width="5%"></td>
                            <td align="center" width="5%"></td>
                            <td align="center" width="10%" style="font-size: 24px;"><%=depCity %></td>
                            <td align="center" width="5%" style="font-size: 24px;">-</td>
                            <td align="center" width="10%" style="font-size: 24px;"><%=arrivalCity %></td>
                            <td align="center" width="5%"></td>
                            <td align="center" width="5%"></td>
                            <td align="center" width="5%"></td>
                            <td align="center" width="5%"></td>
                            <td align="center" width="5%"></td>
                            <td align="center" width="5%"></td>
                            <td align="center" width="5%"></td>
                            <td align="center" width="2.5%"></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td align="center">성인 <%=person %>석</td>
                            <td colspan="2" align="center"><%=classtype %></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center" colspan="2" style="font-size: 22px;">출발 날짜</td>
                            <td align="center" colspan="4"  style="font-size: 22px;" id="depDate"><%=depDate %></td>
                        </tr>
                    </table>
                    <script>
                        $(function(){
                            var depDate = $("#depDate").text();
                            var depYear = depDate.substr(0, 4);
                            var depMonth = depDate.substr(6, 1);
                            var depDay = depDate.substr(8, 10);

                            var allDepDate = depYear + "년 " + depMonth + "월 " + depDay + "일";

                            $("#depDate").html(allDepDate);
                        })
                    </script>
                </div>
                <div id="content_2_1_2">
                    <form action="<%=contextPath %>/search1.ai" id="search" method="post" style="height: 207px;">
                        <table id="airSchedule">
                            <tr>
							<td colspan="2" width="30%">
								<select name="depCity" class="custom-select">
									<option value="인천">인천</option>
	                            </select>
							</td>
							<td width="10%">></td>
							<td colspan="5" width="30%">
								<input type="text" class="form-control" id="arrival" name="arrivalCity" placeholder="도착지 선택" readonly required>
	                            <script>
	                            	$(function(){
	                            		$("#search :submit").attr("disabled", true);
	                            	})
									$("#arrival").click(function(){
										var openOption = "width=580, height=460, location=no, status=no, toolbars=no, scrollbars=no";
										window.open("<%=contextPath%>/cityList.re", "도착지 선택", openOption);
									})
 								</script>
							</td>
							<td rowspan="3" width="10%">
								<div id="btnDiv">
									<button type="submit" id="btn" class="btn" style="color: white; font-size: 23px; font-weight: bold;">검색</button>
								</div>
							</td>
						</tr>
						<tr>
							<td>가는날짜</td>
							<td><input type="date" class="t3" name="depDate" required></td>
							<td></td>
							<td>오는날짜</td>
							<td><input type="date" class="t3" id="comingDate" name="comingDate" required></td>
						</tr>
						<tr>
							<td width="15%">
								<select name="ticket" id="ticket" class="custom-select">
	                                <option value="round">왕복</option>
	                                <option value="oneway">편도</option>
	                            </select>
	                            <script>
 									$("#ticket").change(function(){
 										var answer = $(this).val();
 										if(answer == "oneway"){
 											$("#comingDate").attr("disabled", true);
 										}
 										else{
											$("#comingDate").removeAttr("disabled");
										}
 									})
								</script>
							</td>
							<td></td>
							<td width="15%">
								<select name="person" class="custom-select">
	                                <%for(int i = 1; i <= 9; i++) {%>
	                                	<option value="<%=i %>"><%=i %>석</option>
	                                <%} %>
	                            </select>
							</td>
							<td></td>
							<td width="15%">
								<select name="classType" class="custom-select">
	                                <option value="1">이코노미</option>
	                                <option value="2">비즈니스</option>
	                            </select>
							</td>
						</tr>
                        </table>
                    </form>
                    <br><br>
                    <%for(AirSchedule a : list) {%>
                    <%if(a.getNonstopFlightYn()!=null && a.getNonstopFlightYn().equals("직항")){ %>
                    <form action="<%=contextPath %>/search2.ai" id="flightList" method="post">
                        <table id="flight">
                            <tr>
                                <td width="20%"></td>
                                <td width="10%"></td>
                                <td width="20%"></td>
                                <td width=10%></td>
                                <td width="20%"></td>
                                <td width=20%></td>
                            </tr>
                            
                            <tr>
                                <td></td>
                                <td rowspan="2" style="padding-top: 20px; font-weight: bold;"><%=a.getDepTime() %></td>
                                <td><div style="font-weight: bold;"><%=a.getNonstopFlightYn() %></div></td>
                                <td rowspan="2" style="padding-top: 20px; font-weight: bold;"><%=a.getArrivalTime() %></td>
                                <td rowspan="2"></td>
                                <td rowspan="2" style="font-size: 30px; font-weight: bold;"><%=a.getPrice()*person*classType+"원" %></td>
                            </tr>
                            <tr>
                                <td rowspan="2" style="font-weight: bold;" name="airline"><%=a.getAirline() %></td>
                                <td rowspan="2"><img src="/KGG/resources/images/우측방향화살표.png" alt="" width="150px" height="40px"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td rowspan="2" style="padding-bottom: 20px; font-weight: bold;"><%=a.getDepCode() %></td>
                                <td rowspan="2" style="padding-bottom: 20px; font-weight: bold;"><%=a.getArrivalCode() %></td>
                                <td rowspan="2"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><div style="font-weight: bold;"><%=a.getWholeTime() %></div></td>
                                <td rowspan="2">
                                    <div id="selectBtnArea">
                                    	<%if(loginUser!=null){ %>
                                    		<input type="hidden" name="userNo" value="<%=loginUser.getUserNo()%>">
                                    	<%} %>
                                    	<input type="hidden" name="flightNo" value="<%=a.getFlightNo()%>">
                                    	<input type="hidden" name="depTime" value="<%=a.getDepTime()%>">
                                    	<input type="hidden" name="arrivalTime" value="<%=a.getArrivalTime()%>">
                                    	<input type="hidden" name="price" value="<%=a.getPrice()*person*classType%>">
                                    	<input type="hidden" name="airline" value="<%=a.getAirline()%>">
                                    	<input type="hidden" name="depCode" value="<%=a.getDepCode()%>">
                                    	<input type="hidden" name="arrivalCode" value="<%=a.getArrivalCode()%>">
                                    	<input type="hidden" name="ticket" value="<%=ticket%>">
                                    	<input type="hidden" name="depCity" value="<%=depCity%>">
                                    	<input type="hidden" name="arrivalCity" value="<%=arrivalCity%>">
                                    	<input type="hidden" name="depDate" value="<%=depDate%>">
                                    	<input type="hidden" name="comingDate" value="<%=comingDate%>">
                                    	<input type="hidden" name="person" value="<%=perSon%>">
                                    	<input type="hidden" name="classtype" value="<%=classtype%>">
                                    	<input type="hidden" name="classType" value="<%=classtYpe%>">
                                        <input type="submit" id="selectBtn" value="선택하기">
                                    </div></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                    </form>
                    <%} %>
                    <%if(a.getNonstopFlightYn()!=null && a.getNonstopFlightYn().equals("경유")){ %>
                    <form action="<%=contextPath %>/search2.ai" id="flightList" method="post">
                        <table id="flight">
                            <tr>
                                <td width="20%"></td>
                                <td width="10%"></td>
                                <td width="20%"></td>
                                <td width=10%></td>
                                <td width="20%"></td>
                                <td width=20%></td>
                            </tr>
                            
                            <tr>
                                <td></td>
                                <td rowspan="2" style="padding-top: 20px; font-weight: bold;"><%=a.getDepTime() %></td>
                                <td><div style="font-weight: bold;"><%=a.getNonstopFlightYn() %></div></td>
                                <td rowspan="2" style="padding-top: 20px; font-weight: bold;"><%=a.getArrivalTime() %></td>
                                <td rowspan="2"><%=a.getTransfer()+" 경유" %></td>
                                <td rowspan="2" style="font-size: 30px; font-weight: bold;"><%=a.getPrice()*person*classType+"원" %></td>
                            </tr>
                            <tr>
                                <td rowspan="2" style="font-weight: bold;"><%=a.getAirline() %></td>
                                <td rowspan="2"><img src="/KGG/resources/images/우측방향화살표.png" alt="" width="150px" height="40px"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td rowspan="2" style="padding-bottom: 20px; font-weight: bold;"><%=a.getDepCode() %></td>
                                <td rowspan="2" style="padding-bottom: 20px; font-weight: bold;"><%=a.getArrivalCode() %></td>
                                <td rowspan="2"><%=a.getWaitingTime()+" 대기" %></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><div style="font-weight: bold;"><%=a.getWholeTime() %></div></td>
                                <td rowspan="2">
                                    <div id="selectBtnArea">
                                    	<%if(loginUser!=null){ %>
                                    		<input type="hidden" name="userNo" value="<%=loginUser.getUserNo()%>">
                                    	<%} %>
                                    	<input type="hidden" name="flightNo" value="<%=a.getFlightNo()%>">
                                    	<input type="hidden" name="depTime" value="<%=a.getDepTime()%>">
                                    	<input type="hidden" name="arrivalTime" value="<%=a.getArrivalTime()%>">
                                    	<input type="hidden" name="price" value="<%=a.getPrice()*person*classType%>">
                                    	<input type="hidden" name="airline" value="<%=a.getAirline()%>">
                                    	<input type="hidden" name="depCode" value="<%=a.getDepCode()%>">
                                    	<input type="hidden" name="arrivalCode" value="<%=a.getArrivalCode()%>">
                                    	<input type="hidden" name="ticket" value="<%=ticket%>">
                                    	<input type="hidden" name="depCity" value="<%=depCity%>">
                                    	<input type="hidden" name="arrivalCity" value="<%=arrivalCity%>">
                                    	<input type="hidden" name="depDate" value="<%=depDate%>">
                                    	<input type="hidden" name="comingDate" value="<%=comingDate%>">
                                    	<input type="hidden" name="person" value="<%=perSon%>">
                                    	<input type="hidden" name="classtype" value="<%=classtype%>">
                                    	<input type="hidden" name="classType" value="<%=classtYpe%>">
                                        <input type="submit" id="selectBtn" value="선택하기">
                                    </div></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                    </form>
                    <%} %>
                    <%} %>
                </div>
            </div>
            <script>
                $(function(){
                    $("#itenary").click(function(){
                        var $answer = $("#search");
                        if($answer.css("display") == "none"){
                        $answer.slideDown();
                        }
                        else{
                            $answer.slideUp();
                        }
                    });
                });
            </script>
            <div id="content_2_2"></div>
	    </div>
	    <%@ include file="../common/content3.jsp" %>
    </div>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>