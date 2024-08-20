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
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.AdminService;
import kr.kh.app.service.AdminServiceImp;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/admin/community/delete")
public class AdminCommunityDelete extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminServiceImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 커뮤니티 번호를 가져옵니다.
		String co_numStr = req.getParameter("co_num");
		
		try {
			int co_num = Integer.parseInt(co_numStr);
			MemberVO user = (MemberVO) req.getSession().getAttribute("user");
			
			if(adminService.deleteCommunity(co_num, user)) {
				req.setAttribute("msg", "커뮤니티를 삭제했습니다.");
			}
			else {
				throw new RuntimeException();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "커뮤니티를 삭제하지 못했습니다.");
		}
		req.setAttribute("url", "/admin/community");
		req.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(req, resp);
	
		
	}


}