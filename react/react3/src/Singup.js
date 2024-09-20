import { Button, Form } from 'react-bootstrap';
import { useState } from "react";

function Signup() {

	let [user, setUser] = useState({
		me_id: '',
		me_pw: '',
		me_email: ''
	})

	let [pw2, setPw2] = useState('');

	function submit(e) {

		e.preventDefault();

		if (user.me_id === '') {
			alert("아이디는 필수 항목입니다.");
			return;
		}

		if (user.me_email === '') {
			alert("이메일은 필수 항목입니다.");
			return;
		}

		if (user.me_pw === '') {
			alert("비밀번호는 필수 항목입니다.");
			return;
		}

		const data = new FormData(e.target);
		if (data.get("pw_check") !== (user.me_pw)) {
			alert("비밀번호가 일치하지 않습니다.")
			return;
		}

		let url = "/spring/test/signup";

		fetch(url, {
			method: 'post',
			body: JSON.stringify(user),
			headers: {
				'Content-Type': 'application/json'
			}
		})
			.then(res => res.json())
			.then(data => alertJoin(data))
			.catch(error => console.log(error));

	}

	function alertJoin(res) {
		console.log(res)
		if (res) {
			alert("회원가입 성공!")
			setUser({
				me_id: '',
				me_pw: '',
				me_email: ''
			});
			setPw2('');
		}
		else
			alert("회원가입 실패!")
	}

	function change(e) {
		setUser({
			...user,
			[e.target.name]: e.target.value
		})
	}

	function changePwCheck(e) {
		setPw2(e.target.value); // 비밀번호 확인 상태 업데이트
}

	return (

		<Form onSubmit={submit}>
			<Form.Group className="mb-3"  >
				<Form.Label htmlFor="me_id">아이디</Form.Label>
				<Form.Control type="text" placeholder="아이디를 입력하세요." name="me_id" value={user.me_id} onChange={change} />
			</Form.Group>
			<Form.Group className="mb-3" >
				<Form.Label htmlFor="me_pw">비밀번호</Form.Label>
				<Form.Control type="password" placeholder="비밀번호를 입력하세요." name="me_pw" value={user.me_pw} onChange={change} />
			</Form.Group>
			<Form.Group className="mb-3" >
				<Form.Label htmlFor="pw_check">비밀번호</Form.Label>
				<Form.Control type="password" placeholder="비밀번호를 한번 더 입력하세요." name="pw_check"  value={pw2} onChange={changePwCheck}/>
			</Form.Group>
			<Form.Group className="mb-3" >
				<Form.Label htmlFor="me_email">이메일</Form.Label>
				<Form.Control type="email" placeholder="이메일을 입력하세요." name="me_email" onChange={change} value={user.me_email} />
			</Form.Group>
			<Button type='submit'>가입</Button>
		</Form>
	)
}

export default Signup;