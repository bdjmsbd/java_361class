<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>

<style type="text/css">
label.error {
	color: red;
}

.error.id-ok {
	color: green;
}
</style>

</head>

<body>

	<div class="container" style="min-height: calc(100vh - 246px)">
		<h1>회원 가입</h1>
		<form action="<c:url value="/signup"/>" method="post" id="form">

			<div class="form-group">
				<label for="id">아이디:</label> <input type="text" class="form-control"
					id="id" name="me_id">
			</div>
			<div class="form-group">
				<label for="pwd">비밀번호:</label> <input type="password"
					class="form-control" id="pw" name="me_pw">
			</div>
			<div class="form-group">
				<label for="pwd2">비밀번호 확인:</label> <input type="password"
					class="form-control" id="pw2" name="me_pw2">
			</div>
			<div class="form-group">
				<label for="email">이메일:</label> <input type="text"
					class="form-control" id="email" name="me_email">
			</div>
			<button type="submit" class="btn btn-outline-success col-12">회원가입</button>
		</form>
	</div>


	<script type="text/javascript">
		var flag = false;

		$('#form')
				.validate(
						{
							rules : {
								me_id : {
									required : true,
									regex : /^\w{6,13}$/
								},
								me_pw : {
									required : true,
									regex : /^(?=.*[A-Z])(?=.*[a-z])(?=.*[\d])(?=.*[^\w])([^\w]{1}|[\w]{1}){6,15}$/
								},
								me_pw2 : {
									equalTo : pw
								},
								me_email : {
									required : true,
									email : true
								}
							},
							messages : {
								me_id : {
									required : '필수 항목입니다.',
									regex : '아이디는 영어, 숫자만 가능하며, 6~13자이어야 합니다.'
								},
								me_pw : {
									required : '필수 항목입니다.',
									regex : '영어 대소문자, 숫자, 특수문자가 꼭 들어가야 하며, 6~15자이어야 합니다.'
								},
								me_pw2 : {
									required : '필수 항목입니다.',
									equalTo : '비번이 일치하지 않습니다.'
								},
								me_email : {
									required : '필수 항목입니다.',
									email : '올바른 이메일 형식이 아닙니다'
								}
							},
							submitHandler : function() {
								var id = $('#id').val();
								var res = checkId(id);
								if (res == 0) {
									displayCheckId(res);
									alert('이미 사용중인 아이디입니다.');
									return false;
								}
								return true;
							}
						});

		$.validator.addMethod('regex', function(value, element, regex) {
			var re = new RegExp(regex);
			return this.optional(element) || re.test(value);
		}, "정규표현식을 확인하세요.");
	</script>
	<script type="text/javascript">
		$('#id').keyup(function() {
			var id = $(this).val();
			
			var res = checkId(id);

			displayCheckId(res);
						
		});
		
		function displayCheckId(res) {
			
			$('#check-id').remove();

			var str = `<label id="check-id" class="error"></label>`;
			$('#id').after(str);

			if (res == 1) {
				$('#check-id').addClass('id-ok');
				$('#check-id').text("사용 가능한 아이디입니다.")
			} else if (res == 0) {
				$('#check-id').text("이미 사용중인 아이디입니다.")
			} else {
				$('#check-id').remove();
			}
		}

		function checkId(id) {
			// -1 : 정규식 불일치, 1 : 사용 가능, 0 : 중복된 아이디
			var res = -1;

			var regex = /^\w{6,13}$/;
			if (!regex.test(id)) {
				return res;
			}

			$.ajax({
				async : false, //비동기 : true(비동기), false(동기)
				url : '<c:url value="/check/id"/>',
				type : 'post',
				data : {
					id : id
				},
				success : function(data) {
					res = data ? 1 : 0;
				},
				error : function(jqXHR, textStatus, errorThrown) {

				}

			});
			return res;
		}
	</script>
</body>
</html>
