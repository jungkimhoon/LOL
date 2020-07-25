<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style type="text/css">
	.searchDiv { 
		margin: auto 0px; 
	} 
	
	#myCarousel{
		height: 800px;
	}
	.carousel-control {background: none !important; }
}

</style>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
                       
<div>  
<div class="searchDiv" align="center">
<form name="searchIdForm">
<input type="text" name="searchId" placeholder="소환사 명..." style="width:460px; height:40px; padding: 0 9px;">
<button id="searchBtn" style="width:100px; height:35px;">검색</button>   
</form> 
</div></div>

<div class="container"> 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="/resources/images/thresh.png" style="width:100%; height:700px;">
      </div>

      <div class="item">
        <img src="/resources/images/akali.png" alt="Chicago" style="width:100%; height:700px;">
      </div>
    
      <div class="item">
        <img src="/resources/images/reona.png" alt="New york" style="width:100%; height:700px;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

	<img src="http://ddragon.leagueoflegends.com/cdn/6.24.1/img/profileicon/588.png"> 

<script type="text/javascript">   
$('.carousel').carousel({
  interval: 2000
});

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

