<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head> 

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark navbar-fixed-top">
    <div class="container">     
      <a class="navbar-brand" href="/main/main">전적 검색</a>    
  
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <form name="searchIdForm"> 
<input type="text" name="searchId" placeholder="소환사 명..." style="width:460px; height:40px; padding: 0 9px;">
<button id="searchBtn" style="width:100px; height:35px;">검색</button>   
</form> 
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <c:if test="${memberId != null }">
      	  <li class="nav-item active">
            <a class="nav-link" href="#">${memberId }님
              <span class="sr-only">(current)</span>
            </a>
         </li>
   		 </c:if>
          <li class="nav-item active">
            <a class="nav-link" href="/main/main">메인
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
          	<c:if test="${memberId == null }">
            	<a class="nav-link" href="/member/loginForm">로그인</a>
            </c:if>
            <c:if test="${memberId != null }">
            	<a class="nav-link" href="/member/logout">로그아웃</a>
            </c:if>
          </li>                    
           <li class="nav-item dropdown">
             <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
               	커뮤니티
             </a>
             <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
               <a class="dropdown-item" href="/board/boardList">게시판</a>
               <a class="dropdown-item" href="/board/boardWriteForm">글쓰기</a>               
             </div>
            </li>
        </ul>
      </div>
    </div>
  </nav>


  <!-- Bootstrap core JavaScript -->
  <script src="../vendor/jquery/jquery.slim.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">   
$('#searchBtn').click(function(){	
	if($('input[name=searchId]').val()==''){
		
	}else{
		/* $.ajax({  
			type : 'GET',
			url : 'https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/배꼽때?api_key=RGAPI-8a72924c-702a-4798-83c6-0857b2e32097',
				success : function(data){
					alert(data.name);				 
			}
		});   */
		document.searchIdForm.method = 'get'; 
		document.searchIdForm.action = '/search/searchSummoner';
		document.searchIdForm.submit();
	}
}); 


</script> 
</body>
</html>

