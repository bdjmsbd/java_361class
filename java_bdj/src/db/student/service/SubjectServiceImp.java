package db.student.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.student.dao.StudentDAO;
import db.student.dao.SubjectDAO;
import db.student.model.vo.StudentVO;
import db.student.model.vo.SubjectVO;

// ctrl + shift + o
public class SubjectServiceImp implements SubjectService { // 인터페이스로 선언.

	private SubjectDAO subjectDao;

	public SubjectServiceImp() {
		String resource = "db/student/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			subjectDao = session.getMapper(SubjectDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean insertSubject(String subject) {

		if (subject == null || subject.length() == 0) {
			return false;
		}

		int count = subjectDao.selectCountSubject(subject);
		if (count > 0) {
			return false;
		}

		return subjectDao.insertSubject(subject);
	}

	public boolean updateSubject(String subject, String newSubject) {

		if (subject == null || subject.length() == 0 || newSubject == null || newSubject.length() == 0) {
			return false;
		}
		if (subjectDao.selectCountSubject(subject) == 0) {
			return false;
		}
		if (subjectDao.selectCountSubject(newSubject) != 0) {
			return false;
		}

		return subjectDao.updateSubject(subject, newSubject);
	}

	public boolean deleteSubject(String subject) {
		if (subject == null || subject.length() == 0) {
			return false;
		}
		if (subjectDao.selectCountSubject(subject) == 0) {
			return false;
		}
		return subjectDao.deleteSubject(subject);

	}


	public ArrayList<SubjectVO> selectSubjectNameList() { return subjectDao.selectSubjectNameList();
	}



}
