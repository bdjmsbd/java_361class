package kr.kh.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.pagination.PostCriteria;
import kr.kh.spring.utils.UploadFileUtils;

@Service
public class PostServiceImp implements PostService {

	@Autowired
	private PostDAO postDao;

	@Resource
	String uploadPath;

	@Override
	public List<CommunityVO> getCommunityList() {
		return postDao.selectCommunityList();
	}

	@Override
	public List<PostVO> getPostList(PostCriteria cri) {

		return postDao.selectPostList(cri);
	}

	@Override
	public PageMaker getPageMaker(PostCriteria cri) {

		if (cri == null) {
			return null;
		}
		int totalCount = postDao.selectPostTotalCount(cri);
		return new PageMaker(3, cri, totalCount);
	}

	public boolean insertPost(PostVO post, MemberVO user, MultipartFile[] fileList) {
		
		boolean res = false;
		
		if (post == null || user == null) {
			return res;
		}
		try {
			post.setPo_me_id(user.getMe_id());
			System.out.println(post);
			res = postDao.insertPost(post);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		if (!res) {
			return res;
		}

		if (fileList == null || fileList.length == 0) {
			return res;
		}
		// 첨부파일 추가
		for (MultipartFile file : fileList) {
			uploadFile(file, post.getPo_num());
		}
		return res;
	}

	private void uploadFile(MultipartFile file, int po_num) {

		if (file == null || file.getOriginalFilename().length() == 0) {
			return;
		}

		try {
			String fi_ori_name = file.getOriginalFilename();
			// 첨부파일을 서버에 업로드 후 경로가 포함된 파일명을 가져옴
			String fi_name = UploadFileUtils.uploadFile(uploadPath, fi_ori_name, file.getBytes());
			// DB에 첨부파일 정보를 추가
			FileVO fileVo = new FileVO(fi_name, fi_ori_name, po_num);
			postDao.insertFile(fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
