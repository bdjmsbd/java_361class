package day04;

import java.util.Scanner;

public class H_DoWhileEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
