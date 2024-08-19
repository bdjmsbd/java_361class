package kr.kh.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.CommentCriteria;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;

public interface PostService {

	List<CommunityVO> getCommunityList();

	CommunityVO getCommunity(int coNum);

	List<PostVO> getPostList(Criteria cri);

	PageMaker getPageMaker(Criteria cri, int displayPageNum);

	boolean insertPost(PostVO post, ArrayList<Part> files);

	void updatePostView(int poNum);

	PostVO getPost(int po_num, MemberVO user);
	
	PostVO getPost(int po_num);

	boolean updatePost(PostVO post, MemberVO user, List<Part> fileList, String[] numStr);

	boolean removePost(int po_num, MemberVO user);

	int recommendPost(int po_num, int re_state, MemberVO user);

	RecommendVO getRecommend(int poNum, MemberVO user);

	int getUp(int poNum);

	int getDown(int poNum);

	List<CommentVO> getCommentList(Criteria cri);

	PageMaker getCommentPageMaker(Criteria cri);

	boolean insertComment(CommentVO comment);

	boolean deleteComment(int cm_num, String cm_me_id);

	CommentVO getComment(int cm_num);

	boolean updateComment(CommentVO comment, MemberVO user);

	List<FileVO> getFileList(int po_num);


}
