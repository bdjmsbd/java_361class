package kr.kh.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/community")
public class Community extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();

	// 서비스에게 등록된 커뮤니티 목록을 가져오라고 요청
	// 화면에 커뮤니티 목록을 전송

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CommunityVO> list = postService.getCommunityList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/community.jsp").forward(request, response);
	}

}
