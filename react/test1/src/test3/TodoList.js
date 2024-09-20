import { useState } from 'react';
import Li from "../test1/Li";

/* 
input 창과 버튼, 리스트를 구성해서 버튼을 클릭하면 input 창에 들어간 값이 오늘의 할일에 추가 되도록 작성.
*/

function TodoList() {

	let [todo, setTodo] = useState("");
	let [list, setList] = useState([]);

	function getTodo(e) {
		setTodo(e.target.value);
	}

	function AddList() {
		// list.push(todo);
		if (todo != "") {
			setList([...list, todo]);
			console.log("Todo : " + todo);
			console.log("list : " + list);
		}
	}

	return (
		<div>
			<input onChange={getTodo} />
			<button onClick={AddList}>버튼</button>
			<h1>오늘의 할일</h1>
			<ul>{list.map((value) => { return <Li text={value} /> })}</ul>
		</div>
	)
}

export default TodoList;