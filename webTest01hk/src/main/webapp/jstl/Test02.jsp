<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java63.servlets.test05.domain.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Core 태그 사용</h1>
<h2>c:out</h2>
<p>출력문을 만든다</p>
<c:out value="오호라 출력!"/><br>
<c:out value="${null}" default="기본값"/><br>
<c:out value="${null}">기본값</c:out><br>
<%="오호라 출력!" %>


<hr>

<h2>c:set</h2>
<p>변수를 생성하거나 변수의 값을 설정할 때 사용</p>
<c:set var="name1" value="홍길동" scope="page"/>
<c:set var="name2" value="이순신" scope="page"/>

<%
	String name3 = "임꺽정";
	pageContext.setAttribute("name3", name3);
%>

requestScope.name1 = ${requestScope.name1}<br>
pageScope.name1 = ${requestScope.name1}<br>
pageScope.name2 = ${requestScope.name2}<br>
pageScope.name3 = ${requestScope.name3}<br>

<h2>객체의 프로퍼티 값 설정하기</h2>
<%
Product product = new Product();
product.setNo(10);
product.setName("아이폰");
product.setQuantity(300);
product.setMakerNo(1);
pageContext.setAttribute("product", product);
%>

${product.name}<br>

<c:set target="${pageScope.product}" property="name" value="오호라 폰"/>
${product.name}<br>

<h2>c:remove</h2>
<p>보관소에 저장된 객체 제거하기</p>
${pageScope.name1}<br>
<c:remove var='name1' scope='page'/>
<%pageContext.removeAttribute("name2"); %>
제거한 후의 name1은?
 ${pageScope.name1}<br>
 ${pageScope.name2}

</body>
</html>
















