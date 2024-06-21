//package day05;
//
//import java.util.Scanner;
//
//public class I_ArrayEx05 {
//
//	// rand 함수 틀
//	public static int randGen(int min, int max) {
//
//		return (int) (Math.random() * (max - min + 1) + min);
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		// 1~10 사이 3개의 수를 저장하고
//		// 하나의 수를 입력받아 그 수가 배열에 있는 지 검사
//		int min = 1, max = 10;
//		Scanner scan = new Scanner(System.in);
//		int[] num = new int[3];
//		for (int i = 0; i < num.length; i++)
//			num[i] = randGen(min, max);
//
//		int ans;
//		System.out.print("1~10사이의 숫자를 입력하세요 : ");
//		ans = scan.nextInt();
//
//		for (int i = 0; i < num.length; i++) {
//			if (num[i] == ans) {
//				System.out.println("입력한 숫자가 있습니다");
//				break;
//			}
//			if (i == num.length - 1)
//				System.out.println("입력한 숫자가 없습니다");
//		}
//
//		boolean result = false;
//		for (int tmp : num) {
//			if (tmp == ans) {
//				result = true;
//				break;
//			}
//		}
//		if (result)
//			System.out.println("입력한 숫자가 있습니다");
//		else
//			System.out.println("입력한 숫자가 없습니다");
//
//		System.out.print("3개의 숫자 : ");
//		for (int tmp : num)
//			System.out.print(tmp + " ");
//
//		scan.close();
//	}
//
//}

package day05;

import java.util.InputMismatchException;
import java.util.Scanner;


public class I_ArrayEx05 {

	public static int randGen(int min, int max) {

		return (int) (Math.random() * (max - min + 1) + min);
	}

	public static int[] randArray(int min, int max, int len) {
		int[] num = new int[len];
		for (int i = 0; i < num.length; i++)
			num[i] = randGen(min, max);
		return num;
	}

	public static void checkAnswer(int[] num, int ans) {

		boolean result = false;
		for (int tmp : num) {
			if (tmp == ans) {
				result = true;
				break;
			}
		}
		if (result)
			System.out.println("입력한 숫자가 있습니다");
		else
			System.out.println("입력한 숫자가 없습니다");
		System.out.print("[입력값 : " + ans + "] < ");
		for (int tmp : num)
			System.out.print(tmp + " ");
		System.out.println(">");
	}

	public static int inputAnswer(int min, int max) {
		Scanner scan = new Scanner(System.in);
		int ans = 0;
		
		do {
			try {
				System.out.print(min + "~" + max + "사이의 숫자를 입력하세요 : ");
				ans = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("[ERROR] 입력값 체크");
				scan.nextLine();
			}
		} while (ans < 1 || ans > 10);
		scan.close();
		return ans;
	}

	public static void main(String[] args) {

		int min = 1, max = 10;
		int[] num = new int[3];
		
		num = randArray(min, max, num.length);
		int ans = inputAnswer(min, max);

		checkAnswer(num, ans);

	}

}
