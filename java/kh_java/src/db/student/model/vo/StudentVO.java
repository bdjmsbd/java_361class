package db.student.model.vo;

import lombok.Data;

@Data

//VO: Value Object의 약자로 값 자체를 표현하는 객체
public class StudentVO {

	private int st_key;
	private int st_grade;
	private int st_class;
	private int st_num;
	private String st_name;

	public StudentVO(int st_grade, int st_class, int st_num, String st_name) {
		this.st_grade = st_grade;
		this.st_class = st_class;
		this.st_num = st_num;
		this.st_name = st_name;
	}

	@Override
	public String toString() {
		return "" + st_grade + "학년" + st_class + "반" + st_num + "번 " + st_name + "";
	}
	
	

}
