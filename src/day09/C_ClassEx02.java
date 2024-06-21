package day09;

public class C_ClassEx02 {

	public static void main(String[] args) {

		// getter, setter 사용
		Student2 std = new Student2();
		std.setGrade(3);
		
	}

}


// 학생 성적을 관리하기 위한 학생 클래스를 추상화
class Student2 {
	private int grade, classNum, num;
	private String name;
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade=grade;
	}
	
	
	
	
//	Student1(int eng, int kor, int math) {
//		this.eng_S = eng;
//		this.kor_S = kor;
//		this.math_S = math;
//	}
}
