package day08;

public class B_ClassEx01 {

	public static void main(String[] args) {
		
//		Student stu = new Student("bdj", "2010122250", "seoul", "computer", 8);
//		System.out.println(stu);
		long i = 32l;

		System.out.println(sumTwo(sumTwo((int)i, 6), 10));
		
		sumPrint(5, 25);

	}
	// 두 정수를 합하여 반환
	public static int sumTwo(int num1, int num2) {
		return num1 + num2;
	}
	
	// 두 정수를 합하여 출력
	public static void sumPrint(int num1, int num2) {
		System.out.println(num1 + num2); 
		
	}
}

class Student {
	// 이름, 학번, 학년, 사는 곳, 전공
	String name;
	String id;
	int semester;
	String address;
	String major;

	Student(String name, String id, String address, String major, int semester) {
		this.name = name;
		this.id = id;
		this.semester = semester;
		this.address = address;
		this.major = major;
	}
}