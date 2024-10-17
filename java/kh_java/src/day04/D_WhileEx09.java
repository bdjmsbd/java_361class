package day04;

public class D_WhileEx09 {

	public static void main(String[] args) {

		char a = 'a';

		int count = 0;
		while (count < 26)
			System.out.print((char) ('a' + count++) + " ");

		System.out.println();

		count = 0;
		while (count++ < 26)
			System.out.print(a++ + " ");

	}
}
