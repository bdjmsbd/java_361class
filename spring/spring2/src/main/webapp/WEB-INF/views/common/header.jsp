<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<link rel='stylesheet'
	href='https://cdn-uicons.flaticon.com/2.5.1/uicons-solid-rounded/css/uicons-solid-rounded.css'>

</head>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

	<a class="navbar-brand" href="<c:url value="/"/>"> <img
		src="https://cdn.pixabay.com/photo/2020/05/20/07/52/rooster-5195311_1280.jpg"
		alt="LogoHome" style="width: 90px;">
	</a>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="#">링크 1</a></li>
		<li class="nav-item"><a class="nav-link" href="#">링크 2</a></li>
		<li class="nav-item w3-display-right" style="padding-right: 120px;">
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				<form class="form-inline" action="/action_page.php">
					<input class="form-control mr-sm-2 col-8" type="text"
						placeholder="input text ...">
					<button class="btn btn-success col-3" type="submit">Search</button>
				</form>
			</nav>
		</li>
		<li class="nav-item dropdown w3-display-right"
			style="padding-right: 20px;"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> <span
				class="fi fi-sr-menu-burger " style="font-size: 48px;"></span>
			</a>
			<div class="dropdown-menu" style="top: 70px; left: -60px">
				<a href="<c:url value="/join"/>" class="dropdown-item"> 회원가입 </a> 
				<a class="dropdown-item" href="<c:url value="/login"/>">로그인</a> 
				<a class="dropdown-item"					href="#">로그아웃</a>
			</div>
		</li>
	</ul>
</nav>

