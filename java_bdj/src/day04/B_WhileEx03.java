package day04;

public class B_WhileEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 2;

		// timesTable(num);

		int count = 0;
		while (count++ < 9)
			// System.out.println(num + " * " + count + " = " + num * count);
			System.out.printf("%d * %d = %2d\n", num, count, num * count);

	}

}

//public static void timesTable(int num) {
//
//int count = 0;
//
//while (count++ < 9)
//	System.out.println(num + " * " + count + " = " + num * count);
//
//}
