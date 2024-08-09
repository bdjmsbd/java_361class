package day12;

public class C_FinalEx01 {

	public static void main(String[] args) {

		// final 변수는 상수로 값을 최초 한번만 할당할 수 있다.
		// 여러번 할당이 불가능하다. 클래스에서도 동일 상속 마찬가지
		// 클래스가 final일 경우 상속도 불가능
		String a = new String();
		final int num;
		num = 20;
//		num = 30;
		final int nu[] = new int[5];
		nu[0] = 30;
		nu[0] = 40;

		final int nu2[] = new int[5];
//		nu = nu2;

	}

}

class Parent1 {
	public final void print() {
		System.out.println("파이널 메소드 입니다.");
	}
}

class Child1 extends Parent1 {

//	@Override
//	public final void print() {
//		System.out.println("메소드 수정이 불가능");
//	}
}

final class Parent2 {

}

//class Child2 extends Parent2 {
//	// final 클래스는 상속 받을 수 없다.
//}
