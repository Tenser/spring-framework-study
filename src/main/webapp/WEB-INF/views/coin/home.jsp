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
������: <input type="text" name="upline"><br>
1�� �ż���: <input type="text" name="downline1"><br>
2�� �ż���: <input type="text" name="downline2"><br>
������: <input type="text" name="discard"><br>
sign1 <input type="checkbox" name="sign1" value="sign1"><br>
sign2 <input type="checkbox" name="sign2" value="sign2"><br>
<input type="submit" value="����">
</form><br>

<form action="start2"  method="GET">
market: <input type="text" name="market" value="PCI"><br>
������: <input type="text" name="high"><br>
����: <input type="text" name="importance"><br>
<input type="submit" value="����">
</form><br>

<form action="start3"  method="GET">
market: <input type="text" name="market" value="XRP"><br>
�ϻ�����: <input type="text" name="book_size"><br>
����: <input type="text" name="bid_high"><br>
�ŵ�����: <input type="text" name="ask_standard"><br>
�ż����� ��: <input type="text" name="bid_range_up"><br>
�ż����� �Ʒ�: <input type="text" name="bid_range_down"><br>
����: <input type="text" name="importance"><br>
�����ð�: <input type="text" name="sleep_time"><br>
<input type="submit" value="����">
</form><br>

<form action="start4"  method="GET">
market: <input type="text" name="market" value="HUM"><br>
�к�����: <input type="text" name="minute" value="15"><br>
��������: <input type="text" name="cell_point1"><br>
��������: <input type="text" name="cell_point2"><br>
����: <input type="text" name="importance"><br>
�����ð�: <input type="text" name="sleep_time"><br>
<input type="submit" value="����">
</form><br>XRP

<a href="home">����</a>
</body>
</html>