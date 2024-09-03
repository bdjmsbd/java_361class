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
			<div class="form-check-inline mb-1">
				<label class="form-check-label"> 
				<input type="checkbox" class="form-check-input" value="true" name="autoLogin">자동로그인
				</label>
			</div>
			<button type="submit" class="btn btn-outline-success col-12">로그인</button>
		</form>
		<a class="btn btn-success mt-3 col-2 float-right" href="<c:url value="/find/pw"/>">비밀번호 찾기</a>
	</div>


</body>
</html>
