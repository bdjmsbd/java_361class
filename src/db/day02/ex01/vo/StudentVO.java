package db.day02.ex01.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자가 꼭 필요하다
public class StudentVO {

	private int studentNum;
	private int grade;
	private int classNum;
	private int num;
	private String name;

	@Override
	public String toString() {
		return ""+studentNum + " : [학년 " + classNum + "반" + num + "번 " + name + "]";
	}

}