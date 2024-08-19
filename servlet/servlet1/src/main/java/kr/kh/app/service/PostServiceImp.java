package kr.kh.app.service;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.PostDAO;
import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.utils.FileUploadUtils;

public class PostServiceImp implements PostService {

	private PostDAO postDao;
	
	private String uploadPath = "D:\\uploads";

	public PostServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {

			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			postDao = session.getMapper(PostDAO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CommunityVO> getCommunityList() {
		return postDao.selectCommunityList();
	}

	@Override
	public CommunityVO getCommunity(int coNum) {
		return postDao.selectCommunity(coNum);
	}

	@Override
	public List<PostVO> getPostList(Criteria cri) {
		if (cri == null) {
			throw new RuntimeException();
		}
		return postDao.selectPostList(cri);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri, int displayPageNum) {
		if (cri == null) {
			throw new RuntimeException();
		}
		int totalCount = postDao.selectPostTotalCount(cri);
		return new PageMaker(totalCount, displayPageNum, cri);
	}

	@Override
	public PostVO getPost(int poNum) {
		return postDao.selectPost(poNum);
	}

	@Override
	public void updatePostView(int poNum) {
		postDao.updatePostView(poNum);

	}

	@Override
	public PostVO getPost(int po_num, MemberVO user) {
		if (user == null) {
			return null;
		}
		PostVO post = postDao.selectPost(po_num);
		if (post == null) {
			return null;
		}
		if (!post.getPo_me_id().equals(user.getMe_id())) {
			return null;
		}
		return post;
	}

	private boolean checkPost(PostVO post) {
		if (post == null) {
			return false;
		}
		if (post.getPo_title() == null || post.getPo_title().trim().length() == 0) {
			return false;
		}
		if (post.getPo_content() == null || post.getPo_content().trim().length() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean removePost(int po_num, MemberVO user) {
		
		// 게시글 삭제전에 첨부파일 삭제
		List<FileVO> fileList = postDao.selectFileList(po_num);
		for(FileVO file : fileList) {
			deleteFile(file);
		}
		
		return postDao.deletePost(po_num, user);
	}

	private void deleteFile(FileVO file) {
		if(file == null) {
			return;
		}
		
		postDao.deleteFile(file.getFi_num());
		
		File rmFile = new File(uploadPath + file.getFi_name().replace('/', File.separatorChar));
		
		if(rmFile.exists()) {
			rmFile.delete();
		}
	}

	@Override
	public int recommendPost(int po_num, int re_state, MemberVO user) {
		// 없으면 추가
		// 있으면?
		// 0 : insert , 1: update, -1 실패
		if (user == null)
			return -1;

		RecommendVO recommend = postDao.selectRecommend(po_num, user.getMe_id());

		if (recommend != null) {

			switch (recommend.getRe_state()) {
				case 0:
					if (postDao.updateRecommend(re_state, po_num, user.getMe_id())) {
						return 0;
					}
					break;
				case 1:
				case -1:
					if (recommend.getRe_state() == re_state) {
						if (postDao.updateRecommend(0, po_num, user.getMe_id())) {
							return 1;
						}
					} else {
						if (postDao.updateRecommend(re_state, po_num, user.getMe_id())) {
							return 0;
						}
					}
					break;
			}
		} else {
			if (postDao.insertRecommend(re_state, po_num, user.getMe_id())) {
				return 0;
			}
		}
		return -1;

	}

	@Override
	public RecommendVO getRecommend(int poNum, MemberVO user) {
		if (user == null) {
			return null;
		}
		return postDao.selectRecommend(poNum, user.getMe_id());
	}

	@Override
	public int getUp(int poNum) {
		return postDao.selectRecommendCount(1, poNum);
	}

	@Override
	public int getDown(int poNum) {
		return postDao.selectRecommendCount(-1, poNum);
	}

	@Override
	public List<CommentVO> getCommentList(Criteria cri) {
		if (cri == null) {
			throw new RuntimeException();
		}
		return postDao.selectCommentList(cri);
	}

	@Override
	public PageMaker getCommentPageMaker(Criteria cri) {
		if (cri == null) {
			return null;
		}
		int totalCount = postDao.selectCommentTotalCount(cri);
		return new PageMaker(totalCount, 2, cri);
	}

	@Override
	public boolean insertComment(CommentVO comment) {
		if (comment == null) {
			return false;
		}
		if (comment.getCm_content() == null || comment.getCm_content().trim().length() == 0) {
			return false;
		}
		return postDao.insertComment(comment);
	}

	@Override
	public boolean deleteComment(int cm_num, String cm_me_id) {

		CommentVO comment = postDao.selectComment(cm_num);
		if (comment == null) {
			return false;
		}

		if (!comment.getCm_me_id().equals(cm_me_id)) {
			return false;
		}

		if (comment.getCm_ori_num() == comment.getCm_num()) {
			return postDao.deleteALLComment(cm_num);
		}

		return postDao.deleteComment(cm_num);

	}

	@Override
	public CommentVO getComment(int cm_num) {
		return postDao.selectComment(cm_num);
	}

	@Override
	public boolean updateComment(CommentVO comment, MemberVO user) {
		if (comment == null || user == null) {
			return false;
		}

		if (!comment.getCm_me_id().equals(user.getMe_id())) {
			return false;
		}

		return postDao.updateComment(comment);
	}

	@Override
	public boolean insertPost(PostVO post, ArrayList<Part> files) {
		checkPost(post);
		boolean res = postDao.insertPost(post);
		if (!res) {
			return false;
		}
		if(files == null || files.size() == 0) {
			return true;
		}

		for(Part file : files) {
			uploadFile(post.getPo_num(), file);
		}
		return true;
	}

	private void uploadFile(int po_num, Part file) {
		if(file == null) {
			return;
		}
		// file.getName() => fieldName
		String fileName = FileUploadUtils.getFileName(file);
		if(fileName == null || fileName.trim().length() == 0 || !file.getName().equals("uploadFiles")) {
			return;
		}
		
		// 첨부파일을 upload하고 파일명을 반환
		String uploadFileName = FileUploadUtils.upload(uploadPath, file);
		FileVO fileVO = new FileVO(po_num, fileName, uploadFileName);
		
		postDao.insertFile(fileVO);
	}

	@Override
	public List<FileVO> getFileList(int po_num) {
		return postDao.selectFileList(po_num);
	}

	@Override
	public boolean updatePost(PostVO post, MemberVO user, List<Part> fileList, String[] numStr) {
		
		if (!checkPost(post)) {
			return false;
		}

		boolean res = postDao.updatePost(post);
		if(!res){
			return false;
		}
		
		// 새 첨부파일 추가
		for(Part file : fileList) {
			uploadFile(post.getPo_num(), file);
		}
		
		if(numStr == null) {
			return true;
		}
		
		// 기존 첨부파일 삭제 
		for(String num : numStr) {
			try {
				int fi_num = Integer.parseInt(num);
				FileVO dFile = postDao.selectFile(fi_num);
				deleteFile(dFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}
