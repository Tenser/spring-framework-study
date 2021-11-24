<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href='/hello/stock'>돌아가기</a><br>
	reds<br><br>
	<c:forEach items="${ reds }" var="stock">
		${ stock.code }<br>${ stock.name }<br>${ stock.today_price }<br>${ stock.next_price }<br><br><br>
	</c:forEach>
	<br><br>
	blues<br><br>
	<c:forEach items="${ blues }" var="stock">
		${ stock.code }<br>${ stock.name }<br>${ stock.today_price }<br>${ stock.next_price }<br><br><br>
	</c:forEach>
</body>
</html>