package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/120876
// 선분이 주어졌을 때 겹치는 부분의 길이 출력 중복x

public class overlappingLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// a a'
		// b b'
		// c c'
		// solution(int[][] lines)
		// int[0][0] first, int[0][1] end

		// 1. a, b 비교
		// 2. b의 first가 a - a'있는 지
		// 3. 있다면 b'는 a'보다 큰 지 작은 지
		// 4. a, c 마찬가지로 비교
		// 5. 마찬가지 b, a 비교
		// 6. b, c -> c, a -> c b 모두 비교
		
		int[][] lines = new int[3][2];
		lines[0][0] = 0;
		lines[0][1] = 1;
		lines[1][0] = 2;
		lines[1][1] = 5;
		lines[2][0] = 3;
		lines[2][1] = 9;

		int answer = 0;

		int a[] = new int[200];
		for (int i = 0; i < lines.length; i++) {
			for (int j = lines[i][0]; j < lines[i][1]; j++) {
				a[j + 100]++;
			}
		}
		for (int i = 0; i < a.length; i++)
			if (a[i] > 1)
				answer++;

//		for(int i=0; i<lines.length; i++) {
//			for(int j=0; j<lines.length; j++) {
//				if(i==j) continue;
//				if(lines[i][0] < lines[j][0] && lines[i][1] > lines[j][0]) {
//					if(lines[i][1] > lines[j][1])
//						answer += lines[j][1] - lines[j][0];
//					else if(lines[i][1] < lines[j][1])
//						answer += lines[i][1] - lines[j][0];
//				}
//			}
//		}

		System.out.println(answer);
	}

}
