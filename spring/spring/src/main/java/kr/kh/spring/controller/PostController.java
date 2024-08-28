package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.pagination.PostCriteria;
import kr.kh.spring.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/list")
	public String list(Model model, PostCriteria cri) {

		List<CommunityVO> list = postService.getCommunityList();

		cri.setPerPageNum(2);
		List<PostVO> postList = postService.getPostList(cri);
		PageMaker pm = postService.getPageMaker(cri);

		model.addAttribute("pm", pm);
		model.addAttribute("list", list);
		model.addAttribute("postList", postList);

//		System.out.println(pm);

		return "/post/list";
	}

	@PostMapping("/list")
	public String communityPost() {

		return "/post/list";
	}

	@GetMapping("/insert")
	public String insert(Model model, Integer co_num) {
		model.addAttribute("co_num", co_num);
		return "/post/insert";
	}

	@PostMapping("/insert")
	public String insertPost(Model model, HttpSession session, PostVO post, MultipartFile[] fileList) {

		MemberVO user = (MemberVO) session.getAttribute("user");

		boolean res = postService.insertPost(post, user, fileList);

		if (res) {
			model.addAttribute("url", "/post/list?co_num="+post.getPo_co_num());
			model.addAttribute("msg", "게시글이 등록되었습니다.");
		} else {
			model.addAttribute("url", "/post/insert?co_num="+post.getPo_co_num());
			model.addAttribute("msg", "게시글 등록에 실패하였습니다.");
		}

		return "/main/message";

	}
}
