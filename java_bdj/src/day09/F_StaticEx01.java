package day09;

public class F_StaticEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student4 std1 = new Student4(1,1,1,"hong");
		Student4 std2 = new Student4(1,1,2,"jeong");
		
		// 학생1과 학생2의 정보를 출력
		std1.print();
		std2.print();
		
		// 학생1과 학생2의 고등학교를 출력 
		std1.printSchoolName();
		std2.printSchoolName();

	}

}

class Student4 {
	
	public int grade, classNum, num;
	public String name;
	
	public static String schoolName = "khschool"; 
	
	public void print() {
		System.out.println(grade + "학년 "+classNum+ "반 "+num +"번 "+name);
	}
	public static void printSchoolName() {
		System.out.println(schoolName);
	}
	public Student4(int grade, int classNum, int num, String name) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	
}