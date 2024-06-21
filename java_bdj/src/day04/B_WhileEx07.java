package day04;

public class B_WhileEx07 {

	public static boolean isPrime(int N) {
		if (N < 2)
			return false;
		for (int i = 2; i * i <= N; i++) { // (i < 루트 N) 은 (i*i < N) 으로 표현
			if (N / i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		int num = 2;
		int count = 1;
		
		System.out.println(isPrime(num)?"소수이다":"소수가 아니다");
		while (count++ < num) {
			if (count == num) {
				System.out.println("소수");
				break;
			}
			if (num % count == 0) {
				System.out.println("소수가 아니다");
				break;
			}
		}
//
//		count = 0;
//		int i = 0;
//		while (count++ < num) {
//			if (num % count == 0) {
//				i++;
//			}
//		}
//		System.out.println(num + "은 " + ((i == 2) ? "소수이다" : "소수가 아니다"));
	}
}
