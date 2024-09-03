package kr.kh.app.service;

import java.util.List;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;

public interface PostService {

	List<CommunityVO> getCommunityList();

	CommunityVO getCommunity(String num);

	List<PostVO> getPostList(Criteria cri);

	PageMaker getPostPageMaker(Criteria cri);

	PostVO getPost(int poNum);

	void updatePostView(int poNum);

	boolean insertPost(PostVO post);

	boolean updatePost(PostVO post, MemberVO user);

	boolean deletePost(PostVO post, MemberVO user);

}
