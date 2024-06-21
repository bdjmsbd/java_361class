package day07;

import java.util.Scanner;

public class C_Exam03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 입력한 문자열이 배열에 있는 지 없는 지 확인하는 코드를 작성하세요 단어 입력 (종료 -1) : apple 없는 단어입니다. 있는
		 * 단어입니다. 종료합니다.
		 */
		final String EXIT = "-1";

		Scanner scan = new Scanner(System.in);

		String[] wordList = new String[] { "cat", "dog", "put", "java", "you" };
		String inputWord;

		do {
			System.out.print("단어입력 (종료: -1) : ");

			inputWord = scan.next();
			if (inputWord.equals(EXIT)) {
				System.out.println("메뉴로 돌아갑니다.");
				break;
			}

			boolean isExist = false;
			for (String tmpStr : wordList) {
				if (tmpStr.equals(inputWord)) {
					isExist = true;
					break;		
				}
			}
			System.out.println((isExist?"있는":"없는") + " 단어입니다.");

		} while (true);

		scan.close();

	}

}
