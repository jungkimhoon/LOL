<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	table.QnAtable{
		width: 800px;
		border-collapse: collapse;
		border-top: 2px solid #5f0080;
		border-bottom: 2px solid #5f0080;
	} 
	.join { 
	    width: 270px;
	    height: 54px;
	    border: 0 none; 
	    border-radius: 3px; 
	    background-color: #5f0080;
	    font-size: 16px;
	    color: #fff; 
	    line-height: 44px;
	    font-weight: bold;
	    cursor: pointer;
	}
 	.title{  
 		width: 100px; 
 		text-align: left; 
 		font-size: 10pt; 
 		font-weight: bold; 
 		background-color: #F7F5F8; 
 	}
 	.layoutT{
		width: 500px;
	    height: 30px;
	    padding: 0 9px;
	    border: 1px solid #ccc;
	    font-size: 14px; 
	    color: #333;
	    line-height: 20px;
	    background: #fff;
	    outline: none;   
	}  
	.layoutB{ 
		width: 150px;
		height: 30px;
		background-color: #5f0080;
		border: #5f0080;
		color: white;
		border-radius: 5px;
		font-family: 'Noto Sans';
		font-weight: bold;
		cursor: pointer;
	} 
	.select{
		width: 150px;
	    height: 30px;
	    padding: 0 9px;
	    border: 1px solid #ccc;
	    font-size: 14px; 
	    color: #333;
	    line-height: 20px;
	    background: #fff;
	    outline: none;   
	}  
	
</style>
<div style="width:1200px; margin: 0 auto;">  
<h3>글 등록</h3>  
<form name="modifyForm" id="modifyForm" >
<input type="hidden" name="seq" value="${seq }">   
<table class="QnAtable" cellpadding="5px" style="border-color: grey; width:1200px;">   
	<tr>   
		<td class="title">&emsp;제목</td> 
		<td width="650" style="text-align: left;"><input class="layoutT" type="text" name="boardSubject" value="${boardDTO.boardSubject }"></td>
		
	</tr>  
	<tr>
		<td class="title">&emsp;작성자</td>
		<td style="text-align: left;"><input class="layoutT" type="text" name="memberId" id="memberId" value="${boardDTO.memberId }" read></td>
	</tr>	
	<tr>
		<td class="title">&emsp;내용</td> 
		<td style="text-align:left;">
		<textarea name="boardContent" id="BoardContent" cols="30" rows="80" style="width: 800px; height: 500px;">${boardDTO.boardContent }</textarea>
		</td> 		 
	</tr> 
	<!-- <tr>  
		<td class="title">&emsp;파일 선택</td> 
		<td style="text-align: left;"><input class="layoutT" id="boardFileRequest" type="file" name="boardFileRequest" size="50"></td>
	</tr>  -->
</table>         
<div style="height:50px;"></div> 
<div style="weight: 600px;height: 100px;text-align: center; width: 1000px;"> 
	<input class="join" type="button" id="ModifyBtn" value="등록"> 
</div> 
</form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$("#ModifyBtn").click(function(){ 
    //id가 smarteditor인 textarea에 에디터에서 대입
    if($('input[name=BoardSubject]').val() == ''){
    	alert("제목을 입력하세요."); 
    	return false;
    } 
    
    if($('input[name=BoardContent]').val() == ''){
    	alert("내용을 입력하세요.");   
    	return false;
    }
    
    var queryString = $('form[name=modifyForm]').serialize();
	
	$.ajax({  
		type : 'post',	
		url : '/board/boardModify',             
		data : queryString, 
		success : function(){    
			alert("수정 완료");
			location.href="/board/boardList"; 
		} 			   
	});			 
	  
});
</script>