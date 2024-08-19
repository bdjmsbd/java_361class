package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/comment/delete")
public class CommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cm_numStr = request.getParameter("cm_num");
		
		JSONObject jobj = new JSONObject();
		try {
			int cm_num = Integer.parseInt(cm_numStr);

			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			String cm_me_id = user.getMe_id();
			
			boolean res = postService.deleteComment(cm_num, cm_me_id);
			
			jobj.put("result", res);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
	}

}