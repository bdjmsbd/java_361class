package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class H_Ex05 {

	public static ArrayList<Integer> createRand(int max, int min, int count) {
	// 숫자 생성
		HashSet<Integer> baseSet = new HashSet<>();
		while (baseSet.size() < count) {
			baseSet.add(myutils.MyMath.randGen(min, max));
		}
		return new ArrayList<Integer>(baseSet);
	}
	public static void main(String[] args) {
		// 숫자 야구 1~9 중복되지 않는 3개의 숫자 생성
		// 사용자가 숫자 3개를 중복되지 않게 입력
		
		int max =9, min =1 , count = 3;

		ArrayList<Integer> baseList = createRand(max, min, count);
		Collections.shuffle(baseList);

		System.out.println(baseList);

		// 숫자 입력
		ArrayList<Integer> myNum = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int s = 0, b = 0;
			System.out.print("3개의 숫자 입력 : ");
			myNum.add(sc.nextInt());
			myNum.add(sc.nextInt());
			myNum.add(sc.nextInt());

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (baseList.get(i) == myNum.get(j)) {
						if (i == j) {
							s++;
						} else
							b++;
					}
				}
			}
			if (s == 0 && b == 0)
				System.out.println("Out");
			else if (s == 3) {
				System.out.println("정답");
				break;
			} else
				System.out.println(((s == 0) ? "" : s + "S") + ((b == 0) ? "" : b + "B"));

			myNum.clear();
		}

		sc.close();
	}

}
