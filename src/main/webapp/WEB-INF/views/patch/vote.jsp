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
	body{
		background: gray;
	}
	body #vote{
		position: absolute; top: 20%; left: 20%;
		width: 60%;
		background: white;
		padding: 20px 10px;
	}
	#vote .query{
		position: relative;
	}
	.radio{
		
	}
	form #finish{
		margin-left: 40%;
		width: 20%;
		height: 40px;
		border: 0px;
		background: gray;
	}
	#vote #black{
		position: relative;
		background: green;
		height: 100px;
	}
</style>
<script>
	function radioClick(name, num){
		var names = document.getElementsByClassName(name);
		for(var i=0;i<names.length;i++){
			if(i != num && names[i].checked == true){
				names[i].checked = false;
			}
		}
	}
	function btClick(){
		var form = document.vote;
		if(form.power1.value == "" || form.power2.value == "" || form.power3.value == "" || form.power4.value == "" || form.power5.value == "" || form.favorite.value == ""){
			alert("empty!");
			return;
		}
		form.submit();
	}
</script>
<body>
	<form name="vote" action="vote.do" method="post" id="vote">
	<div class="query">
	<h3>1. 1등</h3>
	<div class="radio">
	<c:forEach items="${ list }" var="dto">
		<input type="radio" name="power1" value="${ dto.name }" class="${ dto.name }" onclick="radioClick('${ dto.name }', 0)" >${ dto.name }
	</c:forEach>
	</div>
	</div>
	<br><br>
	<div class="query">
	<h3>2. 2등</h3>
	<div class="radio">
	<c:forEach items="${ list }" var="dto">
		<input type="radio" name="power2" value="${ dto.name }" class="${ dto.name }" onclick="radioClick('${ dto.name }', 1)">${ dto.name }
	</c:forEach>
	</div>
	</div>
	<br><br>
	<div class="query">
	<h3>3. 3등</h3>
	<div class="radio">
	<c:forEach items="${ list }" var="dto">
		<input type="radio" name="power3" value="${ dto.name }" class="${ dto.name }" onclick="radioClick('${ dto.name }', 2)">${ dto.name }
	</c:forEach>
	</div>
	</div>
	<br><br>
	<div class="query">
	<h3>4. 4등</h3>
	<div class="radio">
	<c:forEach items="${ list }" var="dto">
		<input type="radio" name="power4" value="${ dto.name }" class="${ dto.name }" onclick="radioClick('${ dto.name }', 3)">${ dto.name }
	</c:forEach>
	</div>
	</div>
	<br><br>
	<div class="query">
	<h3>5. 5등</h3>
	<div class="radio">
	<c:forEach items="${ list }" var="dto">
		<input type="radio" name="power5" value="${ dto.name }" class="${ dto.name }" onclick="radioClick('${ dto.name }', 4)">${ dto.name }
	</c:forEach>
	</div>
	</div>
	<br><br>
	<div class="query">
	<h3>6. 6등</h3>
	<div class="radio">
	<c:forEach items="${ list }" var="dto">
		<input type="radio" name="power6" value="${ dto.name }" class="${ dto.name }" onclick="radioClick('${ dto.name }', 5)">${ dto.name }
	</c:forEach>
	</div>
	</div>
	<br><br>
	<div class="query">
	<h3>7. 7등</h3>
	<div class="radio">
	<c:forEach items="${ list }" var="dto">
		<input type="radio" name="power7" value="${ dto.name }" class="${ dto.name }" onclick="radioClick('${ dto.name }', 6)">${ dto.name }
	</c:forEach>
	</div>
	</div>
	<br><br>
	<div class="query">
	<h3>8. 인기투표</h3>
	<div class="radio">
	<c:forEach items="${ list }" var="dto">
		<input type="radio" name="favorite" value="${ dto.name }">${ dto.name }
	</c:forEach>
	</div>
	</div>
	<br><br><br>
	<input type="button" value="제출" onclick="btClick()" id="finish">
	<br><br><br><br><br>
	<!-- <div id="black"></div> -->
	</form>
</body>
</html>