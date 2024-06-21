package day02;

public class K_IncrementOperatorEx01 {

	public static void main(String[] args) {

		int num1 = 10, num2 = 10;
		
		++num1;
		num2++;

		System.out.println("num1: "+ num1);
		System.out.println("num2: "+ num2);

		System.out.println("num1 before increment : " + num1);
		System.out.println("num2 before increment : " + num2);
		
		System.out.println("incrementing num1 : " + ++num1);
		System.out.println("incrementing num2 : " + num2++);

		System.out.println("num1 after increment : " + num1);
		System.out.println("num2 after increment : " + num2);

	}

}
