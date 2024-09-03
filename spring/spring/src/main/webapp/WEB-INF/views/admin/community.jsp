<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>

</head>

<body>
	<h1 class="mt-3">커뮤니티 관리</h1>
	<ul class="list-group mt-3 mb-3">
		<c:forEach items="${list }" var="co">
			<li
				class="list-group-item d-flex justify-content-between align-items-center">
				<span>${co.co_name }</span> <span> <span
					class="badge badge-primary badge-pill mr-1"> ${co.co_count}
				</span>
					<button class="btn btn-outline-danger btn-community-update"
						data-num="${co.co_num}" data-name="${co.co_name}">수정</button> <a
					href=<c:url value="/admin/community/delete?co_num=${co.co_num}"/>
					class="btn btn-outline-dark">삭제</a>
			</span>
			</li>
		</c:forEach>
	</ul>
	<form action="<c:url value="/admin/community/insert"/>" method="post"
		class="community-insert-form">
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="생성할 커뮤니티명을 입력"
				name="co_name" required>
			<div class="input-group-append">
				<button type="submit" class="btn btn-outline-info">생성</button>
			</div>
		</div>
	</form>

	<script type="text/javascript">
	$('.btn-community-update').click(function(){
		var co_num = $(this).data('num');
		var co_name = $(this).data('name');
		var str = `
			<form action="<c:url value="/admin/community/update?co_num=\${co_num}"/>" method="post" class="community-update-form">
			<div class="input-group mb-3">
				<input type="text" class="form-control" value="\${co_name}" name="co_name" required>
				<div class="input-group-append">
					<button type="submit" class="btn btn-outline-info mr-1">수정 등록</button>
					<button type="button" class="btn btn-outline-dark btn-update-cancel">취소</button>
				</div>
			</div>
			</form>
		`;
		$('.community-update-form').remove();
		$('.community-insert-form').hide();
		$('.community-insert-form').after(str);
	});
	
	$(document).off('click','.btn-update-cancel');
	$(document).on('click','.btn-update-cancel', function(){
		$('.community-update-form').remove();
		$('.community-insert-form').show();
	});
	
	</script>
</body>
</html>
