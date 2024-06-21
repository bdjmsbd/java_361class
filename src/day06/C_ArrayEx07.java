package day06;

import java.util.Arrays;
import java.util.Scanner;

public class C_ArrayEx07 {

	public static int randGen(int min, int max) {

		return (int) (Math.random() * (max - min + 1) + min);
	}

	public static void main(String[] args) {
		// UpDownGame
		// 한판만 하고 끝.
		// 메뉴가 생김
		// 1. 플레이
		// 2. 기록확인
		// 3. 종료
		// 메뉴선택 :

		/*
		 * 1 정수입력 : 50 (정답 35) 다운 정수입력 : 30 업 정수입력 : 35 정답입니다. 맞힌 횟수는 3회입니다. 기록이 등록됩니다.
		 * 메뉴선택 : 2 기록확인 1. 3회 메뉴선택 : 3 프로그램을 종료합니다.
		 */

		int min = 1, max = 10;
		Scanner scan = new Scanner(System.in);

		int menuNum;
		int[] scoreTable = new int[5];

		while (true) {
			System.out.println("1. 플레이  ");
			System.out.println("2. 메뉴확인");
			System.out.println("3. 종료   ");
			System.out.print("메뉴선택 : ");
			menuNum = scan.nextInt();

			if (menuNum == 1) {
				int randNum = randGen(min, max);
				int playNum, count = 0;
				do {
					System.out.print("정수입력 : ");
					playNum = scan.nextInt();
					count++;
					if (playNum == randNum) {
						System.out.println("정답입니다. 맞힌 횟수는 " + count + "회입니다.");
						// 배열이 비었으면 일단 삽입, 최초 5회
						if (scoreTable[0] == 0) {
							scoreTable[0] = count;
							System.out.println("기록이 등록됩니다.");
							break;
						} 
						// 배열이 다 찼지만 5위보다 성적이 좋으면 5위랑 성적 교체
						else if (scoreTable[scoreTable.length - 1] > count) {
							scoreTable[scoreTable.length - 1] = count;
							System.out.println("기록이 등록됩니다.");
							break;
						}
						break;
					} else if (playNum > randNum) {
						System.out.println("DOWN!");
					} else if (playNum < randNum) {
						System.out.println("UP!");
					}
				} while (true);
				Arrays.sort(scoreTable);
			} else if (menuNum == 2) {
				System.out.println("<기록>");
				int no = 1;
				for (int i = 0; i < scoreTable.length; i++) {
					// 5게임 이내에서 기록을 확인할 경우, 초기값 패스
					if (scoreTable[i] == 0)
						continue;
					else {
						System.out.println(no++ + "등. " + scoreTable[i] + "회");
					}

				}
				System.out.println();

			} else if (menuNum == 3) {
				System.out.println("게임 종료");
				break;
			}
		}
		scan.close();
	}

}
