<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글 등록</title>

<jsp:include page="/WEB-INF/views/common/head.jsp" />
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<meta charset="UTF-8">
<style>
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	<div class="container" style="min-height: calc(100vh - 237px)">
		<div class="container">
			<h1>게시글 등록</h1>
			<form action="<c:url value="/post/insert"/>" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<input type="text" class="form-control mt-3" id="title"
						name="po_title" placeholder='제목을 작성해주세요.'>
				</div>
				<div class="form-group">
					<textarea type="text" class="form-control mt-3" id="po_content"
						name="content"></textarea>
				</div>
				<div class="form-group">
					<label>파일</label> <input type="file" class="form-control"
						name="file" />
				</div>
				<input type="hidden" name="co_num" value="${co_num}">
				<button type="submit" class="btn btn-primary btn-lg col-12">등록</button>
			</form>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script>
		$('#content').summernote({
			placeholder : '내용을 작성해주세요.',
			tabsize : 2,
			height : 450
		});
	</script>

</body>
</html>