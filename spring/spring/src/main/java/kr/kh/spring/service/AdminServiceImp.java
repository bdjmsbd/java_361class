package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.MemberVO;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private PostDAO postDao;

	@Override
	public boolean insertCommunity(CommunityVO community, MemberVO user) {

		if (user == null || !user.getMe_authority().equals("ADMIN")) {
			return false;
		}
		if (community == null || community.getCo_name().trim().equals("")) {
			return false;
		}

		try {
			postDao.insertCommunity(community);
		} catch (Exception e) {
			return false; // duplicated
		}
		return true;
	}

	@Override
	public boolean deleteCommunity(int co_num, MemberVO user) {

		if (user == null || !user.getMe_authority().equals("ADMIN")) {
			return false;
		}
		try {
			int res = postDao.deleteCommunity(co_num);
			if (res == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}

	@Override
	public boolean updateCommunity(CommunityVO community, MemberVO user) {

		if (user == null || !user.getMe_authority().equals("ADMIN")) {
			return false;
		}
		if (community == null || community.getCo_name().trim().length() == 0) {
			return false;
		}

		try {
			int res = postDao.updateCommunity(community);

			if (res == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
