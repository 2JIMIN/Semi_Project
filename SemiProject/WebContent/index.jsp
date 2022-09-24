<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/internationalReservationStyle.css">
</head>
<body>
	<%@ include file="views/common/menubar.jsp" %>
	<div id="content">
	    <div id="content_1"></div>
	    <div id="content_2">
	        <div id="content_2_1">
	            <form action="<%=contextPath %>/search1.ai" id="search" method="post">
	            	<table>
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
	        </div>
	        <div id="content_2_2">
	            <p>MD 추천 특별 여행지</p>
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
	                    <a href="#"><img src="resources/images/카타르.jpeg" alt="Doha" class="content_2_3_img"></a>
	                    <div class="carousel-caption">
	                        <h4 style="color: black;">미리보는 카타르월드컵</h4>
	                        <p style="color: black;">여러분들을 도하로 초대합니다</p>
	                    </div>
	                  </div>
	                  <div class="carousel-item content_2_3_img" class="content_2_3_div">
	                    <a href="#"><img src="resources/images/싱가포르.jpg" alt="Singapore" class="content_2_3_img"></a>
	                    <div class="carousel-caption">
	                        <h4>아시아의 멜팅팟</h4>
	                        <p>싱가폴의 멋진 야경에 빠져보세요</p>
	                    </div>
	                  </div>
	                  <div class="carousel-item content_2_3_img" class="content_2_3_div">
	                    <a href="#"><img src="resources/images/사이판.jpg" alt="Saipan" class="content_2_3_img"></a>
	                    <div class="carousel-caption">
	                        <h4>신이 축복한 섬, 사이판</h4>
	                        <p>에메랄드 빛 바다를 느껴보세요</p>
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
	            <p style="top: 7px;">금주의 특가</p>
	        </div>
	        <div id="content_2_5" align="center">
	            <div id="content_2_5_1">
	                <div class="content_2_5_1">
	                    <a href="#">
	                            <div class="content_2_5_div">
	                                <img src="resources/images/KE.jpg" alt="대한항공" class="content_2_5_img">
	                            </div>
	                    </a>
	                </div>
	                <div class="content_2_5_1 content_2_5_div_sub1">
	                    <a href="#">
	                        <div class="content_2_5_div">
	                            <img src="resources/images/OZ.jpg" alt="아시아나항공" class="content_2_5_img">
	                        </div>
	                    </a>
	                </div>
	                <div class="content_2_5_1  content_2_5_div_sub2">
	                    <a href="#">
	                        <div class="content_2_5_div">
	                            <img src="resources/images/AC.jpg" alt="에어캐나다" class="content_2_5_img">
	                        </div>
	                    </a>
	                </div>
	                <div class="content_2_5_1">
	                    <a href="#">
	                        <div class="content_2_5_div">
	                            <img src="resources/images/EY.jpg" alt="에티하드항공" class="content_2_5_img">
	                        </div>
	                    </a>
	                </div>
	            </div>
	            <div id="content_2_5_2">
	                <div class="content_2_5_2">
	                    <a href="#">
	                        <p>
	                            <center>5/1~6/30 즉시 출발<br></center>
	                                                                사이판 왕복 항공권<br>
	                            <b style="font-size: 24px">499,000원~</b>
	                        </p>
	                    </a>
	                </div>
	                <div class="content_2_5_2 content_2_5_div_sub1">
	                    <a href="#">
	                        <p>
	                            <center>5/1~6/30 즉시 출발<br></center>
	                                                                괌 왕복 항공권<br>
	                            <b style="font-size: 24px">499,000원~</b>
	                        </p>
	                    </a>
	                </div>
	                <div class="content_2_5_2 content_2_5_div_sub2">
	                    <a href="#">
	                        <p>
	                            <center>5/1~6/30 즉시 출발<br></center>
	                           	 로마 왕복 항공권<br>
	                            <b style="font-size: 24px">1,179,000원~</b>
	                        </p>
	                    </a>
	                </div>
	                <div class="content_2_5_2">
	                    <a href="#">
	                        <p>
	                            <center>5/1~6/30 즉시 출발<br></center>
	                                                                아부다비 왕복 항공권<br>
	                            <b style="font-size: 24px">729,000원~</b>
	                        </p>
	                    </a>
	                </div>
	            </div>
            </div>
	    </div>
	    <%@ include file="views/common/content3.jsp" %>
	</div>
	<%@ include file="views/common/footer.jsp" %>
</body>
</html>