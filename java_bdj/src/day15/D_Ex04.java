package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class D_Ex04 {

	public static void main(String[] args) {
		// 1~45 중복 되지 않은 6개의 번호와 1개의 보너스 번호
		// 1등 : 번호 6개 일치
		// 2등 : 번호 5개 + 보너스 번호 일치
		// 3등 : 번호 5개가 일치
		// 4등 : 번호 4개가 일치
		// 5등 : 번호 3개가 일치
		// 나머지 꽝
		Scanner sc = new Scanner(System.in);

//		while (myNum.size() < 6) {
//			myNum.add(myutils.MyMath.randGen(1, 45));
//		} // 15까지는 정렬 됨

		HashSet<Integer> lottoSet = new HashSet<>();
		while (lottoSet.size() < 7) {
			lottoSet.add(myutils.MyMath.randGen(1, 45));
		} // 마지막 번호는 보너스

		ArrayList<Integer> lottoList = new ArrayList<>(lottoSet);
//	lottoList.addAll(lottoSet);

		int bonus = lottoList.remove(6);
		// hashset은 정렬이 안되기에 List로 변환 후 정렬해준다.
//		Collections.sort(lottoList, (o1,o2) -> o1 - o2);
		System.out.println(lottoList + "(보너스 : " + bonus + ")");

		HashSet<Integer> myNum = new HashSet<>();
		while (myNum.size() < 6) {
			System.out.print(myNum.size() + 1 + "번째 번호 입력 : ");
			myNum.add(sc.nextInt());
		}

		int m = 0;
		for (Integer tmp : lottoList) {
			if (myNum.contains(tmp))
				m++;
		}

		switch (m) {
			case 6:
				System.out.println("1등");
				break;
			case 5:
				if (myNum.contains(bonus))
					System.out.println("2등");
				else
					System.out.println("3등");
				break;
			case 4:
				System.out.println("4등");
				break;
			case 3:
				System.out.println("5등");
				break;
			default:
				System.out.println("꽝");
		}

		System.out.println("내 번호 : " + myNum);
		System.out.println("당첨번호 : " + lottoSet);

		sc.close();
	}

}
