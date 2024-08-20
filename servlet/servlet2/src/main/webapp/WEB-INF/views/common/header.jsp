<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value ="/"/>">Home</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/signup"/>">회원가입</a></li>
			<li class="nav-item"><a class="nav-link" href="#">로그인</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
			</li>

			<li class="nav-item dropdown w3-display-right"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				data-toggle="dropdown"> Dropdown link </a>
				<div class="dropdown-menu ">
					<a class="dropdown-item" href="#">Link 1</a> <a
						class="dropdown-item" href="#">Link 2</a> <a class="dropdown-item"
						href="#">Link 3</a>
				</div>
			</li>
		</ul>
	</nav>
</body>
</html>