package day07;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class C_Exam04 {

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
		 * exam01 ~ exam03 합치기
		 */
		final String EXIT = "-1";
		final int MAX = 10;
		
		Scanner scan = new Scanner(System.in);
		int menuNum = 0;
		String wordList[] = new String[MAX], inputWord;
		int wordCount = 0;

		do {

			try {
				showMenu();
				menuNum = scan.nextInt();
				System.out.println("------------");
			} catch (InputMismatchException e) {
				// System.out.println("잘못된 메뉴입니다.");
			}
			
			scan.nextLine();
			switch (menuNum) {
			case 1:
//				System.out.println("추가했습니다.");

				do {
					System.out.print("단어입력 (종료: -1) : ");

					inputWord = scan.next();
					if (inputWord.equals(EXIT)) {
						System.out.println("메뉴로 돌아갑니다.");
						break;
					}

					if (wordCount == wordList.length) {
						System.out.println("단어를 추가하지 못했습니다.");
						continue;
					}
					wordList[wordCount++] = inputWord;
					System.out.println("단어를 추가했습니다.");

					scan.nextLine();
				} while (true);
				break;

			case 2:
//				System.out.println("검색했습니다.");
				do {
					System.out.print("단어입력 (종료: -1) : ");

					inputWord = scan.next();
					if (inputWord.equals(EXIT)) {
						System.out.println("메뉴로 돌아갑니다.");
						break;
					}

					boolean isExist = false;
					for (int i = 0; i < wordCount; i++) {
						if (wordList[i].equals(inputWord)) {
							isExist = true;
							break;
						}
					}
					System.out.println((isExist ? "있는" : "없는") + " 단어입니다.");

					scan.nextLine();
				} while (true);
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			case 99:
				System.out.println(Arrays.toString(wordList));
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		} while (menuNum != 3);

		scan.close();
	}

}
