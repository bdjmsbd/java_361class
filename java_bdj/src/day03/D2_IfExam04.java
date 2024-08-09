package day03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class D2_IfExam04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num;

		while (true) {
			try {
				System.out.print("정수 입력 : ");
				num = scan.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("[ERROR] 숫자를 입력하세요");
				scan.nextLine();
			}
		}

		if (num % 3 == 0)
			System.out.println("3의 배수입니다.");
		else
			System.out.println("3의 배수가 아닙니다.");
		
		scan.close();

	}

}
