package day04;

public class I_NestedForEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		for(int i=1; i<=9; i++) {
//			for(int j=2; j<=9; j++) {
//				System.out.printf(" %d * %d = %2d",j,i,i*j);
//			}
//			System.out.println();

		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf(" %d * %d = %2d", i, j, i * j);
			}
			System.out.println();

		}

	}

}
