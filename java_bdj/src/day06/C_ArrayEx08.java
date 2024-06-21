package day06;

import java.util.Arrays;
import java.util.Scanner;

public class C_ArrayEx08 {

	public static void main(String[] args) {
		// 문자열을 최대 5개 저장할 수 있는 배열을 선언하고
		// 문자열을 5개 입력하여 저장 한 후, 문자열을 출력
		
		Scanner scan = new Scanner(System.in);

		String[] strList = new String[5];
		for (int i = 0; i < strList.length; i++) {
			System.out.println(i + 1 + "번째 문자열 입력 : ");
			strList[i] = scan.nextLine();
		}
		for (String tmp : strList) {
			System.out.println(tmp);
		}
		System.out.println(Arrays.toString(strList));
		
		scan.close();
	}

}
