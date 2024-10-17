package day22;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Ex01 {

	public static void main(String[] args) {

		// 콘솔에서 한 문장을(영어) 입력 받아 한 문장에 몇개의 단어로 구성되어 있는 지 확인하는 프로그램
		Scanner sc = new Scanner(System.in);
		System.out.print("문장 입력 : ");
		String str = sc.nextLine();

		List<String> list = Arrays.asList(str.split(" "));
		System.out.println("단어의 갯수" + list.size());

		sc.close();
	}

}
