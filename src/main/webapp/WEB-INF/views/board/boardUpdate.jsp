<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} Update</title>
<c:import url="../template/bootstrap.jsp"></c:import>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
	<h2>${board} Update Form</h2>
	
	<form id="frm" action="./${board}Write" method="post" enctype="multipart/form-data">
	
	    <div class="form-group">
	      <label for="title">Title:</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title" value="${dto.title}">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" value="${member.id}" id="writer" placeholder="Enter writer" name="writer">
	    </div>
	    
		<div class="form-group">
			<label for="contents">Contents:</label>
			<textarea class="form-control" rows="10" id="contents" name="contents">
				
			</textarea>
		</div>
		
	    <input type="button" value="FileAdd" id="fileAdd" class="btn btn-info">
		
		
		<div id="files">
	
		</div> 
		
		<div class="form-group">
		 	<label></label>
		    <input type="button" class="btn btn-primary form-control" value="Write" id="btn">
		    <button type="submit" class="btn btn-default form-control">Write</button>
	    </div>
	</form>
</div>
<script type="text/javascript">
	
	$('#contents').summernote({
		height: 300
	});
	
	$("#contents").summernote('code', '${dto.contents}')
	
</script>

</body>
</html>