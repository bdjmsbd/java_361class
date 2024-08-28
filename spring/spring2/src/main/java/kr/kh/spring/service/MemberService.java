package kr.kh.spring.service;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberService {

	String getEmail();

	int getCount();

	boolean joinMember(MemberVO member);

	boolean login(MemberVO member);

}
