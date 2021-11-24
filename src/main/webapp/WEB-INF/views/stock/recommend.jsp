<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<br>
	<a href='/hello/stock'>돌아가기</a>
	<br>
	<c:forEach items="${ list }" var="stock">
		${ stock.name }<br>${ stock.accuracy }<br><br><br>
	</c:forEach>
</body>
</html>