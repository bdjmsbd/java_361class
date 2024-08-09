package day19;

import java.util.Scanner;

public class A_EnumEx02 {

	public static void print(Season2 s) {
		
//		System.out.println(s);
		
		switch (s) {
			case SPRING:
				System.out.println("봄");
				break;
			case SUMMER:
				System.out.println("여름");
				break;
			case FALL:
				System.out.println("가을");
				break;
			case WINTER:
				
				System.out.println("겨울");
				break;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("계절을 입력하세요 (봄:1 여름:2 가을:3 겨울:4) : ");
		int num = sc.nextInt();
		Season2 s = Season2.fromValue(num);

		print(s);
	}

}

enum Season2 {

	SPRING(1),
	SUMMER(2),
	FALL(3),
	WINTER(4);

	private final int value;

	private Season2(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	// 열거형 객체 선택
	public static Season2 fromValue(int value) {
		for (Season2 tmp : Season2.values()) {
			if (tmp.getValue() == value) {
				return tmp;
			}
		}
		throw new IllegalArgumentException("잘못된 계절입니다.");
//		return null;
	}

}
