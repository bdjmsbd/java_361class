package day04;

import java.util.Scanner;

public class H_DoWhileEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num;

		do {
			System.out.println("1. 프로그램 실행");
			System.out.println("2. 프로그램 저장");
			System.out.println("3. 프로그램 불러오기");
			System.out.println("4. 프로그램을 종료");
			System.out.print("메뉴 선택 : ");
			num = scan.nextInt();
		} while (num != 4);

		System.out.print("프로그램을 종료합니다.");
		scan.close();
	}

}
