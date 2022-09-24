<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/KGG/resources/css/user_domesticReservationStyle.css">
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div id="content">
	    <div id="content_1"></div>
	    <div id="content_2">
	        <div id="content_2_1">
	            <form action="<%=contextPath %>/search3.ai" id="search" method="post">
	            	<table>
						<tr>
							<td colspan="2" width="30%">
								<select name="depCity" id="departure" class="custom-select">
		                            <option value="김포">김포</option>
		                            <option value="울산">울산</option>
		                            <option value="부산">부산</option>
		                            <option value="제주">제주</option>
		                            <option value="여수">여수</option>
		                        </select>
							</td>
							<td width="10%">></td>
							<td colspan="5" width="30%">
								<select name="arrivalCity" id="arrival" class="custom-select">
		                        	<option value="울산">울산</option>
		                            <option value="부산">부산</option>
		                            <option value="제주">제주</option>
		                            <option value="여수">여수</option>
		                        </select>
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
	        <script>
	        	$("#departure").change(function(){
	        		var depCity = $(this).val();
	        		if(depCity == '울산'){
	        			
	        			$("#arrival").children().remove();
	        			$("#arrival").append("<option value='김포'>김포</option>");
	        			$("#arrival").append("<option value='제주'>제주</option>");
	        		}
	        		else if(depCity == '부산'){
	        			
						$("#arrival").children().remove();
	        			$("#arrival").append("<option value='김포'>김포</option>");
	        			$("#arrival").append("<option value='제주'>제주</option>");
	        		}
	        		else if(depCity == '제주'){
	        			$("#arrival").children().remove();
	        			$("#arrival").append("<option value='김포'>김포</option>");
	        			$("#arrival").append("<option value='울산'>울산</option>");
	        			$("#arrival").append("<option value='부산'>부산</option>");
	        			$("#arrival").append("<option value='여수'>여수</option>");
	        		}
	        		else if(depCity == '여수'){
	        			$("#arrival").children().remove();
	        			$("#arrival").append("<option value='김포'>김포</option>");
	        			$("#arrival").append("<option value='제주'>제주</option>");
	        		}
	        		else{
	        			$("#arrival").children().remove();
	        			$("#arrival").append("<option value='울산'>울산</option>");
	        			$("#arrival").append("<option value='부산'>부산</option>");
	        			$("#arrival").append("<option value='여수'>여수</option>");
	        			$("#arrival").append("<option value='제주'>제주</option>");
	        		}
	        	})
	        </script>
	    </div>
	    <div id="content_2_2">
	        <p>국내선 탑승 꿀팁 모음</p>
	    </div>
	    <div id="content_2_3">
	        <div id="demo" class="carousel slide" data-ride="carousel" style="height: 100%;">
	
	            <!-- Indicators -->
	            <ul class="carousel-indicators">
	              <li data-target="#demo" data-slide-to="0" class="active"></li>
	              <li data-target="#demo" data-slide-to="1"></li>
	              <li data-target="#demo" data-slide-to="2"></li>
	            </ul>
	          
	            <!-- The slideshow -->
	            <div class="carousel-inner" style="height: 100%;">
	              <div class="carousel-item active content_2_3_div">
	                <a href="#"><img src="resources/images/생체인증.png" alt="category1" class="content_2_3_img"></a>
	                <div class="carousel-caption">
	                    <h4></h4>
	                    <p></p>
	                </div>
	              </div>
	              <div class="carousel-item content_2_3_img" class="content_2_3_div">
	                <a href="#"><img src="resources/images/신분증 확인.jpeg" alt="category2" class="content_2_3_img"></a>
	                <div class="carousel-caption">
	                    <h4></h4>
	                    <p></p>
	                </div>
	              </div>
	              <div class="carousel-item content_2_3_img" class="content_2_3_div">
	                <a href="#"><img src="resources/images/웹체크인.jpg" alt="category3" class="content_2_3_img"></a>
	                <div class="carousel-caption">
	                    <h4></h4>
	                    <p></p>
	                </div>
	              </div>
	            </div>
	          
	            <!-- Left and right controls -->
	            <a class="carousel-control-prev" href="#demo" data-slide="prev">
	              <span class="carousel-control-prev-icon"></span>
	            </a>
	            <a class="carousel-control-next" href="#demo" data-slide="next">
	              <span class="carousel-control-next-icon"></span>
	            </a>
	          
	          </div>
	    </div>
	    <div id="content_2_4">
	        <p style="top: 7px">MD추천 국내 항공 특가</p>
	    </div>
	    <div id="content_2_5" align="center">
	        <div id="content_2_5_1">
	            <div class="content_2_5_1">
	                <a href="#">
                        <div class="content_2_5_div">
                            <img src="resources/images/제주.jpg" alt="제주" class="content_2_5_img">
                        </div>
	                </a>
	            </div>
	            <div class="content_2_5_1 _div content_2_5_div_sub1">
	                <a href="#">
	                    <div class="content_2_5_div">
	                        <img src="resources/images/부산.jpg" alt="부산" class="content_2_5_img">
	                    </div>
	                </a>
	            </div>
	            <div class="content_2_5_1  content_2_5_div_sub2">
	                <a href="#">
	                    <div class="content_2_5_div">
	                        <img src="resources/images/여수.jpg" alt="여수" class="content_2_5_img">
	                    </div>
	                </a>
	            </div>
	            <div class="content_2_5_1">
	                <a href="#">
	                    <div class="content_2_5_div">
	                        <img src="resources/images/울산.jpg" alt="울산" class="content_2_5_img">
	                    </div>
	                </a>
	            </div>
	        </div>
	        <div id="content_2_5_2">
	            <div class="content_2_5_2">
	                <a href="#">
	                    <p>
	                        <center style="font-weight: bold">5월 7일 출발<br></center>
							김포 -> 제주<br>
	                        <b>27,900원~</b>
	                    </p>
	                </a>
	            </div>
	            <div class="content_2_5_2 content_2_5_div_sub1">
	                <a href="#">
	                    <p>
	                        <center style="font-weight: bold">5월 13일 출발<br></center>
	                       	 김포 -> 부산<br>
	                        <b>25,700원~</b>
	                    </p>
	                </a>
	            </div>
	            <div class="content_2_5_2 content_2_5_div_sub2">
	                <a href="#">
	                    <p>
	                        <center style="font-weight: bold">5월 10일 출발<br></center>
	                       	 김포 -> 여수<br>
	                        <b>29,900원~</b>
	                    </p>
	                </a>
	            </div>
	            <div class="content_2_5_2">
	                <a href="#">
	                    <p>
	                        <center style="font-weight: bold">5월 16일 출발<br></center>
								김포 -> 울산<br>
	                            <b>33,900원~</b>
	                        </p>
	                    </a>
	                </div>
	            </div>
	        </div>
	    </div>
	    <%@ include file="../common/content3.jsp" %>
	</div>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>