
import {Container} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import Signup from "./Singup";

function App() {


  

  return (
    <Container>
      <h1>회원가입</h1>
      {/* <form onSubmit={submit}>
        <div>
        <label>아이디</label>
        <input type="text" name="me_id" onChange={change} placeholder="아이디를 입력하세요." />
        </div><div>
        <label>비밀번호</label>
        <input type="password" name="me_pw" onChange={change} placeholder="비밀번호를 입력하세요." />
        </div><div>
        <label>비밀번호 확인</label>
        <input type="password" name="pw_check"placeholder="비밀번호를 다시 입력하세요." />
        </div><div>
        <label>이메일</label>
        <input type="email" name="me_email" onChange={change} placeholder="이메일을 입력하세요." />
        </div>
        <Button type='submit'>가입</Button>
      </form> 
      */}
      <Signup/>
     
    </Container>
  );
}

export default App;
