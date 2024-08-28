package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 이중우선순위큐 {

	public static int[] solution(String[] operations) {

		List<Integer> list = new ArrayList<Integer>();

		for (String tmp : operations) {
			String[] t = tmp.split(" ");
			String oper = t[0];
			Integer num = Integer.parseInt(t[1]);

			if (oper.equals("I")) {
				list.add(num);
			}
			if (oper.equals("D")) {
				if (list.size() == 0) {
					continue;
				}
				if (num == 1) {
					Collections.sort(list);
					list.remove(list.size()-1);
				} else if (num == -1) {
					Collections.sort(list);
					list.remove(0);
				}
			}
		}
		Collections.sort(list);
		if (list.size() == 0) {
			return new int[] { 0, 0 };
		} else {
			return new int[] { list.get(list.size() - 1), list.get(0) };
		}

	}

	public static void main(String[] args) {

		String[] list = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
		solution(list);
	}

}
