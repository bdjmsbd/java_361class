package day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class H_ExceptionEx02 {

	public static void main(String[] args) {
		String str = "2024-06-14";
		// String str = "2024-06-14 15:22";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			date = format.parse(str);
			// runtime Exception이 아니어서 코딩 과정에서 예외처리가 필수.(그냥 그렇게 짠거임)
		} catch (ParseException e) {
			System.out.println("문자열이 올바른 날짜 포맷이 아닙니다.");
		}
		
		System.out.println(date);

	}

}
