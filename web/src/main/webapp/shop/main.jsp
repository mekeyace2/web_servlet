<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//out.print 적용했을 때 null 출력이 될 경우(session) => 연산기호
	HttpSession hs = request.getSession();
	String mid = (String)hs.getAttribute("mid");
	String mnm = (String)hs.getAttribute("mnm");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 메인 화면</title>
</head>
<body>
<% if(mid == null || mnm == null){ //session에 값이 없을 경우 %>
<input type="button" value="로그인">
<% } else { //Controller에서 정상적으로 로그인을 하여 session이 적용 되었을 경우%>
[<%=mid%>] <%=mnm%> 님 환영합니다. <input type="button" value="로그아웃" onclick="logout()">
<% } %>
</body>
<script>
function logout(){
	location.href='./logout.jsp';
}
</script>


</html>