package db.student.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.student.model.vo.SubjectVO;

// ctrl + shift + o
// 인터페이스로 선언.
// Data Access Object
public interface SubjectDAO {

	int selectCountSubject(@Param("subject") String subject);

	boolean insertSubject(@Param("subject") String subject);

	boolean updateSubject(@Param("subject") String subject, @Param("newSubject") String newSubject);

	boolean deleteSubject(@Param("subject") String subject);

	ArrayList<SubjectVO> selectSubjectNameList();

	SubjectVO selectSubject(@Param("subject")SubjectVO subject);

	// StudentVO selectStudent(@Param("std")StudentVO std);

}
