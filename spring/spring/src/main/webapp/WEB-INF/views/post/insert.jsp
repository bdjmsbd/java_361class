<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>커뮤니티</title>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

<style>
</style>
</head>
<body>

	<h1>게시글 작성</h1>
	<form action="<c:url value="/post/insert"/>" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<input type="text" class="form-control mt-3" id="title" name="po_title"
				placeholder='제목을 작성해주세요.'>
		</div>
		<div class="form-group">
			<textarea class="form-control mt-3" id="content" name="po_content"></textarea>
		</div>

		<div class="form-group">
			<label>파일2</label> 
			<input type="file" class="form-control mb-1 pb-5" name="fileList" />
			<input type="file" class="form-control mb-1 pb-5" name="fileList" />
			<input type="file" class="form-control mb-1 pb-5" name="fileList" />
		</div>

		<button type="submit" class="btn btn-primary btn-lg col-12">등록</button>
		<input type="hidden" name="po_co_num" value="${co_num}">
	</form>
	<script>
		$('#content').summernote({
			placeholder : '내용을 작성해주세요.',
			tabsize : 2,
			height : 200
		});
	</script>
</body>
</html>
