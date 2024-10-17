package day06;

public class A_ArrayEx02 {

	public static void main(String[] args) {

		// 구구단 2단의 결가괎인 2,4,6,8,....,18을 배열에 저장하고

		int[] arr = new int[9];
		int num = 2;

		for (int i = 1; i <= 9; i++) {
			arr[i - 1] = num * i;
		}
		for (int i = 1; i <= 9; i++)
			System.out.printf("%d * %d = %2d\n", num, i, arr[i - 1]);

		// 0번째 버리고 코드 간결하게
		int[] arr2 = new int[10];
		for (int i = 1; i <= 9; i++) {
			arr2[i] = num * i;
		}
		for (int i = 1; i <= 9; i++)
			System.out.printf("%d * %d = %2d\n", num, i, arr2[i]);

	}

}
