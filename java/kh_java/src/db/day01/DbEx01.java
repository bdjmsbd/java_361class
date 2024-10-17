package db.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

// PreparedStatement 사용
public class DbEx01 {

	public static Connection con = null;
	public static PreparedStatement ps = null;

	public static ArrayList<Student> list = new ArrayList<Student>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String db = "student";
		String url = "jdbc:mysql://localhost:3306/" + db;
		String id = "root";
		String pw = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			System.out.println("연결 실패");
			return;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
			return;
		}

		// 1학년 1반 3번 강감찬 학생을 추가.
		int grade = 1;
		int _class = 1;
		int num = 3;
		String name = "강감찬";

//		insertStudent(grade, _class, num, name);
//		insertStudent(1,1,4,"김철수");

//		updateStudent(1, 1, 3, 3, 3, 3, name);
		
//		deleteStudent(3,3,3);
		
		list = selectStudent();
		
		for(Student tmp : list) {
			System.out.println(tmp.toString());
		}

	}
	
	public static ArrayList<Student> selectStudent(){
		if(con == null) {
			return null;
		}
		String sql = "select studentNum, grade, class, num, name from student";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Student> sl = new ArrayList<Student>();
			while(rs.next()) {
				int studentNum = rs.getInt(1);
				int grade = rs.getInt(2);
				int classNum = rs.getInt(3);
				int num = rs.getInt(4);
				String name = rs.getString(5);
				Student std = new Student(studentNum, grade, classNum, num, name);
				sl.add(std);
			}
			return sl;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	public static boolean deleteStudent(int grade, int _class, int num) {

		String sql = "delete from student where grade = ? and class = ? and num = ?";

		try {
			ps = con.prepareStatement(sql);
			// ?개수만큼 setxxx을 이용하여 바인딩 해야 함
			ps.setInt(1, grade);
			ps.setInt(2, _class);
			ps.setInt(3, num);
			// 쿼리가 적용된 행의 개수를 리턴.
			// message 10 row(s) returned에서 10을 의미
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("예외 발생3");

			return false;
		}
		return true;
	}

	public static boolean updateStudent(int old_grade, int old_class, int old_num, int grade, int _class, int num, String name) {

		String sql = "update student set grade = ? , class = ? , num = ? , name = ? where grade = ? and class = ? and num = ?";

		try {
			ps = con.prepareStatement(sql);
			// ?개수만큼 setxxx을 이용하여 바인딩 해야 함
			ps.setInt(1, grade);
			ps.setInt(2, _class);
			ps.setInt(3, num);
			ps.setString(4, name);
			ps.setInt(5, old_grade);
			ps.setInt(6, old_class);
			ps.setInt(7, old_num);
			// 쿼리가 적용된 행의 개수를 리턴.
			// message 10 row(s) returned에서 10을 의미
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("예외 발생2");

			return false;
		}
		return true;
	}

	public static boolean insertStudent(int grade, int _class, int num, String name) {

		String sql = "insert into student(grade, class, num, name) values(?, ?, ?, ?)";
		try {

			ps = con.prepareStatement(sql);
			// ?개수만큼 setxxx을 이용하여 바인딩 해야 함
			ps.setInt(1, grade);
			ps.setInt(2, _class);
			ps.setInt(3, num);
			ps.setString(4, name);
			// 쿼리가 적용된 행의 개수를 리턴.
			// message 10 row(s) returned에서 10을 의미
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("예외 발생");

			return false;
		}
		return true;
	}

}
