package day06;

import java.util.Scanner;

public class A_ArrayEx04 {

	public static void main(String[] args) {

		// 4자리 정수를 입력받아서 입력받은 정수를 역순으로 배열에 저장하고 출력

		int arr[] = new int[4];
		Scanner scan = new Scanner(System.in);
		int num;

		do {
			System.out.print("4자리의 정수를 입력하세요 : ");
			num = scan.nextInt();

		} while ((num / 1000) < 1 || (num / 1000) >= 10);
		int cpdNum = num;
		
		for (int i = 0; i < 4; i++) {
			arr[i] = cpdNum % 10; // => 1234 , 4
			cpdNum /= 10; // => 123
		}
//		arr[0]= num%10;
//		arr[1]= (num / 10)%10;
//		arr[2]= ((num / 10)/10)%10;
//		arr[3]= (((num / 10)/10)/10)%10;

		for (int tmp : arr)
			System.out.print(tmp + " ");

		scan.close();
	}

}
