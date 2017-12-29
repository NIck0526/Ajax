<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function registerData() {
		var f = document.registerForm; 
		if(f.id.value==""){
			alert("아이디를 입력하세여");
			return false;
		}if(f.password.value==""){
			alert("패스워드를 입력하세여");
			return false;
		}if(f.name.value==""){
			alert("이름을 입력하세여");
			return false;
		}if(f.address.value==""){
			alert("주소를 입력하세여");
			return false;
		}
		
		if(checkFlag==false){
			alert("아이디 중복 확인부터 하세여");
			return false;
		}
	}//registerData	
	var xhr;
	function checkId() {
		xhr = new XMLHttpRequest();
		var id = document.getElementById("memberId").value;
		xhr.onreadystatechange = callback;
		
		xhr.open("post","DispatcherServlet");
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded;charset=utf-8");
		xhr.send("command=idCheck&&id="+id);
	}//checkId
	function callback() {
		if(xhr.readyState==4){
			if(xhr.status==200){
				var flag = xhr.responseText;
				var checkResult = document.getElementById("checkResult");
				
				if(flag=="true"){
					checkResult.innerHTML=
						"<font color= red size=5><b>Can't use ::"+document.registerForm.id.value+"</b></font>";	
				}//if
				else{
					checkResult.innerHTML=
						"<font color= green size=5><b>welcome ::"+document.registerForm.id.value+"</b></font>";	
				}//else
			}
		}
		
	}
</script>
</head>
<body>
<h2 align="center">Member Register Form...</h2><p>
<form action="DispatcherServlet" method="post" name="registerForm" onsubmit="return registerData()">
아이디 : <input type="text" name="id" id="memberId">
<input type="button" value="중복확인" onclick="checkId()">
<span id="checkResult"></span><br><br>
패스워드 : <input type="password" name="password"><br><br>
이름 : <input type="text" name="name" ><br><br>
주소 : <input type="text" name="address" ><br><br>
<input type="submit" value="회원등록">
<input type="hidden" name="command" value="register">
</form>
</body>
</html>











