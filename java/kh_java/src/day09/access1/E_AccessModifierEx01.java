package day09.access1;

public class E_AccessModifierEx01 {

	public static void main(String[] args) {
		// 접근 제어자 예제
		Student std1 = new Student();
		std1.grade = 3; // public, 다른 패키지 다른 클래스에서도 사용 가능
		std1.classNum =5; // protected, 같은 패키지에 다른 클래스에서 사용 가능
		std1.num = 26; // default, 접근제어 default 같은 패키지에 다른 클래스 사용가능
		// std1.name  // private, 다른 클래스에서 사용 불가
		

	}

}
