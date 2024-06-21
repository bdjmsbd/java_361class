package day07;

import java.util.InputMismatchException;
import java.util.Scanner;

public class C_Exam01 {

	public static void showMenu() {

		System.out.println("------------");
		System.out.println("1. 추가");
		System.out.println("2. 검색");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 다음 메뉴를 출력하고 메뉴를 선택하면 안내문구를 출력하는 코드를 작성하세요.
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		int menuNum = 0;
		do {

			try {
				showMenu();
				menuNum = scan.nextInt();
				System.out.println("------------");
			} catch (InputMismatchException e) {
				//System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}

			switch (menuNum) {
			case 1:
				System.out.println("추가했습니다.");
				break;
			case 2:
				System.out.println("검색했습니다.");
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		} while (menuNum != 3);

		scan.close();

	}

}
