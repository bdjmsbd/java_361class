import {useState} from 'react';

/*
1. state 변수 todo와 setTodo]를 선언
2. input 창의 값이 바뀌면 콘솔에 1이 출력되게 작성
*/

function Todo(){

	var [input, setInput] = useState("");
	var [tmp, setTmp] = useState("");

	function inputChange(e){

		setTmp(e.target.value); //setInput(e.target.value);

	}

	function btnClick(){
		setInput(tmp);
	}

	return(
		<div>
			<input onChange={inputChange}/>
			<button onClick={btnClick}>버튼</button>
		</div>
	)
}

export default Todo;