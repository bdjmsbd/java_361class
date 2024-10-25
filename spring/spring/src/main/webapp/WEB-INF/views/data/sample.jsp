<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>

<body>

	<h1>공공데이터</h1>
	<table>
		<thead>
			<tr>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<td></td>
		</tbody>
	</table>

<script type="text/javascript">
fetch("<c:url value='/data/sample'/>", {
    method: 'post'
})
.then(res => {
    if (!res.ok) {
        throw new Error('Network response was not ok');
    }
    return res.json();
})
.then(res => {
    let list = res.response.body.items; // 응답 데이터 매핑
    let tbody = document.querySelector('tbody'); // tbody 요소 선택
    let str = ''; // str 변수 초기화
    console.log(res)
    for (let item of list) {
    	console.log(item.imageUrl1)
           str += `
        <tr>
            <td><img alt="이미지없음" src="\${item.imageUrl1}" height="200"></td>
        </tr>
        `;   
/*      str += '<tr><td><img alt="이미지없음" src="'
    		+ item.imageUrl1 
    		+'"height="200"></td></tr> ';  */
    }
    tbody.innerHTML = str; // tbody에 내용 추가
})
.catch(error => console.error('Error:', error)); // 오류 출력
	
</script>
</body>
</html>
