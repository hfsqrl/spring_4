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
	
	<div>
		<table id="result" class="table table-border">
		</table>
	</div>
	
	<button class="btn btn-danger" id="more">더보기</button>
	
</div>

<script type="text/javascript">
	var curPage = 1
	getList()
	
	// ============= more ============
		$("#more").click(function(){
			curPage++
			getList()
		})
	
	// =============delete===========================
		
	$("#result").on("click", ".del", function(){
		var num = $(this).attr("title")
		
		$.ajax({
			url:"./memoDelete",
			type:"POST",
			data:{num:num},
			success:function(data){
				data = data.trim()
				
				if(data>0) {
					$("#result").html('')
					curPage = 1
					getList()
				} else {
					alert("delete fail")
				}
			}
		})
		
		
	})
	
	// =============write===========================
		
	$("#write").click(function(){
		var writer = $("#writer").val()
		var contents = $("#contents").val()
		
		$.ajax({
			url:"./memoWrite",
			type:"POST",
			data: {
				writer:writer,
				contents:contents
			},
			success: function(result){
				alert(result)
				$("#writer").val('')
				$("#contents").val('')
				$("#result").html('')
				curPage = 1
				getList()
			}
		})
		
	})
	
	// ========================================
		
	function getList() {
		
		$.ajax({
			url:"./memoList",
			type:"get",
			data:{curPage:curPage},
			success: function(data){
				$("#result").append(data)
			}
		})
		
	}
	
</script>
</body>
</html>