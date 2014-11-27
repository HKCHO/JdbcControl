<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java63.servlets.test05.domain.Product" %>

<%--
		jsp:useBean 태그 사용 => ServletRequest(request), HttpSession(session), ServletContext(application), PageContext(page)로부터 객체 생성 또는 꺼내기
		
		^^속성^^
		id => reference변수
		scoped => 객체를 꺼낼 보관소  ex) page, request, session, application
		class => 보관소에서 꺼낼 객체의 타입, 또는 객체 생성을 위한 타입.
		type => reference 변수의 타입  
		
		ex) <jsp:useBean type="java.util.List" id="products" class="java.util.ArrayList" scope='request'/>
			=> 자바 코드로 전환
			 : java.util.List products = (java.util.ArrayList) request.getAttribute("products");
			 if (products == null) {
			  products = new java.util.ArrayList();															
			}
	 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP useBean ActionTag</h1>

	<p>태그를 이용하여 보관소에 저장된 객체를 꺼내거나, 새로 객체를 생성하는 문법</p>

	<h1>1. bean 객체 생성</h1>
	<jsp:useBean type="java63.servlets.test05.domain.Product" id="product"
		class="java63.servlets.test05.domain.Product" scope="page" />

	<%--
	Product product = (Product)pageContext.getAttribute("product");
	if (product == null) {
		product = new Product();
		}
	 --%>
	제품명 : 	<%= product.getName() %><br> 
	수량 : 	<%= product.getQuantity() %><br> 
	제조사 번호 : <%= product.getMakerNo() %><br>
	
	<hr>

	<h1>2. bean 객체 생성(type속성 생략)</h1>
	<jsp:useBean id="product2" class="java63.servlets.test05.domain.Product" scope="page" />
	제품명 : 	<%= product2.getName() %><br> 
	수량 : 	<%= product2.getQuantity() %><br> 
	제조사 번호 : <%= product2.getMakerNo() %><br>
	
	<hr>

	<h1>3. bean 객체 생성(class속성 생략)</h1>
	<p>class 속성을 생략하면 보관소에서 객체를 찾을 수 없을 때, 객체를 새로 생성하지 못한다. 오류발생!!!!</p>
	
	<%
	Product temp = new Product();
	temp.setName("나 호갱이다");
	temp.setQuantity(200);
	temp.setMakerNo(2);
	pageContext.setAttribute("product3",temp);
	%>
	
	<jsp:useBean id="product3" class="java63.servlets.test05.domain.Product" scope="page" />
	
	<%-- 
	Product product3 = (Product)pageContext.getAttribute("product3");
	if (product3 == null) {    //객체를 못찾으면 오류!
		throw new InstantiationException(......);
		}
	 --%>
	
	제품명 : 	<%= product3.getName() %><br> 
	수량 : 	<%= product3.getQuantity() %><br> 
	제조사 번호 : <%= product3.getMakerNo() %><br>
	

</body>
</html>





