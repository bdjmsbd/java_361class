import {BrowserRouter, Link, Route, Routes} from 'react-router-dom';
import PostList from './PostList';

function Nav() {

	return(
		<nav>
			<ul>
				<li>
					<Link to={"/"}>
					홈
					</Link>

				</li>
				<li>
					<Link to={"/"}>
						커뮤니티
					</Link>
				</li>
			</ul>
		</nav>
	);
}

export default Nav;