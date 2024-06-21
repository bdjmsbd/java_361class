package day03;

import java.util.Scanner;

public class C_IfExam01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.printf("나이릅 입력하세요 : ");
		int age = scan.nextInt();
		
		if(age>=19)
			System.out.println("성인");
		else
			System.out.println("미성년자");

		scan.close();
	}

}
