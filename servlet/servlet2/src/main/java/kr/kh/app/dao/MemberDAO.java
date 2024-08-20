package kr.kh.app.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.MemberVO;

public interface MemberDAO {

	void insertMember(@Param("user")MemberVO newUser);

	Object selectMember(@Param("me_id")String me_id);

}
