<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div style="height: 200px;">
	<div style="float:left; width:30px;">&nbsp;</div>  
	<div style="float:left;"><img src="http://ddragon.leagueoflegends.com/cdn/10.6.1/img/profileicon/${summonerDTO.profileIconId }.png" width="130px" height="130px"></div>
	
	<div style="float:left; width:15px;">&nbsp;</div>  
	<div style="float:left;"><font style="font-size: 18pt; font-weight: bold;">${summonerDTO.name }</font><br>
	레벨 : ${summonerDTO.summonerLevel }<br>
	랭크 : ${leagueEntryDTO.wins }승 ${leagueEntryDTO.losses }패<br>
	</div> 
	<div style="float:left; width:30px;">&nbsp;</div>  
	<div style="float: left">	
		<img src="/resources/images/ranked-emblems/Emblem_${leagueEntryDTO.tier}.png" width="130px" height="130px">			
	</div> 	 
	<div style="float:left; width:15px;">&nbsp;</div>	
		<c:if test="${leagueEntryDTO.queueType eq 'RANKED_SOLO_5x5'}">솔로랭크<br></c:if>
		<c:if test="${leagueEntryDTO.queueType eq 'RANKED_TEAM_5x5'}">5:5랭크<br></c:if>
		${leagueEntryDTO.tier } ${leagueEntryDTO.rank }<br>
		${leagueEntryDTO.leaguePoints } LP<br> 
		${leagueEntryDTO.wins }승 ${leagueEntryDTO.losses }패<br>
		<%-- <fmt:parseNumber var="winRate" value="${leagueEntryDTO.wins / (leagueEntryDTO.losses + leagueEntryDTO.wins) * 100 }" integerOnly="true"/>
		승률 : ${winRate }%<br>  --%>
</div> 


<div style="height:50px;"></div>


<h1>최근 전적 (20게임)</h1> 

<c:forEach var="matches" items="${matchlistDTO.matches}">
<div style="border: 1px solid red; height:70px;">
	<div style="float: left; width:100px;">&nbsp;</div>
	<div style="float: left; border: 1px solid blue; height:70px"><img src="https://ddragon.leagueoflegends.com/cdn/10.6.1/img/champion/${matches.championName }.png" width="70" height="70"></div>
	<div style="float: left; width:15px;">&nbsp;</div>
	<div style="float: left; height:70px;">
		${matches.championName }&emsp;<br>
		<c:if test="${matches.win}">승리</c:if>
		<c:if test="${!matches.win}">패배</c:if><br>
		${matches.kills } / ${matches.assists } / ${matches.deaths } <br>
	</div>
</div>
</c:forEach> 

<h1>summonerDTO</h1>
${summonerDTO.profileIconId } = profileIconId <br>
${summonerDTO.name } = name<br>
${summonerDTO.puuid } = puuid<br>
${summonerDTO.summonerLevel } = summonerLevel<br>
${summonerDTO.revisionDate } = revisionDate<br>
${summonerDTO.id } = id<br>
${summonerDTO.accountId } = accountId<br>
<br><br>
<h1>leagueEntryDTO</h1>
${leagueEntryDTO.leagueId } = leagueId<br>
${leagueEntryDTO.summonerId } = summonerId<br>
${leagueEntryDTO.summonerName } = summonerName<br>
${leagueEntryDTO.queueType } = queueType<br>
${leagueEntryDTO.tier } = tier<br>
${leagueEntryDTO.rank } = rank<br>
${leagueEntryDTO.leaguePoints } = leaguePoints<br>
${leagueEntryDTO.wins } = wins<br>
${leagueEntryDTO.losses } = losses<br>

<br><br>
</body> 
</html> 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">   


</script> 