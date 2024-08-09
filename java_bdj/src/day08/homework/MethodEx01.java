package day08.homework;

import java.util.Scanner;

public class MethodEx01 {

	public static int[] createArray(int size) {
		if(size<0)
			return null;
		return new int[size];
	}

	public static int inputNum() {
		Scanner scan = new Scanner(System.in);
		int num;
		System.out.print("크기 입력 : ");
		num = scan.nextInt();
		scan.close();
		return num;
	}
	
	public static void main(String[] args) {
		// 정수 n을 입력받아 n 크기를 갖는 배열을 생성하는 코드 작성.
		
		int num = inputNum();
		int numList[] = createArray(num);
		
		System.out.print("배열 크기 : " + numList.length);
		
	}

}
