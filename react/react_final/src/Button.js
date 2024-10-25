import './Button.css'



function Button1() {
  return (
      <button onClick={()=>{alert("버튼1")}} class="btn">버튼1</button>
  );
}

const Button2 = () => {
  return (
      <button onClick={()=>{alert("버튼2")}} >버튼2</button>
  );
}

function Button3(props) {
  return (
      <button>{props.text}</button>
  );
}

const Button4 = ({text}) => {
  return (
      <button>{text}</button>
  );
}

function Button5(props) {
  return (
      <button 
			className={props.classNames}>
			{props.text}
			</button>
  );
}

const Button6 = ({text, classNames}) => {
  return (
      <button
			class={classNames}>
			{text}
			</button>
  );
}

const Button7 = ({text, type, classNames, click}) => {
	return(
		<button type={type} className={classNames} onClick={click}>{text}</button>
	);
}

function Button8(props) {
  return (
      <button onClick={()=>{alert(props.value)}}>{props.text}</button>
  );
}

export {Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8};
