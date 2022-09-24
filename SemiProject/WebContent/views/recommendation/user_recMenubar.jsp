<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	#content_1{
    	width: 15%;
    	text-align: center;
	}
	#content_1_1{
	    height: 10%;
	    text-align: left;
	    padding-top: 15px;
	    overflow: visible;
	    width: 180px;
	    height: 60px;
	    line-height: 20px;
	    padding: 20px 12px;
	    background-color: #1a3d89;
/* 	    font-family: "Malgun Gothic"; */
/* 	    font-weight: 700; */
/* 	    color: #fff; */
/* 	    font-size: 16px; */
	}
	#content_1_2, #content_1_3, #content_1_4, #content_1_5, #content_1_6{
	    height: 7%;
	    text-align: left;
	    padding-top: 8px;
   	    width: 180px;
   	    
	}
	#content_1>div>a{
	    text-decoration: none;
	    color: black;
	    display: block;
	    position: relative;
	    padding: 4.8px 12px;
	    color: #333;
	    font-family: "Malgun Gothic";
	    font-size: 14px;
	    font-weight: 700;
	}
	#content_1>div{
    height: 68px;
    padding-top: 19px;
}
</style>
</head>
<body>
	<div id="content_1">
	    <div id="content_1_1">
	    	<a href="/KGG/list.re?kpage=1" style="color: #fff; font-size: 16px; font-family: 'Malgun Gothic'; font-weight: 700;">추천여행지(전체)</a>
	    </div>
	    <div id="content_1_2">
	        <a href="/KGG/listArea1.re?kpage=1">국내</a>
	    </div>
	    <div id="content_1_3">
	        <a href="/KGG/listArea2.re?kpage=1">동북아시아</a>
	    </div>
	    <div id="content_1_4">
	        <a href="/KGG/listArea3.re?kpage=1">동남아시아</a>
	    </div>
	    <div id="content_1_5">
	        <a href="/KGG/listArea4.re?kpage=1">미주/대양주</a>
	    </div>
   	    <div id="content_1_6">
	        <a href="/KGG/listArea5.re?kpage=1">유럽</a>
	    </div>
	</div>
</body>
</html>