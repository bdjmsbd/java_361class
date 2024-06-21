package day06;

import java.util.Arrays;
import java.util.Collections;

public class B_ArraySortEx02 {

	public static void main(String[] args) {
		// 정렬
		int[] arr = new int[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };
		Arrays.sort(arr);
		
//		int a= 6;
//		int b= 5;
//		System.out.println(arr[a=b]);
		
		// 오름차순 => 작은수에서 큰수로
		System.out.println(Arrays.toString(arr));
		for(int tmp : arr)
			System.out.print(tmp + " ");
		System.out.println();
		
		// 내림차순 => 큰수에서 작은수로
		Integer [] arr2 =  { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };
		Arrays.sort(arr2, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr2));
	}

}
