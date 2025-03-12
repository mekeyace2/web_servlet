<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<String> cpdata = (ArrayList)request.getAttribute("cpdata");
%>
<div class="footer">
      <a href="http://facebook.com">
        <img src="images/facebook.png"height="20">
      </a>
      <a href="http://instagram.com">
        <img src="images/instagram.png"height="20">
      </a>
      <a href="http://twitter.com">
        <img src="images/twitter.png"height="20">
      </a>
    </div>
    <section class="foot_section"></section>
    <aside class="aside_footer">
        <div class="div_footer">
        <ul>
        <li><img src="./images/foot_logo.png"></li>
        <li>
회사명 :  <%=cpdata.get(0)%>
대표자 : <%=cpdata.get(1)%>
주소 : <%=cpdata.get(2)%>  <br>
고객센터 : <%=cpdata.get(3)%>
상담시간 : <%=cpdata.get(4)%>
E-Mail : <%=cpdata.get(5)%>
사업자등록번호 :  <%=cpdata.get(6)%><br>
통신판매업신고번호 : <%=cpdata.get(7)%>
개인정보보호책임자 : <%=cpdata.get(8)%>  <br>
Copyright © <%=cpdata.get(9)%> All Rights Reserved.
        </li>
        </ul>    
        </div>
    </aside>