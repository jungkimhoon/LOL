<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	table {				
		text-align: center; 		
		margin: auto;
		border-spacing: 2px;
	} 
	 
	.subject{	
		text-align: left;
		font-size: 14;
		font-family: 'Noto Sans';
	}
	
	.layoutB{ 
		width: 150px; 
		height: 40px;
		background-color: #000000;
		border: #000000;
		color: white;
		border-radius: 5px;
		font-family: 'Noto Sans';
		font-weight: bold;
		cursor: pointer;
	} 
	
	.layoutT{
	width: 300px;
    height: 40px;
    padding: 0 9px;
    border: 1px solid #ccc;
    font-size: 14px;
    color: #333;
    line-height: 20px;
    border-radius: 3px;
    background: #fff;
    outline: none;
   
	}  
	
	th {
    text-align: left;
 	}
 	
 	td {
 	text-align: left;
 	vertical-align: center;
 	} 
 	
 	.box{   
	width: 640px;
	margin: 0 auto;
	height: 250px; 	 
	text-align: left;
	} 
	
	.join {  
    width: 340px;
    height: 54px;
    margin: 0 auto;
    border: 0 none;  
    border-radius: 3px;
    background-color: #000000;
    font-size: 16px;
    color: #fff;
    line-height: 44px;  
    cursor: pointer;
	}
	.sign {
	cursor: pointer;
	}
	a.sign {color:purple; text-decoration: none; }
	a.sign:link {color: purple; text-decoration: none;}
	a.sign:visited {color: purple; text-decoration: none;} 
	a.sign:hover {color: #000000; text-decoration: none; font-weight: bolder;}
	a.sign:active {color: purple; text-decoration: none;}
}
	
</style>
<div style="height:30px;"></div>
<form name="memberWriteForm">  
<h2 align="center">회원가입</h2> 
<div style="height:20px;"></div>
<div> 
	<table cellpadding="15" cellspacing="5">   
		<tr> 
			<th class="subject">아이디*</th>
			<td style="vertical-align: top;"><input class="layoutT" type="text" id="id" name="id" placeholder="6자 이상의 영문 혹은 영문과 숫자를 조합">&emsp;
			<input class="layoutB" type="button" id="member_checkIdBtn" name="member_checkId" value="중복확인"><br id="member_id_p" style="display: none;"><span id="member_id_Div" ></span></br></td>					
		</tr>  
		 
		<tr>   
			<th class="subject">비밀번호*</th>   
			<td><input class="layoutT" type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력해주세요"></td>
			
		</tr>
		<tr>
			<th class="subject">비밀번호확인*</th>
			<td style="padding-top: 2px;"><input class="layoutT" type="password" name="repwd" placeholder="비밀번호를 한번 더 입력해주세요">
			<br id="member_pwd_p" style="display: none;"><span id="member_pwd_Div"></span></br></td>
		</tr>			
		<tr>   
			<th class="subject">이메일*</th>
			<td><input class="layoutT" type="text" id="email" name="email" placeholder="예: qwer1234@naver.com">&emsp;
			<input class="layoutB" type="button" name="checkEmail" value="이메일 인증">
			<br id="member_email_p" style="display: none;"><span id="member_email_Div"></span></br>			
			</td>			 
		</tr>
		<tr> 
			<th class="subject">휴대폰*</th>
			<td><input class="layoutT" type="text" name="phone" placeholder="010-1234-1234">
			<br id="member_phone_p" style="display: none;"><span id="member_phone_Div" ></span></br>
			</td> 
		</tr>
	</table>
	<div style="height:50px;"></div>
	<div style="weight: 100px; height: 100px; text-align: center;"> 
		<input class="join" name="writeFormBtn" id="writeFormBtn" type="button" onclick="checkMemberWrite()" value="가입하기"> 
	</div>		
</div>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
function checkMemberWrite(){
	document.memberWriteForm.method = 'post'; 
	document.memberWriteForm.action = '/member/signUp';
	document.memberWriteForm.submit();  
}
</script> 
 