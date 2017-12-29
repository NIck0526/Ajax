<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var xhr;

	function startRequest() {
		xhr = new XMLHttpRequest();
		var id = document.getElementById("memberId").value;
		//alert(id);
		xhr.onreadystatechange = callback;
		xhr.open("post","DispatcherServlet");
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		xhr.send("command=findMember&&id="+id);
	}

	function callback() {
		if(xhr.readyState==4){
			if(xhr.status==200){
				var member = xhr.responseText;
				document.getElementById("resultView").innerHTML=
					"<font color= green size=5>"+member+"</font>";	
			}
		}
	}
</script>
</head>
<body>
<h2 align="center">ID LIST INFORMATION...</h2>
<h3 align="center">리스트에서 특정 아이디를 선택해 주세용</h3>
<select id="memberId" onchange="startRequest()">
	<option value="=== id choice ===">=== id choice ===</option>
	<c:forEach items="${list}" var="memId">
		<option value="${memId}">${memId}!</option> 
	
	</c:forEach>

</select>
<span id="resultView"></span>

</body>
</html>