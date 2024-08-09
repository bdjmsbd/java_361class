package day05;

import java.util.Scanner;

public class I_ArrayEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 3개의 정수를 입력받고 역순 출력
		
		Scanner scan = new Scanner(System.in);
		int [] num = new int[3];
		
//		System.out.printf("3개의 숫자 입력 : ");
//		for(int i=0; i<num.length;i++)
//			num[i] = scan.nextInt();
//		for(int i=0; i<num.length; i++)
//			System.out.print(num[num.length-1-i] + " ");
			
		//int [] num = new int[3];
		
		System.out.printf("3개의 숫자 입력 : ");
		for(int i=num.length-1; i>=0;i--)
			num[i] = scan.nextInt();
		for(int i=0; i<num.length; i++)
			System.out.print(num[i] + " ");
	
		scan.close();
	}

}
