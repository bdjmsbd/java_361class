package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.AdminService;
import kr.kh.spring.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PostService postService;

	@Autowired
	private AdminService adminService;

	@GetMapping("/community")
	public String community(Model model) {

		List<CommunityVO> list = postService.getCommunityList();
		model.addAttribute("list", list);

		return "/admin/community";
	}

	@PostMapping("/community/insert")
	public String communityInsert(CommunityVO community, Model model, HttpSession session) {

		MemberVO user = (MemberVO) session.getAttribute("user");
		boolean res = adminService.insertCommunity(community, user);

		if (res) {
			model.addAttribute("msg", "커뮤니티가 등록되었습니다.");
		} else {
			model.addAttribute("msg", "커뮤니티 등록에 실패했습니다.");
		}

		model.addAttribute("url", "/admin/community");

		return "main/message";

	}

	@GetMapping("/community/delete")
	public String communityDelete(Model model, HttpSession session, int co_num) {

		MemberVO user = (MemberVO) session.getAttribute("user");
		boolean res = adminService.deleteCommunity(co_num, user);
		
		if(res) {
			model.addAttribute("msg", "커뮤니티가 삭제되었습니다.");
		}
		else {
			model.addAttribute("msg", "커뮤니티가 삭제에 실패했습니다.");			
		}
		
		model.addAttribute("url", "/admin/community");
		return "/main/message";
	}
	
//	@PostMapping("/community/update")
	// requestmapping은 get으로 접근할 경우 메인으로 돌려보냄.
	@RequestMapping("/community/update")
	public String communityUpdatePost(Model model, HttpSession session, CommunityVO community) {
		
		System.out.println("name: "+ community.getCo_name() + ", num : " + community.getCo_num());
		MemberVO user = (MemberVO) session.getAttribute("user");
		boolean res = adminService.updateCommunity(community , user);

		if (res) {
			model.addAttribute("msg", "커뮤니티가 수정되었습니다.");
		} else {
			model.addAttribute("msg", "커뮤니티 수정에 실패했습니다.");
		}

		model.addAttribute("url", "/admin/community");

		return "main/message";

	}

}
