<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${summonerDTO.profileIconId } = profileIconId <br>
${summonerDTO.name } = name<br>
${summonerDTO.puuid } = puuid<br>
${summonerDTO.summonerLevel } = summonerLevel<br>
${summonerDTO.revisionDate } = revisionDate<br>
${summonerDTO.id } = id<br>
${summonerDTO.accountId } = accountId<br>

${wow }
</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">   
$(document).ready(function(){
	$.ajax({ 
		type : 'get',
		url : 'https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/${summonerDTO.id}?api_key=RGAPI-8a72924c-702a-4798-83c6-0857b2e32097',
 		success : function(data){
			alert(JSON.stringify(data));	
			${wow} = "안녕";
		}
	});     		
});

</script> 