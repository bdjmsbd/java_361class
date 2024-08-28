package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberDAO {

	String getEmail();

	int getCount();

	boolean insertMember(@Param("m")MemberVO member);

	boolean login(@Param("m")MemberVO member);

	MemberVO selectMember(@Param("m")MemberVO member);

}
