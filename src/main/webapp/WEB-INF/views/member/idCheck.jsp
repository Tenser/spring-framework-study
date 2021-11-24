<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>idCheck</title>
</head>
<style>
	body #forms{
		margin-top: 18%;
		margin-left: 43%;
	}
</style>
<script type="text/javascript">
	function check(){
		var form = document.idCheck;
		if(form.id.value == ""){
			alert("아이디를 입력하세요.");
			return;
		}
		form.submit();
	}
</script>
<body>
	<div id="forms">
	<form action="idCheck" method="get" name="idCheck">
		<input type="text" name="id" value=${ res }>&nbsp;<input type="button" value="중복 확인" onclick="check()"><br>
		${ msg }
	</form>
	<form action="signup" method="get">
		<input type="hidden" name="res" value=${ res }>
		<c:if test="${ msg eq '사용가능' }">
		<input type="submit" value="사용">
		</c:if>
	</form>
	</div>
</body>
</html>