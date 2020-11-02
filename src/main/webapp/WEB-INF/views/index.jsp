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

<div id="map" style="width:100%;height:400px;"></div>

</div>


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8359d6b1a5e0267b346e7ce57922d7f4"></script>
<script>

	var container = document.getElementById("#map"); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};
	
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	
	
</script>  

</body>
</html>
