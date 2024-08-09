package day06;

public class A_ArrayEx01 {

	public static void main(String[] args) {
		// 배열 선언 방법에 따른 차이점.
		int[] arr1, arr2;
		int arr3[], arr4;
		
		arr1 = new int[3];
		arr2 = new int[3];
		arr3 = new int[3];
		arr4 = 3;

		// 배열은 생성시 초기화가 되는 지
		
		int num1;

		//System.out.println(num1);
		num1 = 3;
		System.out.println(num1);
		
		int [] arr = new int[3];
		for(int tmpArray : arr)
			System.out.print(tmpArray+ " ");
		
		//arr[3] = 20;
	}

}
