<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style type="text/css"> 
	.wrap{  
		width: 1300px; 
		margin: 0 auto;   
	
	} 
	
	.contents{ 
		white-space: pre-wrap;
		word-break: break-all;
	}

	.tdstyle{
	    width: 130px;
	    padding: 13px 0 13px 20px;
	    background-color: #F7F5F8; 
	    
	    text-align: left;
	}
	
	table{
		 border-collapse: collapse;
		 border-top: 1px solid #e8e8e8;
	
	}
	
	 th, td {
   		 border-bottom: 1px solid #dcdcdc;
   		 
 	 }
 	 
 	 .layoutB{ 
		width: 150px;
		height: 40px;
		background-color: #5f0080;
		border: #5f0080;
		color: white;
		border-radius: 5px;
		font-family: 'Noto Sans';
		font-weight: bold;
		cursor: pointer;
	} 
	
</style>
 
<div class="wrap">
	
	 
		<table width="1300px" > 
			<tr><td style="border-top: 2px solid #5f0080;" > 
				<table align="center" style="padding: 0; width:100%;">
					<tr>  
						<td class="tdstyle">제목</td>  
						<td colspan="3" style="border-top: 1px solid #e8e8e8;">${boardDTO.boardSubject}</td> 						
					</tr>
					 
					<tr>
						<td class="tdstyle">작성자</td>
						<td colspan="3">${boardDTO.memberId }</td> 
					</tr>
					
					<tr>
						<td class="tdstyle">작성일</td> 
						<td >${boardDTO.boardDate }</td> 
						<td ></td> 
						<td width="50%"></td>
					</tr>	 
				</table>
			</td></tr> 
			<tr> 
				<td height="30px" style="border-bottom: 0px"></td>
			</tr>
			<tr><td style="border-bottom: 0px">   
				<pre class="contents">${boardDTO.boardContent }</pre><br> 
			<c:if test="${boardDTO.boardFile != '0'}">
				<img src="../storage/${boardDTO.boardFile }">
			</c:if>
			</td></tr>  
			<tr>   
				<td height="30px"></td>
			</tr>
			<tr><td align="center" style="border-bottom: 2px solid #5f0080; border-top: 2px solid #5f0080;">
				<input class="layoutB" id="goBackBtn" type="button" value="목록">
				<c:if test="${admin =='admin' }"> 
				<input class="layoutB" id="delBtn" type="button" value ="삭제">
				</c:if>
			</td></tr>						
		</table>	
		<input type="hidden" name="seq" value="${informationDTO.information_number }">
</div>  
 
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript"> 
$('#goBackBtn').click(function(){
	location.href = '/bitFarm/information/infoBoardList?pg=${pg}'
});

$('#delBtn').click(function(){
	$.ajax({
		type : 'post',
		url : '/bitFarm/information/deleteInfo',
		data : {'seq' : $('input[name=seq]').val()},
		dataType : 'json',
		success : function(data){ 			
			alert("삭제완료"); 
			location.href='/bitFarm/information/infoBoardList';
		}
	});
	
});
</script>
