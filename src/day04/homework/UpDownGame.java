package day04.homework;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 100, min = 1;
		int randNum = (int)(Math.random() * (max - min+1)) + min;
//		int randNum = (int)(0.995 * (max - min+1)) + min;
//		int randNum2 = (int)(0.001 * (max - min+1)) + min;
		// System.out.println("랜덤한 수 : " + randNum);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println(min + " ~ " + max + " 사이");
		
		int num;
//		while(true) {
//			System.out.print("정수 입력 : ");
//			num = scan.nextInt();
//			if(num == randNum) {
//				System.out.println("정답입니다.");
//				break;
//				}
//			else if(num>randNum)
//				System.out.println("DOWN!");
//			else if(num<randNum)
//				System.out.println("UP!");
//		}
		
		do {
			System.out.print("정수 입력 : ");
			num = scan.nextInt();
			if(num == randNum) {
				System.out.println("정답입니다.");
				break;
				}
			else if(num>randNum)
				System.out.println("DOWN!");
			else if(num<randNum)
				System.out.println("UP!");
		}while(num!=randNum);
		
		scan.close();
	}

}
