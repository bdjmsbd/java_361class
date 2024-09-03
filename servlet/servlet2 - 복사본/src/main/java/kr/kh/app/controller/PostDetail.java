package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/detail")
public class PostDetail extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PostService postService = new PostServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String poNumStr = request.getParameter("po_num");

		try {

			int poNum = Integer.parseInt(poNumStr);
			PostVO post = postService.getPost(poNum);

			if (post == null) {
				throw new RuntimeException();
			}

			CommunityVO cm = postService.getCommunity(Integer.toString(post.getPo_co_num()));
			if (cm == null) {
				throw new RuntimeException();
			}
			
			postService.updatePostView(poNum);
			post.setPo_view(post.getPo_view()+1);
			
			request.setAttribute("cm_name", cm.getCo_name());
			request.setAttribute("post", post);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/views/post/detail.jsp").forward(request, response);
	}

}
