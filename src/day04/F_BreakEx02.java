package day04;

import java.util.Scanner;

public class F_BreakEx02 {

	public static void main(String[] args) {
		
		char ch;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("문자입력 : ");
			ch = scan.next().charAt(0);
			if(ch == 'y')
				break;
		}
		
		scan.close();
	}

}
