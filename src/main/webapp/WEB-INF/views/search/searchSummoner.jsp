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
<c:if test="${!matches.win}">
	<div style="background-color:#e2b6b3; height:100px; width:70%; margin:0 auto;">
</c:if>
<c:if test="${matches.win}">
	<div style="background-color:#a3cfec; height:100px; width:70%; margin:0 auto;">
</c:if> 
		
		<div style="float: left; width:100px;">&nbsp;</div>
		<div style="float: left; height:70px">
			<div style="height:17px"></div>
			<img src="https://ddragon.leagueoflegends.com/cdn/10.6.1/img/champion/${matches.championName }.png" width="65" height="65">
		</div>
		<div style="float: left; width:40px;">
			<div style="height:17px"></div>
			<img src="https://ddragon.leagueoflegends.com/cdn/10.15.1/img/spell/${matches.spell1Id }.png" width="30px" height="30px"> 
			<div style="height:5px;"></div>
			<img src="https://ddragon.leagueoflegends.com/cdn/10.15.1/img/spell/${matches.spell2Id }.png" width="30px" height="30px">
		</div>
		 
		<div style="float: left; width:70px;">&nbsp;</div>
		<div style="float: left; width:150px; font-size: 10pt;">
			<div style="height:17px;"></div>
			<c:if test="${!matches.win}"> 
				패배<br>
			</c:if>
			<c:if test="${matches.win}">
				승리<br>
			</c:if>
			
			<font style="font-size: 12pt; font-weight: bold;"> ${matches.kills } / ${matches.deaths } / ${matches.assists } <br></font>
			<c:if test="${matches.deaths != 0}">
				<fmt:formatNumber var="kda" value="${(matches.kills+matches.assists+0.00)/(matches.deaths+0.00)}" pattern="0.00"/>
				KDA : ${kda }  
			</c:if> 
			<c:if test="${matches.deaths == 0}">
				<c:if test="${matches.kills > 0  || matches.assists > 0}">
					KDA : perfect
				</c:if>
				<c:if test="${matches.kills == 0  && matches.assists == 0}">
					KDA : 0.00
				</c:if>
			</c:if>
			
		</div>
			<div style="height: 35px;"></div>
		<c:forTokens var="item" items="${matches.item0 },${matches.item1 },${matches.item2 },${matches.item3 },${matches.item4 },${matches.item5 },${matches.item6 }" delims=",">
		
			<c:if test="${item != '0'}">
			<div style="float:left;">
				<img src="https://ddragon.leagueoflegends.com/cdn/10.15.1/img/item/${item }.png" width="30px" height="30px" title="${item }">
			</div>
			</c:if>
			<c:if test="${item == '0'}">
				<div style="background-color: black; width:30px; height:30px; float:left;"> </div> 
			</c:if>	   
		
		</c:forTokens>
	</div> 


	<div style="height:10px"></div>
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