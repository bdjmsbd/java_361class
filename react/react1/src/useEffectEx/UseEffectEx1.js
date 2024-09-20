import { useEffect, useState } from "react";

// state 변수를 이용해서 화면을 렌더링하여 useEffect를 확인하는 예제
function UseEffectEx1() {
	let [num, setNum] = useState(1);
	let [maxNum, setMaxNum] = useState(5);
	console.log("init");
	
	// state 변수의 값이 변경될 때 마다 effect가 실행된다. 
	useEffect(()=>{
		console.log("useEffect" + maxNum);
	}, [maxNum]);

	return (
		<div>
			<button onClick={()=>setNum(num-1)}>-</button>
			<span>{num}</span>
			<button onClick={()=>{
				if(num + 1 === maxNum) {
					setMaxNum(maxNum+5)
				}
				setNum(num+1)
				}}>+</button>
		</div>
	)
}

export default UseEffectEx1;