package day12;

import java.util.Arrays;
import java.util.Objects;

public class F_Object_Clone_Ex01 {

	public static void main(String[] args) throws CloneNotSupportedException {

		Test3 t1 = new Test3();
		// 기존에 해쉬값 출력되는데 객체를 통해서 오버라이딩 가능
		System.out.println(t1); // t1 == t1.toString()
		System.out.println(t1.toString());

		Test3 list[] = new Test3[3];
		list[0] = new Test3();
		list[1] = new Test3();
		list[2] = new Test3();

//		for(Test3 tmp : list)
//			System.out.println(tmp.toString());

		System.out.println(Arrays.toString(list));

		///////////////////////////////////////////////////////////
		// equals 오버라이딩을 이용한 객체 간 비교
		// 오버라이딩 안하고 단순 비교시 false 나옴

		Student std1 = new Student(1, 1, 1, "bdj");
		Student std2 = new Student(1, 1, 1, "bdj");
		Student std3 = new Student(1, 1, 1, "jbd");
		Student std4 = new Student(1, 1, 2, "bdj");

		System.out.println(std1);
		System.out.println(std2);
		System.out.println(std3);
		System.out.println(std4);

		System.out.println("std1 == std2 : " + (std1 == std2));
		System.out.println("std1 == std2 : " + (std1.equals(std2)));

		///////////////////////////////////////////////////////////
		// clone
		// class에서 cloneable 상속받고, clone 메소드 오버라이딩해서 사용
		// throw 에러처리를 해줘야 한다.
		Student std5 = (Student) std1.clone();
		System.out.println(std5);
		
		System.out.println("std1 == std5 : " + (std1 == std5));
		System.out.println("std1 == std5 : " + (std1.equals(std5)));
	}

}

class Student implements Cloneable {

	int grade, classNum, num;
	String name;

	public Student(int grade, int classNum, int num, String name) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}

		// hashcode 함수를 쓰면 기존 해시가 아닌 변수를 통한 해시를 생성
//	@Override
//	public int hashCode() {
//		return Objects.hash(classNum, grade, num);
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // 값이 같다. 객체의 값은 주소값
			return true;
		if (obj == null) // 비교대상이 없다.
			return false;
		if (getClass() != obj.getClass()) // 클래스가 다른 경우
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

class Test3 {

	int num1, num2;

	public String toString() {
		return "Test3 [num1=" + num1 + ", num2=" + num2 + "]";
	}

}