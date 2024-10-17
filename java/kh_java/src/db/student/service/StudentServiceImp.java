package db.student.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.student.dao.StudentDAO;
import db.student.model.vo.StudentVO;

// ctrl + shift + o
public class StudentServiceImp implements StudentService { // 인터페이스로 선언.

	private StudentDAO studentDao;

	public StudentServiceImp() {
		String resource = "db/student/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			studentDao = session.getMapper(StudentDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean insertStudent(StudentVO std) {

		if (std == null) {
			return false;
		}
		// 이미 등록된 학생인 지 확인합니다.
		// 학년, 반, 번호를 저장
		StudentVO dbStd = studentDao.selectStudent(std);
		if (dbStd != null) {
			return false;
		}
		return studentDao.insertStudent(std);
	}

	public boolean contains(StudentVO std) {
		if (std == null) {
			return false;
		}
		StudentVO dbStd = studentDao.selectStudent(std);
		if (dbStd != null) {
			return false;
		} else
			return true;
	}

	public boolean updateStudent(StudentVO std, StudentVO newStd) {

		if (std == null || newStd == null) {
			return false;
		}
		
		std = studentDao.selectStudent(std);
		
		StudentVO dbStd = studentDao.selectStudent(newStd);
		if(!std.equals(dbStd)) {
			return false;
		}
		
		newStd.setSt_key(std.getSt_key());
		return studentDao.updateStudent(newStd);
		
	}

	public boolean deleteStudent(StudentVO std) {
		if (std == null) {
			return false;
		}
		
		return studentDao.deleteStudent(std);
		
	}

	public StudentVO selectStudent(StudentVO std) {
		return studentDao.selectStudent(std);
	}


}
