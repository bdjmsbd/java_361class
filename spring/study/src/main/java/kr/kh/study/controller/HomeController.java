package kr.kh.study.controller;

import java.util.Locale;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.study.dao.PostDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
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
		
		//mailSend("jkserena@naver.com","메일 테스티", "전송이 잘 됐습니다.");

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
	


	public boolean mailSend(String to, String title, String content) {

	    String setfrom = "stajun@naver.com";
	    
	   try{
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom(setfrom);// 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(to);// 받는사람 이메일
	        messageHelper.setSubject(title);// 메일제목은 생략이 가능하다
	        messageHelper.setText(content, true);// 메일 내용

	        mailSender.send(message);
	        return true;
	    } catch(Exception e){
	        e.printStackTrace();
	        return false;
	    }
	}
}
