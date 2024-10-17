package day08;

public class C_MethodEx01___ {

	public static boolean isPrime(int num) {

		if (num < 2)
			return false;
		for (int i = 2; i*i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	public static boolean isPrime2(int num) {

		if (num < 2)
			return false;
		for (int i = 2; i*i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {

		// 주어진 정수 num가 소수인지 아닌지 확인하는 method 작성
		int num = 51;

		System.out.println(num + "은 " + (isPrime(num) ? "소수이다" : "소수가 아니다"));

		//int numList [] = new int[100];
		for(int i =1; i<100; i++) {
			//System.out.println(i+1 + "은 " + (isPrime(i+1) ? "소수이다" : "소수가 아니다"));
			System.out.printf(isPrime(i+1) ?i+1 + " ":"");
		}
	}
}
