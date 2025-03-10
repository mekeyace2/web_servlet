<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Controller에서 session을 받은 후 해당 session값을 문자열로 변환 후 HTML에 출력
	HttpSession se = (HttpSession)request.getAttribute("se");
	String userid = (String)se.getAttribute("id");
	String usernm = (String)se.getAttribute("name");
	String usertel = (String)se.getAttribute("tel");
	if(userid == null){
		out.print("<script> alert('로그인 하셔야만 됩니다.'); location.href='./login.html';</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 정보 출력</title>
</head>
<body>
<%=usernm%>님 환영합니다. <input type="button" value="로그아웃" onclick="logout()">
<br>
아이디 : <%=userid%><br>
연락처 : <%=usertel%>
</body>
<script>
function logout(){
	if(confirm("로그아웃 하시겠습니까?")){
		location.href="./session3.do";	
	}
}
</script>






</html>