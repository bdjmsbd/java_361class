package my;

import java.util.ArrayList;
import java.util.List;

public class swap_list {

	public static void main(String args[]) {
		// list의 set함수는 return값으로 이전의 객체를 가져옴
		List<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(10);

		System.out.println(list);
		swap(list, 0, 1);
		System.out.println(list);

		System.out.println(list.set(1, list.get(0)));
		System.out.println(list.get(1));
	}

	public static void swap(List<?> list, int i, int j) {
		// instead of using a raw type here, it's possible to capture
		// the wildcard but it will require a call to a supplementary
		// private method
		final List l = list;
		l.set(i, l.set(j, l.get(i)));
	}

}
