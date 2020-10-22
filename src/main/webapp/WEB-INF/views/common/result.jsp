<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result jsp</title>
</head>
<body>
<script type="text/javascript">
	var result = '${msg}' // msg의 값이 숫자면 홑따옴표를 하지 않아도 된다.
	var path = '${path}'
	alert(result)
	location.href = path
	
</script>

</body>
</html>