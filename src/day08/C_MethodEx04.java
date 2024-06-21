package day08;

public class C_MethodEx04 {
	public static int a= 4;
	// 값 만을 참조
	public static long factorial(int num) {
		return (num==1||num==0)?1:num*factorial(num-1);
	}
	
	public static void main(String[] args) {

		// 재귀 메소드로 인한 스택 오버플로우 예제
		// 탈출 조건 미기재로 인한 오류 발생
		// java.lang.StackOverflowError
		
		int num = a+ C_MethodEx04.a+1+ C_MethodEx03.a;
		System.out.println(num);
		System.out.println(factorial(num));
	}
}
