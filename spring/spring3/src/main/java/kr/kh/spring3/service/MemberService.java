package kr.kh.spring3.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring3.dao.MemberDAO;
import kr.kh.spring3.model.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberDao;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public boolean signup(MemberVO member) {
		try {
			if (member == null || (memberDao.selectMember(member) != null)) {
				return false;
			}
			// 회원 정규 표현식 검사
			if (!regexCheckMember(member)) {
				return false;
			}
			// 비번 암호화
			String encPw = passwordEncoder.encode(member.getMe_pw());
			member.setMe_pw(encPw);
			return memberDao.insertMember(member);
		} catch (Exception e) {
			return false;
		}
	}

	private boolean regexCheckMember(MemberVO member) {
		if (member == null || member.getMe_pw() == null || member.getMe_id() == null)
			return false;
		if (!Pattern.matches("^\\w{6,13}$", member.getMe_id()))
			return false;
		if (!Pattern.matches("^[a-zA-Z0-9!@#$]{6,15}$", member.getMe_pw()))
			return false;
		return true;
	}

	public MemberVO login(MemberVO member) {

		if (member == null) {
			return null;
		}

		MemberVO loginUser = memberDao.selectMember(member);
		boolean res = passwordEncoder.matches(member.getMe_pw(), loginUser.getMe_pw());

		if (res) {
			return loginUser;
		} else {
			return null;
		}
	}

	public void updateMemberCookie(MemberVO user) {

		if (user == null) {
			return;
		}
		memberDao.updateMemberCookie(user);

	}
}
