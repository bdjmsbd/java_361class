package day13;

public class H_ExceptionEx03 {

	public static void main(String[] args) {
		// finally 예제
		// catch 에러 처리 후 리턴 전에 finally를 실행

		test();
		System.out.println("-------------");
		test2();
	}

	public static void test() {
		int num1 = 1, num2 = 0;

		try {
			System.out.println(num1 % num2);
		} catch (Exception e) {
			System.out.println("예외 발생");
			return;
		}
		System.out.println("프로그램을 종료합니다");
	}

	public static void test2() {
		int num1 = 1, num2 = 0;

		try {
			System.out.println(num1 % num2);
		} catch (Exception e) {
			System.out.println("예외 발생");
			return;
		} finally {
			System.out.println("프로그램을 종료합니다");
		}
	}

}
