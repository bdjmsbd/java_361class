package day16;

import java.util.Scanner;

public class B_Ex01 {

	public static void run(Scanner sc) {

		int randNum = my.MyMath.randGen(1, 100);
		// 숫자 생성

		while (true) {
			// 숫자 입력
			System.out.print("숫자 입력 : ");
			int myNum = sc.nextInt();

			// 비교 출력
			if (myNum > randNum) {
				System.out.println("Down!");
			} else if (myNum < randNum) {
				System.out.println("Up!");
			} else if (myNum == randNum) {
				System.out.println("정답!");
				break;
			}
		}
		// 맞추면 종료
	}

	public static void main(String[] args) {
		// updown game
		// 1~100 만들어진 숫자를 맞추는 게임
		
		Scanner sc = new Scanner(System.in);
		run(sc);

	}

}
