<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int i =20;
%>
<h1>Expression Element</h1>
<p>Java code의 작업 결과를 간단히 출력하고 싶을 때 사용</p>

10 * i = <%= 10 * i %>

<p>tag안의 내용은 출력문의 파라미터로 사용된다.</p>

</body>
</html>