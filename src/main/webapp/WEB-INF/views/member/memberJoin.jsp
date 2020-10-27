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
	<form action="./memberJoin" method="post" id="frm">
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
	      <input type="password" class="form-control" id="pw2" placeholder="Enter password" name="pw2">
	      <div id="pwResult"></div>
	    </div>
	    
	    <div class="form-group">
	      <label for="name">Name:</label>
	      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
	    </div>
	    
	    <div class="form-group">
	      <label for="email">Email:</label>
	      <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email">
	    </div>
	    
	    <input type="button" value="Join" class="btn btn-default" id="join">
	    
  </form>
</div>

<script type="text/javascript">

// ============= join ==============
	var idCheck = false
	var pwCheck = false
	
	$("#join").click(function() {
		if(idCheck && pwCheck) {
		// 중복체크하고, 사용 가능한 id
			alert("Join")
		} else {
		// 중복체크 하지 않거나, 사용 불가능한 id
			alert("no")
		// $("#frm").submit()
		}
	});

// ============= id check ===============
	
	$("#id").blur(function(){
		var id = $(this).val()
		idCheck = false
		
		if(id != '') {
			$.get("./memberIdCheck?id="+id, function(data) {
				// 0 사용가능, 1 사용불가
				data=data.trim()
				/*   */
				var str = "중복된 ID 입니다."
				
				$("#idResult").addClass("idCheck1")
				$("#idResult").removeClass("idCheck1=0").addClass("idCheck1")
				
				if(data==0){
					str = "사용 가능한 ID입니다."
					$("#idResult").removeClass("idCheck1").addClass("idCheck0")
					idCheck = true
				} 
				
				$("#idResult").html(str)
				
			})
		} else {
			$("#idResult").html("id는 필수항목입니다.")
			$("#idResult").removeClass("idCheck1=0").addClass("idCheck1")
		}
	})
	
	// =============== pw check ================
	
	$("#pw2").blur(function (){
		var pw = $("#pw").val()
		var pw2 = $(this).val()
		pwCheck = false
		
		if(pw == '') {
			$("#pwResult").html("password를 입력하세요.");
			$("#pwResult").removeClass("idCheck0").addClass("idCheck1")
		} else if(pw == pw2) {
			$("#pwResult").html("password가 일치합니다.");
			$("#pwResult").removeClass("idCheck1").addClass("idCheck0")
			pwCheck = true
		} else {
			$("#pwResult").html("password가 일치 하지 않습니다.");
			$("#pwResult").removeClass("idCheck0").addClass("idCheck1")
		}
		
	})
</script>
</body>
</html>