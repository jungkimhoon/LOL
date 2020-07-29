<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
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
          <li class="nav-item active">
            <a class="nav-link" href="/main/main">메인
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/member/loginForm">로그인</a>
          </li>                    
           <li class="nav-item dropdown">
             <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
               	커뮤니티
             </a>
             <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
               <a class="dropdown-item" href="#">게시판</a>
               <a class="dropdown-item" href="#">글쓰기</a>               
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

