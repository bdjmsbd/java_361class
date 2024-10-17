package day05;

public class G_ArrayCoptEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열을 다른 배열에 복사하기

		int[] arr1 = new int[] { 5, 4, 3, 2, 1 };
		int[] arr2 = new int[arr1.length];

		for (int i = 0; i < arr1.length; i++)
			arr2[4 - i] = arr1[i];

		for (int i = 0; i < arr2.length; i++)
			System.out.print(arr2[i] + " ");

		System.out.println();
		// System.arraycopy
		int[] arr3 = new int[arr1.length + 1];
		System.arraycopy(arr2, 0, arr3, 1, arr2.length);
		for (int i = 0; i < arr3.length; i++)
			System.out.print(arr3[i] + " ");

		System.out.println();

	}

}
