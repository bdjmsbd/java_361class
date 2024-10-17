package db.day01;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Student {

	private int studentNum;
	private int grade;
	private int classNum;
	private int num;
	private String name;
	@Override
	public String toString() {
		return studentNum + " : [학년 " + classNum + "반" + num + "번 " + name + "]";
	}

	
}