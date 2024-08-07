package db.student.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

//VO: Value Object의 약자로 값 자체를 표현하는 객체
public class SubjectVO {

	// 과목명, 학년, 학기

	private int su_key; // 과목 기본키
	private String su_name;
	private int su_grade;
	private int su_semester;

	public SubjectVO(String su_name, int su_grade, int su_semester) {
		this.su_name = su_name;
		this.su_grade = su_grade;
		this.su_semester = su_semester;
	}

}
