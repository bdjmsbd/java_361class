package day09;

public class A_VariableArgumentEx01 {

	public static void main(String[] args) {
		// 가변 매개 변수들을 이용하여
		// 정수들의 합을 구하는 예제
		
		System.out.println(sum(1,2,3,4,5));

	}

	// 안에서 배열처럼 사용된다
	// 향포
	public static int sum(int... nums) {
		if (nums == null)
			return 0;
		int sum = 0;
		for (int tmp : nums) {
			sum += tmp;
		}
		return sum;
	}
	
}
