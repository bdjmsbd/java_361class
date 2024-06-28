package day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

public class B_Ex03 {

	public static int runPlay(Scanner sc) {

		int randNum = my.MyMath.randGen(1, 100);
		// 숫자 생성
		System.out.println(randNum);
		int score = 0;
		while (true) {
			// 숫자 입력
			System.out.print("숫자 입력 : ");
			int myNum = sc.nextInt();
			score++;
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
		return score;
	}

	public static int runMenu(Scanner sc) {

		System.out.println("메뉴");
		System.out.println("1.플레이");
		System.out.println("2.기록환인");
		System.out.println("3.종료");
		System.out.print("메뉴 선택 : ");

		return sc.nextInt();
	}

	public static void recordId(Map<String, Integer> rM, int score, Scanner sc) {
		System.out.println("기록\nID 입력 : ");
		String id = sc.next();
		if (!rM.containsKey(id) || rM.get(id) > score)
			rM.put(id, score);

		System.out.println("기록 등록");
	}

	public static void recordReg(Map<String, Integer> rM, int score, Scanner sc) {

		if (rM.size() < 5) {
			recordId(rM, score, sc);
			return;
		}
		Iterator<String> it = rM.keySet().iterator();
		int tmpScore = 0;
		String tmpId = null;
		while (it.hasNext()) {

			String id = it.next();
			Integer c = rM.get(id);
			if (score < c && tmpScore < c) {
				tmpScore = c;
				tmpId = id;
			}
		}
		if (tmpId != null) {
			rM.remove(tmpId);
			recordId(rM, score, sc);
		}
	}

	public static void showRank(Map<String, Integer> rM) {
		if (rM.size() == 0) {
			System.out.println("기록이 없습니다.");
			return;
		}

		Iterator<String> it = rM.keySet().iterator();
		while (it.hasNext()) {
			String id = it.next();
			Integer score = rM.get(id);
			System.out.println(id + " : " + score);
		}
	}

	public static void main(String[] args) {
		// Hashmap으로 작성
		// updown game
		// 1~100 만들어진 숫자를 맞추는 게임
		// 최대 5등까지 저장하며, 먼저 등록된 순으로 저장
		// 아이디를 입력받음

		// 메뉴 출력
		// 메뉴
		// 1. 플레이
		// 2. 기록확인
		// 3. 종료
		// 메뉴선택 :
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> rM = new HashMap<>();

		int menuNum;
		int score;
		do {
			menuNum = runMenu(sc);

			switch (menuNum) {
				case 1:
					score = runPlay(sc);
					recordReg(rM, score, sc);
					break;
				case 2:
					showRank(rM);
					break;
				case 3:
					break;
			}
		} while (menuNum != 3);
	}

}