<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/KGG/resources/css/user_joininnerStyle.css">
</head>
<body>
	<div class="wrap">
	    <div id="header">
	        <div id="header_1" style="border-bottom: 1px solid gray;">
	            <h2>회원가입</h2>
	        </div>
	    </div>
	    <form id="enroll-form" action="<%=contextPath%>/insert.us" method="post">
		<div id="content"  style="width: 1000px;">
		   	<div id="content_1" style="float: left;">
				<div id="content_1_1" class="inline-block">
					<input type="text" id="c1" name="userId" placeholder="아이디(6자리 이상 영문+숫자 조합)">
				</div>
 					<button type="button" class="inline-block" id="checkBlock" onclick="idCheck();">중복확인</button> 
				
		        <div id="content_1_2">
		            <input type="password" name="userPwd" id="c1" placeholder="비밀번호">
		        </div>
		        <div id="content_1_3">
		            <input type="password" name="" id="c1" placeholder="비밀번호 확인">
		        </div>
		        <div id="content_1_4" style="height:45px;"></div>
		        <div id="content_1_5">
		            <input type="text" name="userName" id="c1" placeholder="이름">
		        </div>
		        <div id="content_1_6">
		            <input type="text" name="email" id="c1" placeholder="이메일 주소">
		        </div>
		        <div id="content_1_7">
		            <input type="text" name="phone" id="c1" placeholder="휴대전화번호(-포함)">
		        </div>
		   	</div>
	        <div id="content_2" style="float: left;">
	            <div id="content_2_1" style="border-bottom: 1px solid gray;">
	            	 <input type="checkbox" id="check_all">전체 선택
	            </div>
	            <div id="content_2_2">
	                <input type="checkbox" class="input_check" name="class1" id="check1" value="1">이용 약관 동의
	            </div>
	            <div id="content_2_3" style="border-top: 1px solid gray;"></div>
	            <div id="content_2_4">
	                <textarea cols="60" rows="6" readonly style="resize: none;">
	제 1조(목적)
	이 약관은 (주)킹갓제너럴투어(전자상거래 사업자)가 운영하는 킹갓제너럴투어 사이버 몰(이하 "몰"라 한다)에서 제공하는 인터넷 관련 서비스 (이하 "서비스"라 한다)를 이용함에 있어 사이버 몰과 이용자의 권리ㆍ의무 및 책임사항을 규정함을 목적으로 합니다.
	제 2조(정의)
	① "몰" 이란 (주)킹갓제너럴투어가 재화 또는 용역(이하 "재화 등”이라 함)을 이용자에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 재화 등을 거래할 수 있도록 설정한 가상의 영업장을 말하며, 아울러 사이버몰을 운영하는 사업자의 의미로도 사용합니다.
	② "이용자"란 "몰"에 접속하여 이 약관에 따라 "몰"이 제공하는 서비스를 받는 회원 및 비회원을 말합니다.
	③ "회원"이라 함은 "몰"에 개인정보를 제공하여 회원등록을 한 자로서, "몰"의 정보를 지속적으로 제공받으며, "몰"이 제공하는 서비스를 계속적으로 이용할 수 있는 자를 말합니다.
	④ "비회원"이라 함은 회원에 가입하지 않고 "몰"이 제공하는 서비스를 이용하는 자를 말합니다.
	제 3조 (약관등의 명시와 설명 및 개정)
	① "몰"은 이 약관의 내용과 상호, 영업소 소재지, 대표자의 성명, 연락처(전화, 팩스, 전자우편 주소), 사업자등록번호, 통신판매업 신고번호, 개인정보관리책임자 등을 이용자가 알 수 있도록 사이버몰의 초기 서비스화면(전면)에 게시합니다. 다만, 약관의 내용은 이용자가 연결화면을 통하여 볼 수 있도록 할 수 있습니다.
	② "몰"은 이용자가 약관에 동의하기에 앞서 약관에 정하여져 있는 내용 중 청약철회, 환불조건 등과 같은 중요한 내용을 별도의 연결화면(항공권 요금규정)에 표기하여 이용자의 확인을 구하여야 합니다.
	③ "몰"은 전자상거래등에서의 소비자보호에 관한 법률, 약관의 규제 등에 관한 법률, 전자거래기본법, 전자서명법, 정보통신망 이용촉진등에 관한 법률, 방문판매 등에 관한 법률, 소비자보호법 등 관련법을 위배하지 않는 범위에서 이 약관을 개정할 수 있습니다.
	④ "몰"은 약관을 개정할 경우에는 적용일자 및 개정사유를 명시하여 현행약관과 함께 "몰”의 초기화면에 그 적용일자 7일 이전부터 적용일자 전일까지 공지합니다. 다만, 이용자가 불리하게 약관내용을 변경하는 경우에는 최소한 30일 이상의 사전 유예기간을 두고 공지합니다. 이 경우 "몰”은 개정전 내용과 개정후 내용을 명확하게 비교하여 이용자가 알기 쉽도록 표시합니다.
	                </textarea>  
	            </div>
	            <div id="content_2_5"></div>
	            <div id="content_2_6" style="border-bottom: 1px solid gray;"></div>
	            <div id="content_2_7">
	                <input type="checkbox" class="input_check" name="class2" id="check2" value="2">개인정보 취급방침 동의
	            </div>
	            <div id="content_2_8" style="border-top: 1px solid gray;"></div>
	            <div id="content_2_9">
	                <textarea cols="60" rows="6" readonly style="resize: none;">
	와이페이모어 개인정보취급방침
	
	와이페이모어는 아래와 같이 개인정보 보호를 매우 중요하게 생각하고 있습니다. 
	따라서 와이페이모어는 이러한 개인정보의 보호를 위해 아래와 같은 사항을 원칙으로 삼고 있습니다.
	이러한 사항은 와이페이모어의 정책변화에 따라 수시로 변경될 수 있으므로 정기적으로 방문하셔서 확인하여 주시기 바랍니다.
	와이페이모어의 개인정보 취급방침은 아래와 같습니다.
	                    
	1. 총칙
	① (주)킹갓제너럴투어가 운영하는 "킹갓제너럴투어" 웹사이트는 귀하의 개인정보보호를 매우 중요시하며, 
	정보통신망이용촉진및정보보 호에관한법률』상의 개인정보보호 규정 및 정보통신부가 제정한 『개인정보보호지침』을 준수하고 있습니다. 
	"킹갓제너럴투어"는 개인정보취급방침을 통하여 귀하께서 제공하시는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며 
	개인정보보호를 위해 어떠한 조치가 취해지고 있는지 알려드립니다.
	② "킹갓제너럴투어"는 개인정보취급방침을 홈페이지 첫 화면에 공개함으로써 귀하께서 언제나 용이하게 보실 수 있도록 조치하고 있습니다.
	③ "킹갓제너럴투어"는 개인정보취급방침의 지속적인 개선을 위하여 개인정보취급방침을 개정하는데 필요한 절차를 정하고 있습니다. 그리고 개인정보취급방침을 개정하는 경우 버전번호 등을 부여하여 개정된 사항을 귀하께서 쉽게 알아볼 수 있도록 하고 있습니다.
	                    
	2. 용어 정의
	① "킹갓제너럴투어" 란 (주)킹갓제너럴투어의 재화 또는 용역을 이용자에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 재화 또는 용역을 거래할 수 있도록 설정한 가상의 영업 장을 말하며, 아울러 "킹갓제너럴투어"를 운영하는 기업의 의미로도 사용합니다.
	② "이용자"란 "킹갓제너럴투어"에 접속하여 이 약관에 따라 "킹갓제너럴투어"가 제공하는 서비스를 받는 회원 및 비회원을 말합니다.
	③ "회원"이라 함은 "킹갓제너럴투어"에 개인정보를 제공하여 회원등록을 한 자로써, "킹갓제너럴투어"의 정보를 지속적으로 제공받으며, "킹갓제너럴투어"가 제공하는 서비스를 계속적으로 이용할 수 있는 자를 말합니다.
	④ "비회원"이라 함은 회원에 가입하지 않고 "킹갓제너럴투어"가 제공하는 서비스를 이용하는 자를 말합니다.
	⑤ "제3자"라 함은 이용자, 당해 이용자로부터 동의를 받아 개인정보를 수집한 서비스제공자 그리고 서비스제공자로부터 
	개인정보 처리를 위탁 받은 자 이외의 자연인, 법인, 공공기관, 정부투자기관 및 기타의 자를 말합니다.
	⑥ "개인정보"란 생존하는 개인에 관한 정보로서 당해 정보에 포함되어 있는 성명, 아이핀 등의 사항에 의하여 당해 
	개인을 식별할 수 있는 정보(당해 정보만으로는 특정 개인을 식별할 수 없더라도 다른 정보와 용이하게 결합하여 
	식별할 수 있는 것을 포함합니다)를 말합니다.
	                </textarea>
	            </div>
			</div>
			<div id="footer" align="center" style="float: left">
	        	<div id="footer_1">
	        		<button type="submit" id="btn" disabled>회원가입</button>
	        	</div>
		        <div id="footer_2">
		        	<button type="button" id="btn2" onclick="insertHome()">회원가입 없이 서비스 이용</button>
		        </div>
		        <script>
            		function insertHome(){
                		location.href="<%=contextPath%>";
            		}
        		</script>
		        <p id="f1">
		            Copyleft ©️ 2022-2022 King God General Tour All Right Reserved<br>
		        </p>
		    </div>
		</div>
		</form>
	</div>
	
	<script>
	function idCheck(){
        
        var $userId = $("#enroll-form input[name=userId]");
        
        $.ajax({
            url : "idCheck.us",
            data : {checkId : $userId.val()}, //$userId는 input요소객체 이기때문에 .val()로 값가져가기
            success : function(result){
            	
            	if(result=="NNNNN"){ 
            		alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.");
            		$userId.focus();
            	}else{ 
            		
            		if(confirm("멋진 아이디네요. 사용하시겠습니까?")){ 
            			$userId.attr("readonly",true); 
            		}else{ 
            			$userId.focus();
            		}
            	}
            },
            error : function(){
                console.log("아이디 중복체크용 ajax 실패");
            }
        })
		}
		
		$(document).on('click','#check_all',function(){
			if($('#check_all').is(':checked')){
				$('.input_check').prop('checked',true);
				$('#btn').css("font-weight","bold");
				$('#btn').css("color","white");
				$('#btn').css("cursor", "pointer");
			}else{
				$('.input_check').prop('checked',false);
				$('#btn').css("font-weight","normal");
				$('#btn').css("color","white");
				$('#btn').css("cursor", "none");
			}
		});
		
 		$(document).on('click','.input_check',function(){
 			if($('input[class=input_check]:checked').length==$('.input_check').length){
 				$('#check_all').prop('checked',true);
 				$('#btn').css("font-weight","bold");
				$('#btn').css("color","white");
				$('#btn').css("cursor", "pointer");
 			}else{
 				$('#check_all').prop('checked',false);
 				$('#btn').css("font-weight","normal");
				$('#btn').css("color","white");
				$('#btn').css("cursor", "none");
 			}
 		});

			$("#check1" && "#check2").on('click',function(){
				var chk1 = $('input:checkbox[id="check1"]').is(":checked");
        		if(chk1==true){
            		$("#btn").removeAttr('disabled');
            		$('#btn').css("font-weight","bold");
    				$('#btn').css("color","white");
    				$('#btn').css("cursor", "pointer");
        		}else{
             		$("#btn").attr("disabled", true);
             		$('#btn').css("font-weight","normal");
    				$('#btn').css("color","white");
    				$('#btn').css("cursor", "none");
         		}
   			 });
			
			$("#check1" || "#check2").on('click',function(){
				var chk1 = $('input:checkbox[id="check1"]').is(":checked");
				var chk2 = $('input:checkbox[id="check2"]').is(":checked");
        		if(chk1==true && chk2==true){
            		$("#btn").removeAttr('disabled');
            		$('#btn').css("font-weight","bold");
    				$('#btn').css("color","white");
    				$('#btn').css("cursor", "pointer");
        		}else{
             		$("#btn").attr("disabled", true);
             		$('#btn').css("font-weight","normal");
    				$('#btn').css("color","white");
    				$('#btn').css("cursor", "none");
         		}
   			 });
			
			
			$("#check_all").on('click',function(){
        		var chk = $('input:checkbox[id="check_all"]').is(":checked");
        		if(chk==true){
            		$("#btn").removeAttr('disabled');
            		$('#btn').css("font-weight","bold");
    				$('#btn').css("color","white");
    				$('#btn').css("cursor", "pointer");
        		}else{
             		$("#btn").attr("disabled", true);
             		$('#btn').css("font-weight","normal");
    				$('#btn').css("color","white");
    				$('#btn').css("cursor", "none");
         		}
    		});
	</script>
</body>
</html>