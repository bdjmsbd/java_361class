import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Link } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';

function PostDetail() {

	let [date, setDate] = useState('');
	let [post, setPost] = useState({});

	const { po_num } = useParams();

	useEffect(() => {
		fetch('/spring/react/post/detail/' + po_num)
			.then((res) => res.json())
			.then(data => {
				setPost(data);

				var date = (new Date(data.po_date)).toLocaleDateString();
				// 함수형 업데이트 사용
				setPost(post => ({
					...post,
					fmt_date: date
				}));
				// console.log(post)
				setDate(date)
			})
	}, []);
	
	return (
		<div className="container my-4">
			<div className="card" style={{ maxWidth: '600px', margin: '0 auto' }}>
				<div className="card-body">
					<h3 className="card-title">{post.po_title}</h3>
					<div className="mb-2">
						<strong>작성자:</strong> <span>{post.po_me_id}</span>
					</div>
					<div className="mb-2">
						<strong>조회수:</strong> <span>{post.po_view}</span>
					</div>
					<div className="mb-2">
						<strong>날짜:</strong> <span>{post.fmt_date}</span>
					</div>
					<div className="mb-3">
						<strong>내용:</strong>
						<div className="border rounded p-2" style={{ maxHeight: '200px', overflowY: 'auto' }}>
							<div dangerouslySetInnerHTML={{ __html: post.po_content }} />
						</div>
					</div>
					<Link to={`/post/list/${post.po_co_num}`} className="btn btn-primary">목록으로</Link>
				</div>
			</div>
		</div>
	)
}

export default PostDetail;