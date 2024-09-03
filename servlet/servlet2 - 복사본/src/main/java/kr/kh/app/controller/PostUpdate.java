package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/update")
public class PostUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PostService postService = new PostServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String poNumStr = request.getParameter("po_num");
		String coNumStr = request.getParameter("co_num");

		try {
			int po_num = Integer.parseInt(poNumStr);

			PostVO post = postService.getPost(po_num);
			if (post == null) {
				throw new RuntimeException();
			}

			request.setAttribute("post", post);
			request.getRequestDispatcher("/WEB-INF/views/post/update.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "잘못된 경로입니다.");
			request.setAttribute("url", "/post/list?co_num=" + coNumStr);
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		String content = req.getParameter("content");

		String poNumStr = req.getParameter("po_num");

		MemberVO user = (MemberVO) req.getSession().getAttribute("user");

		try {

			int poNum = Integer.parseInt(poNumStr);
			PostVO post = postService.getPost(poNum);
			PostVO updatePost = new PostVO(post.getPo_co_num(), title, content, user.getMe_id());
			updatePost.setPo_num(post.getPo_num());

			boolean res = postService.updatePost(updatePost, user);

			if (res) {
				req.setAttribute("msg", "게시글을 수정했습니다.");
			} else {
				throw new RuntimeException();
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "게시글을 수정하지 못했습니다.");

		}

		req.setAttribute("url", "/post/detail?po_num=" + poNumStr);
		req.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(req, resp);

	}

}
