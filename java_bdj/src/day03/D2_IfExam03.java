package day03;

//import java.util.InputMismatchException;
import java.util.Scanner;

public class D2_IfExam03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int num1, num2, res = 0;
		char oper;
		boolean isCorrect = true;

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
			res = num1 / num2;
		else if (oper == '%')
			res = num1 % num2;
		else
			isCorrect = false;
		
		if (isCorrect)
			System.out.println(num1 + " " + oper + " " + num2 + " = " + res);
		else
			System.out.println(oper + "는 잘못된 연산자입니다");
		
		scan.close();
	}

}

//while (true) {
//	try {
//		System.out.printf("두 정수와 산술 연산자를 입력하세요(예 : 1 + 2) : ");
//		num1 = scan.nextInt();
//		oper = scan.next().charAt(0);
//		num2 = scan.nextInt();
//		
//		res = (oper == '+') ? num1 + num2
//				: (oper == '-') ? num1 - num2 
//				: (oper == '*') ? num1 * num2 
//				: (oper == '/') ? num1 / num2 : 0;
//		
//		break;
//	} catch (InputMismatchException e) {
//		System.out.println("[ERROR] 다시 입력하세요.");
//		scan.nextLine();
//	}
//}
