package kr.kh.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.kh.boot.model.vo.CommunityVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.pagination.PostCriteria;

@Mapper
public interface PostDAO {

	List<PostVO> selectPostList(PostCriteria cri);

	List<CommunityVO> selectCommunityList();

	int selectCountPostList(PostCriteria cri);

	PostVO selectPost(int po_num);

	void insertPost(@Param("post") PostVO post);

	void updatePost(PostVO post);

	void deletePost(int po_num);
}
