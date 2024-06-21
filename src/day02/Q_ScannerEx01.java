package day02;

import java.util.Scanner;

public class Q_ScannerEx01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
//		System.out.print("정수를 입력하세요. (Input Integer) : ");
//		int num= scan.nextInt();
//		System.out.println(num);
//		
//		System.out.print("실수를 입력하세요. (Input DoubleInteger) : ");
//		double num2 = scan.nextDouble();
//		System.out.println(num2);
		
		// 공백전까지 문자열(한 단어)만 가져온다.
		System.out.print("문자를 입력하세요. (Input Word) : ");
		String str1 = scan.next();
		System.out.println(str1);
		
		scan.nextLine();
		
		System.out.print("문자열을 입력하세요. (Input String) : ");
		String str2 = scan.nextLine();
		System.out.println(str2);
		
		System.out.print("문자를 입력하세요. (Input Char) : ");
		char ch1 = scan.next().charAt(0);
		System.out.println(ch1);
	}

}
