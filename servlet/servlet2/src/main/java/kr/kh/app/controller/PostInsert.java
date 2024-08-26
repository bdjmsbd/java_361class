package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/insert")
public class PostInsert extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PostService postService = new PostServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String coNumStr = request.getParameter("co_num");
		try {
			int co_num = Integer.parseInt(coNumStr);
			request.setAttribute("co_num", co_num);
			request.getRequestDispatcher("/WEB-INF/views/post/insert.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "잘못된 커뮤니티입니다.");
			request.setAttribute("url", "/community");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		String content = req.getParameter("content");

		String coNumStr = req.getParameter("co_num");

		MemberVO user = (MemberVO) req.getSession().getAttribute("user");

		try {

			int coNum = Integer.parseInt(coNumStr);

			PostVO post = new PostVO(coNum, title, content, user.getMe_id());

			boolean res = postService.insertPost(post);

			if (res) {	
				req.setAttribute("msg", "게시글이 등록됐습니다.");
			} else {
				req.setAttribute("msg", "게시글이 등록에 실패했습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		req.setAttribute("url", "/post/list?co_num=" + coNumStr);
		req.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(req, resp);

	}

}
