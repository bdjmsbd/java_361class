package day03;

public class E_NestedIfEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 6의 배수를 중첩 if문을 이용하여 작성하는 예제
		int num = 68;

		if (num % 2 == 0)
			if (num % 3 == 0)
				System.out.println("6의 배수입니다.");
			else
				System.out.println("6의 배수가 아닙니다.");
		else
			System.out.println("6의 배수가 아닙니다.");

	}

}
