package day02;

public class P_ConditionalOperatorEx01 {

	public static void main(String[] args) {

		int age = 20;
		System.out.println(age + "\" is a " + (age>=19?"Adult":"Minor"));
		
		int num = 3;
//		String str1 = num + "는(은) " + ((num%2!=0)?"홀수":"짝수") + "입니다.";
//		System.out.println(str1);;
		System.out.println(num + "는(은) " + ((num%2!=0)?"홀수":"짝수") + "입니다.");
		
		int num2 = 100;
		num2 <<= 3;
		System.out.println(num2);
		System.out.println(Integer.toBinaryString(num2));
		
		int num3 = -30;
		System.out.println(Integer.toBinaryString(num3));
		System.out.println(num3>>2);
		System.out.println(Integer.toBinaryString(num3>>2));
		System.out.println(num3>>>2);
		System.out.println(Integer.toBinaryString(num3>>>2));

	}

}
