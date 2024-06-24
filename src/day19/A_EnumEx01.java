package day19;

import java.util.Scanner;

public class A_EnumEx01 {

	public static void print(Season s) {
		System.out.println(s);
		switch (s) {
			case SPRING:
				break;
			case SUMMER:
				break;
			case FALL:
				break;
			case WINTER:
				break;
		}
	}

	public static void main(String[] args) {
		// 열거형 :상수 데이터들의 집합.
		// enum 열거형명 {
		// 값1,
		// 값2,
		// ...
		// }
		Scanner sc = new Scanner(System.in);
		Season a = Season.SPRING;
		System.out.println(a.ordinal());

		System.out.print("계절을 입력하세요 : ");
		String season = sc.next();

		Season b = Season.valueOf(season);

		print(b);

		System.out.print("계절을 입력하세요 (봄:1 여름:2 가을:3 겨울:4) : ");
		int num = sc.nextInt();
		b = null;
		for (Season tmp : Season.values()) {
			if (num == tmp.ordinal() + 1) {
				b = tmp;
			}
		}

		print(b);
	}

}

enum Season {
	SPRING,
	SUMMER,
	FALL,
	WINTER
}
