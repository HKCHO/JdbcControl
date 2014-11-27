<%@ page import="java63.servlets.test05.domain.Product"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/common/header"/>  
</head>
<body>
<div class='container'>
<h1>제품 목록(v1.0)</h1>
<p><a href='product-form.html' class='btn btn-primary'>새제품</a></p>
<table class='table table-hover'>
<tr>
  <th>#</th><th>제품</th><th>수량</th><th>제조사</th>
</tr>
<jsp:useBean
  scope="request" 
  type="java.util.List<java63.servlets.test05.domain.Product>"
  id="products"/>
  
<%
for (Product product : products) {
%>
<tr>
  <td><%=product.getNo()%></td>
  <td><a href='view?no=<%=product.getNo()%>'><%=product.getName()%></a></td>
  <td><%=product.getQuantity()%></td>
  <td><%=product.getMakerNo()%></td>
</tr>
<%} %>

</table>
</div>
<script src='../../js/jquery-1.11.1.js'></script>
<jsp:include page="/common/footer"/> 
</body>
</html>
















