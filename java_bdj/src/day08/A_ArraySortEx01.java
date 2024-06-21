package day08;

import java.util.Arrays;

public class A_ArraySortEx01 {

	public static int randGen(int min, int max) {

		return (int) (Math.random() * (max - min + 1) + min);
	}

	public static int[] numGen(int min, int max, int[] randList) {

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
		return randList;
	}

	public static void main(String[] args) {

		// 버블정렬 버블버블~
		// 문자열도 과연 버블버블~

		int min = 1, max = 100;
		int randList[] = new int[10];
		randList = numGen(min, max, randList);
		System.out.println(Arrays.toString(randList));

		for (int i = 0; i < randList.length - 1; i++) {
			for (int j = 0; j < randList.length - 1/*-i*/; j++) {
				if (randList[j] > randList[j + 1]) {
					int tmp = randList[j];
					randList[j] = randList[j + 1];
					randList[j + 1] = tmp;
//					System.out.println(Arrays.toString(randList));
				}
			}
		}
		System.out.println(Arrays.toString(randList));

	}
}
