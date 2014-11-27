<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL 사용</h1>
<p>JSP 확장 태그다. 별도의 라이브러리를 추가해야한다.</p>

<h2>1. 라이브러리</h2>
<ul>
	<li>JSTL API => JSTL 관련 클래스와 인터페이스 정의</li>
	<li>JSTL API => JSTL 규약에 따라 만들 클래스들</li>
</ul>

<h2>2. JSP 페이지에 사용할 태그를 import한다.</h2>
<p>
라이브러리명      :    약자   :    태그 라이브러리 URL<br>
Core Library  :     c     : http://java.sun.com/jsp/jstl/core<br>
XML 				  :     x     : http://java.sun.com/jsp/jstl/xml<br>
I18N 		  		:    fmt    : http://java.sun.com/jsp/jstl/fmt<br>
Database      :    sql    : http://java.sun.com/jsp/jstl/sql<br>
Functions     :     fn    : http://java.sun.com/jsp/jstl/functions<br>
</p>
<p>
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</p>

</body>
</html>