<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Home</title>
</head>
<body>
<a href="member/exit">logout</a>

<form action="search" method="get">
<input type="text" name="word"> <input type="submit" value="검색"> <br>
</form>
<h1>
	Hello world!  
</h1>
		<c:forEach items="${ goods }" var="good">
		${ good.num }<br>${ good.name }<br>${ good.price }<br>${ good.kind }<br>${ good.discript }<br><br><br>
		</c:forEach>
<br>
<a href="add">상품 등록</a>
</body>
</html>
