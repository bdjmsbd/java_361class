package kr.kh.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.study.dao.PostDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PostDAO postDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		String str = "abc";
		
		String enc = passwordEncoder.encode(str);
		boolean res = passwordEncoder.matches(str, enc);
		
		System.out.println("enc : "+ enc);
		System.out.println("res : "+ res);

		return "/home";
	}
	
	@GetMapping("/post/list")
	public String postList() {
		
		return "/home";
	}
	
	@GetMapping("/post/detail")
	public String postDetail() {
		
		return "/home";
	}
	
	@GetMapping("/post/insert")
	public String postInsert() {
		
		return "/home";
	}
	
}
