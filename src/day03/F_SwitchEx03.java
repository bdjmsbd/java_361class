package day03;

import java.util.Scanner;

public class F_SwitchEx03 {

	static boolean ERROR_ZERO_DENOMINATOR = false;
	static boolean ERROR_INVALID_OPERATOR = false;

	public static void operationTool (int num1, int num2, char oper) {
		int res = 0;
		boolean is_Err = true;
		
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num1 - num2;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			if (num2 != 0)
				res = num1 / num2;
			else
				is_Err = ERROR_ZERO_DENOMINATOR;
			break;
		case '%':
			if (num2 != 0)
				res = num1 % num2;
			else
				is_Err = ERROR_ZERO_DENOMINATOR;
			break;
		default:
			is_Err = ERROR_INVALID_OPERATOR;
		}

		if (is_Err)
			System.out.println(num1 + " " + oper + " " + num2 + " = " + res);
		else
			System.out.println("잘못된 연산입니다.");
		
	}

	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int num1, num2;
		char oper;

		System.out.print("두 정수와 산술 연산자를 입력하세요(예 : 1 + 2) : ");
		num1 = scan.nextInt();
		oper = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		operationTool(num1, num2, oper);

		scan.close();

	}

}
