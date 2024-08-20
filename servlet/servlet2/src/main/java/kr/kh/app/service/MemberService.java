package kr.kh.app.service;


public interface MemberService {

	boolean signUp(String id, String pw, String pw_ckh, String email);

	boolean checkId(String me_id);

}
