package day16;

public class C_LambdaEx01 {

	public static void main(String[] args) {

		A a1 = new A() {

			@Override
			public int sum(int n1, int n2) {
				return n1 + n2;
			}

		};

		A a2 = (n1, n2) -> {
			return n1 + n2;
		};
		// 구현부 1줄 일 경우 괄호 생략가능, 리턴도 없어야됨
		A a3 = (n1, n2) -> n1 + n2;
		// 인지가 1개면 앞에 가로도 생략가능
		B b1 = n1 -> System.out.println(n1);
		b1.print(10);
		System.out.println(a3.sum(10, 20));
	}
	
	public static void ttt(C c) {
		
		
	}

}

interface A {

//	 익명 함수를 호출 하기에 이런 메소드가 있으면 lambda식 사용 불가하다
//	int sum(int num1, int num2);
//	int sub(int num1, int num2);

	int sum(int num1, int num2);

}

interface B {

	void print(int num);

}

//@FunctionalInterface를 추가했기 때문이 추상 메소드가 2개가 되면 에러 발생
// Function Interface 선언할 경우 추상 메소드는 1개만 존재 가능하다. 
@FunctionalInterface
interface C {

	void test();
	// int test2(int a);
}