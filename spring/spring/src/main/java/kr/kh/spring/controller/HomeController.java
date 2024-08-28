package kr.kh.spring.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring.model.dto.PersonDTO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private MemberService memberService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	// method를 지우면 get/ post 둘다 가능.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// =같음 @GetMapping("/")
	// return type을 void로 하면 value의 url로 리턴 된다.
	public String home(Locale locale, Model model, PersonDTO person) {

		return "/main/home";
	}

	@GetMapping("/signup")
	public String signup() {
		return "/member/signup";
	}

	@PostMapping("/signup")
	public String signupPost(Model model, MemberVO member) {

		System.out.println(member);

		boolean res = memberService.signup(member);
		if (res) {
			model.addAttribute("msg", "회원 가입을 했습니다.");
			model.addAttribute("url", "/");
		} else {
			model.addAttribute("msg", "회원 가입을 하지 못했습니다.");
			model.addAttribute("url", "/signup");
		}
		return "/main/message";
	}

	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}

	@PostMapping("/login")
	public String loginPost(Model model, HttpSession session, MemberVO member) {

		MemberVO user = memberService.login(member);
		if (user != null) {
			model.addAttribute("msg", "로그인을 성공 했습니다.");
			model.addAttribute("url", "/");
		} else {
			model.addAttribute("msg", "로그인을 실패 했습니다.");
			model.addAttribute("url", "/login");
		}
		session.setAttribute("user", user);
		return "/main/message";

	}

	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {

		MemberVO user = (MemberVO) session.getAttribute("user");

		if (user != null) {

			session.removeAttribute("user");

			model.addAttribute("msg", "로그아웃 했습니다.");
			model.addAttribute("url", "/");
		} else {
			model.addAttribute("msg", "이미 로그아웃되어 있습니다.");
			model.addAttribute("url", "/");
		}

		return "/main/message";

	}

	// @CrossOrigin(origins = "*")
	// @CrossOrigin(origins = "http://domain1.com, http://domain2.com")
	@ResponseBody
	@PostMapping("/check/id")
	public boolean checkId(@RequestParam("id") String id) {
		// 중복이면 false, 아니면 true
		boolean res = false;

		try {

//			if(id == null || id.trim().length() == 0) {
//				throw new RuntimeException();
//			}

			res = memberService.checkId(id);
			return res;

		} catch (Exception e) {
			e.printStackTrace();
			return res;
		}
	}

}
