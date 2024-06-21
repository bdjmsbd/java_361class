package day08;

public class C_MethodEx02___ {

	// mod 수식만 보고 의미파악 힘드니 함수를 만들어서 이해하기 쉽게 해주기
	public static boolean isDivisor(long num1, long num2) {
		return num1 % num2 == 0;
	}
	
	public static boolean isDivisor(int num1, long num2) {
		return num1 % num2 == 0;
	}

	// 최대공약수
	// 두 수 중 작은 수의 값을 줄여가며 두 수 모두에 약수가 있는 지 확인
	// 마지막은 결국 1
	public static int gcdCal(int num1, int num2) {
		int sNum = (num1 > num2) ? num2 : num1;
		for (int i = sNum;; i--) {
			if (isDivisor(num1, i) && isDivisor(num2, i))
				return i;
		}
	}

	// 최소공배수
	// 두 수중 큰 수의 배수를 탐색하여 작은 수의 배수가 있는 지 확인
	// 공배수는 타입을 int보단 long으로 하는 것이 적절하다.
	public static long lcmCal(int num1, int num2) {
		int sNum = (num1 > num2) ? num2 : num1;
		int bNum = (num1 > num2) ? num1 : num2;
		for (long i = bNum;; i += bNum) {
			if (isDivisor(i, sNum))
				return i;
		}
	}

	// 최소공배수 => 두 수의 곱 / 최대 공약수와 같다.
	public static long lcmCal2(int num1, int num2) {
		return (long)num1 * num2 / gcdCal(num1, num2);
	}

	public static void main(String[] args) {
		// 두 수의 최대 공약수와 최소 공배수를 구하는 코드를 작성하세요.
		int num1 = 1111111114, num2 = 1888888888;
		String s = "<" + num1 + "," + num2 + ">";
		System.out.println(s + " 최대공약수는 : " + gcdCal(num1, num2));
		System.out.println(s + " 최소공배수는 : " + lcmCal(num1, num2));
		System.out.println(s + " 최소공배수는 : " + lcmCal2(num1, num2));

		int i = 1111111114;
		int j = 1888888888;
		long k = (long) i * j;
		System.out.println(i * j);
		System.out.println(k);
	}
}
