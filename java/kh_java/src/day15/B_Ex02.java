package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class B_Ex02 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("메뉴");
		System.out.println("1.번호 추가");
		System.out.println("2.번호 삭제");
		System.out.println("3.번호 조회");
		System.out.println("4.종료");
		System.out.print("메뉴 선택 : ");
	}

	public static void runMenu(int menu, ArrayList<String> list) {

		switch (menu) {
			case 1:
				System.out.println("번호 추가");
				System.out.print("전화번호 입력 : ");
				// contains로 중복 여부 파악
				list.add(sc.next());
				break;
			case 2:
				System.out.println("번호 삭제");
				System.out.print("삭제할 번호 입력 : ");
				list.remove(sc.next());
				break;
			case 3:
				System.out.println("번호 조회");
				System.out.println(list);
				break;
			case 4:
				System.out.println("종료합니다.");
				break;
		}

	}

	public static void main(String[] args) {
		// 메뉴
		// 1. 번호추가
		// 2. 번호 삭제
		// 3. 번호 조회
		// 4. 종료
		
		ArrayList<String> list = new ArrayList<String>();
		
		int menuNum = -1;

		do {
		showMenu();
		menuNum = sc.nextInt();
		runMenu(menuNum, list);
		}while(menuNum != 4);
		

		sc.close();
	}

}
