package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/admin/community")
public class AdminCommunity extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<CommunityVO> list = postService.getCommunityList();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/admin/community.jsp").forward(req, resp);
	
		
	}


}