<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.kh.board.model.vo.*"%>
<% 
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/KGG/resources/css/user_faqMainStyle.css">
    <style>   
    .subarea{
        background-color: rgb(248, 244, 244);
        color: rgb(77, 77, 168);
    }
    </style> 
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
    <div id="content">
       <%@ include file="/views/common/content1_cs.jsp" %>
      
       <div id="content_2">
           <div id="content_3_1">자주묻는 질문</div>
           <div id="content_3_2">
               <ul id="navi2">
                   <li id="out" class="out" style="height: 45px;"><a href="userout1.bo">해외항공</a>
                       <div class="content_3_subMenu" id="content_3_2_1">
                           <ul class="block">
                               <li class="sub1" style="width: 30%;"><a href="userout2.bo">예약/조회/취소</a></li>
                               <li class="sub1" style="width: 35%;"><a href="userout3.bo">요금/규정/발권/결제/티켓</a></li>
                               <li class="sub1" style="width: 35%"><a href="userout4.bo">여권/체류지정보/증빙서류</a></li> 
                           </ul>
                       </div>
                   </li>
                   <li id="in" class="in" style="height: 45px;"><a href="userin4.bo">국내항공</a>
                       <div class="content_3_subMenu" id="content_3_2_2">
                           <ul class="block">
                               <li class="sub2" style="width: 50%;"><a href="userin1.bo">예약/결제/변경/취소/환불</a></li>
                               <li class="sub2" style="width: 30%;"><a href="userin2.bo">발권/탑승수속</a></li>
                               <li class="sub2" style="width: 20%;"><a href="userin3.bo">기타</a></li>
                           </ul>
                       </div>
                   </li>
                </ul>
            </div> 
            <div class="content_3_3" id="userCategory">
            	
            	<%for(Board b : list){ %>
                <div class="menu1 v1" id="userTitle">Q.<%=b.getFaqTitle() %></div>
                
                <span class="v1 checkmark">V</span>
                
                <p class="subarea" id="userContent">
                    <B>A</B><%=b.getFaqContent() %>
                </p>
                <%} %>
                
           	</div>
           	 <div id="content_3"></div>
           	<%@ include file="../common/footer.jsp" %>
		</div>
		<script>
            $(function(){
                $(".out>a").on({"mouseenter":function(){
                    $(this).css("font-size", "18px");
                    $(this).css("color", "rgb(154, 222, 226)");
                    $("#content_3_2_1").css("background-color", "rgb(241, 241, 241)");
                    $("#content_3_2_2").css("background-color", "rgb(241, 241, 241)");
                },
                "mouseout":function(){
                    $(".out>a").css("color", "black");
                    $(this).css("font-size", "15px");
                    $("#content_3_2_1").css("background-color", "white");
                    $("#content_3_2_2").css("background-color", "white");
                }});
                $(".sub1").on({"mouseenter":function(){
                    $(".out>a").css("color", "rgb(154, 222, 226)");
                    $(".out>a").css("font-size", "18px");
                    $("#content_3_2_1").css("background-color", "rgb(241, 241, 241)");
                    $("#content_3_2_2").css("background-color", "rgb(241, 241, 241)");
                },
                "mouseout":function(){
                    $("#out>a").css("color", "black");
                    $("#out>a").css("font-size", "15px");
                    $("#content_3_2_1").css("background-color", "white");
                    $("#content_3_2_2").css("background-color", "white");
                }});
                $(".in>a").on({"mouseenter":function(){
                    $(this).css("font-size", "18px");
                    $(this).css("color", "rgb(154, 222, 226)");
                    $("#content_3_2_2").css("background-color", "rgb(241, 241, 241)");
                },
                "mouseout":function(){
                    $(".in>a").css("color", "black");
                    $(this).css("font-size", "15px");
                    $("#content_3_2_2").css("background-color", "white");
                }});
                $(".sub2").on({"mouseenter":function(){
                    $(".in>a").css("color", "rgb(154, 222, 226)");
                    $(".in>a").css("font-size", "18px");
                    $("#content_3_2_2").css("background-color", "rgb(241, 241, 241)");
                },
                "mouseout":function(){
                    $("#in>a").css("color", "black");
                    $("#in>a").css("font-size", "15px");
                    $("#content_3_2_2").css("background-color", "white");
                }});
            });
            $(function(){
                $(".checkmark").click(function(){
                    var $answer = $(this).next();
                    if($answer.css("display") == "none"){
                        $(this).siblings(".subarea").slideUp();
                        $answer.slideDown();
                    }
                    else{
                        $answer.slideUp();
                    }
                });
            });
        </script>
       
</body>
</html>