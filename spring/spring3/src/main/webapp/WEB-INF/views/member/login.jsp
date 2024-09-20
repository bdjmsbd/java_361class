<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="<c:url value="/guest/login"/>" method="post" id="form">
		<div class="form-group">
			<label for="me_id">아이디:</label> 
			<input type="text" class="form-control" id="me_id" name="me_id" value="${id }">
		</div>
		<div class="form-group">
			<label for="me_pw">비번:</label> <input type="password"
				class="form-control" id="me_pw" name="me_pw">
		</div>
		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input" value="true" name="autoLogin"> 자동 로그인
			</label>
		</div>
		<button class="btn btn-outline-info col-12">로그인</button>
	</form>
	
	<script type="text/javascript">
	
	var id = $('#me_id').val();
	if(id == ''){
		$('#me_id').focus();
	}
	else {
		$('#me_pw').focus();
	}
	</script>
</body>
</html>