package day22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex02 {

	public static int sumStrInteger(List<String> list) {
		int sum = 0;
		for (String tmp : list) {
			sum += Integer.parseInt(tmp);
			
		}
		return sum;
	}

	public static void main(String[] args) {

		// 정수로 이루어진 문자열에서 각 정수들의 합을 구하는 코드를 작성
		// 15 16 17 181 18 20

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 문자열 입력 : ");
		String str = sc.nextLine();

		List<String> list = Arrays.asList(str.split(" "));

		int sum = sumStrInteger(list);
		System.out.println("합 : " + sum);

//		List<String> list2 = new ArrayList<String>();
//		// collection은 shallow copy만 지원. deep copy는 구현해야됨. 
//		for(int i=0; i<list.size(); i++)
//			list2.add(list.get(i));
//		
//		
//		int sum = 0;list2.add("15");
//		for (String tmp : list2) {
//			sum += Integer.parseInt(tmp);
//		}
//
//		System.out.println("합 : " + sum);

		sc.close();
	}

}
