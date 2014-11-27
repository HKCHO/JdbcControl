<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List , java.util.ArrayList , java.util.HashMap , java.util.Map" %>
<%@ page import='java63.servlets.test05.domain.Product' %>
<%@ page import='java.util.HashSet' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test04</title>
</head>
<body>
<h1>연산자(operator)</h1>
<h2>산술 연산자(Math)</h2>
\${10+20} = ${10+20}
\${10*20} = ${10*20}<br>
\${10/20} = ${10/20}<br>
\${10%20} = ${10%20}<br>
\${10 div 20} = ${10 div 20};<br>
\${10 mod 20} = ${10 mod 20};<br>


<hr>

<h2>논리 연산자(Logic)</h2>
\${true && false} = ${true && false}<br>
\${true || false} = ${true || false}<br>
\${true and false} = ${true and false}<br>
\${true or false} = ${true or false}<br>
\${!true} = ${!true}<br>
\${not true} = ${not true}<br>

<hr>

<h2>관계 연산자</h2>
\${10 == 11} = ${10 == 11}<br>
\${10 == 11} = ${10 == 11}<br>

\${10 != 11} = ${10 != 11}<br>
\${10 ne 11} = ${10 ne 11}<br>

\${10 < 11} = ${10 < 11}<br>
\${10 lt 11} = ${10 lt 11}<br>

\${10 > 11} = ${10 > 11}<br>
\${10 gt 11} = ${10 gt 11}<br>

\${10 <= 11} = ${10 <= 11}<br>
\${10 le 11} = ${10 le 11}<br>

\${10 >= 11} = ${10 >= 11}<br>
\${10 ge 11} = ${10 ge 11}<br>

<hr>

<h2>empty 연산자</h2>
<p>값이 비어 있거나 null인지 여부를 검사</p>

<%
pageContext.setAttribute("age" , null);
pageContext.setAttribute("alias", "");
pageContext.setAttribute("name", "홍길동");
pageContext.setAttribute("list", new ArrayList());
pageContext.setAttribute("set" , new HashSet());
pageContext.setAttribute("map" , new HashMap());
List list = new ArrayList();
list.add("okok");
pageContext.setAttribute("list2" , list);
%>

age(null) = ${empty age}<br>
alias("") = ${empty alias}<br>
name(값) = ${empty name}<br>
list(size:0) = ${empty list}<br>
list2(size:1) = ${empty list2}<br>
set(size:0) = ${empty set}<br>
map(size:0) = ${empty map}<br>


<hr>
<h2>조건 연산자</h2>
\${10 > 15 ? "크다" : "작다"} = ${10 > 15 ? "크다" : "작다"} <br>

</body>
</html>


















