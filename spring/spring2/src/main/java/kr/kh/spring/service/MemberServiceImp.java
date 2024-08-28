package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDAO memberDao;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public String getEmail() {
		return memberDao.getEmail();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return memberDao.getCount();
	}

	@Override
	public boolean joinMember(MemberVO member) {

		if (member == null) {
			return false;
		}

		return memberDao.insertMember(member);
	}

	@Override
	public boolean login(MemberVO member) {

		if (member == null) {
			return false;
		}
		MemberVO loginUser = memberDao.selectMember(member);
		
		if (loginUser == null) {
			return false;
		}

		boolean res = passwordEncoder.matches(member.getMe_pw(), loginUser.getMe_pw());
		
		if(res) {
			return true;
		}
		else {
			return false;
		}

	}

}
