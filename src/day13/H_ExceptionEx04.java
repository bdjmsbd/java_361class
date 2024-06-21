package day13;

public class H_ExceptionEx04 {

	public static void main(String[] args) {
		// throw
		// 예외를 발생시키고 미룸
		int[] arr = null;
		try {
			printArray(arr);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void printArray(int[] arr) {
		if (arr == null) {
			throw new NullPointerException("배열이 생성되지 않았습니다");
		}
		for (int tmp : arr) {
			System.out.println(tmp);
		}
	}

}
