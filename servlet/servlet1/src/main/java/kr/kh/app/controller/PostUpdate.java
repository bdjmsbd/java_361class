package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/update")
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10, // 10Mb
		maxRequestSize = 1024 * 1024 * 10 * 3,
		fileSizeThreshold = 1024 * 1024
)
public class PostUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	PostService postService = new PostServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 게시글 번호를 반아옴
		String po_numStr = request.getParameter("po_num");
		try {
			int po_num = Integer.parseInt(po_numStr);
			MemberVO user = (MemberVO) request.getSession().getAttribute("user");
			// 회원 정보를 받아옴
			PostVO post = postService.getPost(po_num, user);
			// 서비스에게 게시글 번호와 회원 정보를 주면서 게시글을 가져오라고 요청

			if (post != null) {
				
				List<FileVO> fileList = postService.getFileList(po_num);
				
				request.setAttribute("fileList", fileList);
				request.setAttribute("post", post);
				request.getRequestDispatcher("/WEB-INF/views/post/update.jsp").forward(request, response);
			} else {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			// null이면 작성자가 아니거나 게시글이 없습니다라고 출력
			request.setAttribute("msg", "작성자가 아니거나 등록된 게시물이 없습니다.");
			request.setAttribute("url", "/post/detail?po_num=" + po_numStr);
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String poNumStr = request.getParameter("po_num");

		try {
			int poNum = Integer.parseInt(poNumStr);

			String title = request.getParameter("title");
			String content = request.getParameter("content");

			MemberVO user = (MemberVO) request.getSession().getAttribute("user");

			PostVO post = postService.getPost(poNum, user);

			post.setPo_title(title);
			post.setPo_content(content);
			
			List<Part> fileList = (List<Part>)request.getParts();
			
			String numStr [] = request.getParameterValues("fi_num");
			
			if (postService.updatePost(post, user, fileList, numStr)) {
				request.setAttribute("msg", "게시물 수정에 성공했습니다.");
				request.setAttribute("url", "/post/detail?num="+poNumStr);
			} else {
				throw new RuntimeException();
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "게시물 수정에 실패했습니다.");
			request.setAttribute("url", "/post/detail?num="+poNumStr);
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);

	}

}
