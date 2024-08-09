package day19;

import java.text.Format;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class B_Ex02 {

	public static void main(String[] args) {

		// 주민등록번호를 입력받아 생일을 출력하는 예제

		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호 입력하세요 : ");
		// 871203-1005232
		String regNum = sc.next();

		boolean res = checkNum(regNum);
		if (res) {
			String month, day, year, gen;

			month = regNum.substring(2, 4);
			day = regNum.substring(4, 6);
			gen = regNum.substring(7, 8);
			if (gen.equals("1") || gen.equals("2")) {
				year = "19" + regNum.substring(0, 2);
			} else {
				year = "20" + regNum.substring(0, 2);
			}
			System.out.println(
					"생년월일 : " + year + "-" + month + "-" + day);
		} else {
			System.out.println("잘못된 주민번호");
		}

	}

	private static boolean checkNum(String regNum) {
//		String regex = "^[\\d]{6}-[\\d]{7}$";
		String regex = "^[\\d]{2}(1[0-2]{1}|0[1-9]{1}){1}(0[1-9]{1}|[1-2]{1}[0-9]{1}|3[0-1]{1}){1}-[1-4]{1}[\\d]{6}$";

		// 뒷 자리가 3,4일 떄 현재년도보다 크면 false
		// 2월 29일 보다 크면 false

		LocalDate now = LocalDate.now();
		int curYear = Integer
				.valueOf(now.toString().substring(2, 4));
		int year = Integer
				.valueOf(regNum.toString().substring(0, 2));
		boolean isNewGen = regNum.substring(7).equals("3")
				|| regNum.substring(7).equals("4");
		boolean isFebruary = regNum.substring(3, 4).equals("2");
		boolean isBigger29 = Integer
				.valueOf(regNum.substring(4, 6)) > 29;

		if (isNewGen && year - curYear > 0) {
			return false;
		}
		if (isFebruary && isBigger29) {
			return false;
		}
		return Pattern.matches(regex, regNum);

	}

}
