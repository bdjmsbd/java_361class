package programmers;

public class 정수삼각형 {

	public static int solution(int[][] list) {

		int answer = 0;
		System.out.println(list.length);

		for (int i = 1; i < list.length; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j == 0) {
					list[i][j] += list[i - 1][j];
					continue;
				}
				if (j == i) {
					list[i][j] += list[i - 1][j - 1];
					continue;
				} else {
					if (list[i - 1][j - 1] > list[i - 1][j]) {
						list[i][j] += list[i - 1][j - 1];
					} else {
						list[i][j] += list[i - 1][j];
					}
				}
			}
		}
		for (int i = 0; i < list.length; i++) {
			if (list[list.length - 1][i] > answer) {
				answer = list[list.length - 1][i];
			}
		}

		return answer;
	}

	public static void main(String[] args) {

		int[][] num = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		solution(num);

	}

}
