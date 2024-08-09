package day07;

import java.util.Arrays;
import java.util.Collections;

public class D_ArrayEx02 {

	
	// rand 함수 틀
	public static int randGen(int min, int max) {

		return (int) (Math.random() * (max - min + 1) + min);
	}

	public static void main(String[] args) {
		/*
		 * 1~9 사이의 랜덤한 수 3개를 중복되지 않게 배열에 저장하는 코드
		 */

		int min = 1, max = 5;
		int[] randList = new int[3];
		int numCount = 0;

		int randNum;
		for (int i = 0; i < randList.length; i++) {
			randNum = randGen(min, max);
			boolean isExist = false;
			for (int j = 0; j < numCount; j++) {
				if (randList[j] == randNum) {
					isExist = true;
					break;
				}
			}
			if (isExist) {
				i--; // System.out.println("hi");
			} else {
				randList[i] = randNum;
				numCount++;
			}
		}

		// 내림차순
		Integer[] a = Arrays.stream(randList).boxed().toArray(Integer[]::new);
		Arrays.sort(a, Collections.reverseOrder());
		// 오름차순
		Arrays.sort(a);

		System.out.println(Arrays.toString(randList));
	}

}
