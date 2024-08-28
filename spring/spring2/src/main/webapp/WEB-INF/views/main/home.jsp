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

	<c:if test="${user ne null}">
		<h1>${user.me_id}님안녕하세요.</h1>
	</c:if>


</body>
</html>
