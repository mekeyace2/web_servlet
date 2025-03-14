<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<ArrayList<String>> all = (ArrayList)request.getAttribute("all");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품리스트 출력 파트</title>
<style>
s {
color: red;
}
</style>
</head>
<body>
<table>
<tbody>
<%
int w = 0;
while(w < all.size()){
	//숫자만 적용됨(문자X)
	DecimalFormat df = new DecimalFormat("###,###");
%>
<tr onclick="product_view('<%=all.get(w).get(0)%>')">
<td><img src=".<%=all.get(w).get(6)%>"></td>
<td>상품명 : <%=all.get(w).get(2)%></td>

<td>
<% if(all.get(w).get(4).intern() == "0") { %>
상품금액 : <%=df.format(Integer.parseInt(all.get(w).get(3)))%> 원
<% } else { %>
<s>상품금액 : <%=df.format(Integer.parseInt(all.get(w).get(3)))%> 원</s>
<% } %>
</td>

<% if(all.get(w).get(4).intern() != "0") { %>
<td>할인율 : <%=all.get(w).get(4)%> %</td>
<td>할인금액 : <%=df.format(Integer.parseInt(all.get(w).get(5)))%> 원</td>
<% } %>
</tr>
<%
	w++;
}
%>
</tbody>
</table>
<script>
//SPA => React, Vue, ECMA
function product_view(midx){
	location.href='./product_list.do?midx='+midx;
}
</script>

</body>
</html>