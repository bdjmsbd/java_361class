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

	<h1>게시글 수정</h1>
	<form action="<c:url value="/post/update"/>" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<input type="text" class="form-control mt-3" id="title" name="po_title" value="${post.po_title }">
		</div>
		<div class="form-group">
			<textarea class="form-control mt-3" id="content" name="po_content">${post.po_content }</textarea>
		</div>

		<div class="form-group file-container">
			<label>첨부파일</label> 
			<c:forEach items="${list }" var="file">
					<div class="form-control  mb-1" style="position: relative;"> 
						<span> ${file.fi_ori_name } </span>
						<span> 
							<a class="btn-del" style="color: red;position: absolute; right: 10px;" href="javascript:void(0)" data-num="${file.fi_num }"> X </a>
						</span>
					</div>
			</c:forEach>
			<c:forEach begin="1" end="${3 - list.size() }">
				<input type="file" class="form-control mb-1" name="fileList" />
			</c:forEach>
		</div>

		<button type="submit" class="btn btn-primary btn-lg col-12">수정 등록</button>
		
		<input type="hidden" name="co_num" value="${cri.co_num}">
		<input type="hidden" name="po_num" value="${post.po_num}">
		<input type="hidden" name="page" value="${cri.page}">
		<input type="hidden" name="search" value="${cri.search}">
		<input type="hidden" name="type" value="${cri.type}">
	</form>
	<script>
		$('#content').summernote({
			tabsize : 2,
			height : 200
		});
		
		$('.btn-del').click(function() {
			var fi_num = $(this).data('num');
			$(this).parent().parent().remove();
			
			var input = `<input type="hidden" name="fi_nums" value="\${fi_num}">`;
			var file = `<input type="file" class="form-control mb-1" name="fileList" />`;
			
			$('.file-container').append(input);
			$('.file-container').append(file);
		})
	</script>
</body>
</html>
