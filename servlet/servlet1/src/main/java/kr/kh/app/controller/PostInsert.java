package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

/*
 * 값 이하라면 임시파일을 생성하지 않고 메모리에서 즉시 파일을 읽어서 생성할 수 있어요. 
 * 속도는 더 빠르겠지만, 쓰레드가 작업을 수행하는 동안 부담이 되는 부분이기 때문에 충분한 검토가 필요한 설정이에요.
 * 파일의 크기가 fize-size-threshold 값을 초과한다면 파일은 
 * spring.servlet.multipart.location 경로에 저장되어 해당 파일을 읽어서 작업을 하도록 되어있어요.
 * */
@WebServlet("/post/insert")
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10, // 10Mb
		maxRequestSize = 1024 * 1024 * 10 * 3,
		fileSizeThreshold = 1024 * 1024
)
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String coNumStr = request.getParameter("co_num");
		String title = request.getParameter("title");
		String content = request.getParameter("content")
		/*
		 * .replace("<p>", "") .replace("</p>", "") .replace("<br>", "\n")
		 */
		;
		System.out.println("title : " + title + "\ncontent : " + content);

		try {
			int co_num = Integer.parseInt(coNumStr);

			MemberVO user = (MemberVO) request.getSession().getAttribute("user");

			if (user == null) {
				throw new RuntimeException();
			}

			String id = user.getMe_id();

			PostVO post = new PostVO();
			
			//첨부파일을 가져옴
			ArrayList<Part> files = (ArrayList<Part>)request.getParts();
			
			post.setPo_co_num(co_num);
			post.setPo_title(title);
			post.setPo_content(content);
			post.setPo_me_id(id);

			if (postService.insertPost(post, files)) {
				request.setAttribute("msg", "게시글을 등록했습니다.");
				request.setAttribute("url", "/post/list?co_num=" + co_num);

			} else {
				throw new RuntimeException();
			}

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("msg", "게시글 등록에 실패했습니다.");
			request.setAttribute("url", "/post/list?co_num=" + coNumStr);
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);

	}

}
