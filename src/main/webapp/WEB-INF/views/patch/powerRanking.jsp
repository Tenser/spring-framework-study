<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>영등포구 셔틀패치</title>
</head>
<style>
	#ranking{
		margin: 0px auto;
		padding: 0px;
		width: 500px;
		background: gray;
	}
	#on{
		margin: 0px;
		border: 1px solid #bcbcbc;
		padding: 0px;
		height: 60px;
		text-align: center;
		line-height: 60px;
		font-size: 30px;
		background: blue;
	}
	.person{
		position: relative;
		margin: 0px;
		border: 1px solid #bcbcbc;
		padding: 0px;
		height: 120px;
	}
	.link{
		text-decoration: none;
	}
	.person .rank{
		position: absolute;
		left: 0px;
		top: 0px;
		height: 100%;
		width: 30px;
		text-align: center;
		background: yellow;
		line-height: 120px;
	}
	.person img{
		position: absolute;
		left: 30px;
		top: 0px;
		height: 100%;
	}
	.person .name{
		position: absolute;
		left: 150px;
		top: 10px;
		width: 150px;
		text-align: center;
		font-size: 40px;
		color: black;
	}
	.person .school{
		position: absolute;
		left: 170px;
		top: 70px;
		width: 50px;
		text-align: center;
		font-size: 15px;
		color: #92B3B7;
	}
	.person .point{
		position: absolute;
		right: 0px;
		top: 0px;
		width: 100px;
		height: 100%;
		text-align: center;
		line-height: 120px;
	}
	.person .more{
		position: absolute;
		right: 5px;
		top: 5px;
		width: 65px;
		height: 20px;
		border: 1px solid black; 
		border-radius: 5px;
		font-size: 10px;
		background: gray;
	}
	.person .more:hover{
		cursor: pointer;
	}
	body #btzone{
		margin: 0px auto;
		text-align: center;
	}
	#btzone .bts{
		margin: 0px 15px; 
		width: 100px;
		height: 40px;
	}
	#btzone .bts:hover{
		cursor: pointer;
	}
	#back{
		background: green;
	}
	#popularity{
		background: green;
	}
</style>
<script>
	function goBack(){
		location.href="/patch";
	}
	function goPopularity(){
		location.href="popularity";
	}
	function goInfo(name){
		location.href="info?name="+name;
	}
</script>
<body>
	<% int rank = 1; %>
	<div id="ranking">
		<div id="on">
			랭킹
		</div>
		<c:forEach items="${ list }" var="dto">
			<div class="person">
				<div class="rank"><%= rank++ %></div>
				<a href="info?name=${ dto.name }" class="link">
				<img src="/hello/resources/heros/${ dto.image_one }.jpg" width="120px">
				<div class="name">${ dto.name }</div></a>
				<div class="school">${ dto.school }</div>
				<div class="point">Point: ${ dto.power }</div>
				<input type="button" class="more" onclick="goInfo('${ dto.name }')" value="자세히 보기">
			</div>
		</c:forEach>
	</div>
	<br>
	<div id="btzone">
	<input type="button" id="back" class="bts" onclick="goBack()" value="홈으로">
	<input type="button" id="popularity" class="bts" onclick="goPopularity()" value="인기순위 보기"> 
	</div>
</body>
</html>