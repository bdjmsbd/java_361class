package kr.kh.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.pagination.CommentCriteria;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.pagination.PostCriteria;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/comment/list")
public class CommentList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PostService postService = new PostServiceImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String po_numStr = request.getParameter("po_num");
		String pageStr = request.getParameter("page");
		
		JSONObject jobj = new JSONObject();
		ObjectMapper om = new ObjectMapper();

		try {
			int po_num = Integer.parseInt(po_numStr);

				
			int page = 1;
			if(pageStr != null && pageStr.length() != 0) {
				page = Integer.parseInt(pageStr);
			}
			
			Criteria cri = new CommentCriteria(page, 5, po_num);
			PageMaker pm = postService.getCommentPageMaker(cri);

			List<CommentVO> list = postService.getCommentList(cri);

			jobj.put("cmList", list);
			jobj.put("pm", om.writeValueAsString(pm));
			

		} catch (Exception e) {
			e.printStackTrace();
			jobj.put("error", "Exception 발생!!!");
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);

	}

}
