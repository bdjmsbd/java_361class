package kr.kh.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.CommentCriteria;
import kr.kh.app.pagination.Criteria;

public interface PostDAO {

	List<CommunityVO> selectCommunityList();

	CommunityVO selectCommunity(@Param("co_num")int coNum);

	List<PostVO> selectPostList(@Param("cri")Criteria cri);

	int selectPostTotalCount(@Param("cri")Criteria cri);

	boolean insertPost(@Param("po")PostVO post);

	PostVO selectPost(@Param("po_num")int poNum);

	void updatePostView(@Param("po_num")int poNum);

	boolean updatePost(@Param("post")PostVO post);

	boolean deletePost(@Param("po_num")int po_num, @Param("user")MemberVO user);

	RecommendVO selectRecommend(@Param("po_num")int po_num, @Param("id")String me_id);

	boolean updateRecommend(@Param("re_state")int re_state, @Param("po_num")int po_num,  @Param("id")String me_id);

	boolean insertRecommend(@Param("re_state")int re_state, @Param("po_num")int po_num,  @Param("id")String me_id);

	int selectRecommendCount(@Param("re_state")int re_state, @Param("po_num")int po_num);

	List<CommentVO> selectCommentList(@Param("cri")Criteria cri);

	int selectCommentTotalCount(@Param("cri")Criteria cri);

	boolean insertComment(@Param("cm")CommentVO comment);

	boolean deleteALLComment(@Param("cm_num")int cm_num);
	
	boolean deleteComment(@Param("cm_num")int cm_num);

	CommentVO selectComment(@Param("cm_num")int cm_num);

	boolean updateComment(@Param("cm")CommentVO comment);

	void insertFile(@Param("f")FileVO fileVO);

	List<FileVO> selectFileList(@Param("po_num")int po_num);

	FileVO selectFile(@Param("fi_num")int fi_num);

	void deleteFile(@Param("fi_num")int fi_num);

	boolean insertCommunity(@Param("co_name")String coName);

	boolean deleteCommunity(@Param("co_num")int co_num);

	boolean updateCommunity(@Param("co_num")int co_num, @Param("co_name")String coName);

}
