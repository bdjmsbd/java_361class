package day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class A_DateEx01 {

	public static void test() throws ParseException {
		Date date = new Date();
		System.out.println(date);
		// Fri Jun 14 09:13:55 KST 2024

		// 날짜 => 문자열로
		SimpleDateFormat format = new SimpleDateFormat("yyyy년MM월dd일");
		String dateStr = format.format(date);
		System.out.println(dateStr);

		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
		String dateStr2 = format2.format(date);
		System.out.println(dateStr2);

		// Fri, Jun 등은 지역설정이 kst로 되어있어서 출력이 안됨..
		SimpleDateFormat format3 = new SimpleDateFormat("E");
		String dateStr3 = format3.format(date);
		System.out.println(dateStr3);

		String dateStr4 = "2024-06-14 09/22";
		SimpleDateFormat format4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date4 = format4.parse(dateStr4);
		System.out.println(date4);
	}

	public static void main(String[] args) throws Exception {
		/*
		 * <li>{@code dow} is the day of the week ({@code Sun, Mon, Tue, Wed, Thu, Fri,
		 * Sat}). <li>{@code mon} is the month ({@code Jan, Feb, Mar, Apr, May, Jun,
		 * Jul, Aug, Sep, Oct, Nov, Dec}). <li>{@code dd} is the day of the month
		 * ({@code 01} through {@code 31}), as two decimal digits. <li>{@code hh} is the
		 * hour of the day ({@code 00} through {@code 23}), as two decimal digits.
		 * <li>{@code mm} is the minute within the hour ({@code 00} through {@code 59}),
		 * as two decimal digits. <li>{@code ss} is the second within the minute ({@code
		 * 00} through {@code 61}, as two decimal digits. <li>{@code zzz} is the time
		 * zone (and may reflect daylight saving time). Standard time zone abbreviations
		 * include those recognized by the method {@code parse}. If time zone
		 * information is not available, then {@code zzz} is empty - that is, it
		 * consists of no characters at all. <li>{@code yyyy} is the year, as four
		 * decimal digits.
		 */
		test();
	}

}
