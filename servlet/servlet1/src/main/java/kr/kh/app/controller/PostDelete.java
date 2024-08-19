package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/delete")
public class PostDelete extends HttpServlet {

	private static final long serialVersionUID = 1L;
	PostService postService = new PostServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 게시글 번호를 반아옴
		String po_numStr = request.getParameter("po_num");
		PostVO post = null; 
		
		try {
			int po_num = Integer.parseInt(po_numStr);
			post= postService.getPost(po_num);
			MemberVO user = (MemberVO) request.getSession().getAttribute("user");
			// 회원 정보를 받아옴

			if (postService.removePost(po_num, user)) {

				request.setAttribute("msg", "게시물이 삭제되었습니다.");

			} else {
				throw new RuntimeException();
			}

		} catch (Exception e) {
			// null이면 작성자가 아니거나 게시글이 없습니다라고 출력
			request.setAttribute("msg", "작성자가 아니거나 등록된 게시물이 없습니다.");
		}
				
		request.setAttribute("url", "/post/list?co_num="+((post==null)?"":post.getPo_co_num()));
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);

	}

}
