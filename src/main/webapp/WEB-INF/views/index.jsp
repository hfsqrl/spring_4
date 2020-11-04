<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<html>
<head>
	<title>Home</title>
<c:import url="./template/bootstrap.jsp"></c:import>
</head>
<body>

<c:import url="./template/header.jsp"></c:import>

<div class="container">
  <h3>Right Aligned Navbar</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p>
  <div>
  	<c:if test="${not empty member}">
  		<h1>Login Success</h1>
  	</c:if>
  	
  	<c:if test="${empty member}">
  		<h1>Login Fail</h1>
  	</c:if>
	<img alt="main img" src="./resources/images/index/iphone12.png">
  </div>

</div>

<a href="./cookie/makeCookie">Make Cookie</a>


</body>
</html>
