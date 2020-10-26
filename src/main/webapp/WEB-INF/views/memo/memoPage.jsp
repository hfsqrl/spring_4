<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memo</title>
<c:import url="../template/bootstrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
 
	<h1>Memo Page</h1>
	
	
	<div>
		<div class="form-group">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" value="${member.id}" id="writer" placeholder="Enter writer" name="writer">
	    </div>
	    
	    <div class="form-group">
	      <label for="contents">Contents:</label>
	      <textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
	    </div>
	    
	    <div class="form-group">
	    <button type="submit" class="btn btn-default" id="write">Write</button>
	    </div>
	    
	</div>
	
	<div id="result"></div>
	
	<button class="btn btn-primary del">더보기</button>
	
</div>

<script type="text/javascript">
	getList()
	
	// =============delete===========================
		
	$("#result").on("click", ".del", function(){
		var num = $(this).attr("title")
		alert(num)
		
		$.post("./memoDelete", {num:num}, function (data) {
			data = data.trim()
			alert(data)
			if(data>0) {
				getList()
			} else {
				alert("delete fail")
			}
		})
		
	})
	
	// =============write===========================
		
	$("#write").click(function(){
		var writer = $("#writer").val()
		var contents = $("#contents").val()
		
		$.post("./memoWrite",{writer:writer, contents:contents}/*파라미터이름:변수명*/, function(result){
			alert(result)
			$("#writer").val('')
			$("#contents").val('')
			getList()
		})
	})
	
	// ========================================
		
	function getList(){
		var list = $("#btn").val()
		$.get("./memoList", function(data){
			$("#result").html(data)
		})
	}
	
</script>
</body>
</html>