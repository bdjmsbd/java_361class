<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>스프링</title>
</head>
<body>

	<script type="text/javascript">
		var msg = '${msg}';
		if (msg != '') {
			alert(msg);
		}
		location.href = '<c:url value="/${url}"/>';
	</script>
</body>
</html>
