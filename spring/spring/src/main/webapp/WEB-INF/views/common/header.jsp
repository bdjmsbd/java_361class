<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 10px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown-content .dropdown-item {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: center;
}

.dropdown-content a:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value ="/"/>">Home</a></li>

			<li class="nav-item dropdown pl-5"><a
				class="nav-link dropdown-toggle" href="<c:url value="/post/list"/>">커뮤니티</a>
				<div class="dropdown-content" id="community-list"></div></li>

			<c:if test="${user.me_authority == 'ADMIN'}">
				<li class="nav-item dropdown pl-2"><a class="nav-link"
					href="<c:url value="/admin/community"/>">커뮤니티 관리</a>
			</c:if>

			<c:if test="${user == null}">
				<li class="nav-item w3-display-right" style="padding-right: 65px">
					<a class="nav-link pr-5" href="<c:url value="/signup"/>">회원가입</a>
				</li>
				<li class="nav-item w3-display-right"><a class="nav-link pr-5"
					href="<c:url value="/login"/>">로그인</a></li>
			</c:if>
			<c:if test="${user != null }">
				<li class="nav-item w3-display-right" style="margin: 0px 110px 0px 0px;"><a class="nav-link"
					href="<c:url value="/mypage"/>">마이 페이지</a></li>
				<li class="nav-item w3-display-right"><a class="nav-link pr-5"
					href="<c:url value="/logout"/>">로그아웃</a></li>
			</c:if>
			<li class="nav-item"><a class="nav-link disabled" href="#"></a>
			</li>

			<!-- <li class="nav-item dropdown w3-display-right"><a
				class="nav-link dropdown-toggle pr-5" href="#" id="navbardrop"
				data-toggle="dropdown"> Dropdown link </a>
				<div class="dropdown-menu ">
					<a class="dropdown-item" href="#">Link 1</a> <a
						class="dropdown-item" href="#">Link 2</a> <a class="dropdown-item"
						href="#">Link 3</a>
				</div></li> -->
		</ul>
	</nav>

	<script type="text/javascript">
	
	$.ajax({
		async : true,
		url : '<c:url value="/post/community/list"/>',
		type : 'post',
		success : function (data) {
			var str = '';
			for(community of data) {
				str += `
					<a class="dropdown-item" href="<c:url value="/post/list?co_num="/>\${community.co_num}">\${community.co_name}</a>
				`
			}
			$('#community-list').html(str);
		},
		error : function(jqXHR, textStatus, errorThrown){
			
		}	
	});
	</script>

</body>
</html>
