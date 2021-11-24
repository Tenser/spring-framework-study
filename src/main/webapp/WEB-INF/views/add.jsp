<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="add.do" method="get">
	이름: <input type="text" name="name"><br>
	가격: <input type="text" name="price"><br>
	설명: <input type="text" name="discript"><br>
	종류: <input type="text" name="kind"><br>
	<input type="submit" value="등록"><br>
</form>
<a href="/hello">홈으로</a>
</body>
</html>