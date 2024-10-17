package db.student.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.student.dao.ScoreDAO;
import db.student.dao.StudentDAO;
import db.student.dao.SubjectDAO;
import db.student.model.vo.ScoreVO;
import db.student.model.vo.StudentVO;
import db.student.model.vo.SubjectVO;

public class ScoreServiceImp implements ScoreService {

	private ScoreDAO scoreDao;
	private StudentDAO studentDao;
	private SubjectDAO subjectDao;

	public ScoreServiceImp() {
		String resource = "db/student/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			subjectDao = session.getMapper(SubjectDAO.class);
			studentDao = session.getMapper(StudentDAO.class);
			scoreDao = session.getMapper(ScoreDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertScore(StudentVO std, SubjectVO subject, ScoreVO score) {

		SubjectVO dbSubject = subjectDao.selectSubject(subject);

		if (dbSubject == null) {
			return false;
		}

		StudentVO dbStd = studentDao.selectStudent(std);
		if (dbStd == null) {
			return false;
		}

		ScoreVO dbScore = scoreDao.selectScore(dbStd.getSt_key(), dbSubject.getSu_key());
		if (dbScore != null) {
			return false;
		}

		score.setSc_st_key(dbStd.getSt_key());
		score.setSc_su_key(dbSubject.getSu_key());

		return scoreDao.insertScore(score);

	}

	@Override
	public boolean deleteScore(StudentVO std, SubjectVO subject) {
		
		SubjectVO dbSubject = subjectDao.selectSubject(subject);

		if (dbSubject == null) {
			return false;
		}

		StudentVO dbStd = studentDao.selectStudent(std);
		if (dbStd == null) {
			return false;
		}
		
		return scoreDao.deleteScore(dbStd.getSt_key(), dbSubject.getSu_key());
		
	}

	@Override
	public boolean updateScore(StudentVO std, SubjectVO subject, ScoreVO score) {
		
		SubjectVO dbSubject = subjectDao.selectSubject(subject);

		if (dbSubject == null) {
			return false;
		}

		StudentVO dbStd = studentDao.selectStudent(std);
		if (dbStd == null) {
			return false;
		}

		ScoreVO dbScore = scoreDao.selectScore(dbStd.getSt_key(), dbSubject.getSu_key());
		if (dbScore == null) {
			return false;
		}

		score.setSc_st_key(dbStd.getSt_key());
		score.setSc_su_key(dbSubject.getSu_key());
		return scoreDao.updateScore(score);
	}

}
