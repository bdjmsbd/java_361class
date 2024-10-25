<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

	<h2>실시간 대기오염 정보</h2>
	지역 :
	<select id="location">

		<option>서울</option>

		<option>부산</option>

		<option>대전</option>

	</select>

<!-- 	<button id="btn1">해당 지역 대기오염 정보</button>

	<br>
	<br>
	<table id="result1" border="1">

		<thead>

			<tr>

				<th>측정소명</th>

				<th>측정일시</th>

				<th>통합대기환경수치</th>

				<th>미세먼지농도</th>

				<th>일산화탄소농도</th>

				<th>이산화질소농도</th>

				<th>아황산가스농도</th>

				<th>오존농도</th>

			</tr>
		</thead>
		<tbody>
					stationName
			dataTime
			khaiValue
			pm10Value
			coValue
			no2Value
			so2Value
			o3Value

		</tbody>

	</table> -->
<button id="btn2">해당 지역 대기오염 정보</button>
<table id="result2" border="1">

		<thead>

			<tr>

				<th>측정소명</th>

				<th>측정일시</th>

				<th>통합대기환경수치</th>

				<th>미세먼지농도</th>

				<th>일산화탄소농도</th>

				<th>이산화질소농도</th>

				<th>아황산가스농도</th>

				<th>오존농도</th>

			</tr>
		</thead>
		<tbody>
<!-- 					stationName
			dataTime
			khaiValue
			pm10Value
			coValue
			no2Value
			so2Value
			o3Value -->

		</tbody>

	</table>
	<script>
		/* $(function() {

			$("#btn1").click(function() {

				$.ajax({

					url : "air.do",

					data : {
						location : $("#location").val()
					},

					success : function(data) {

						const itemArr = data.response.body.items;

						let value = "";
						
						let tbody = document.querySelector('tbody');
						
						for ( let i in itemArr) {

					        value += `<tr>
								<td>${i.stationName}</td>
								<td>${i.dataTime}</td>
								<td>${i.khaiValue}</td>
								<td>${i.pm10Value}</td>
								<td>${i.coValue}</td>
								<td>${i.no2Value}</td>
								<td>${i.so2Value}</td>
								<td>${i.o3Value}</td>
				        			</tr>`;

				    }
				    tbody.innerHTML = str; // tbody에 내용 추가

						}

						$("#result1 tbody").html(value);

					}

				})

			})

		})
		 */
		$("#btn2").click(function() {
			
			result = `{"response":{"body":{"totalCount":40,"items":[{"so2Grade":"1","coFlag":null,"khaiValue":"56","so2Value":"0.003","coValue":"0.4","pm10Flag":null,"o3Grade":"1","pm10Value":"24","khaiGrade":"2","sidoName":"서울","no2Flag":null,"no2Grade":"1","o3Flag":null,"so2Flag":null,"dataTime":"2024-10-25 11:00","coGrade":"1","no2Value":"0.012","stationName":"중구","pm10Grade":"1","o3Value":"0.016"},{"so2Grade":"1","coFlag":null,"khaiValue":"52","so2Value":"0.003","coValue":"0.5","pm10Flag":null,"o3Grade":"1","pm10Value":"25","khaiGrade":"2","sidoName":"서울","no2Flag":null,"no2Grade":"1","o3Flag":null,"so2Flag":null,"dataTime":"2024-10-25 11:00","coGrade":"1","no2Value":"0.025","stationName":"한강대로","pm10Grade":"2","o3Value":"0.020"},{"so2Grade":"1","coFlag":null,"khaiValue":"59","so2Value":"0.004","coValue":"0.4","pm10Flag":null,"o3Grade":"1","pm10Value":"28","khaiGrade":"2","sidoName":"서울","no2Flag":null,"no2Grade":"1","o3Flag":null,"so2Flag":null,"dataTime":"2024-10-25 11:00","coGrade":"1","no2Value":"0.023","stationName":"종로구","pm10Grade":"2","o3Value":"0.022"},{"so2Grade":"1","coFlag":null,"khaiValue":"60","so2Value":"0.003","coValue":"0.7","pm10Flag":null,"o3Grade":"1","pm10Value":"34","khaiGrade":"2","sidoName":"서울","no2Flag":null,"no2Grade":"1","o3Flag":null,"so2Flag":null,"dataTime":"2024-10-25 11:00","coGrade":"1","no2Value":"0.029","stationName":"청계천로","pm10Grade":"2","o3Value":"0.016"},{"so2Grade":"1","coFlag":null,"khaiValue":"51","so2Value":"0.003","coValue":"0.6","pm10Flag":null,"o3Grade":"1","pm10Value":"28","khaiGrade":"2","sidoName":"서울","no2Flag":null,"no2Grade":"1","o3Flag":null,"so2Flag":null,"dataTime":"2024-10-25 11:00","coGrade":"1","no2Value":"0.026","stationName":"종로","pm10Grade":"2","o3Value":"0.015"},{"so2Grade":"1","coFlag":null,"khaiValue":"56","so2Value":"0.003","coValue":"0.4","pm10Flag":null,"o3Grade":"1","pm10Value":"31","khaiGrade":"2","sidoName":"서울","no2Flag":null,"no2Grade":"1","o3Flag":null,"so2Flag":null,"dataTime":"2024-10-25 11:00","coGrade":"1","no2Value":"0.022","stationName":"용산구","pm10Grade":"2","o3Value":"0.019"},{"so2Grade":"1","coFlag":null,"khaiValue":"51","so2Value":"0.003","coValue":"0.4","pm10Flag":null,"o3Grade":"2","pm10Value":"19","khaiGrade":"2","sidoName":"서울","no2Flag":null,"no2Grade":"1","o3Flag":null,"so2Flag":null,"dataTime":"2024-10-25 11:00","coGrade":"1","no2Value":"0.013","stationName":"광진구","pm10Grade":"1","o3Value":"0.031"},{"so2Grade":"1","coFlag":null,"khaiValue":"50","so2Value":"0.004","coValue":"0.3","pm10Flag":null,"o3Grade":"1","pm10Value":"28","khaiGrade":"1","sidoName":"서울","no2Flag":null,"no2Grade":"1","o3Flag":null,"so2Flag":null,"dataTime":"2024-10-25 11:00","coGrade":"1","no2Value":"0.015","stationName":"성동구","pm10Grade":"1","o3Value":"0.025"},{"so2Grade":"1","coFlag":null,"khaiValue":"51","so2Value":"0.003","coValue":"0.6","pm10Flag":null,"o3Grade":"1","pm10Value":"33","khaiGrade":"2","sidoName":"서울","no2Flag":null,"no2Grade":"1","o3Flag":null,"so2Flag":null,"dataTime":"2024-10-25 11:00","coGrade":"1","no2Value":"0.029","stationName":"강변북로","pm10Grade":"2","o3Value":"0.009"},{"so2Grade":"1","coFlag":null,"khaiValue":"43","so2Value":"0.002","coValue":"0.3","pm10Flag":null,"o3Grade":"1","pm10Value":"20","khaiGrade":"1","sidoName":"서울","no2Flag":null,"no2Grade":"1","o3Flag":null,"so2Flag":null,"dataTime":"2024-10-25 11:00","coGrade":"1","no2Value":"0.012","stationName":"중랑구","pm10Grade":"1","o3Value":"0.025"}],"pageNo":1,"numOfRows":10},"header":{"resultMsg":"NORMAL_CODE","resultCode":"00"}}}`;
			let parsedResult = JSON.parse(result);
			itemArr = parsedResult.response.body.items;
			console.log(itemArr);
			let value = "";
			
			let tbody = document.querySelector('tbody');
			
			for ( let i in itemArr) {
value += `<tr>
	<td>\${itemArr[i].stationName}</td>
	<td>\${itemArr[i].dataTime}</td>
	<td>\${itemArr[i].khaiValue}</td>
	<td>\${itemArr[i].pm10Value}</td>
	<td>\${itemArr[i].coValue}</td>
	<td>\${itemArr[i].no2Value}</td>
	<td>\${itemArr[i].so2Value}</td>
	<td>\${itemArr[i].o3Value}</td>
</tr>`;
		        /* value += `<tr>
					<td>${itemArr[i].stationName}</td>
					<td>${itemArr[i].dataTime}</td>
					<td>${itemArr[i].khaiValue}</td>
					<td>${itemArr[i].pm10Value}</td>
					<td>${itemArr[i].coValue}</td>
					<td>${itemArr[i].no2Value}</td>
					<td>${itemArr[i].so2Value}</td>
					<td>${itemArr[i].o3Value}</td>
	        			</tr>`;
 */
	    	}
			tbody.innerHTML = value; // tbody에 내용 추가


			$("#result2 tbody").html(value);
		})
	</script>

</body>

</html>