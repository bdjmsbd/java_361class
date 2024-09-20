package kr.kh.spring3.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.model.dto.MessageDTO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.model.vo.PostVO;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.pagination.PostCriteria;
import kr.kh.spring3.service.PostService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService postService;

	/*
	 * @GetMapping("/post/list/{co_num}")public String
	 * postList(@PathVariable("co_num") int co_num) { log.info(" "+co_num);
	 * 
	 * return "/post/list"; }
	 */

	@GetMapping("/list/{co_num}")
	public String postList(Model model, @PathVariable("co_num") int co_num, PostCriteria cri) {

		log.info("/post/list");

		List<CommunityVO> list = postService.getCommunityList();

		cri.setCo_num(co_num);
		cri.setPerPageNum(2);

		List<PostVO> postList = postService.getPostList(cri);
		PageMaker pm = postService.getPageMaker(cri);

		model.addAttribute("pm", pm);
		model.addAttribute("list", list);
		model.addAttribute("postList", postList);

		return "/post/list";
	}

	@GetMapping("/detail/{co_num}/{po_num}")
	public String postDetail(Model model, @PathVariable("co_num") int co_num, @PathVariable("po_num") int po_num) {

		log.info("/post/detail");

		// 조회수 증가
		postService.updateView(po_num);

		PostVO post = postService.getPost(po_num);

		// 첨부파일 가져옴
		List<FileVO> fileList = postService.getFileList(po_num);

		model.addAttribute("post", post);
		model.addAttribute("list", fileList);

		return "/post/detail";
	}

	@GetMapping("/insert/{co_num}")
	public String insert(Model model, @PathVariable("co_num") int co_num) {
		log.info("/post/insert:get");
		// 커뮤니티 번호를 화면에 전송
		model.addAttribute("co_num", co_num);
		return "/post/insert";
	}

	@PostMapping("/insert/{co_num}")
	public String insertPost(Model model, @PathVariable("co_num") int co_num, PostVO post, HttpSession session,
			MultipartFile[] fileList) {
		log.info("/post/insert:post");
		post.setPo_co_num(co_num);
		MemberVO user = (MemberVO) session.getAttribute("user");
		boolean res = postService.insertPost(post, user, fileList);
		log.info(post);

		MessageDTO message;
		if (res) {
			message = new MessageDTO("/post/list/" + co_num, "게시글을 등록했습니다.");
		} else {
			message = new MessageDTO("/post/insert/" + co_num, "게시글을 등록하지 못했습니다.");
		}
		model.addAttribute("message", message);
		return "/main/message";
	}

	@GetMapping("/update/{po_num}")
	public String update(Model model, @PathVariable("po_num") int po_num) {
		log.info("/post/update:get");
		// 커뮤니티 번호를 화면에 전송

		PostVO post = postService.getPost(po_num);
		if (post == null) {
			MessageDTO message = new MessageDTO("/main/home", "에러가 발생했습니다.\\n초기 화면으로 돌아갑니다.");
			model.addAttribute("message", message);
			return "/main/message";
		}

		List<FileVO> list = postService.getFileList(po_num);
		if (list != null) {
			model.addAttribute("list", list);
		}

		model.addAttribute("post", post);
		return "/post/update";
	}

	@PostMapping("/update/{po_num}")
	public String updatePost(Model model, @PathVariable("po_num") int po_num, PostVO post, HttpSession session,
			MultipartFile[] fileList, int[] fi_nums) {

		log.info("/post/update:post");

		MemberVO user = (MemberVO) session.getAttribute("user");

		boolean res = postService.updatePost(post, user, fileList, fi_nums);

		MessageDTO message;
		if (res) {
			message = new MessageDTO("/post/detail/" + post.getPo_co_num() + "/" + po_num, "게시글을 수정했습니다.");
		} else {
			message = new MessageDTO("/post/detail/" + post.getPo_co_num() + "/" + po_num, "게시글을 수정하지 못했습니다.");
		}
		model.addAttribute("message", message);
		return "/main/message";
	}

	@GetMapping("/delete/{co_num}/{po_num}")
	public String delete(Model model, @PathVariable("co_num") int co_num, @PathVariable("po_num") int po_num,
			HttpSession session) {

		log.info("/post/delete:get");

		MemberVO user = (MemberVO) session.getAttribute("user");
		boolean res = postService.deletePost(po_num, user);

		MessageDTO message;
		if (res) {
			message = new MessageDTO("/post/list/" + co_num, "게시글을 삭제했습니다.");
		} else {
			message = new MessageDTO("/post/detail/" + po_num, "게시글을 삭제하지 못했습니다.");
		}
		model.addAttribute("message", message);
		return "/main/message";
	}

}