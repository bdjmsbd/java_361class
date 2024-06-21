package day05;

public class B_StarEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 00 - - - - * 01 - - - * *
		 */

//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++)
//				if ((4-i) <= j)
//					System.out.print("*");
//				else
//					System.out.print(" ");
//			System.out.println();
//		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (4 - i); j++)
				System.out.print(" ");
			for (int j = 0; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
	}

}
