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
<div style="width:1200px; margin: 0 auto;">
<table width="1200px" cellpadding="15" style="border-top: 2px solid black; font-size: 12px; border-collapse: collapse;"> 
		<tr>  
		<td align="center">
			글번호
		</td> 
		    
		<td style="width: 560px; height: 50px;">  
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
		    
		<td style="width: 560px; height: 50px;">  
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
</table>  
<form id="BoardListForm" name="BoardListForm">
<div style="height:50px;"></div>
<div>
	<input type="hidden" name="pg" value="${pg }">
	<div align="center" id="pagingDiv">${boardPaging.pagingHTML}</div>    
</div>

<div style="height:50px;">	
	<div style="float:left; width:500px; height:50px;">
		<select name="searchOption" id="searchOption" style="width: 80px; height:30px;">  
					<option value="boardSubject">제목
					<option value="memberId">아이디 
		</select>        
		<input type="text" valign="center" id="keyword" name="keyword" style="height:30px; ">   
		<!-- <img align="top" src="../resources/images/bg.jpg" id="searchBtn" name="searchBtn" style="height:35px; cursor: pointer;"> -->  
		<input type="button" id="search" name="search" value="검색"> 
	</div>
	<div style="float:left; width:610px;">&nbsp;</div>
	<div style="float:left;">
		<button id="goWrite">글쓰기</button> 
	</div>
</div>

</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">  
function boardPaging(pg){   
	location.href='boardList?pg='+pg;	 
} 

$("#goWrite").click(function(e){
	e.preventDefault();
	location.href='/board/boardWriteForm'; 
});
 
  
$('#search').click(function(){     
	$('#pg').val(1); 
	
	document.BoardListForm.method = 'GET';
	document.BoardListForm.action = '/board/boardListSearch'; 
	document.BoardListForm.submit();  
});   
  
function boardSearch(pg){   
	$('#pg').val(pg);  
	
	document.BoardListForm.method = 'GET';
	document.BoardListForm.action = '/board/boardListSearch';
	document.BoardListForm.submit();     
} 

$("#keyword").keydown(function (key) { 
    if (key.keyCode == 13) { // 엔터키면
        $("#search").focus(); // 암호에 포커스 
    }
}); 
</script>
</div>



	
	

