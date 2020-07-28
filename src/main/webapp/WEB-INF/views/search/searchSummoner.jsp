<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>사용자정보</h1>
<h3>${summonerDTO.name }</h3>
<img src="http://ddragon.leagueoflegends.com/cdn/10.6.1/img/profileicon/${summonerDTO.profileIconId }.png" width="100" height="100"><br>
<c:if test="${leagueEntryDTO.queueType eq 'RANKED_SOLO_5x5'}">솔로랭크<br></c:if>
<c:if test="${leagueEntryDTO.queueType eq 'RANKED_TEAM_5x5'}">5:5랭크<br></c:if>
${leagueEntryDTO.tier } ${leagueEntryDTO.rank }<br>
${leagueEntryDTO.leaguePoints } LP<br>
${leagueEntryDTO.wins }승 ${leagueEntryDTO.losses }패<br>
<fmt:parseNumber var="winRate" value="${leagueEntryDTO.wins / (leagueEntryDTO.losses + leagueEntryDTO.wins) * 100 }" integerOnly="true"/>
승률 : ${winRate }%<br> 
<img src="/resources/images/ranked-emblems/Emblem_${leagueEntryDTO.tier}.png" width="100">

<h1>최근 전적 (20게임)</h1>

<c:forEach var="matches" items="${matchlistDTO.matches}">
		<img src="https://ddragon.leagueoflegends.com/cdn/10.6.1/img/champion/${matches.championName }.png" width="70" height="70">
		${matches.gameId }&emsp;<br>
		${matches.role }&emsp;<br>
		${matches.season }&emsp;<br>
		${matches.platformId }&emsp;<br>
		${matches.championName }&emsp;<br>
		${matches.queue }&emsp;<br>
		${matches.lane }&emsp;<br>
		${matches.timestamp }&emsp;<br>
		<c:if test="${matches.win}">승리</c:if>
		<c:if test="${!matches.win}">패배</c:if><br>
		${matches.kills } / ${matches.assists } / ${matches.deaths } <br>
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