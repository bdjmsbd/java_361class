package kr.kh.spring.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MemberDAO memberDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean signup(MemberVO user) {
		if (user == null) {
			return false;
		}

		// 정규표현식은 생략

		// 비밀번호 암호화
		String encPw = passwordEncoder.encode(user.getMe_pw());
		user.setMe_pw(encPw);

		try {
			return memberDao.insertMember(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public MemberVO login(MemberVO member) {
		if (member == null) {
			return null;
		}
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if (user == null) {
			return null;
		}
		// matches : 왼쪽에는 암호화 안된 비번, 오른쪽은 암호화된 비번
		if (passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {
			return user;
		}
		return null;
	}

	@Override
	public boolean checkId(String id) {
		return (memberDao.selectMember(id) == null);
	}

	@Override
	public void updateMemberCookie(MemberVO user) {

		if (user == null) {
			return;
		}
		memberDao.updateMemberCookie(user);

	}

	@Override
	public MemberVO getMemberByCookie(String sid) {
		return memberDao.selectMemberByCookie(sid);
	}

	@Override
	public boolean findPw(String id, String email) {

		// 새 비밀번호 생성
		String newPw = randomPassword(8);
//		System.out.println(newPw);
		// 메일 전송
		if (id.trim().length() == 0) {
			return false;
		}
		MemberVO user = memberDao.selectMember(id);
		if(user == null) {
			return false;
		}
		if(!email.equals(user.getMe_email())){
			return false;
		}
		
		String title = "새로운 비밀번호입니다.";
		
		boolean res = mailSend(email, title, "새로운 비밀번호는 <b><font color='red'>" + newPw + "</font></b>입니다.");
		
		if(!res) {
			return false;
		}
		
		// 디비에 새로운 비밀번호 저장
		String encPw = passwordEncoder.encode(newPw);
		memberDao.updatePassword(id,encPw);
		
		return true;
	}

	private String randomPassword(int numSize) {
		String pw = "";
		int max = 10 + 26 + 26; // 0~9 a-z A-Z
		while(pw.length() < numSize) {
			Random random = new Random();
			int r = random.nextInt(max);
			if(r<10) {
				pw += r;
			}
			else if(r<36) {
				pw += (char)('a' + r - 10);
			}
			else {
				pw += (char)('A' + r - 36);
			}
		}
		
		return pw;
	}
	
	

	public boolean mailSend(String to, String title, String content) {

		String setfrom = "bdjmsbd@naver.com";
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom);// 보내는사람, 생략하면 정상작동을 안함
			messageHelper.setTo(to);// 받는사람 이메일
			messageHelper.setSubject(title);// 메일제목, 생략이 가능하다
			messageHelper.setText(content, true);// 메일 내용
			// true가 오버라이딩 된 경우. 컨텐츠가 html 코드로 되어 있는 경우 코드가 적용된다.

			mailSender.send(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


}
