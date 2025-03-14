<%@page import="mallpage.dto_product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function errmsg(){
		alert("해당 상품의 정보가 올바르지 않습니다.");
		location.href='./product_list.do';
	}
</script>
<%
	//DTO Model을 Controller에서 받은 값을 이관 시켜서 해당 메소드로 값을 출력하기 위한방식
	dto_product pd = (dto_product)request.getAttribute("dto");
	if(pd.getMidx() == 0) {
		out.print("<script>errmsg();</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
</head>
<body>
<!-- DTO Getter 메소드를 출력 순서에 맞게 적용 -->
<img src=".<%=pd.getPimg()%>"><br>
상품명 : <%=pd.getPnm()%><br>
상품가격 : <%=pd.getPmoney()%><br>
할인율 : <%=pd.getPsales()%><br>
할인금액 : <%=pd.getPsmoney()%><br>
<input type="button" value="상품 리스트" onclick="location.href='./product_list.do';">
</body>
</html>