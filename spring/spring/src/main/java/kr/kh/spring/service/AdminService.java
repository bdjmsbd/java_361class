package kr.kh.spring.service;

import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.MemberVO;

public interface AdminService {

	boolean insertCommunity(CommunityVO community, MemberVO user);

	boolean deleteCommunity(int co_num, MemberVO user);

	boolean updateCommunity(CommunityVO community, MemberVO user);

}
