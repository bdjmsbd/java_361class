package kr.kh.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagination.Criteria;

public interface PostDAO {

	List<CommunityVO> selectCommunityList();

	CommunityVO selectCommunity(@Param("co_num")String num);

	List<PostVO> selectPostList(@Param("cri")Criteria cri);

	int selectPostTotalCount(@Param("cri")Criteria cri);

	PostVO selectPost(@Param("po_num")int poNum);

	void updatePostView(@Param("po_num")int poNum);

	boolean insertPost(@Param("po")PostVO post);

	boolean updatePost(@Param("po")PostVO post);

	boolean deletePost(@Param("po")PostVO post);
}
