package my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import programmers.parallel;

public class Main {

	public static String[] solution(String[] quiz) {

		List<String> list = Arrays.asList(quiz);
		String[] answer = new String[quiz.length];

		int j = 0;
		for (int i = 0; i < list.size(); i++) {
			List<String> tmp = Arrays.asList(list.get(i).split(" "));
			int a, b;
			char c;
			int e, res;
			a = Integer.parseInt(tmp.get(0));
			b = Integer.parseInt(tmp.get(2));
			c = tmp.get(1).charAt(0);
			e = Integer.parseInt(tmp.get(4));
			if (c == '+')
				res = a + b;
			else
				res = a - b;
			if (e == res)
				answer[j++] = "O";
			else
				answer[j++] = "X";
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] answer = { "3 - 4 = -3", "5 + 6 = 11" };
		answer = solution(answer);
		System.out.println(Arrays.toString(answer));

	}

}
