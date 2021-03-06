<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
<c:import url="../template/bootstrap.jsp"></c:import>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>

	<div class="container">
	  <h2>${board} Write Form</h2>
	  <form id="frm" action="./${board}Write" method="post">
	  
	    <div class="form-group">
	      <label for="title">Title:</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" readonly="readonly" value="${member.id}" id="writer" placeholder="Enter writer" name="writer">
	    </div>
	    
	    <div class="form-group">
	      <label for="contents">Contents:</label>
	      <textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
	    </div>
	    
		<input type="button" value="FileAdd" id="fileAdd" class="btn btn-info">
		<div id="files">
		    <div class="form-group">
		      <label for="files">file:</label>
		      <input type="file" class="form-control" id="file" name="file">
		      <input type="button" value="DeleteFile" class="form-control btn btn-danger">
		    </div>
		</div>
	    
	    <input type="button" class="btn btn-primary" value="Write" id="btn">
	    <button type="submit" class="btn btn-default">Write</button>
	  </form>
	</div>

<script type="text/javascript">
	$("#fileAdd").click(function(){
		
	})
</script>

</body>
</html>