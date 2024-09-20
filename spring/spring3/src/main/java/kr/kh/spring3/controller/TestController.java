package kr.kh.spring3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.service.MemberService;
import kr.kh.spring3.service.PostService;

@RestController // => responseBody를 생략해도 됨
@RequestMapping("/test")
public class TestController {
	
	
	@Autowired
	PostService postService;
	
	@Autowired
	MemberService memberService;
	
	
	@PostMapping("/signup")
	public boolean signup(@RequestBody MemberVO user) {
		System.out.println(user);
		
		boolean res = memberService.signup(user);
		System.out.println("res : "+ res);
		
		return res;
	}
	
}

