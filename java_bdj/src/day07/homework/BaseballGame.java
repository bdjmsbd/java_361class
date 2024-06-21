package day07.homework;

//import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseballGame {

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

//		 숫자야구 게임 - 중복되지 않은 1~9사이의 랜덤한 수를 생성 
//		 - 이 세 수를 맞추는 게임 
//		 - 스트라이크 : 해당 숫자가 있고, 위치도 같은 경우 
//		 - 볼 : 숫자는 있지만 위치가 다른 경우 
//		 - 아웃 : 일치하는 숫자가 하나도 없는 경우 
//		 (3 9 7) 
//		 입력 : 1 2 3 
//		 1B	  
//		 입력 : 5 6 7 
//		 1S 
//		 입력 : 4 5 6 
//		 Out 
//		 입력 : 3 7 9 
//		 1S2B 
//		 입력 : 3 9 7 
//		 3S 
//		 정답입니다.

		Scanner scan = new Scanner(System.in);

		int min = 1, max = 9;
		int[] randList = new int[3];
		int[] myNumList = new int[3];
		int sc, bc;
		randList = numGen(min, max, randList);
//		System.out.println(Arrays.toString(randList));

		do {
			sc = bc = 0;
			System.out.print("입력 : ");
			try {
				for (int i = 0; i < myNumList.length; i++) {
					myNumList[i] = scan.nextInt();
					if(myNumList[i]<1 || 9<myNumList[i]) {
						System.out.printf("[ERROR] 1~9 사이 숫자 3개 입력 (예: 3 2 1) : ");
						scan.nextLine();
						i=-1;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("[Error] 숫자 제대로 입력!");
				scan.nextLine();
				continue;
			}
			for (int i = 0; i < randList.length; i++) {
				for (int j = 0; j < randList.length; j++) {
					if (myNumList[i] == randList[j])
						if (i == j)
							sc++;
						else
							bc++;
				}
			}
			if (sc == 3) {
				System.out.println("3S\n정답입니다.");
				break;
			} else if (sc == 0 && bc == 0) {
				System.out.println("Out");
			} else
				System.out.println((sc != 0 ? sc + "S" : "") + ((bc != 0) ? bc + "B" : ""));

		} while (true);

		scan.close();

	}

}
