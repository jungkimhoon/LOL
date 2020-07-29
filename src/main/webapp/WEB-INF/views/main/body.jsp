<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   	<div style="width:80%; margin: 0 auto;" align="center">
   	<h1>이번주 로테이션 챔피언</h1>
	<c:forEach var="imgName" items="${imgName}">
		<img src="https://ddragon.leagueoflegends.com/cdn/10.6.1/img/champion/${imgName }.png" width="70" height="70" title="${imgName }" style="cursor: pointer;">
	</c:forEach>
	</div>   

<br>
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

	<br>

	
<script type="text/javascript">   
$('.carousel').carousel({
  interval: 2000
}); 
</script> 

