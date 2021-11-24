<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>영등포구 셔틀패치</title>
</head>
<body>
<form action="insert.do" method="post">
	이름: <input type="text" name="name"><br>
	학교: <input type="text" name="school"><br>
	힘: <input type="text" name="power" value="0"><br>
	인기도: <input type="text" name="popularity" value="0"><br>
	이미지1: <input type="text" name="image_one"><br>
	이미지2: <input type="text" name="image_two"><br>
	<input type="submit" value="등록">
</form>
</body>
</html>