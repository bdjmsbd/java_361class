package day15;

import java.util.ArrayList;
import java.util.Iterator;

public class A_ListEx02 {

	public static void main(String[] args) {
		// Iterator

		ArrayList<String> list = new ArrayList<String>();

		list.add("hi");
		list.add("apple");
		list.add("banana");
		for (String str : list) {
			System.out.print(str + " ");
		}
		System.out.println();

		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();

		for (int i = 0; i < list.size(); i++) {
			String tmp = list.get(i);
			System.out.print(tmp + " ");
		}

	}

}
