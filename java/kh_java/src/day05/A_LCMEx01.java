package day05;

public class A_LCMEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 두 수의 최소 공배수를 구하는 코드를 작성하라
		int num1 = 30000, num2 = 111;

		int lcm;
//		int i = num1 > num2 ? num1 : num2;
//		while (true) {
//			if (i % num1 == 0 && i % num2 == 0) {
//				lcm = i;
//				break;
//			}
//			i++;
//		}

		int i = num1 > num2 ? num1 : num2;
		while (true) {
			if (i % num1 == 0 && i % num2 == 0) {
				lcm = i;
				break;
			}
			i += num1 > num2 ? num1 : num2;
		}

		// System.out.println(num1 + "과 " + num2 + "의 최소공배수는 " + lcm + "입니다.");
		System.out.printf("<%d,%d>의 최소공배수는 \"%d\"입니다.\n", num1, num2, lcm);
	}

}
