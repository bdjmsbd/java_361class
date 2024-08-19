<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<jsp:include page="/WEB-INF/views/common/head.jsp" />
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<style type="text/css">
.comment-list {
	list-style: none;
	padding: 0;
}

.comment-list>.comment-item {
	margin-bottom: 20px;
}

.comment-list>.comment-item.reply {
	padding-left: 30px;
}

.ttttt {
	float: right;
}

.ddddd {
	float: left;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="container">
		<h1>게시글 상세</h1>
		<div class="form-group">
			<label for="title">제목:</label>
			<div class="form-control">${post.po_title}</div>
		</div>
		<div class="form-group">
			<label for="id">작성자:</label>
			<div class="form-control">${post.po_me_id}</div>
		</div>
		<div class="form-group">
			<label for="date">작성일:</label>
			<div class="form-control">
				<fmt:formatDate value="${post.po_date}"
					pattern="yyyy-MM-dd HH:mm:ss" />
			</div>
		</div>
		<div class="form-group">
			<label for="view">조회수:</label>
			<div class="form-control">${post.po_view}</div>
		</div>
		<div class="text-center">
			<%-- <a href="<c:url value="/post/like?po_num=${post.po_num}&re_state=1"/>" --%>
			<a href="#" data-state="1"
				class="btn-up btn btn<c:if test="${re_state ne 1}">-outline</c:if>-danger">추천
				<span>(${post.po_up})</span>
			</a>
			<%-- <a href="<c:url value="/post/like?po_num=${post.po_num}&re_state=-1"/>" --%>
			<a href="#" data-state="-1"
				class="btn-down btn btn<c:if test="${re_state ne -1}">-outline</c:if>-danger">비추천
				<span>(${post.po_down})</span>
			</a>
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<div class="form-control" style="min-height: 200px">${post.po_content}</div>
		</div>
		<div class="form-group">
			<label for="content">첨부파일:</label>
			<c:if test="${fileList.size() == 0}">
				<div class="form-control">첨부파일 없음</div>
			</c:if>
			<c:if test="${fileList.size() != 0}">
				<c:forEach items="${fileList}" var="file">
					<a class="form-control" href="<c:url value="/download?fileName=${file.fi_name}"/>"
					download="${file.fi_ori_name}">${file.fi_ori_name}</a>
				</c:forEach>
			</c:if>
		</div>
		<hr>
		<h3>댓글 목록</h3>
		<ul class="comment-list">
			<li class="comment-item">
				<div>작성자 아이디(시간)</div>
				<div>댓글 내용</div>
			</li>
			<li class="comment-item reply">
				<div>작성자 아이디(시간)</div>
				<div>대댓글 내용</div>
			</li>
		</ul>
		<div class="comment-pagination"></div>
		<div class="comment-insert-box">
			<textarea class="col-12 input-comment-insert"></textarea>
			<button class="ddddd btn btn-outline-success btn-comment-insert">등록</button>
		</div>
		<div class="ttttt">
			<a href="<c:url value="/post/list?co_num=${post.po_co_num}"/>"
				class="btn btn-outline-primary">목록</a>
			<c:if test="${user ne null && user.me_id eq post.po_me_id}">
				<a href="<c:url value="/post/update?po_num=${post.po_num}"/>"
					class="btn btn-outline-warning">수정</a>
				<a href="<c:url value="/post/delete?po_num=${post.po_num}"/>"
					class="btn btn-outline-dark">삭제</a>
			</c:if>
		</div>
		<br>


	</div>
	<script type="text/javascript">
		var cri = {
			po_num : '${post.po_num}',
			page : 1
		}
		getCommentList(cri);
		
		//추천/비추천 버튼 클릭 이벤트
		$('.btn-up, .btn-down').click(function(e) {
			e.preventDefault();

			if (!checkLogin()){
				return;
			}
			let state = $(this).data('state');
			let num = '${post.po_num}';
			$.ajax({
				url : '<c:url value="/post/like"/>',
				method : "get", //원하는 방식 선택
				data : { //보낸 데이터를 객체로
					re_state : state,
					po_num : num
				},
				success : function(data) {
					let res = data.result;
					console.log(data.re_state);
					if (res == 0) {
						alert(`\${data.re_state == 1?'추천':'비추천'}을 했습니다.`);
					} else {
						alert(`\${data.re_state == 1?'추천':'비추천'}을 취소했습니다.`);
					}
					checkRecommendBtns(res, data.re_state);
					let post = JSON.parse(data.post);
					$('.btn-up span').text(post.po_up);
					$('.btn-down span').text(post.po_down);
				},
				error : function(xhr, status, error) {
					//xhr : XHLHttpRequest 객체, 요청과 관련된 정보를 제공
					//status :HTTP 상태 코드, 요청이 실패한 원인
					//error : 에러에 대한 추가 정보
					console.log("error");
				}
			});
		});
		
		$(document).on('click', ".pagination .page-item", function(){
			if($(this).hasClass('disabled')){
				return;
			}
			let page = $(this).data('page');
			cri.page = page;
			getCommentList(cri);
		});
		
		$('.btn-comment-insert').click(function(){
			//로그인 안한 비회원을 위한 안내 작업
			
			if (!checkLogin()){
				return;
			}
			
			//댓글, 댓글 번호
			let content = $('.input-comment-insert').val();
			let cm_ori_num = 0;
			let po_num = '${post.po_num}';
			
			if(content.trim() == ''){
				alert('댓글을 입력하세요');
				$('.input-comment-insert').focus();
				return;
			}
			
			let obj = { 
				cm_content : content,
				cm_ori_num : cm_ori_num,
				cm_po_num : po_num
			};
			$.ajax({
				url : '<c:url value="/comment/insert"/>',
				method : "post",
				data : obj,
				success : function(data){
					console.log(data);
					if(data.result){
						alert('댓글을 등록했습니다.');
						cri.page = 1;
						getCommentList(cri);
					}
					else{
						alert('댓글을 등록하지 못했습니다.');
					}
					$('.input-comment-insert').val('');
				}, 
				error : function(xhr, status, error){
					console.log("error");
					console.log(xhr);
				}
			});
		});
		

		$(document).on('click', '.btn-comment-delete', function(){
			//로그인 안한 비회원을 위한 안내 작업
			
 			if (!checkLogin()){
				return;
			} 
			
			let cm_num = $(this).data('num');;
			let me_id = '${user.me_id}';
			
			let po_num = '${post.po_num}';
		
			let obj = { 
				cm_num : cm_num
			};
			console.log(obj);
			
			$.ajax({
				url : '<c:url value="/comment/delete"/>',
				method : "post",
				data : obj,
				success : function(data){
					if(data.result){
						alert('댓글을 삭제했습니다.');
						cri.page = 1;
						getCommentList(cri);
					}
					else{
						alert('댓글을 삭제하지 못했습니다.');
					}
				}, 
				error : function(xhr, status, error){
					console.log("error");
					console.log(xhr);
				}
			}); 
		});
		
		$(document).on('click', '.btn-comment-update', function(){
			$('.comment-update-box').remove();
			//로그인 안한 비회원을 위한 안내 작업
 			if (!checkLogin()){
				return;
			} 
 			let cm_num = $(this).data('num');
			let cm_content = $(this).parent().next().text();
			/*  
			this는 a태그. 부모인 div의 다음 형제 div의 내용물. 
			<div>
				<span>abc123(15:25:29)</span>
				<a href="" class="btn-comment-delete">수정</a>
			</div>
			<div class="cm_content"> asd
			</div>
			*/
			
			var str = `
			<div class="comment-update-box">
			<textarea class="col-12 input-comment-update">\${cm_content}</textarea>
			<button class="btn btn-outline-success btn-comment-update-complete" data-num="\${cm_num}">수정완료</button>
			</div>
			`;
						
			$('.comment-insert-box').after(str);
			$('.comment-insert-box').hide();
			
		});

		$(document).on('click', '.btn-comment-update-complete', function(){
			
			let cm_num = $(this).data('num');
			let cm_content = $('.input-comment-update').val();
			console.log("cm_num : " + cm_num);
			console.log("cm_content : " + cm_content);
			
			let obj = {
					cm_num : cm_num,
					cm_content : cm_content					
			}
			
			$.ajax({
				url : '<c:url value="/comment/update"/>',
				method : "post",
				data : obj,
				success : function(data){
					if(data.result){
						alert('댓글을 수정했습니다.');
						cri.page = 1;
						getCommentList(cri);
					}
					else{
						alert('댓글을 수정하지 못했습니다.');
					}
					
					$('.comment-update-box').remove();
					$('.comment-insert-box').show();
				}, 
				error : function(xhr, status, error){
					console.log("error");
					console.log(xhr);
				}
			}); 
		
		});
		
		$(document).on('click', '.btn-comment-reply', function(){
			$('.comment-reply-box').remove();
			//로그인 안한 비회원을 위한 안내 작업
 			if (!checkLogin()){
				return;
			} 
 			let cm_num = $(this).data('cm_num');
			/*  
			this는 a태그. 부모인 div의 다음 형제 div의 내용물. 
			<div>
				<span>abc123(15:25:29)</span>
				<a href="" class="btn-comment-delete">수정</a>
			</div>
			<div class="cm_content"> asd
			</div>
			*/
			
			var str = `
			<div class="comment-reply-box">
			<textarea class="col-12 input-comment-reply"></textarea>
			<button class="btn btn-outline-success btn-comment-reply-complete" data-cm_num="\${cm_num}">댓글작성</button>
			</div>
			`;
						
			$('.comment-insert-box').after(str);
			$('.comment-insert-box').hide();
			
		});

		$(document).on('click', '.btn-comment-reply-complete', function(){
			
			let cm_num = $(this).data('cm_num');
			let cm_content = $('.input-comment-reply').val();
			let po_num = '${post.po_num}';

			console.log("po_num : " + po_num);
			console.log("cm_num : " + cm_num);
			console.log("cm_content : " + cm_content);
			
			let obj = {
					cm_po_num : po_num,
					cm_ori_num : cm_num,
					cm_content : cm_content					
			}
			
			$.ajax({
				url : '<c:url value="/comment/insert"/>',
				method : "post",
				data : obj,
				success : function(data){
					if(data.result){
						alert('대댓글을 작정했습니다.');
						cri.page = 1;
						getCommentList(cri);
					}
					else{
						alert('대댓글을 작성하지 못했습니다.');
					}
					
					$('.comment-reply-box').remove();
					$('.comment-insert-box').show();
				}, 
				error : function(xhr, status, error){
					console.log("error");
					console.log(xhr);
				}
			}); 
		
		});
		
		
		
		//해당 게시글의 추천/비추천에 따라 각 버튼의 색상을 채워주는 함수
		function checkRecommendBtns(state, re_state) {
			$('.btn-up, .btn-down').removeClass('btn-danger');
			$('.btn-up, .btn-down').addClass('btn-outline-danger');
			if (state == 0) {
				$(re_state == 1 ? '.btn-up' : '.btn-down').removeClass(
						'btn-outline-danger');
				$(re_state == 1 ? '.btn-up' : '.btn-down').addClass(
						'btn-danger');
			}
		}

		function getCommentList(cri) {

			let num = '${post.po_num}';

			$.ajax({
				url : '<c:url value="/comment/list"/>',
				method : "post", //원하는 방식 선택

				data : cri,
				success : function(data) {
					let cmList = data.cmList;

					displayCommentList(cmList);
					
					let pm = JSON.parse(data.pm);
					displayPagination(pm);

				},
				error : function(xhr, status, error) {

					console.log("error");
					console.log(xhr.responseText);
				}
			});
		}
		
		function displayPagination(pm){

			if(pm.totalCount == 0){
				return;
			}
			
			var disabled = pm.prev ? '' : 'disabled'
					
			str = `
				<ul class="pagination justify-content-center">`;
				
				str +=
					  `<li class="page-item \${disabled}" data-page="\${pm.startPage-1}">
				    	<a class="page-link" href="javascript:void(0);">이전</a>
				    </li>`;
				
				for(var i = pm.startPage; i<=pm.endPage; i++){
					var active = pm.cri.page == i ? 'active' : '';
					
					str +=
						`<li class="page-item \${active}"  data-page="\${i}">
				    	<a class="page-link" href="javascript:void(0);">\${i}</a>
				    </li>`;
				}
				
				var disabled = pm.next ? '' : 'disabled'
						
				str +=		
					`<li class="page-item  \${disabled}"  data-page="\${pm.endPage+1}">
				    	<a class="page-link" href="javascript:void(0);">다음</a>
				    </li>`;
				
			  	str += 
			  	`</ul>`;
				$('.comment-pagination').html(str);
				
		}
		

		function displayCommentList(list) {
			
			var str = '';
			if(list.length == 0){
				str = `<li>등록된 댓글이 없습니다.</li>`;
				$('.comment-list').html(str);
				return;
			}
			console.log(list);
			
			for(co of list){
				
				var delBtn ='';
				var updBtn ='';
				var replyBtn = '';
				if ('${user.me_id}' == co.cm_me_id){
					delBtn += `<a href="javascript:void(0);" data-num="\${co.cm_num}"
					class="btn btn-danger btn-comment-delete" style="font-size: 10px">삭제</a>`;
					updBtn += `<a href="javascript:void(0);" data-num="\${co.cm_num}"
						class="btn btn-success btn-comment-update" style="font-size: 10px">수정</a>`;
				}
				if(co.cm_num == co.cm_ori_num) {
				var replyBtn = `
					<a href="javascript:void(0);" data-cm_num="\${co.cm_num}"
					class="btn btn-info btn-comment-reply" style="font-size: 10px">대댓</a>
				`;
				}
				
				var reportBtn = `
					<a href="javascript:void(0);" data-num="\${co.cm_num}"
					class="btn btn-secondary btn-comment-report" style="font-size: 10px">신고</a>
				`;
				
				// 댓글
				if(co.cm_num == co.cm_ori_num){
					str += `
						<li class="comment-item">`;
				} else { // 대댓글
					str += `
						<li class="comment-item reply">`;
				}
				str += `
					<div>
						<span>\${co.cm_me_id}(\${co.cm_date})</span>
						\${delBtn} \${updBtn} \${replyBtn} \${reportBtn}
					</div>
					<div>\${co.cm_content}</div></li>
				`;					
			}
			$('.comment-list').html(str);
		}
		
		
		function checkLogin(){
			/* console.log('${user.me_id}'); */
			if ('${user.me_id}' == '') {
				if (confirm('로그인이 필요한 서비스입니다.\n 로그인 페이지로 이동하시겠습니까?')) {
					location.href = '<c:url value="/login"/>';
					return false;
				} else {
					return false;
				}
			}
			return true;
		}
	</script>
</body>
</html>