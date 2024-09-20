import { useEffect, useState } from "react";


function FetchEx1(){
	let [str, setStr] = useState('');
	let [obj, setObj] = useState({});
	let [person, setPerson] = useState({
		name : '',
		age : ''
	})
	
	function submit(e){
		e.preventDefault();

		//form 태그 안에 있는 input 태그들 값을 읽어 온다. 
		const data = new FormData(e.target);
		// console.log(data.get("name"));
		// console.log(data.get("age"));
		
			// let url = "/spring/react/send/person";
			// fetch(url,{
			// 	method: 'post',
			// 	body: data
			// })
			// .then(res=>res.text())
			// .then(data=>console.log(data))
			// .catch(error =>console.log(error));

			let url = "/spring/react/send/person2";
			// let obj = {
			// 	name : data.get("name"),
			// 	age: data.get("age")
			// }
			fetch(url,{
				method: 'post',
				body: JSON.stringify(person),
				headers: {
					'Content-Type' : 'application/json'
				}
			})
			.then(res=>res.text())
			.then(data=>console.log(data))
			.catch(error =>console.log(error));
		
	}

	

	// obj로 번거롭게 하나씩 추가할 필요가 없다.
	function change(e) {
		setPerson({
			...person, 
			[e.target.name] : e.target.value
		})
	}
	
	return(
	<div>
		<h1>{str}</h1>
		{ // obj && 의미 : null이면 실행이 안되고, 
			obj && (
				<div>
					<div> 이름 : {obj.name} </div>
					<div> 나이 : {obj.age} </div>
				</div>
			)
		}
		{/* <form action="/spring/react/post/person"> */}
		<form onSubmit={submit}>
			<input name="name" placeholder="이름을 입력하세요" onChange={change}/><br/>
			<input name="age" placeholder="나이를 입력하세요" onChange={change}/><br/>
			<button type="submin">등록</button>

		</form>
	</div>
	)
}

export default FetchEx1;