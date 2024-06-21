package day03;

import java.util.Scanner;

public class D2_IfExam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int num;
		System.out.print("정수 입력 : ");
		num = scan.nextInt();

//		if(num == 0)
//			System.out.println("2,3,6의 배수입니다.");
//		else 
		if (num % 6 == 0)
			System.out.println("6의 배수입니다.");
		else if (num % 2 == 0)
			System.out.println("2의 배수입니다.");
		else if (num % 3 == 0)
			System.out.println("3의 배수입니다.");
		else
			System.out.println("2,3,6의 배수가 아닙니다.");

		if (num % 2 == 0 && num % 3 != 0)
			System.out.println("2의 배수입니다.");
		else if (num % 3 == 0 && num % 2 != 0)
			System.out.println("3의 배수입니다.");
		else if (num % 6 == 0)
			System.out.println("6의 배수입니다.");
		else
			System.out.println("2,3,6의 배수가 아닙니다.");

		scan.close();

	}

}
