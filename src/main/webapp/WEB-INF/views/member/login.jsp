<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login</title>
</head>
<style>
    body{
        text-align: center;
        align-items: center;
        background-color: gray;
    }
    form{
    	margin: 0 auto;
    	margin-top: 200px;
    	text-align: center;
        background-color: black;
        width: 200px;
        padding-top:25px;
        padding-bottom:25px;
        border: 1px solid blue;
    }
    .items{
    	width: 150px;
    	height: 25px;
    	margin-top: 12px;
    	margin-bottom: 12px;
    	font-size: 12.5px;
    	border: 0px;
    }
    #bgm{
        	position: fixed;
        	left: 0px;
        	top: 0px;
        	width: 100px;
        	height: 60px;
        }
</style>
<script>
	function btClick(){
		var form = document.login;
		if(form.id.value == ""){
			alert("아이디를 입력해주세요");
			return;
		}else if(form.password.value == ""){
			alert("비밀번호를 입력해주세요");
			return;
		}else{
			form.submit();
		}
	}
	function goSignupForm(){
		location.href = "signup";
	}
	function goHome(){
		location.href = "/hello/patch";
	}
</script>
<body>
	<form name="login" action="loginCheck" method="POST">
		<input type="text" name="id" class="items"/><br>
		<input type="password" name="password" class="items"/><br>
		<input type="button" value="로그인" onclick="btClick()" class="items" style="background-color: gray;"><br>
		<input type="button" value="회원가입" onclick="goSignupForm()" class="items" style="background-color: gray;"><br>
		<input type="button" value="비회원" onclick="goHome()" class="items" style="background-color: gray;"><br>
	</form>
	<!-- <embed id="bgm" src="bgm/first_step.mp3" autostart="true" loop="true" volume="100"> -->
</body>
</html>