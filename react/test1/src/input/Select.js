
import { useState } from "react";


/*
	select 태그를 이용해서 과일은 선택할 수 있는 창을 만들고,
	과일을 선택하면 h1태그에 선택한 과일이 출력되도록 작성
	- 선택암함, 사과, 바나나, 오렌지
*/

function Select() {

	let fruits = ["선택안함", "사과", "바나나", "오렌지"];
	let [selected, setSelected] = useState("");

	let showFruits = (e) => {
		setSelected(e.target.value);
	}
	
	function display() {
		return selected == "선택안함"?"":selected;
	}

	return (
		<div>

			<label>과일선택</label>
			<select onChange={showFruits}>
				{
					fruits.map((v,index) => {
						return (
							<option value={v} key={index}>{v}</option>
						)
					})
				}
			</select>
			<h1>{display()}</h1>
		</div>
	)
}

export default Select;
