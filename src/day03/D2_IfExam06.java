package day03;

import java.util.Scanner;

public class D2_IfExam06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("성적을 입력하세요 : ");
		int num = scan.nextInt();
		
		if(num<0 || num > 100)
			System.out.println("잘못된 성적입니다.");
		else if(num>=90)
			System.out.println("A");
		else if(num>=80)
			System.out.println("B");
		else if(num>=70)
			System.out.println("C");
		else if(num>=60)
			System.out.println("D");
		else // if(num<60)
			System.out.println("F");
		
		scan.close();
	}

}
