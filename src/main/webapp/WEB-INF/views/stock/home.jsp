<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="stock/search" method="get">
	<input type="text" name="word"> <input type="submit" value="검색"> <br>
	</form>
	<br>
	<a href='stock/divide'>상승 하강 종목 보기</a>
	<br>
	<br>
	<a href='stock/recommend'>추천주 보기</a>
	<br>
	<c:forEach items="${ list }" var="stock">
		${ stock.code }<br>${ stock.name }<br>${ stock.today_price }<br>${ stock.next_price }<br>${ stock.accuracy }<br><a href="/hello/stock/delete.do?code=${ stock.code }">삭제</a><br><br>
	</c:forEach>
</body>
</html>