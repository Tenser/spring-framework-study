<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="id" value="${ sessionScope.id }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>영등포구 셔틀패치</title>
</head>
<style>
	#info{
		position: relative;
		border: 2px solid #bcbcbc;
		border-radius: 5px;
		margin: 0px auto;
		width: 650px;
		height: 360px;
		background: gray;
	}
	#info #img1{
		position: absolute;
		top: 0px;
		right: 0px;
	}
	#info #img2{
		position: absolute;
		top: 180px;
		right: 0px;
	}
	#info #name{
		position: absolute;
		top: 0px;
		left: 0px;
		font-size: 60px;
	}
	#info #school{
		position: absolute;
		top: 80px;
		left: 75px;
		font-size: 30px;
		color: #92B3B7;
	}
	#info #performance{
		position: absolute;
		left: 0px;
		bottom: 0px;
		font-size: 30px;
	}
	#comments{
		margin: 0px auto;
		padding: 0px;
		width: 1000px;
	}
	.comment{
		position: relative;
		margin: 0px;
		padding: 0px;
		height: 25px;
	}
	.comment .name{
		position: absolute;
		left: 0px;
		font-size: 15px;
		color: #92B3B7;
	}
	.comment .contents{
		position: absolute;
		left: 100px;
		width: 68%;
	}
	.comment .date{
		position: absolute;
		right: 45px;
		color: #92B3B7;
		font-size: 15px;
	}
	.comment .delete{
		position: absolute;
		right: 0px;
		color: black;
	}
	#write{
		position: relative;
		margin: 0px auto;
		padding: 0px;
		width: 1000px;
		height: 130px;
		background: gray;
	}
	#write #writor{
		position: absolute;
		top: 10%;
		left: 1%;
		width: 15%;
		height: 15%;
	}
	#write #phrase{
		position: absolute;
		top: 10%;
		left: 18%;
		width: 80%;
		height: 55%;
		font-size: 20px;
	}
	#write #add{
		position: absolute;
		top: 75%;
		right: 2%;
		width: 8%;
		height: 20%;
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
	#power{
		background: green;
	}
	#popularity{
		background: green;
	}
</style>
<script type="text/javascript">
	function btClick(){
		var form = document.comment;
		if(form.name.value == "" || form.contents.value == ""){
			alert("empty!");
			return;
		}else if(form.contents.value.length > 43){
			alert("too long!");
			return;
		}
		form.submit();
	}
	function goPower(){
		location.href="powerRanking"
	}
	function goPopularity(){
		location.href="popularity"
	}
</script>
<body>
	<div id="info">
	<img src="/hello/resources/heros/${ info.image_one }.jpg" width="180px" height="180px" id="img1"><br>
	<img src="/hello/resources/heros/${ info.image_two }.jpg" width="180px" height="180px" id="img2"><br>
	<div id="name">${ info.name }</div>
	<div id="school">${ info.school }</div>
	<div id="performance">Point: ${ info.power }(${ powerRank }등)<br>
	인기도: ${ info.popularity }표(${ popularityRank }등)</div>
	</div>
	<br><br>
	<div id="comments">
		<hr width="1000px" align="center" size="2px" color="blue">
		<c:forEach items="${ comments }" var="comment">
			<div class=comment>
				<div class="name">${ comment.name }</div>
				<div class="contents">${ comment.contents }</div>
				<div class="date">${ comment.post_date }</div>
				<c:if test="${ id ne null and (id eq 'admin' or id eq comment.id) }">
				<a href="deleteComment.do?num=${ comment.num }&group_name=${ info.name }" class="delete">삭제</a>
				</c:if>
			</div>
			<hr width="1000px" align="center">
		</c:forEach>
	</div>
	
	<br>
	<div id="write">
	<form name="comment" action="addComment.do" method="post">
		<c:if test="${ id eq null }">
		<input type="text" name="name" id="writor">
		</c:if>
		<c:if test="${ id ne null }">
		<input type="text" name="name" id="writor" value="${ name }" readonly>
		</c:if>
		<textarea name="contents" id="phrase"></textarea>
		<input type="hidden" name="group_name" value="${ info.name }"><br>
		<input type="button" value="등록" onclick="btClick()" id="add">
	</form>
	</div>
	<br><br>
	<div id="btzone">
	<input type="button" id="power" class="bts" onclick="goPower()" value="파워랭킹 보기">
	<input type="button" id="popularity" class="bts" onclick="goPopularity()" value="인기순위 보기"> 
	</div>
	<br><br>
</body>
</html>