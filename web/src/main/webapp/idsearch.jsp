<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Controller에서 데이터를 값을 이관하는 형태
	String result = (String)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 검색결과</title>
</head>
<body>
아이디 : <%=result%> 
</body>
</html>