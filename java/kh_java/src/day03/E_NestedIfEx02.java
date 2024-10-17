package day03;

import java.util.Scanner;

public class E_NestedIfEx02 {

	static boolean ERROR_NOT = true;
	static boolean ERROR_ZERO_DENOMINATOR = false;
	static boolean ERROR_INVALID_OPERATOR = false;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int num1, num2, res = 0;
		char oper;
		boolean isError = ERROR_NOT;

		System.out.print("두 정수와 산술 연산자를 입력하세요(예 : 1 + 2) : ");
		num1 = scan.nextInt();
		oper = scan.next().charAt(0);
		num2 = scan.nextInt();

		if (oper == '+')
			res = num1 + num2;
		else if (oper == '-')
			res = num1 - num2;
		else if (oper == '*')
			res = num1 * num2;
		else if (oper == '/')
			if (num2 == 0) {
				System.out.println("0은 분모가 될 수 없습니다.");
				isError = ERROR_ZERO_DENOMINATOR;
			} else
				res = num1 / num2;
		else if (oper == '%')
			if (num2 == 0) {
				System.out.println("0은 분모가 될 수 없습니다.");
				isError = ERROR_ZERO_DENOMINATOR;
			} else
				res = num1 % num2;
		else {
			isError = ERROR_INVALID_OPERATOR;
			System.out.println(oper + "는 잘못된 연산입니다");
		}

		if (isError)
			System.out.println(num1 + " " + oper + " " + num2 + " = " + res);

		scan.close();
	}

}
