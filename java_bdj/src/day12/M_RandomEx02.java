package day12;

import java.util.Random;

public class M_RandomEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rd = new Random();

		int min = 1, max = 9;
		int res = (int) (rd.nextDouble() * (max - min + 1) + min);
		int res2 = rd.nextInt(max - min + 1) + min;
		int res3 = (int) (rd.nextDouble(min, max + 1));
		System.out.println("min~max사이의 랜덤한 수를 만드는 코드를 작성하기 : " + res);
		System.out.println("min~max사이의 랜덤한 수를 만드는 코드를 작성하기 : " + res2);
		System.out.println("min~max사이의 랜덤한 수를 만드는 코드를 작성하기 : " + res3);
		// 3 ~ 10
		for (int i = 0; i < 20; i++) {
			int res4 = rd.nextInt(10 - 3 + 1) + 3;
			System.out.print(res4 + " ");
		}

	}

}
