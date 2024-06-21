package day06;

public class B_ArraySortEx01 {

	public static void main(String[] args) {
		// 정렬
		int[] arr = new int[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		for (int tmp : arr)
			System.out.print(tmp + " ");
	}

}
