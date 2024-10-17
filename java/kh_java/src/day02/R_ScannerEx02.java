package day02;

import java.util.Scanner;

public class R_ScannerEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 두 정수와 연산자를 입력 받고 입력받은 결과를 콘솔에 출력 
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수1을 입력하세요 : ");
		int num1 = scan.nextInt();

		System.out.print("정수2를 입력하세요 : ");
		int num2 = scan.nextInt();
		
		System.out.print("연산자를 입력하세요 : ");
		char ch1 = scan.next().charAt(0);
		
		System.out.println("입력결과 : " + num1 + ch1 + num2);
		
		int result;
		result = (ch1 == '+')? num1 + num2
				:(ch1 == '-')? num1 - num2
				:(ch1 == '*')? num1 * num2
				:(ch1 == '/')? num1 / num2 : 0;
		
		System.out.println("연산결과 : " + ((result==0)?"연산자 오류!":result));
		

	}

}
