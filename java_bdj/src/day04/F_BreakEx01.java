package day04;

import java.util.Scanner;

public class F_BreakEx01 {

	public static void main(String[] args) {

		int num1 = 12, num2 = 8;

		int i = num1;
		int gcd;

		while (true) {
			
			if (num1 % i == 0 && num2 % i == 0) {
				gcd = i;
				System.out.println(gcd);
				break;
			}
			i--;
		}

	}

}
