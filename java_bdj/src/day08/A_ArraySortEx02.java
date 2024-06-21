package day08;

import java.util.Arrays;

public class A_ArraySortEx02 {

	public static void main(String[] args) {

		// 문자열도 과연 버블버블~ 0,1? 1,2? 2,3? 3,4? .. 젤 큰거 맨뒤로
		// 선택정렬은? 0,1? 0,2? 0,3? 0,4? ... 젤 작은거 맨 앞으로
		
		String [] arr = new String[] {"정", "국", "fdc", "ac", "oh", "banana", "ao","dc"};
//		Arrays.toString(arr);
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				//문자열.compareTo(문자열2) abcd ab => 2 2자리 차이, ab c => -2 아스키 값 반환
				if(arr[j].compareTo(arr[j+1]) > 0) {
					String tmp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
//					System.out.println(Arrays.toString(arr));
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}


}
