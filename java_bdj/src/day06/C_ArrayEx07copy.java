package day06;

import java.util.Arrays;
import java.util.Scanner;

public class C_ArrayEx07copy {

	public static int randGen(int min, int max) {

		return (int) (Math.random() * (max - min + 1) + min);
	}

	public static void showMenu() {
		System.out.println("1. 플레이  ");
		System.out.println("2. 메뉴확인");
		System.out.println("3. 종료   ");
		System.out.print("메뉴선택 : ");
	}

	public static void showRecord(int[] scoreRecord) {

		System.out.println("<기록>");
		int no = 1;
		for (int i = 0; i < scoreRecord.length; i++) {
			// 5게임 이내에서 기록을 확인할 경우, 초기값 패스
			if (scoreRecord[i] == 0)
				continue;
			else {
				System.out.println(no++ + "등. " + scoreRecord[i] + "회");
			}

		}
		System.out.println();
	}

	public static int[] playGame(int[] scoreRecord, int randNum) {

		Scanner scan = new Scanner(System.in);
		int playNum, count = 0;
		do {
			System.out.print("정수입력 : ");
			playNum = scan.nextInt();
			count++;
			if (playNum == randNum) {
				System.out.println("정답입니다. 맞힌 횟수는 " + count + "회 입니다.");
				// 배열이 비었으면 일단 삽입, 최초 5회
				if (scoreRecord[0] == 0) {
					scoreRecord[0] = count;
					System.out.println("기록이 등록됩니다.");
					break;
				}
				// 배열이 다 찼지만 5위보다 성적이 좋으면 5위랑 성적 교체
				else if (scoreRecord[scoreRecord.length - 1] > count) {
					scoreRecord[scoreRecord.length - 1] = count;
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

		scan.close();
		return scoreRecord;
	}

	public static void main(String[] args) {

		int min = 1, max = 10;
		Scanner mScan = new Scanner(System.in);

		int menuNum;
		int[] scoreTable = new int[5];

		do {

			showMenu();
			menuNum = mScan.nextInt();
			mScan.nextLine();

			switch (menuNum) {
			case 1:
				int randNum = randGen(min, max);
				playGame(scoreTable, randNum);
				Arrays.sort(scoreTable);
				break;
			case 2:
				showRecord(scoreTable);
				break;
			case 3:
				System.out.println("게임 종료");
				break;
			}
		} while (menuNum != 3);
		mScan.close();
	}
}
