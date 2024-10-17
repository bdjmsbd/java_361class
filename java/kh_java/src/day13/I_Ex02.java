package day13;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class I_Ex02 {

	public static void main(String[] args) {
		// 두 정수와 산술 연산자를 입력받아 산술연산결과를 알려주는 메소드를 정의 및 구현하고
		// main 메소드에서 실행하는 코드를 작성하세요.
		// 단 예외 발생 시 예외처리하는 코드를 추가하세요
		calculator();
	}

	public static void calculator() {
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char oper;

		System.out.println("두 정수와 산술 연산자를 입력하세요(예 a * b) :");
		try {
			num1 = sc.nextInt();
			oper = sc.next().charAt(0);
			num2 = sc.nextInt();
			sc.close();

			String format = MessageFormat.format("{0} {1} {2} = ", num1, oper, num2);

			switch (oper) {
				case '+':
					System.out.println(format + (num1 + num2));
					break;
				case '-':
					System.out.println(format + (num1 - num2));
					break;
				case '*':
					System.out.println(format + (num1 * num2));
					break;
				case '/':
					System.out.println(format + (num1 / (double) num2));
					break;
				case '%':
					System.out.println(format + (num1 % num2));
					break;
				default:
//					System.out.println("연산자가 이상해 : " + oper);
					throw new IllegalArgumentException("잘못된 연산자 : " + oper);
			}
		} catch (InputMismatchException e) {
			System.out.println("input error");
			return;
		} catch (ArithmeticException e) {
			System.out.println("denominator is not zero");
			return;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}

}
