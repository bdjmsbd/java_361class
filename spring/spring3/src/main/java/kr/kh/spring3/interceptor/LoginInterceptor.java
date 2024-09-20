package kr.kh.spring3.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring3.model.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		MemberVO user = (MemberVO) modelAndView.getModel().get("user");

		HttpSession session = request.getSession();
		
		if (user == null) {
			
			String id = (String)modelAndView.getModel().get("id");
			
			if(id != null) {
				session.setAttribute("id", id);
			}
			return;
		}
		
		session.removeAttribute("id");
		session.setAttribute("user", user);

		return;

	}
}
