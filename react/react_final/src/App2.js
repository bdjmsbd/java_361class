import { useState } from "react";

function App2() {
	let [title, setTitle] = useState('');
	let [id, setId] = useState('');
	let [content, setContent] = useState('');
	let [list, setList] = useState([]);

	const click = () => {
		alert('제목: ' + title + '\n작성자: ' + id + '\n내용: ' + content)

		setList(prevList => [
			...prevList,
			{ title: title, id: id, content: content }
		]);

		setTitle('');
		setId('');
		setContent('');
	}

	return (
		<div>
			<div>
			<table className="styled-table">
          <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>작성자</th>
            </tr>
          </thead>
          <tbody>
            {
              list.map((item, index) => (
                <tr key={index}>
									<td>{index+1}</td>
                  <td>{item.title}</td>
                  <td>{item.id}</td>
                </tr>
              ))
            }
          </tbody>
        </table>
			</div>
			<div>
				<Input text="제목" change={setTitle} value={title} /><br />
				<Input text="작성자" change={setId} value={id} /><br />
				<textarea placeholder='내용 입력' onChange={(e) => setContent(e.target.value)} value={content}></textarea><br />
				<button type="button" onClick={click}>등록</button>
			</div>
		</div>
	)
}

function Input({ text, change, value }) {
	return (
		<input type='text' onChange={(e) => change(e.target.value)} value={value} placeholder={text + "를 입력하세요"}></input>
	)
}

export default App2;