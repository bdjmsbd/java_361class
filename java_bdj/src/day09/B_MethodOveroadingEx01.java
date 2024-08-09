package day09;

public class B_MethodOveroadingEx01 {

	public static void main(String[] args) {
		// 메소드 오버로딩,

		System.out.println(sum("a", "b", "c", "def"));
		System.out.println(sum('a', 'b', 'c', 'd'));
		System.out.println(sum(1, 3, 4, 5, 6));

	}

	// 매개변수의 갯수나 타입이 다르면 같은 이름으로도 함수 선언 가능
	// 변수의 리턴 타입이랑은 상관이 없음
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}

	public static int sum(int... nums) {
		if (nums == null)
			return 0;
		int sum = 0;
		for (int tmp : nums) {
			sum += tmp;
		}
		return sum;
	}

	public static String sum(char... nums) {
		if (nums == null)
			return null;
		String str = "";
		for (char tmp : nums) {
			str += tmp;
		}
		return str;
	}

	public static String sum(String... strs) {
		if (strs == null)
			return null;
		String str = "";
		for (String tmp : strs) {
			str += tmp;
		}
		return str;
	}

}
