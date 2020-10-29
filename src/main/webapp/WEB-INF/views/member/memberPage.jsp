<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootstrap.jsp"></c:import>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>

<div class="container">

	<table class="table table-condensed">
		<tr>
			<th>Num</td>	<td>${member.num}</td>
		</tr>
		<tr>
			<th>Id</td>		<td>${member.id}</td>
		</tr>
		<tr>
			<th>Name</td>	<td>${member.name}</td>
		</tr>
		<tr>
			<th>Email</td>	<td>${member.email}</td>
		</tr>
	</table>
	
	<div>
		<img alt="" src="../resources/upload/member/${member.memberFileDTO.fileName}">
	</div>
	
	<a href="./memberUpdate" class="btn btn-primary">Update</a>
	<a href="./memberDelete" class="btn btn-danger">Delete</a>

</div>

</body>
</html>