package myutils;

public class utils {
	
	public static void typePrint(Object obj) {
		// instanceof 을 이용한 자료형 확인예제
		// Object obj = field.get(clazz); 
		// 임의의 객체를 Object형으로 가져옵니다.

		// instanceof를 이용한 비교
		if (obj instanceof Integer) { 
		    System.out.println("숫자형입니다.");
		} else if (obj instanceof String) {
		    System.out.println("문자열입니다.");
		} else if (obj instanceof String[]) {
		    System.out.println("문자열 배열입니다.");
		}
	}
	
	// swap 사용 예제 .
	// b = swap(a, a=b);  a=b값을 넘겨주면서 b는 함수 호출로 a 대입
	public static <T> T swap(T a, T b) {
		return a;
	}
	
//	public static <T> T sum(T a, T b) {
//		return (a + b);
//	}
}
