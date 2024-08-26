<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글</title>

<jsp:include page="/WEB-INF/views/common/head.jsp" />


<style>
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	<div class="container" style="min-height: calc(100vh - 237px)">

		<div class="w3-panel w3-leftbar" style="margin-bottom: 20px;">
			<h2>${cm_name}커뮤니티</h2>
		</div>
		<div class="form-group"
			style="line-height: 110%; margin-bottom: 30px; border-bottom: 1px solid rgb(41, 54, 124);">
			<h3 style="margin-bottom: 5px;">${post.po_title}</h3>
			<br> <span>${post.po_me_id} | <fmt:formatDate
					value="${post.po_date}" pattern="yyyy-MM-dd HH:mm:ss" />
			</span>
			<div class="form-group" style="float: right;">
				<span>조회 ${post.po_view}</span>
			</div>
			<br> <br>
		</div>
		<div class="form-group" style="min-height: 400px; height: auto">
			${post.po_content}</div>
		<div class="form-group" style="float: right;">
			<c:if test="${post.po_me_id eq user.me_id}">
				<a class="btn btn-lg mr-2 btn-update"
					style="background: #666; border-color: #444; text-shadow: 0px -1px #474747; color: #fff;"
					href="<c:url value="/post/update?po_num=${post.po_num}&co_num=${post.po_co_num}"/>">수정</a>
			</c:if>
			<c:if
				test="${post.po_me_id eq user.me_id || user.me_authority eq 'ADMIN'}">
				<a class="btn btn-lg mr-2 btn-del" data-num="${post.po_num}" 
					style="background: #666; border-color: #444; text-shadow: 0px -1px #474747; color: #fff;">삭제</a>
			</c:if>
			<a class="btn btn-lg"
				style="background: #3b4890; border-color: #29367c; text-shadow: 0px -1px #1d2761; color: #fff"
				href="<c:url value="/post/list?co_num=${post.po_co_num}"/>">목록</a>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script type="text/javascript">
		$('.btn-del').click(function() {
			
			let po_num = $(this).data('num');
			if (confirm('정말로 삭제하시겠습니까?')) {
				location.href = '<c:url value="/post/delete?po_num='+po_num+'"/>';
				return false;
			} else {
				return false;
			}
		});
	</script>
</body>
</html>