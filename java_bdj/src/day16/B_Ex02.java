package day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

public class B_Ex02 {

	public static int runPlay(Scanner sc) {

		int randNum = myutils.MyMath.randGen(1, 100);
		// 숫자 생성
//		System.out.println(randNum);
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

	public static void recordId(List<RankedRecord> rL, int score, Scanner sc) {
		System.out.println("기록\nID 입력 : ");
		String id = sc.next();
		rL.add(new RankedRecord(id, score));

		System.out.println("기록 등록");
	}

	public static void recordReg(List<RankedRecord> rL, int score, Scanner sc) {

		if (rL.size() < 5) {
			recordId(rL, score, sc);
		} else if (rL.size() == 5) {
			if (rL.get(rL.size() - 1).getScore() > score) {
				rL.remove(rL.size() - 1);
				recordId(rL, score, sc);
			} else {
				System.out.println("순위 미달");
			}
		}
		Collections.sort(rL, (o1, o2) -> o1.getScore() - o2.getScore());
	}

	public static void showRank(List<RankedRecord> rL) {
		if (rL.size() == 0) {
			System.out.println("기록이 없습니다.");
			return;
		}
		for (int i = 0; i < rL.size(); i++) {
			System.out.println("" + (i + 1) + "등. " + rL.get(i) + "번");
		}
	}

	public static void main(String[] args) {
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
		List<RankedRecord> recordList = new ArrayList<>();

		int menuNum;
		int score;
		do {
			menuNum = runMenu(sc);

			switch (menuNum) {
				case 1:
					score = runPlay(sc);
					recordReg(recordList, score, sc);
					break;
				case 2:
					showRank(recordList);
					break;
				case 3:
					break;
			}
		} while (menuNum != 3);
	}

}

@Data
@AllArgsConstructor // 모든 멤버변수를 필요로 하는 생성자
//@RequiredArgsConstructor // 반드시 필요한 멤버 변수들을 매개변수로 갖는 생성자
class RankedRecord /* implements Comparable<RankedRecord> */ {

	@NonNull
	private String id;
	private int score;

	@Override
	public String toString() {
		return id + " : " + score;
	}
	
//	@Override
//	public int compareTo(RankedRecord r) {
//		return score - r.score;
//	}

}