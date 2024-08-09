package day04;

import java.util.Scanner;

public class G_ForEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		for(int i =1; i<=5; i++)
//			System.out.println("Hello world");
		
//		int num = 2;
//		for(int i=1; i<=9; i++)
//			System.out.printf("%d * %d = %2d\n",num,i,num*i);
//			//System.out.println(num+ " * "+ i + " = " + num*i);
		
		Scanner scan = new Scanner(System.in);
//		char ch;
//		for(;;) {
//			System.out.print("y를 입력하세요 : ");
//			ch = scan.next().charAt(0);
//			if(ch == 'y')
//				break;
//		}
		
		for(char ch=' '; ch != 'y';ch = scan.next().charAt(0)) {
			System.out.print(" y를 입력하세요 : ");
		}
		
		scan.close();
			
	}

}
