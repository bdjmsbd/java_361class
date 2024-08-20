package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.AdminService;
import kr.kh.app.service.AdminServiceImp;

@WebServlet("/admin/community/insert")
public class AdminCommunityInsert extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminServiceImp();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String coName = req.getParameter("co_name");
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");

		if (adminService.insertCommunity(coName, user)) {
			req.setAttribute("msg", "커뮤니티를 등록했습니다.");
			req.setAttribute("url", "/admin/community");

		} else {
			req.setAttribute("msg", "커뮤니티 등록에 실패했습니다.");
			req.setAttribute("url", "/admin/community");

		}

		req.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(req, resp);
	}

}