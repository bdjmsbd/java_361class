package kr.kh.spring3.dao;

import kr.kh.spring3.model.vo.MemberVO;

public interface MemberDAO {
	
	boolean insertMember(MemberVO member);

	MemberVO selectMember(MemberVO member);

	void updateMemberCookie(MemberVO user);

}