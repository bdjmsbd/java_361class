
import { useState } from 'react';
import './App.css';
import { Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8 } from './Button';

function App() {
  const text7 = "버튼7";
  const click = (t) => {
    alert('t');
  }

  let [text, setText] = useState('');
  return (
    <div>
      { <Button1 /> }
      { <Button2 /> }

      { <Button3 text={"버튼33"} />}
      { <Button4 text={"버튼44"} />}

      { <Button5 text={"버튼5"} classNames="btn"/>}
      { <Button6 text={"버튼6"} classNames="btn" />}

      <br/>
      <Button7 text={text7} type={"button"} classNames={"btn"} click={()=>click(text7)}/>

      <form>
        <input onChange={(e)=>setText(e.target.value)}></input>
        <Button8 text="버튼8" value={text}></Button8>
        
      </form>
    </div>
  );
}

export default App;
