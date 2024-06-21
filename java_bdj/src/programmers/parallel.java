package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/120875
//각각 두 점을 직선으로 이었을 때 평행 한 지 확인하는 문제
//점은 중복될 수 없다는 것이 포인트
public class parallel {

	public static int solution() {
		int X = 0, Y = 1;
		int[][] dots = new int[4][2];
		dots[0][X] = 3;
		dots[0][Y] = 5;
		dots[1][X] = 4;
		dots[1][Y] = 1;
		dots[2][X] = 2;
		dots[2][Y] = 4;
		dots[3][X] = 5;
		dots[3][Y] = 10;
		int answer = 0;
		// 0  1  2  3  4  5
		// 12 13 14 23 24 34
		// 0,5 1,4 2,3 => 항상 합이 5
		double[] a = new double[6];
		int c = 0;
		for (int i = 0; i < dots.length - 1; i++) {
			for (int j = i + 1; j < dots.length; j++) {
				a[c] = (dots[j][Y] - dots[i][Y]) / (double)(dots[j][X] - dots[i][X]);
				c++;
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if(a[i]==a[j] && i+j==5) return answer=1;
			}

		}
		return answer;

	}

	public static void main(String[] args) {
		System.out.println(solution());
		//

	}

}
