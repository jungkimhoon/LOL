<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
a.searchA {color:blak; text-decoration: none; font-size: 8pt;}
a.searchA:link {color: black; text-decoration: none;}
a.searchA:visited {color: black; text-decoration: none;}
a.searchA:hover {color: #5f0080; text-decoration: none; font-weight: bolder;}
a.searchA:active {color: black; text-decoration: none;}

.box{
	margin: 0 auto;
	width: 340px;
	height: 450px;
	top: 50%; 
	left: 50%;  
	
}

.layout{   
	width: 340px;
	height: 54px;
	line-height: 20px;   
    border-radius: 3px; 
    background: #fff;
    border: 1px solid #5f0080;
    outline: none; 
    color: #5f0080; 
    padding: 0 15px;
}

</style> 

 
<div class="box">  
<h2 align="center">로그인</h2>
	<div>
		<input class="layout" type="text" name="id" placeholder=" 아이디를 입력해주세요" style="font-size:15px;">
		<div id="loginIdDiv"></div>
	</div>
		<div style="height:5px;"></div>
	<div>
		<input class="layout" type="password" name="pwd" id="pwd" placeholder=" 비밀번호를 입력해주세요" style="font-size:15px;">
		<div id="loginPwdDiv" align= "left"></div>		
	</div>
	<div style="width:340px; height:20px;" >
	 
	</div>  
		  
	<div align="right">
		<a class="searchA" href="/bitFarm/member/findIdForm">아이디 찾기</a> 
		<a class="searchA" href="/bitFarm/member/findPwdForm">비밀번호 찾기</a>&nbsp;
		<div style="height:5px;"></div>  
		<input class="layout" type="button" id="loginBtn" value="로그인" style="color: white; background-color: #5f0080; border: #5f0080; border-radius: 5px; cursor: pointer;">
	</div>   
		<div style="height:5px;"></div>
	<div>
		<input class="layout" type="button" value="회원가입" onclick="location.href='signUp'" style="border-radius: 5px; cursor: pointer;"> 
	</div>	 
		<div style="height:5px;"></div>   
	<div style="height:60px;"> 

</div>   

<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">   
   
    $('#loginBtn').click(function(){
    	$('#loginIdDiv').empty();
    	$('#loginPwdDiv').empty(); 
    	if($('input[name=id]').val()==''){
    		$('#loginIdDiv').text('아이디를 입력해주세요.');
    		$('#loginIdDiv').css('color','red');
    		$('#loginIdDiv').css('font-weight','bold');
    		$('#loginIdDiv').css('font-size','9pt'); 
    		
    	}else if($('input[name=pwd]').val()==''){
        		$('#loginPwdDiv').text('비밀번호를 입력해주세요.'); 
        		$('#loginPwdDiv').css('color','red');
        		$('#loginPwdDiv').css('font-weight','bold');
        		$('#loginPwdDiv').css('font-size','9pt');
    	}else{ 
    		$.ajax({ 
    			type : 'post',
    			url : '/bitFarm/member/login',
    			data : {'id' : $('input[name=id]').val(),  
    					'pwd' : $('input[name=pwd]').val()},
    			dataType : 'json',
    	 		success : function(data){
    				//alert(data.login);  
    				if(data.login == 'fail'){ 
    					$('#loginPwdDiv').text('가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.'); 
    	        		$('#loginPwdDiv').css('color','red');
    	        		$('#loginPwdDiv').css('font-weight','bold');
    	        		$('#loginPwdDiv').css('font-size','9pt');
    				}else{
    					location.href="/bitFarm/main/main";
    				}
    			}
    		});     		
    	}
    });
     
    $("#pwd").keydown(function (key) { 
        if (key.keyCode == 13) { // 엔터키면
            $("#loginBtn").focus(); // 암호에 포커스
        }
    });

    
    
</script>

