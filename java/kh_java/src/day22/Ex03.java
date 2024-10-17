package day22;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex03 {

	public static void main(String[] args) {
		// list에 숫자들을 저장하고 정렬하는 코드를 작성하세요.
		List<Integer> list = Arrays.asList(1, 3, 355, 67, 7, 2, 23, 4, 545, 6, 166, 21, 3, 595, 6, 7, 9, 0, 19, 213, 12, 5);
		Collections.sort(list, (o1, o2) -> o1 - o2);
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, (o2, o1) -> o1 - o2);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
//		Collections.sort(list, (o1, o2) -> -(o1 - o2));
//		System.out.println(list);
	}

}
