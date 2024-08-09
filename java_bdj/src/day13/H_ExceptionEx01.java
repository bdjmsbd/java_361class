package day13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class H_ExceptionEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		// 에러 처리 부모 에러처리가 자식 보다 위에 오면 에러 처리가 됨
		do {
			try {
				System.out.println("input two integer: ");
				int num1 = scan.nextInt();
				int num2 = scan.nextInt();
				System.out.println(num1 / num2);
				break;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("잘못된 번지 접근");
			} catch (ArithmeticException e) {
				System.out.println("denominator is not zero");
			} catch (InputMismatchException e) {
				System.out.println("입력값 에러");
			} catch (RuntimeException e) {
				System.out.println("실행 예외");
			} catch (Exception e) {
				System.out.println("예외");
			}
			scan.nextLine();
		} while (true);
	}

}
