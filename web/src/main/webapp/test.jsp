<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String name = "홍길동";
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
고객명 : <input type="text" name="mname" value="<%=name%>" readonly>
</body>
<script>
var username = "<%=name%>";
console.log(username);
</script>


</html>