<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.idCheck0 {
		color: blue;
	}
	
	.idCheck1 {
		color: red;
	}
</style>
<c:import url="../template/bootstrap.jsp"></c:import>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>
<div class="container">
	<h3>Member Join Page</h3>
	<form action="./memberJoin" method="post">
	    <div class="form-group">
	      <label for="id">Id:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter Id" name="id">
	      <div id="idResult"></div>
	    </div>
	    <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
	    </div>
	    <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw2">
	    </div>
	    
	    <div class="form-group">
	      <label for="name">Name:</label>
	      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
	    </div>
	    
	    <div class="form-group">
	      <label for="email">Email:</label>
	      <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email">
	    </div>
	    
	    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
<script type="text/javascript">
	$("#id").blur(function(){
		var id = $(this).val()
		
		$.get("./memberIdCheck?id="+id, function(data) {
			// 0 사용가능, 1 사용불가
			data=data.trim()
			/*   */
			var str = "중복된 ID 입니다."
			$("#idResult").addClass("idCheck1")
			if(data==0){
				str = "사용 가능한 ID입니다."
				$("#idResult").removeClass("idCheck1").addClass("idCheck0")
			} 
			
			$("#idResult").html(str)
			
		})
	})
</script>
</body>
</html>