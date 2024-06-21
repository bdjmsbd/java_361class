package myutils;

public class MyMath {
	
	// mod 수식만 보고 의미파악 힘드니 함수를 만들어서 이해하기 쉽게 해주기
	public static boolean isDivisor(long num1, long num2) {
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
//	public static long lcmCal(int num1, int num2) {
//		int sNum = (num1 > num2) ? num2 : num1;
//		int bNum = (num1 > num2) ? num1 : num2;
//		for (long i = bNum;; i += bNum) {
//			if (isDivisor(i, sNum))
//				return i;
//		}
//	}

	// 최소공배수 => 두 수의 곱 / 최대 공약수와 같다.
	public static long lcmCal(int num1, int num2) {
		return (long)num1 * num2 / gcdCal(num1, num2);
	}

	// 소수 판별
	public static boolean isPrime(int num) {

		if (num < 2)
			return false;
		for (int i = 2; i*i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	public static int randGen(int min, int max) {

		return (int) (Math.random() * (max - min + 1) + min);
		// min 10 max 1 => -10 *rand + 10
		// min, max가 바껴도 상관이 없다!
	}

	// rand num 생성기, 중복제외 처리
	public static int[] numGen(int min, int max, int[] randList) {

		int numCount = 0;

		int randNum;
		for (int i = 0; i < randList.length; i++) {
			randNum = randGen(min, max);
			boolean isExist = false;
			for (int j = 0; j < numCount; j++) {
				if (randList[j] == randNum) {
					isExist = true;
					break;
				}
			}
			if (isExist) {
				i--;
			} else {
				randList[i] = randNum;
				numCount++;
			}
		}
		return randList;
	}
}
