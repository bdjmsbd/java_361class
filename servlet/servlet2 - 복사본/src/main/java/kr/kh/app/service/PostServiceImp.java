package kr.kh.app.service;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.PostDAO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;

public class PostServiceImp implements PostService {

	private PostDAO postDao;

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
	public CommunityVO getCommunity(String num) {
		return postDao.selectCommunity(num);
	}

	@Override
	public List<PostVO> getPostList(Criteria cri) {
		if (cri == null) {
			return null;
		}
		return postDao.selectPostList(cri);
	}

	@Override
	public PageMaker getPostPageMaker(Criteria cri) {
		if (cri == null) {
			return null;
		}
		int totalCount = postDao.selectPostTotalCount(cri);
		return new PageMaker(totalCount, 5, cri);
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
	public boolean insertPost(PostVO post) {
		
		if (post == null) {
			return false;
		}
		
		if (post.getPo_title().trim().length() == 0) {
			return false;
		}
		
		
		return postDao.insertPost(post);
	}

	@Override
	public boolean updatePost(PostVO post, MemberVO user) {

			if(user ==null) {
				return false;
			}
			
			if(!user.getMe_id().equals(post.getPo_me_id())) {
				return false;
			}
			
			if (post.getPo_title().trim().length() == 0) {
				return false;
			}
			
			
			return postDao.updatePost(post);
	}

	@Override
	public boolean deletePost(PostVO post, MemberVO user) {
		
		if(!post.getPo_me_id().equals(user.getMe_id())) {
			if(!user.getMe_authority().equals("ADMIN")) {
				return false;
			}
		}
		
		return postDao.deletePost(post);
	}

}