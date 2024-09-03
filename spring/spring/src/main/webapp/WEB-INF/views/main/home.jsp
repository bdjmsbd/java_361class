<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>

<body>

	<div class="container" style="min-height: calc(100vh - 237px)">
		<h1>Hello world!</h1>
		<%
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = simpleDate.format(date);
		%>
		오늘 날짜는
		<%=strDate%>입니다. 
						
		
		<c:set var="nowDate" value='<%=strDate%>' />		
		<c:set var="Date" value='<%=strDate%>' />
		
		
		<c:set var="today" value="<%=new java.util.Date() %>"/>
		
		<div><fmt:formatDate value="${today}" pattern="MM-dd" var="ang" /></div>
		앙, ${ ang}
		
		<c:if test="${nowDate eq Date }">
			안녕2222
		</c:if>
				
		<br>

		<h2>데이터 전송 연습(서버로)</h2>

		<form action="<c:url value="/"/>" method="post">
			<input type="text" name="name" placeholder="이름 입력"> <br>
			<input type="text" name="age" placeholder="나이 입력"> <br>
			<button type="submit">전송</button>

		</form>
	</div>

</body>
</html>
