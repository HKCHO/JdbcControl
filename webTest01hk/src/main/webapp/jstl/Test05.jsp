<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Core 태그 사용</h1>
	<h2>c:redirect</h2>
	<c:set var='age' value='20' />
	<c:if test='${pageScope.age < 19}'>
		<c:redirect url="http://warning.or.kr/" />
	</c:if>
	
	<hr>
	
	<h2>fmt:parseDate</h2>
	<fmt:parseDate var="date1" value="11-25-2014" pattern="MM-dd-yyyy"/>
	${date1}<br>
	
	<h2>fmt:formatDate</h2>
	<p>java.util.Date객체를 가지고 문자열로 만든다.</p>
	<% pageContext.setAttribute("today", new java.util.Date()); %>
	<fmt:formatDate value="${pageScope.today}" pattern="yyyy/MM/dd"/>
</body>
</html>
















