package kr.kh.spring3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.PostVO;
import kr.kh.spring3.model.dto.Person;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.pagination.PostCriteria;
import kr.kh.spring3.service.PostService;

@RestController
@RequestMapping("/react")
public class ReactController {
	
	
	@Autowired
	PostService postService;
	
	
	@GetMapping("/post/list/{co_num}")
	public Map<String, Object> postList(Model model, @PathVariable("co_num") int co_num, PostCriteria cri) {

		cri.setCo_num(co_num);
		cri.setPerPageNum(5);

		List<PostVO> list = postService.getPostList(cri);
		
		PageMaker pm = postService.getPageMaker(cri);
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("pm", pm);
		map.put("list",list);

		return map;
	}
	
	@GetMapping("/post/detail/{po_num}")
	public PostVO getPost(Model model, @PathVariable("po_num") int po_num) {
		
		PostVO post = postService.getPost(po_num);
		
		// 조회수 증가
		postService.updateView(po_num);
		return post;
	}
	
	@ResponseBody
	@GetMapping("/community/list")
	public List<CommunityVO> communityList() {
		
		return postService.getCommunityList();
	}
	
	
	@GetMapping("/get/str")
	public String getStr() {
		return "hello? no. hell lo? yes";
	}
	
//	@GetMapping("/get/obj")
//	public Map<String, Object> getObj() {
//
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		Person p = new Person("jake", 20);
//		map.put("person", p);
//		return map;
//	}	
	
	@GetMapping("/get/obj")
	public Person getObj() {

		Person p = new Person("jake", 20);
		return p;
	}
	
	@PostMapping("/send/person")
	public String sendPerson(@RequestParam("name") String name, @RequestParam("age") int age) {
		System.out.println(name);
		System.out.println(age);
		
		return "OK";
	}
	
	@PostMapping("/send/person2")
	public String sendPerson2(@RequestBody Person person) {
		System.out.println(person);
		System.out.println(person.getName());
		System.out.println(person.getAge());
		
		return "OK";
	}
	
}

