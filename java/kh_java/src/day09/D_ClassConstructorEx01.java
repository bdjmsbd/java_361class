package day09;

import java.util.Scanner;

public class D_ClassConstructorEx01 {

	public static void main(String[] args) {


		//Scanner scan2 = new Scanner(System.in);
		Scanner scan2 = new Scanner("abc\n123\n1.23");
		String str = scan2.next();
		int num = scan2.nextInt();
		double num2 = scan2.nextDouble();
		System.out.println(str);
		System.out.println(num);
		System.out.println(num2);
		
		scan2.close();
		
		
		
	}

}

