<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="start"  method="GET">
market: <input type="text" name="market" value="XRP"><br>
익절가: <input type="text" name="upline"><br>
1차 매수가: <input type="text" name="downline1"><br>
2차 매수가: <input type="text" name="downline2"><br>
손절가: <input type="text" name="discard"><br>
sign1 <input type="checkbox" name="sign1" value="sign1"><br>
sign2 <input type="checkbox" name="sign2" value="sign2"><br>
<input type="submit" value="시작">
</form><br>

<form action="start2"  method="GET">
market: <input type="text" name="market" value="PCI"><br>
전고점: <input type="text" name="high"><br>
비중: <input type="text" name="importance"><br>
<input type="submit" value="시작">
</form><br>

<form action="start3"  method="GET">
market: <input type="text" name="market" value="XRP"><br>
북사이즈: <input type="text" name="book_size"><br>
정상: <input type="text" name="bid_high"><br>
매도기준: <input type="text" name="ask_standard"><br>
매수범위 위: <input type="text" name="bid_range_up"><br>
매수범위 아래: <input type="text" name="bid_range_down"><br>
비중: <input type="text" name="importance"><br>
지연시간: <input type="text" name="sleep_time"><br>
<input type="submit" value="시작">
</form><br>

<form action="start4"  method="GET">
market: <input type="text" name="market" value="HUM"><br>
분봉단위: <input type="text" name="minute" value="15"><br>
익절비율: <input type="text" name="cell_point1"><br>
손절비율: <input type="text" name="cell_point2"><br>
비중: <input type="text" name="importance"><br>
지연시간: <input type="text" name="sleep_time"><br>
<input type="submit" value="시작">
</form><br>XRP

<a href="home">종료</a>
</body>
</html>