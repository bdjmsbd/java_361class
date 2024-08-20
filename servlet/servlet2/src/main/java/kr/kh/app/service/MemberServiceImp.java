package kr.kh.app.service;

import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {

	private MemberDAO memberDao;

	public MemberServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {

			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signUp(String id, String pw, String pw_ckh, String email) {

		if (checkRegex(id, "^\\w{6,13}$")) {
			return false;
		}

		if (checkRegex(pw, "^(?=.*[A-Z])(?=.*[a-z])(?=.*[\\d])(?=.*[^\\w])([^\\w]{1}|[\\w]{1}){6,15}$")) {
			return false;
		}

		if (checkRegex(pw_ckh, "^(?=.*[A-Z])(?=.*[a-z])(?=.*[\\d])(?=.*[^\\w])([^\\w]{1}|[\\w]{1}){6,15}$")) {
			return false;
		}

		if (checkRegex(email, "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$")) {
			return false;
		}

		if (!pw.equals(pw_ckh)) {
			return false;
		}

		MemberVO newUser = new MemberVO(id, pw, email);
		try {
			memberDao.insertMember(newUser);

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

	private boolean checkRegex(String str, String regex) {

		if (str == null || str.trim().length() == 0) {
			return true;
		}

		if (Pattern.matches(regex, str)) {
			return false;
		}

		return true;

	}

	@Override
	public boolean checkId(String me_id) {
		
		return memberDao.selectMember(me_id)==null;
	}

}
