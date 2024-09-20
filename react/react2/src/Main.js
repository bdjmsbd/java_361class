import { useEffect, useState } from "react";
import { Link } from "react-router-dom";


function Main() {

  const [list, setList] = useState([]);

  useEffect(() => {
    fetch('/spring/react/community/list')
      .then((res) => res.json())
      .then(res => {
        setList(res);
        //console.log(res);
      })
  }, []);

  return (
      <div className="container">
      <h1>커뮤니티 목록</h1>
        <div className="row">
          {list.map(item => (
             <div className="col-6 col-md-2 mb-2 d-flex" key={item.co_num}>
             <Link to={`/post/list/${item.co_num}`} className="btn btn-primary w-100 h-100 d-flex align-items-center justify-content-center">
                 {item.co_name}
             </Link>
         </div>
          ))}
        </div>
      </div>
  );
}

export default Main;
