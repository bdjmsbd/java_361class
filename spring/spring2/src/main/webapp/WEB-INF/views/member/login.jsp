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


	<h1>로그인</h1>
	<form action="<c:url value="/login"/>" method="post" id="form">
		<div class="form-group">
			<label>아이디: </label> <input type="text" class="form-control" id="id"
				name="me_id">
		</div>
		<div class="form-group">
			<label>비번: </label> <input type="password" class="form-control"
				id="pw" name="me_pw">
		</div>
		<button type="submit" class="btn btn-outline-success col-12 bt-5">로그인</button>
	</form>


</body>
</html>
