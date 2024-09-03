package kr.kh.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		// 로그인한 회원이 관리자이면 가려던 길을 가고 아니면 메인 페이지로 이동을 시키려고 한다.
		MemberVO user = (MemberVO) modelAndView.getModel().get("user");
		
		if (user == null) {
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		// 자동 로그인이 아닌 경우
		if (!user.isAutoLogin()) {
			return;
		}
		// 세션 아이디를 가져옴 => 쿠키 값을 만들기 위해서
		String sid = session.getId();
		// 쿠키 생성
		Cookie cookie = new Cookie("LC", sid);
		// 쿠키의 만료 시간을 계산
		int time = 60 * 60 * 24 * 7 * 1000;
		cookie.setMaxAge(time);
		cookie.setPath("/");

		// 회원 정보에 쿠키와 만료 시간을 수정
		Date date = new Date(System.currentTimeMillis() + time);
		user.setMe_cookie(sid);
		user.setMe_limit(date);
		
		memberService.updateMemberCookie(user);
		
		// 화면에 쿠키를 전송
		response.addCookie(cookie);

		return;

	}

}
