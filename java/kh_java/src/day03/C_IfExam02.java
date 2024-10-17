package day03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class C_IfExam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int month;
		// while (true) {
		for (;;) {
			Scanner scan = new Scanner(System.in);
			try {
				System.out.printf("월을 입력 하세요 : ");
				month = scan.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("[ERROR] 정수를 입력하세요.");
				scan.nextLine();
			}
			scan.close();
		}
		if (month >= 3 && month < 6)
			System.out.println("봄");
		else if (month >= 6 && month < 9)
			System.out.println("여름");
		else if (month >= 9 && month < 12)
			System.out.println("가을");
		else if (month == 12 || month == 1 || month == 2)
			System.out.println("겨울");
		else
			System.out.println("잘못된 월");
//		if (month/3 == 1)
//			System.out.println("봄");
//		else if (month/3 == 2)
//			System.out.println("여름");
//		else if (month/3 == 3)
//			System.out.println("가을");
//		else if (month == 12 || month == 1 || month == 2 )
//			System.out.println("겨울");
//		else 
//			System.out.println("잘못");

	}

}
