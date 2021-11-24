<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>영등포구 셔틀패치</title>
</head>
<style>
	body{
		text-align: center;
	}
	body #logo{
		font-size: 70px;
		margin: 50px;
	}
	body #info{
		position: absolute;
		top: 10%;
		left: 5%;
		border: 1px solid black;
		border-radius: 15px;
		width: 150px;
	}
	body #vote{
		margin: 0px auto;
		background: green;
		width: 150px;
		height: 50px;
		border-radius: 15px;
		text-align: center;
		line-height: 50px;
		color: black;
		text-decoration: none;
	}
	.link{
		text-decoration: none;
	}
	body #ranking{
		margin: 0px auto;
		width: 660px;
	}
	.each{
		float: left;
		margin: 30px;
		width: 270px;
		border-radius: 20px;
	}
	.what{
		text-align: center;
		color: black;
		border: 1px solid #bcbcbc;
		background: blue;
		height: 40px;
		line-height: 40px;
		font-size: 25px;
	}
	.each .items{
		position: relative;
		border: 1px solid #bcbcbc;
		height: 120px;
		background: gray;
	}
	.items .num{
		position: absolute;
		top: 0%;
		left: 0%;
		width: 20px;
		height: 100%;
		line-height: 120px;
		text-align: center;
		background: yellow;
	}
	.items .img{
		position: absolute;
		top: 0%;
		left: 20px;
	}
	.items .name{
		position: absolute;
		top: 0%;
		right: 20px;
		line-height: 120px;
		font-size: 30px;
	}
	.more{
		text-align: center;
		border: 1px solid #bcbcbc;
		background: gray;
		color: black;
		text-decoration: none;
		height: 30px;
		line-height: 30px;
		font-size: 18px;
	}
</style>
<body>
	<div id="logo">영등포구 셔틀패치</div>
	
	<div id="info">
	${ name }님<br>
	<c:if test="${ id ne null }">
	<a href="member/exit" class="link">로그아웃</a><br>
	</c:if>
	<c:if test="${ id eq null }">
	<a href="member/login" class="link">로그인</a><br>
	</c:if>
	</div>
	
	<a href="patch/vote" class="link"><div id="vote">투표하기</div></a>
	
	<div id="ranking">
	<div class="each">
		<a href="patch/powerRanking" class="link"><div class="what">랭킹</div></a>
		<% int num = 1; %>
		<c:forEach items="${ list1 }" var="dto">
		<div class="items">
			<div class="num"><%= num++ %></div>
			<img class="img" src="resources/heros/${ dto.image_one }.jpg" width="120px" height="120px">
			<div class="name">${ dto.name }</div>
		</div>
		</c:forEach>
		<a href="patch/powerRanking" class="link"><div class="more">더보기</div></a>
	</div>
	<div class="each">
		<a href="patch/popularity" class="link"><div class="what">인기 순위</div></a>
		<% num = 1; %>
		<c:forEach items="${ list2 }" var="dto">
		<div class="items">
			<div class="num"><%= num++ %></div>
			<img class="img" src="resources/heros/${ dto.image_two }.jpg" width="120px" height="120px">
			<div class="name">${ dto.name }</div>
		</div>
		</c:forEach>
		<a href="patch/popularity" class="link"><div class="more">더보기</div></a>
	</div>
	</div>
</body>
</html>