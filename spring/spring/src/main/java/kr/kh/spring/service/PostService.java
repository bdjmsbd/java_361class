package kr.kh.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.pagination.PostCriteria;

// 협업할 때 어떤 기능이 있는 지 확인하기 유용하다.
public interface PostService {

	List<CommunityVO> getCommunityList();

	List<PostVO> getPostList(PostCriteria cri);

	PageMaker getPageMaker(PostCriteria cri);

	boolean insertPost(PostVO post, MemberVO user, MultipartFile[] fileList);

	List<FileVO> getFileList(Integer po_num);

	PostVO getPost(Integer po_num);

	void updateView(Integer po_num);

	boolean updatePost(PostVO post, int[] fi_nums, MultipartFile[] fileList, MemberVO user);

	boolean deletePost(PostVO post, MemberVO user);

}
