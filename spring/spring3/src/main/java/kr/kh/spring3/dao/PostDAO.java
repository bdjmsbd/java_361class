package kr.kh.spring3.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.PostVO;
import kr.kh.spring3.pagination.PostCriteria;

public interface PostDAO {
	
	List<CommunityVO> selectCommunityList();

	List<PostVO> selectPostList(@Param("cri")PostCriteria cri);

	int selectPostTotalCount(@Param("cri")PostCriteria cri);

	PostVO selectPost(@Param("po_num")int po_num);
	
	void updateView(int po_num);

	List<FileVO> selectFileList(int po_num);
	
	boolean insertPost(PostVO post);

	void insertFile(FileVO fileVo);

	boolean updatePost(@Param("post")PostVO post);

	FileVO selectFile(int fi_num);

	void deleteFile(int fi_num);
	
	boolean deletePost(int po_num);

}