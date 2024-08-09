package day08;

public class C_MethodEx03 {
	protected static int a= 4;
	// 값 만을 참조
	public static int sum(int num1, int num2) {
		return num1+num2;
	}
	
	
	public static void main(String[] args) {

		int a=1,b=2;
		int num1=1,num2=2;

		System.out.println(sum(a,b));
		System.out.println(sum(1,2));
		System.out.println(sum(num1,num2));
	}
}
