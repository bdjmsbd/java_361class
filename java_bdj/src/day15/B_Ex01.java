package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class B_Ex01 {

	public static void main(String[] args) {
		// 전화번호를 5번 입력받아 리스트에 저장하는 코드를 작성하세요.

		Scanner sc = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			System.out.print(i + 1 + "번 전화번호 입력 : ");
			list.add(sc.next());
		}

		System.out.println(list);
		
		System.out.print("삭제할 번호 입력 : ");
		list.remove(sc.next());

		System.out.println(list);
		sc.close();
	}

}
