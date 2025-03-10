<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//getAttribute : Controller에서 setAttribute로 생성된 값을 이관받음
	int total = (int)request.getAttribute("total"); 
	int product_m = (int)request.getAttribute("product_m");
	int product_s = (int)request.getAttribute("product_s");
	int product_p = (int)request.getAttribute("product_p");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 진행사항</title>
</head>
<body>
<%-- out.print : <%=%> --%> 
상품금액 : <% out.print(product_m);%><br>
할인율 : <%=product_s%>%<br>
적립금 :  <%=product_p%><br>
최종 결제 금액 :  <%=total%><br>
<input type="button" value="결제하기">
</body>
</html>