<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>로그인 화면</title>

</head>

<body>

	<div class="container" style="min-height: calc(100vh - 246px)">
		<h1>로그인</h1>
		<form action="<c:url value="/login"/>" method="post" id="form">

			<div class="form-group">
				<label for="id">아이디:</label> <input type="text" class="form-control"
					id="me_id" name="me_id">
			</div>
			<div class="form-group">
				<label for="pwd">비밀번호:</label> <input type="password"
					class="form-control" id="me_pw" name="me_pw">
			</div>
			<button type="submit" class="btn btn-outline-success col-12">로그인</button>
		</form>
	</div>


</body>
</html>
