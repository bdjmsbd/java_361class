package kr.kh.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/detail")
public class PostDetail extends HttpServlet {

	private static final long serialVersionUID = 1L;
	PostService postService = new PostServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String poNumStr = request.getParameter("num");

		try {
			int poNum = Integer.parseInt(poNumStr);

			postService.updatePostView(poNum);

			PostVO post = postService.getPost(poNum);

			// 로그인한 회원의 추천 정보를 가져온다.
			MemberVO user = (MemberVO) request.getSession().getAttribute("user");
			RecommendVO recommend = postService.getRecommend(poNum, user);
			
			post.setPo_up(postService.getUp(post.getPo_num()));
			post.setPo_down(postService.getDown(post.getPo_num()));
			
			List<FileVO> fileList = postService.getFileList(post.getPo_num());
			
			request.setAttribute("fileList", fileList);
		
			request.setAttribute("post", post);
			request.setAttribute("re_state", recommend.getRe_state());

		} catch (Exception e) {

		}

		request.getRequestDispatcher("/WEB-INF/views/post/detail.jsp").forward(request, response);
	}

}
