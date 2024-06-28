package day22.student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Student implements Comparable<Student>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5775801874085657890L;
	
	@NonNull
	private int grade, classNum, num;
	@NonNull
	private String name;

	private List<Subject> subjectList = new ArrayList<>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}
	// (학년,반,번호)가 키가 됨.

	@Override
	public int hashCode() {
		return Objects.hash(grade, classNum, num);
	}

	public void update(Student stu) {
		this.grade = stu.grade;
		this.classNum = stu.classNum;
		this.num = stu.num;
		this.name = stu.name;
	}

	@Override
	public int compareTo(Student o1) {

		if (this.grade != o1.grade)
			return this.grade - o1.grade;
		else if (this.classNum != o1.classNum)
			return this.classNum - o1.classNum;
		else if (this.num != o1.num)
			return this.num - o1.num;
		return 0;
	}

	@Override
	public String toString() {
		return grade + "학년 " + classNum + "반 " + num + "번 : " + name ;
	}

}
