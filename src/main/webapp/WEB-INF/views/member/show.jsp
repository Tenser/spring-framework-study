<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.jiyoung.member.*" import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>showMember</title>
</head>
<body>
	<table border="1">
        <th>아이디</th>
        <th>비번</th>
        <th>이름</th>
        <th>폰번호</th>
        <c:forEach items="${ list }" var="dto">
        <tr>
        <td>${ dto.id }</td><td>${ dto.password }</td><td>${ dto.name }</td><td>${ dto.phone }</td><td><a href="delete?id=${ dto.id }">삭제</a></td>
        <tr>
        </c:forEach>
	</table>
	<br>
	<a href="/cex">돌아가기</a>
</body>
</html>