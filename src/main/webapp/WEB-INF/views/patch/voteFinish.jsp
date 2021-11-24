<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>영등포구 셔틀패치</title>
</head>
<style>
	body{
		background: white;
		text-align: center;
	}
	body #thanks{
		background: white;
		font-size: 50px;
	}
	#thanks #homeBtn{
		background: green;
		width: 100px;
		height: 40px;
		border: 0px;
		border-radius: 20px;
	}
</style>
<script>
	function goHome(){
		location.href="/hello/patch"
	}
</script>
<body>
<div id="thanks">Good<br><br><input type="button" onclick="goHome()" value="홈으로" id="homeBtn"><br><br></div>
</body>
</html>