package db.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;

//Statement 사용
public class DbEx02 {

	public static Connection con = null;

	public static Statement st = null;

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
		int _class = 2;
		int num = 3;
		String name = "조진웅";

//		insertStudent(grade, _class, num, name);
		
//		insertStudent(1,1,4,"김철수");

//		updateStudent(1, 2, 3, 3, 3, 15, name);

		deleteStudent(3,3,15);

		list = selectStudent();

		for (Student tmp : list) {
			System.out.println(tmp.toString());
		}

	}

	public static ArrayList<Student> selectStudent() {
		if (con == null) {
			return null;
		}
		String sql = "select studentNum, grade, class, num, name from student";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList<Student> sl = new ArrayList<Student>();
			while (rs.next()) {
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

		String sql = "delete from student where grade = "+grade+" and class = "+_class+" and num = "+num;

		try {
			st = con.createStatement();

			return st.execute(sql);
		} catch (SQLException e) {
			System.out.println("예외 발생3");

			return false;
		}
	}

	public static boolean updateStudent(int old_grade, int old_class, int old_num, int grade, int _class, int num, String name) {
		
		if(con == null) {
			return false;
		}
		
//		String sql = "update student set grade = ? , class = ? , num = ? , name = ? where grade = ? and class = ? and num = ?";

		String pattern = "update student set grade = {0} , class = {1} , num = {2} , name = \"{3}\" where grade = {4} and class = {5} and num = {6}";
		String sql = MessageFormat.format(pattern, grade, _class, num, name, old_grade, old_class, old_num);
		System.out.println(sql);
		
		try {
			st = con.createStatement();
			
			st.execute(sql);
			return true; 
		} catch (SQLException e) {
			System.out.println("예외 발생2");

			return false;
		}
	}

	public static boolean insertStudent(int grade, int _class, int num, String name) {

		String sql = "insert into student(grade, class, num, name) "+
								"values("+grade+", "+_class+", "+num+", '"+name+"')";
		try {

			st = con.createStatement();
			
			// 쿼리가 적용된 행의 개수를 리턴.
			// message 10 row(s) returned에서 10을 의미
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("예외 발생");

			return false;
		}
	}

}
