<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>signup</title>
</head>
<style>
	body{
		background: gray;
	}
    form{
        
        background: white;
        border: 1px solid blue;
        margin: 0 auto;
    	margin-top: 200px;
        width: 340px;
    }
    form .item{
    	margin-top: 10%;
    	margin-botton: 10%;
    	margin-left: 15%;
    	border: 0px;
    	font-size: 14px;
    }
    .label{
    	font-size: 10px;
    }
</style>
<script>
	function signup(){
		var form = document.join;
		if(form.id.value == "이거먼저->"){
			alert("중복확인 ㄱㄱ");
			return;
		}else if(form.password.value == ""){
			alert("비밀번호를 입력하세요.");
			return;
		}else if(form.name.value == ""){
			alert("이름을 입력하세요.");
			return;
		}else if(form.phone.value == ""){
			alert("전화번호를 입력하세요.");
			return;
		}
		form.submit();
	}
	function check(){
		location.href="idCheckForm";
	}
</script>
<body>
	<form action="join" method="POST" name="join">
		<div class="item"><div class="label">아이디</div><input type="text" name="id" value="${ res }" readonly/>&nbsp;<input type="button" onclick="check()" value="중복확인"></div>
		<div class="item"><div class="label">비밀번호</div><input type="password" name="password"/></div>
		<div class="item"><div class="label">이름</div><input type="text" name="name"/></div>
		<div class="item"><div class="label">전화번호</div><input type="text" name="phone"/></div>
		<div class="item"><input type="button" value="SignUp" onclick="signup()"></div>
		<div class="item"><a href="login" class="view" style="color:black">돌아가기</a></div>
		<br><br>
	</form>
	<!-- <embed id="bgm" src="bgm/first_step.mp3" autostart="true" loop="true" volume="100"> -->
</body>
</html>