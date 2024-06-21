package day07;

import java.util.Arrays;
import java.util.Scanner;

public class A_ScannerEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// scanner의 next와 nextline의 차이

		/*
		 * next는 메모리의 공백(엔터 등)을 버리고 뒤에 값을 가져옴 없으면 입력받음 => 마지막 엔터를 메모리에 남겨둠 nextLine은
		 * 공백까지 모두 가져와서 마지막 공백을 버리고 출력 없으면 입력받음 => 싹 가져와서 마지막 엔터만 제외하고 저장
		 */

		Scanner scan = new Scanner(System.in);

//		String str1, str2;
//		String str11, str22;
//
//		System.out.println("문자열 입력 next : ");
//		str1 = scan.next();
//		System.out.println("문자열 입력 next : ");
//		str11 = scan.next();
//		System.out.println("문자열 입력 nextline : ");
//		str2 = scan.nextLine();
//
//		System.out.println("문자열 출력 next : " + str1 + ", nextline : " + str2);

		int a[] = { 1, 2, 3, 4, 5 };
		int b[] = { 1, 2, 3, 4, 5 };
		if (Arrays.toString(a).equals(Arrays.toString(b)))
			System.out.println(Arrays.toString(a));

		scan.close();
	}

}
