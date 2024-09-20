package kr.kh.spring3.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring3.model.dto.MessageDTO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.service.MemberService;
import kr.kh.spring3.service.PostService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {

	@Autowired
	MemberService memberService;

	@Autowired
	PostService postService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		log.info("/ : 메인 페이지입니다.");
		model.addAttribute("title", "메인");
		return "/main/home";
	}

	@GetMapping("/guest/signup")
	public String guestSignup() {
		log.info("/guest/signup:get");
		return "/member/signup";
	}

	@PostMapping("/guest/signup")
	public String guestSignupPost(Model model, MemberVO member) {
		log.info("/guest/signup:post");

		boolean res = memberService.signup(member);

		MessageDTO message;

		if (res) {
			message = new MessageDTO("/", "회원가입에 성공했습니다.");
		} else {
			message = new MessageDTO("/guest/signup", "아이디나 이메일이 중복되었습니다.");
		}

		model.addAttribute("message", message);
		return "/main/message";
	}

	@GetMapping("/guest/login")
	public String guestlogin() {
		log.info("/guest/login:get");
		return "/member/login";
	}

	@PostMapping("/guest/login")
	public String guestLoginPost(Model model, MemberVO member) {
		log.info("/guest/login:post");
		log.info(member);

		MessageDTO message;
		MemberVO user = memberService.login(member);

		if (user != null) {
			message = new MessageDTO("/", "로그인에 성공했습니다.");
		} else {
			message = new MessageDTO("/guest/login", "아이디나 비밀번호가\\n일치하지 않습니다.");
			model.addAttribute("id", member.getMe_id());
		}

		model.addAttribute("message", message);
		model.addAttribute("user", user);

		return "/main/message";
	}

	@GetMapping("/member/logout")
	public String memberLogout(Model model, HttpSession session) {

		log.info("/guest/logout:get");

		MemberVO user = (MemberVO) session.getAttribute("user");
		MessageDTO message;
		if (user != null) {
			session.removeAttribute("user");
			message = new MessageDTO("/", "로그아웃 되었습니다.");
		} else {
			message = new MessageDTO("/", "이미 로그아웃되었습니다.");
		}

		model.addAttribute("message", message);
		return "/main/message";
	}

	@ResponseBody
	@GetMapping("/test")
	public String test() {

		return "Hi";
	}

	@GetMapping("/naver/login")
	public String naverLogin(Model model, HttpSession session) {
		System.out.println("hey~");
		return "/naver/naverlogin";
	}

	@GetMapping("/naver/callback")
	public String naverCallback(Model model, HttpSession session) {
		System.out.println("yo~");
		return "/naver/callback";
	}

	// @RequestMapping(value = "/personalInfo")
	@GetMapping("/personalInfo")
	public void personalInfo(HttpServletRequest request) throws Exception {
		System.out.println("hello~");
		String token = "AAAAOB88E4-J_0qIpfd2terE9aq7Leqncbo5HPrLxx5y9Xd19k6BpOSqwxN9TtvXlcUKqSbHxavYpvpDTWnKTJrEh0g";
		// 네이버
		// 넣어줍니다.
		String header = "Bearer " + token; // Bearer 다음에 공백 추가
		try {
			String apiURL = "https://openapi.naver.com/v1/nid/me";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println(response.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}