package day09;

public class C_ClassEx01 {

	public static void main(String[] args) {

		Student1 std1 = new Student1();
		Student1 std2 = new Student1(3,1,27,"bdj");
		std2.print();
		std1.name= "yjf";
		std1.print();
		
		
		
	}

}


// 학생 성적을 관리하기 위한 학생 클래스를 추상화
class Student1 {
	int eng_S, kor_S, math_S;
	int grade, classNum, num;
	String name;
	
	Student1() {
	}
	
	// 학년, 반, 번호, 이름
	Student1(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	
	void print() {
		System.out.println(grade + "학년 " + classNum + "반 " +num +"번 "+ name);
	}
	
//	Student1(int eng, int kor, int math) {
//		this.eng_S = eng;
//		this.kor_S = kor;
//		this.math_S = math;
//	}
}
