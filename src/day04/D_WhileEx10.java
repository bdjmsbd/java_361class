package day04;

import java.util.Scanner;

public class D_WhileEx10 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		char ch;

		do {
			System.out.print("y를 입력하세요 : ");
			ch = scan.next().charAt(0);
		} while (ch != 'y' /* && ch != 'Y' */);

		System.out.print("y를 입력했네요");
		scan.close();
	}
}
