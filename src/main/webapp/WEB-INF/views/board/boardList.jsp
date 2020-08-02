<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style type="text/css">
	a.subject {color:black; text-decoration: none; font-size: 10pt;}  
	a.subject:link {color: black; text-decoration: none;}
	a.subject:visited {color: black; text-decoration: none;}
	a.subject:hover {color: #5f0080; text-decoration: none;} 
	a.subject:active {color: black; text-decoration: none;} 

	th{
		background-color: #F7F5F8;
	}   
	
	#paging {
		color: black;
		text-decoration: none; 
		cursor: pointer;
	} 
	
	#currentpaging {
		color: #5f0080;   
		text-decoration: none;   
		cursor: pointer;  
	}	
	
	td{
		border-bottom: 1px solid #e5e5e5; 
	}
</style> 

<table width="1200px" cellpadding="15" style="border-top: 2px solid #5f0080; font-size: 12px; border-collapse: collapse;"> 
		<tr>  
		<td align="center">
			글번호
		</td> 
		    
		<td style="width: 560px;">  
			글제목
		</td>
		  
		<td align="center"> 
		 	글쓴이
		</td>  		
		    
		<td align="center">   
			작성일 	 	 
		</td>				
	</tr>	 
<c:forEach var="i" items="${boardList }"> 
	<tr>  
		<td align="center">
		${i.boardNum }  
		</td> 
		    
		<td style="width: 560px;">  
		<a class="subject" href="/board/boardView?seq=${i.boardNum}">${i.boardSubject }</a>
		</td>
		  
		<td align="center"> 
		${i.memberId } 
		</td>   
		
		    
		<td align="center">   
		${i.boardDate}	   	 	 
		</td>				
	</tr>	 
</c:forEach> 
<form id="BoardListForm" name="BoardListForm">
</table>  
	<input type="hidden" name="pg" value="${pg }">
	<div align="center" id="pagingDiv">${boardPaging.pagingHTML}</div>    
	<table>
	<tr><td valign="middle"> 
	<select name="searchOption" id="searchOption" style="width: 80px; height:30px;">  
				<option value="boardSubject">제목
				<option value="memberId">아이디 
	</select>        
	<input type="text" valign="center" id="keyword" name="keyword" style="height:30px; ">   
	<!-- <img align="top" src="../resources/images/bg.jpg" id="searchBtn" name="searchBtn" style="height:35px; cursor: pointer;"> -->  
	<input type="button" id="search" name="search" value="검색"> 
	</td></tr>
	</table>
</form>

<script type="text/javascript">  
function boardPaging(pg){   
	location.href='boardList?pg='+pg;	 
} 
 
  
$('#search').click(function(event){    
	document.BoardListForm.method = 'GET';
	document.BoardListForm.action = '/board/boardListSearch'; 
	document.BoardListForm.submit();  
});   
  
function boardSearch(pg){   
	$('#pg').val(pg);  
	$('#searchBtn').trigger('click');	   
} 

$("#keyword").keydown(function (key) { 
    if (key.keyCode == 13) { // 엔터키면
        $("#searchBtn").focus(); // 암호에 포커스 
    }
}); 
</script>



	
	

