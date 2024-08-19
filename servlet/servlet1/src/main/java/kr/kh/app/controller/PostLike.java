package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/like")
public class PostLike extends HttpServlet {

	private static final long serialVersionUID = 1L;
	PostService postService = new PostServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 게시글 번호를 반아옴
		String po_numStr = request.getParameter("po_num");
		String re_stateStr = request.getParameter("re_state");

		PostVO post = null;

		JSONObject jobj = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		try {
			int po_num = Integer.parseInt(po_numStr);
			int re_state = Integer.parseInt(re_stateStr);

			post = postService.getPost(po_num);
			MemberVO user = (MemberVO) request.getSession().getAttribute("user");
			// 회원 정보를 받아옴
			

			// 0 : insert , 1: update, -1 실패
			int res = postService.recommendPost(po_num, re_state, user);
			// 객체를 json 형태로 변환해준다.
			post.setPo_up(postService.getUp(post.getPo_num()));
			post.setPo_down(postService.getDown(post.getPo_num()));

			String postStr = om.writeValueAsString(post);

			jobj.put("result", res);
			jobj.put("re_state", re_state);
			jobj.put("post", postStr);
			
//			if (res == 0) {
//				request.setAttribute("msg", "게시물 "+ ((re_state==-1)?"비":"")+"추천 하였습니다.");
//			}
//			else if (res ==1) {
//				request.setAttribute("msg", "게시물 "+ ((re_state==-1)?"비":"")+"추천 취소 하였습니다.");
//			}else {
//				throw new RuntimeException();
//			}

		} catch (Exception e) {
			// null이면 작성자가 아니거나 게시글이 없습니다라고 출력
			e.printStackTrace();
			jobj.put("error", "Exception 발생!!!");
//			request.setAttribute("msg", (re_stateStr.equals("-1")?"비":"")+"추천에 실패하였습니다.");
		}

		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);

//		request.setAttribute("url", "/post/detail?num="+post.getPo_num());
//		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);

	}

}
