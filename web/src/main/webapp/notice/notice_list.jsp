<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<ArrayList<String>> notice = (ArrayList<ArrayList<String>>)request.getAttribute("result");
//페이지 번호 생성
/* 
페이징 생성방법
1. 한 페이지당 몇개씩 데이터를 출력할 것인지를 설정합니다.
2. 데이터베이스에 있는 데이터의 총 갯수 / 한페이지당 갯수 (소수점)
3. Math.ceil 사용하는 이유는 1.1 1.6 => 반올림으로 페이지가 추가 되도록 합니다.
*/
String total_page = notice.get(0).get(5);
int pg = 1;
if(total_page != null || !total_page.equals(null)){
	float pg2 = Integer.parseInt(total_page) / 3f;
	pg = (int)Math.ceil(pg2); 
}

/*
get page번호를 가져오는 방식
최초 공지사항 리스트 페이지에 접근시 페이지 번호가 없을 수 있음 또는 
페이지번호가 1을 클릭했을 경우
*/
String pno = request.getParameter("pageno");
if(pno == null || pno.equals("1")){
	pno = "1";
}
%>
<!-- View -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 리스트</title>
</head>
<body>
<p>현재 등록된 게시물 : <%=notice.get(0).get(5)%></p>
<table border="1" cellpadding="0" cellspacing="0">
<thead>
	<tr>
		<th width="50">번호</th>
		<th width="500">제목</th>
		<th width="100">글쓴이</th>
		<th width="100">조회</th>
		<th width="150">등록일</th>
	</tr>
</thead>
<tbody>
<%
	int f;
	//리스트 출력 번호를 총 데이터 갯수로 처리
	//총 데이터 갯수 - ((페이지번호 - 1) * 한페이지당 출력갯수)
	int total = Integer.parseInt(total_page) - ((Integer.parseInt(pno)-1) * 3);	
	for(f=0; f<notice.size(); f++){
%>
	<tr height="30" align="center">
		<td><%=total%></td>
		<td align="left" onclick="notice_view('<%=notice.get(f).get(0)%>')"><%=notice.get(f).get(1)%></td>
		<td><%=notice.get(f).get(2)%></td>
		<td><%=notice.get(f).get(3)%></td>
		<td><%=notice.get(f).get(4).substring(0,10)%></td>
	</tr>
<%
	total--;
	}
%>	
</tbody>
</table>
<br><br><br>
<table border="1">
<tr>
<% 
	int w = 1;
	while(w <= pg){
%>
<td width=20 height=20 align="center"><a href="./notice_list.do?pageno=<%=w%>"><%=w%></a></td>
<%
	w++;
	}
%>
</tr>
</table>
</body>
<script>
function notice_view(no){
	//해당 게시물의 내용 및 첨부파일을 확인 할 수 있는 view 페이지
	location.href='./notice_view.do?nidx='+no;
}

</script>




</html>