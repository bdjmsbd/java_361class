package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/delete")
public class PostDelete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PostService postService = new PostServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String poNumStr = request.getParameter("po_num");

		try {

			int poNum = Integer.parseInt(poNumStr);
			PostVO post = postService.getPost(poNum);
			
			MemberVO user = (MemberVO) request.getSession().getAttribute("user");


			if (post == null || user == null) {
				throw new RuntimeException();
			}
			
			int coNum = post.getPo_co_num();
			
			boolean res = postService.deletePost(post, user);
			
			if(!res) {
				throw new RuntimeException();
			}
			request.setAttribute("msg", "게시글이 삭제되었습니다.");
			request.setAttribute("url", "/post/list?co_num=" + Integer.toString(coNum));
			

		} catch (Exception e) {
			request.setAttribute("msg", "게시글을 삭제하지 못했습니다.");
			request.setAttribute("url", "/post/detail?po_num=" + poNumStr);
			
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
