package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("user") MemberVO user);

	MemberVO selectMember(@Param("me_id")String me_id);

}
