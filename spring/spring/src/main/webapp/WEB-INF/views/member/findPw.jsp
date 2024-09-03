<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<style type="text/css">
.modal-container {
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0 background: rgba(0, 0, 0, 0.2);
}
.modal-email {
	position: fixed;
	top: 50vh; left: 50vw;
	margin-left: -99px; margin-top: -19px;
}
</style>
<body>

	<h1>비밀번호 찾기</h1>
	<div class="box-find-pw">
		<div class="form-group">
			<label for="id">아이디:</label>
			<input type="text" class="form-control" id="id" name="me_id">
		</div>
		<div class="form-group">
			<label for="email">이메일:</label>
			<input type="text" class="form-control" id="email" name="me_email">
		</div>
		<button type="button" class="btn btn-outline-success col-12 btn-find-pw">비번 찾기</button>
	</div>
	
</body>
<script type="text/javascript">

function findPw(id, email) {
	
	var res = false;
	
	$.ajax({
		async : false, //비동기 : true(비동기), false(동기)
		url : '<c:url value="/find/pw"/>',
		type : 'post',
		data : {
			id : id,
			email : email
		},
		success : function(data) {
			res = data;
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(jqXHR);
		}
	});
	
	$('.modal-container').remove();
	
	if(res) {
		alert("이메일로 임시 비밀번호가 전송되었습니다.");
	}else {
		alert("실패");
	}
}

$('.btn-find-pw').click(function(){
	var id = $('#id').val();
	var email = $('#email').val();
	
	if(id =='') {
		alert('아이디를 입력하세요.');
		return;
	}
	if(email =='') {
		alert('이메일을 입력하세요.');
		return;
	}
	
	var res = false;
	
	var str = `
		<div class="modal-container">
		<button class="btn btn-info modal-email">
			<span class="spinner-border spinner-border-sm"></span>
			<span class=""> 이메일 전송중 입니다.</span>
		</button>
	</div>
	`;
	
	$('.box-find-pw').after(str);
	
	setTimeout(() => { 
		findPw(id, email);
	}, 100);
	
});
</script>
</html>
