package kr.kh.spring.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private MemberService memberService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "main/home";
	}

	@GetMapping("/join")
	public String join(Locale locale, Model model) {

		return "member/join";

	}

	@PostMapping("/join")
	public String joinPost(Model model, MemberVO member) {

		try {
			String encPw = passwordEncoder.encode(member.getMe_pw());
			member.setMe_pw(encPw);

			boolean res = memberService.joinMember(member);
			
			if (res) {
				model.addAttribute("msg", "회원가입 성공!");
			} else {
				throw new RuntimeException();
			}

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원가입 실패!");
		}

		model.addAttribute("url", "");
		return "main/message";
	}
	
	@GetMapping("/login")
	public String login(Locale locale, Model model) {

		return "member/login";

	}
	
	@PostMapping("/login")
	public String loginPost(Model model, HttpSession session, MemberVO member) {

		try {
			boolean res = memberService.login(member);

			if (res) {
				
				model.addAttribute("msg", "로그인 성공!");
				session.setAttribute("user", member);
				
			} else {
				throw new RuntimeException();
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			model.addAttribute("msg", "로그인 실패!");
		}

		model.addAttribute("url", "");
		return "main/message";
	}
}
