package db.student.dao;

import org.apache.ibatis.annotations.Param;

import db.student.model.vo.StudentVO;

// ctrl + shift + o
// 인터페이스로 선언.
// Data Access Object
public interface StudentDAO {

	StudentVO selectStudent(@Param("std")StudentVO std);

	boolean insertStudent(@Param("std")StudentVO std);

	boolean updateStudent(@Param("std")StudentVO std);

	boolean deleteStudent(@Param("std")StudentVO std); 

//	boolean insertStudent(
//			@Param("grade") int grade,
//			@Param("classNum") int classNum,
//			@Param("num") int num,
//			@Param("name") String name);
//
//	ArrayList<StudentVO> selectStudentList();
//
//	ArrayList<StudentVO> selectStudentList2();
//
//	StudentVO selectStudentByKey(@Param("studentNum")int studentNum);

}
