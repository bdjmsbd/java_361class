<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<title>커뮤니티</title>
<style>
.post-table td {
	padding: 10px 4px;
	border-bottom: 1px solid #e9e9e9; line-height : 1.5em;
	word-break: break-all;
	line-height: 1.5em;
}
</style>
</head>
<body>

	<h1>게시글 목록</h1>

	<div class="mb-3">
		<c:forEach items="${list}" var="co">
			<c:choose>
				<c:when test="${co.co_num eq pm.cri.co_num}">
					<a href="<c:url value="/post/list?co_num=${co.co_num}"/>"
						class="btn btn-info"> ${co.co_name} </a>
				</c:when>
				<c:otherwise>
					<a href="<c:url value="/post/list?co_num=${co.co_num}"/>"
						class="btn btn-outline-info"> ${co.co_name} </a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>
	<c:if test="${pm.cri.co_num ne null}">
		<table class="table post-table"
			style="background-color: rgb(34, 85, 119)">
			<thead>
				<tr style="font-weight: bold; color: white;">
					<th style="width: 8%;">-</th>
					<th style="text-align: left; padding-left: 8px">제목</th>
					<th style="width: 10%; text-align: right; padding-left: 8px">글쓴이</th>
					<th style="width: 9%; text-align: center;">날짜</th>
					<th style="width: 7%; text-align: center;">추천수</th>
					<th style="width: 7%; text-align: center;">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${postList.size() == 0}">
					<tr class="table-secondary">
						<td colspan=6 style="text-align: center;">등록된 게시글이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${postList}" var="po">
					<tr class="table-light">
						<td>${po.po_num }</td>
						<td><a href="#">${po.po_title }</a></td>
						<td style="text-align: center;"><c:url var="url"
								value="/post/list">
								<c:param name="co_num" value="${pm.cri.co_num}" />
								<c:param name="type" value="${pm.cri.type }" />
								<c:param name="search" value="${pm.cri.search }" />
							</c:url> <a href="${url }">${po.po_me_id }</a></td>

						<td style="text-align: center;"><c:set var="now"
								value="<%=new java.util.Date()%>" /> <fmt:formatDate
								value="${now}" pattern="MM-dd" var="nowDate" /> <fmt:formatDate
								value="${po.po_date}" pattern="MM-dd" var="po_date" /> <c:choose>
								<c:when test="${po_date eq nowDate}">
									<fmt:formatDate value="${po.po_date}" pattern="HH:mm" />
								</c:when>
								<c:otherwise>
							${po_date}
						</c:otherwise>
							</c:choose></td>
						<td style="text-align: center;">0</td>
						<td style="text-align: center;">${po.po_view }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${pm.totalCount ne 0 }">
			<ul class="pagination justify-content-center">
				<c:if test="${pm.prev }">
					<c:url var="url" value="/post/list">
						<c:param name="co_num" value="${pm.cri.co_num }" />
						<c:param name="page" value="${pm.startPage - 1 }" />
						<c:param name="type" value="${pm.cri.type }" />
						<c:param name="search" value="${pm.cri.search }" />
					</c:url>
					<li class="page-item"><a class="page-link" href="${url }">이전</a>
					</li>
				</c:if>
				<c:forEach begin="${pm.startPage }" end="${pm.endPage}" var="i">
					<c:url var="url" value="/post/list">
						<c:param name="co_num" value="${pm.cri.co_num }" />
						<c:param name="page" value="${i}" />
						<c:param name="type" value="${pm.cri.type }" />
						<c:param name="search" value="${pm.cri.search }" />
					</c:url>
					<c:choose>
						<c:when test="${pm.cri.page eq i }">
							<c:set var="active" value="active" />
						</c:when>
						<c:otherwise>
							<c:set var="active" value="" />
						</c:otherwise>
					</c:choose>
					<li class="page-item ${active}"><a class="page-link"
						href="${url }">${i}</a></li>
				</c:forEach>
				<c:if test="${pm.next }">
					<c:url var="url" value="/post/list">
						<c:param name="co_num" value="${pm.cri.co_num }" />
						<c:param name="page" value="${pm.endPage + 1 }" />
						<c:param name="type" value="${pm.cri.type }" />
						<c:param name="search" value="${pm.cri.search }" />
					</c:url>
					<li class="page-item"><a class="page-link" href="${url }">다음</a>
					</li>
				</c:if>
			</ul>
		</c:if>

		<c:if test="${user ne null}">
			<a href="<c:url value="/post/insert?co_num=${pm.cri.co_num}"/>"
				class="btn btn-outline-success btn-insert" style="float: right;">게시글
				등록</a>
		</c:if>

		<div style="display: flex; justify-content: center;">
			<form action="<c:url value="/post/list"/>" class=""
				style="width: 450px;">
				<input type="hidden" name="co_num" value="${pm.cri.co_num }">
				<div class="input-group mb-3 ">
					<select class="form-control col-3" name="type">
						<option value="all"
							<c:if test="${pm.cri.type eq 'all' }">selected</c:if>>전체</option>
						<option value="title"
							<c:if test="${pm.cri.type eq 'title' }">selected</c:if>>제목</option>
						<option value="id"
							<c:if test="${pm.cri.type eq 'id' }">selected</c:if>>작성자</option>
					</select> <input type="text" class="form-control" placeholder="검색어"
						name="search" value="${pm.cri.search }">
					<div class="input-group-append">
						<button type="submit" class="btn btn-outline-info">검색</button>
					</div>
				</div>
			</form>
		</div>
	</c:if>
</body>
</html>
