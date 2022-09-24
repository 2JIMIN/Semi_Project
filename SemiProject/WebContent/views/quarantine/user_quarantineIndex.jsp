<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.kh.quarantine.model.vo.*"%>  

<%
	ArrayList<Quarantine> listTap1 = (ArrayList<Quarantine>)request.getAttribute("listTap1");
	ArrayList<Quarantine> listTap2 = (ArrayList<Quarantine>)request.getAttribute("listTap2");
	ArrayList<Quarantine> listTap3 = (ArrayList<Quarantine>)request.getAttribute("listTap3");
	ArrayList<Quarantine> listTap4 = (ArrayList<Quarantine>)request.getAttribute("listTap4");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/KGG/resources/css/user_quarantineIndexStyle.css">

</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <div id="content" style="height:2200px;">
        <div id="content_1"></div>
        <div id="content_2">
		    <br><br>
    <div class="top-outer">
        <div class="content1">
            <h1 align="center">국가별 입국 제한 안내</h1>
            <br>
            <p align="center" style="font-size: 20px;">여행 전 참고할 수 있도록 취항 국가의 입국 제한 현황을 안내 드립니다.</p>
            <img src="/KGG/resources/images/covidInfo.jpg" alt="covidInfo" id="img-info" width="100%" height="60%" class="">
        </div>
        <br>
        <div class="content2">
            <a href="https://kdca.go.kr/index.es?sid=a2" target="_blank">질병관리청</a>
            <a href="https://overseas.mofa.go.kr/www/pgm/m_4179/uss/emblgbd/emblgbdAdres.do" target="_blank">국가별 재외공관 정보</a>
            <a href="https://www.0404.go.kr/dev/main.mofa" target="_blank">외교부 해외안전여행</a>
        </div>
        <br>
        <hr>
        <div class="content3">
            <div id="content3_1">
                <p id="contetn3_1_title" style="font-size: 18px;">&ensp;코로나19 관련 국가/지역별 입국 제한 현황</p>
                <p id="updateDate" align="right" style="font-size:12px">(2022년 5월 10일 업데이트 기준)</p>
            </div>
                <br><br><br>
                <hr>
            <div id="content3_2">
                <p>&ensp;고객 여러분께 코로나19 관련 국가/지역별 입국 제한 현황 관련 사전 안내 말씀드립니다. </p>
                <ul class="mainChkList"> 
                    <li>코로나19 관련 국가/지역별 입국 제한 현황 안내는 최소한의 정보 제공을 목적으로 하며, <span class="redFont">승객의 출국/입국을 보장하지 않습니다.</span></li> 
                    <li>국가/지역별 출입국 규정이 빈번하게 변경되고 있으며, 사전 고지없이 <span class="redFont">관련 규정이 변경될 수 있습니다.</span></li> 
                    <li>출국 전 목적지 국가의 정부 안내 홈페이지 등을 통해 관련 규정을 <span class="redFont">필히 확인해 주시기 바랍니다.</span></li> 
                    <li>충분한 시간적 여유를 가지고 공항에 오셔서 탑승수속 완료 및 탑승구에서 대기하여 주시기 바랍니다.</li> 
                    <li>개인정보가 포함되지 않은 단순 “음성입니다“ 라는 문자 메시지는 코로나19 음성 확인서로 인정되지 않으니 유의하시기 바랍니다.</li> 
                </ul> <br>
            </div>
        </div>
        <div class="content4">    
            <a href="https://cov19ent.kdca.go.kr/cpassportal/" align="center" style="font-size:17px; font-weight: bold" target="_blank">
                검역정보 사전입력시스템(Q-code) 바로가기</a>
        </div>
        <br><br>
    </div>

    <div class="tabs-outer">
        <ul class="tabs">
            <li class="tab-link current" data-tab="tab1" align="center">동북아시아</li>
            <li class="tab-link" data-tab="tab2" align="center">동남아시아</li>
            <li class="tab-link" data-tab="tab3" align="center">미주/대양주</li>
            <li class="tab-link" data-tab="tab4" align="center">유럽</li>
        </ul>

		<!-- 동북아시아 -->
        <div id="tab1" class="tab-content current">
            <br><br>
            <!-- 리스트가 비어있는 경우 -->
            <%if(listTap1.isEmpty()){%>
            	<h4 align="center">등록된 정보가 없습니다.</h4>
            <%} else {%>
	            <!-- 비어있지 않을 경우 -->
	            <%for(Quarantine q : listTap1){ %>
		            <div class="table-content">
		            
		                <span id="national_kor"><%=q.getCountryKor() %></span>
		                <span id="national_eng"><%=q.getCountryEng() %></span>
		                <table class="covid_table" border="1px solid gray">
		                    <tbody>
		                        <tr>
		                            <td width="16%" height="10%">&nbsp;</td>
		                            <td width="42%" class="text_blue text_bold">백신 접종자</td>
		                            <td width="42%" class="text_green text_bold">백신 미접종자</td>
		                        </tr>
		                        <!-- 여행불가 국가 -->
		                        <%if(q.getDepVyPcr().contains("여행불가")) {%>
			                        <tr>
			                            <td height="45%" class="text_bold">출발전</td>
				                        <td id="depVyPcr" rowspan="2" colspan="2"><%=q.getDepVyPcr() %></td>
			                      	</tr>
			                     	<tr>
				                        <td height="45%" class="text_bold">도착후</td>
			                      	</tr>
			                      	<tr>
			                      	</tr>
			                      	<!-- 미접종자 입국불가 -->
		                        <%} else if(q.getDepVnPcr().contains("입국불가")){%>
			                        <tr>
			                            <td height="45%" class="text_bold">출발전</td>
				                        <td id="depVyPcr"><%=q.getDepVyPcr() %></td>
				                        <td id="depVnPcr" colspan="2" rowspan="3"><%=q.getDepVnPcr() %></td>
			                      	</tr>
			                     	<tr>
				                        <td height="45%" rowspan="2" class="text_bold">도착후</td>
				                        <td id="arrVyPcr"><%=q.getArrVyPcr() %></td>
			                      	</tr>
			                      	<tr>
				                        <td id="arrVySelf"><%=q.getArrVySelf() %></td>
			                      	</tr>
			                      	<!-- 그외(전체분리) -->
	                        	<%} else {%>
			                        <tr>
			                            <td height="45%" class="text_bold">출발전</td>
				                        <td id="depVyPcr"><%=q.getDepVyPcr() %></td>
				                        <td id="depVnPcr"><%=q.getDepVnPcr() %></td>
			                      	</tr>
			                     	<tr>
				                        <td height="45%" rowspan="2" class="text_bold">도착후</td>
				                        <td id="arrVyPcr"><%=q.getArrVyPcr() %></td>
				                        <td id="arrVnPcr"><%=q.getArrVnPcr() %></td>
			                      	</tr>
			                      	<tr>
				                        <td id="arrVySelf"><%=q.getArrVySelf() %></td>
				                        <td id="arrVnSelf"><%=q.getArrVnSelf() %></td>
			                      	</tr>
	                        	<%} %>
		                    </tbody>
		                  </table>
		            	</div>   
            		<%} %>
            	<%} %>
        </div>
        
		<!-- 동남아시아 -->
        <div id="tab2" class="tab-content">
            <br><br>
            <!-- 리스트가 비어있는 경우 -->
            <%if(listTap2.isEmpty()){%>
            	<h4 align="center">등록된 정보가 없습니다.</h4>
            <%} else {%>
	            <!-- 비어있지 않을 경우 -->
	            <%for(Quarantine q : listTap2){ %>
		            <div class="table-content">
		            
		                <span id="national_kor"><%=q.getCountryKor() %></span>
		                <span id="national_eng"><%=q.getCountryEng() %></span>
		                <table class="covid_table" border="1px solid gray">
		                    <tbody>
		                        <tr>
		                            <td width="16%" height="10%">&nbsp;</td>
		                            <td width="42%" class="text_blue text_bold">백신 접종자</td>
		                            <td width="42%" class="text_green text_bold">백신 미접종자</td>
		                        </tr>
		                        <!-- 여행불가 국가 -->
		                        <%if(q.getDepVyPcr().contains("여행불가")) {%>
			                        <tr>
			                            <td height="45%" class="text_bold">출발전</td>
				                        <td id="depVyPcr" rowspan="2" colspan="2"><%=q.getDepVyPcr() %></td>
			                      	</tr>
			                     	<tr>
				                        <td height="45%" class="text_bold">도착후</td>
			                      	</tr>
			                      	<tr>
			                      	</tr>
			                      	<!-- 미접종자 입국불가 -->
		                        <%} else if(q.getDepVnPcr().contains("입국불가")){%>
			                        <tr>
			                            <td height="45%" class="text_bold">출발전</td>
				                        <td id="depVyPcr"><%=q.getDepVyPcr() %></td>
				                        <td id="depVnPcr" colspan="2" rowspan="3"><%=q.getDepVnPcr() %></td>
			                      	</tr>
			                     	<tr>
				                        <td height="45%" rowspan="2" class="text_bold">도착후</td>
				                        <td id="arrVyPcr"><%=q.getArrVyPcr() %></td>
			                      	</tr>
			                      	<tr>
				                        <td id="arrVySelf"><%=q.getArrVySelf() %></td>
			                      	</tr>
			                      	<!-- 그외(전체분리) -->
	                        	<%} else {%>
			                        <tr>
			                            <td height="45%" class="text_bold">출발전</td>
				                        <td id="depVyPcr"><%=q.getDepVyPcr() %></td>
				                        <td id="depVnPcr"><%=q.getDepVnPcr() %></td>
			                      	</tr>
			                     	<tr>
				                        <td height="45%" rowspan="2" class="text_bold">도착후</td>
				                        <td id="arrVyPcr"><%=q.getArrVyPcr() %></td>
				                        <td id="arrVnPcr"><%=q.getArrVnPcr() %></td>
			                      	</tr>
			                      	<tr>
				                        <td id="arrVySelf"><%=q.getArrVySelf() %></td>
				                        <td id="arrVnSelf"><%=q.getArrVnSelf() %></td>
			                      	</tr>
	                        	<%} %>
		                    </tbody>
		                  </table>
		            	</div>   
            		<%} %>
            	<%} %>
        </div>

		<!-- 미주/대양주 -->
        <div id="tab3" class="tab-content">
            <br><br>
            <!-- 리스트가 비어있는 경우 -->
            <%if(listTap3.isEmpty()){%>
            	<h4 align="center">등록된 정보가 없습니다.</h4>
            <%} else {%>
	            <!-- 비어있지 않을 경우 -->
	            <%for(Quarantine q : listTap3){ %>
		            <div class="table-content">
		            
		                <span id="national_kor"><%=q.getCountryKor() %></span>
		                <span id="national_eng"><%=q.getCountryEng() %></span>
		                <table class="covid_table" border="1px solid gray">
		                    <tbody>
		                        <tr>
		                            <td width="16%" height="10%">&nbsp;</td>
		                            <td width="42%" class="text_blue text_bold">백신 접종자</td>
		                            <td width="42%" class="text_green text_bold">백신 미접종자</td>
		                        </tr>
		                        <!-- 여행불가 국가 -->
		                        <%if(q.getDepVyPcr().contains("여행불가")) {%>
			                        <tr>
			                            <td height="45%" class="text_bold">출발전</td>
				                        <td id="depVyPcr" rowspan="2" colspan="2"><%=q.getDepVyPcr() %></td>
			                      	</tr>
			                     	<tr>
				                        <td height="45%" class="text_bold">도착후</td>
			                      	</tr>
			                      	<tr>
			                      	</tr>
			                      	<!-- 미접종자 입국불가 -->
		                        <%} else if(q.getDepVnPcr().contains("입국불가")){%>
			                        <tr>
			                            <td height="45%" class="text_bold">출발전</td>
				                        <td id="depVyPcr"><%=q.getDepVyPcr() %></td>
				                        <td id="depVnPcr" colspan="2" rowspan="3"><%=q.getDepVnPcr() %></td>
			                      	</tr>
			                     	<tr>
				                        <td height="45%" rowspan="2" class="text_bold">도착후</td>
				                        <td id="arrVyPcr"><%=q.getArrVyPcr() %></td>
			                      	</tr>
			                      	<tr>
				                        <td id="arrVySelf"><%=q.getArrVySelf() %></td>
			                      	</tr>
			                      	<!-- 그외(전체분리) -->
	                        	<%} else {%>
			                        <tr>
			                            <td height="45%" class="text_bold">출발전</td>
				                        <td id="depVyPcr"><%=q.getDepVyPcr() %></td>
				                        <td id="depVnPcr"><%=q.getDepVnPcr() %></td>
			                      	</tr>
			                     	<tr>
				                        <td height="45%" rowspan="2" class="text_bold">도착후</td>
				                        <td id="arrVyPcr"><%=q.getArrVyPcr() %></td>
				                        <td id="arrVnPcr"><%=q.getArrVnPcr() %></td>
			                      	</tr>
			                      	<tr>
				                        <td id="arrVySelf"><%=q.getArrVySelf() %></td>
				                        <td id="arrVnSelf"><%=q.getArrVnSelf() %></td>
			                      	</tr>
	                        	<%} %>
		                    </tbody>
		                  </table>
		            	</div>   
            		<%} %>
            	<%} %>
        </div>
        
 		<!-- 유럽 -->
        <div id="tab4" class="tab-content">
            <br><br>
            <!-- 리스트가 비어있는 경우 -->
            <%if(listTap4.isEmpty()){%>
            	<h4 align="center">등록된 정보가 없습니다.</h4>
            <%} else {%>
	            <!-- 비어있지 않을 경우 -->
	            <%for(Quarantine q : listTap4){ %>
		            <div class="table-content">
		            
		                <span id="national_kor"><%=q.getCountryKor() %></span>
		                <span id="national_eng"><%=q.getCountryEng() %></span>
		                <table class="covid_table" border="1px solid gray">
		                    <tbody>
		                        <tr>
		                            <td width="16%" height="10%">&nbsp;</td>
		                            <td width="42%" class="text_blue text_bold">백신 접종자</td>
		                            <td width="42%" class="text_green text_bold">백신 미접종자</td>
		                        </tr>
		                        <!-- 여행불가 국가 -->
		                        <%if(q.getDepVyPcr().contains("여행불가")) {%>
			                        <tr>
			                            <td height="45%" class="text_bold">출발전</td>
				                        <td id="depVyPcr" rowspan="2" colspan="2"><%=q.getDepVyPcr() %></td>
			                      	</tr>
			                     	<tr>
				                        <td height="45%" class="text_bold">도착후</td>
			                      	</tr>
			                      	<tr>
			                      	</tr>
			                      	<!-- 미접종자 입국불가 -->
		                        <%} else if(q.getDepVnPcr().contains("입국불가")){%>
			                        <tr>
			                            <td height="45%" class="text_bold">출발전</td>
				                        <td id="depVyPcr"><%=q.getDepVyPcr() %></td>
				                        <td id="depVnPcr" colspan="2" rowspan="3"><%=q.getDepVnPcr() %></td>
			                      	</tr>
			                     	<tr>
				                        <td height="45%" rowspan="2" class="text_bold">도착후</td>
				                        <td id="arrVyPcr"><%=q.getArrVyPcr() %></td>
			                      	</tr>
			                      	<tr>
				                        <td id="arrVySelf"><%=q.getArrVySelf() %></td>
			                      	</tr>
			                      	<!-- 그외(전체분리) -->
	                        	<%} else {%>
			                        <tr>
			                            <td height="45%" class="text_bold">출발전</td>
				                        <td id="depVyPcr"><%=q.getDepVyPcr() %></td>
				                        <td id="depVnPcr"><%=q.getDepVnPcr() %></td>
			                      	</tr>
			                     	<tr>
				                        <td height="45%" rowspan="2" class="text_bold">도착후</td>
				                        <td id="arrVyPcr"><%=q.getArrVyPcr() %></td>
				                        <td id="arrVnPcr"><%=q.getArrVnPcr() %></td>
			                      	</tr>
			                      	<tr>
				                        <td id="arrVySelf"><%=q.getArrVySelf() %></td>
				                        <td id="arrVnSelf"><%=q.getArrVnSelf() %></td>
			                      	</tr>
	                        	<%} %>
		                    </tbody>
		                  </table>
		            	</div>   
            		<%} %>
            	<%} %>
        </div>

    </div>
            
    <script>
    	//대륙탭 클릭시 대륙명 가져옴, current 속성 추가및삭제
        $(function(){
            $('ul.tabs li').click(function(){
                var tabId = $(this).attr('data-tab'); //누른탭의 data-tap명 출력되는 div영역 id와 동일함
  	    		var clickTab = $(this).text();
  	    		
  	    		console.log($(this).text());

                $('ul.tabs li').removeClass('current');
                $('.tab-content').removeClass('current');

                $(this).addClass('current');
                $("#"+tabId).addClass('current');
                })
            })
    </script>
        </div>
        <%@ include file="/views/common/content3.jsp" %>
    </div>
    <%@ include file="/views/common/footer.jsp" %>
</body>
</html>