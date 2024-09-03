package kr.kh.spring.service;

import java.util.List;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

	List<CommentVO> getCommentList(Criteria cri);

	PageMaker getCommentPageMaker(Criteria cri);

	boolean deleteComment(int cm_num, MemberVO user);

	boolean deleteComment(CommentVO comment, MemberVO user);

	boolean updateComment(CommentVO comment, MemberVO user);


}
