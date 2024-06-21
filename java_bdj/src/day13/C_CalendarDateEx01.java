package day13;

import java.util.Calendar;
import java.util.Date;

public class C_CalendarDateEx01 {

	// 1970/ 1/ 1
	public static void main(String[] args) {
		// Calendar -> date
		Calendar cal = Calendar.getInstance();
		
		Date date = new Date(cal.getTimeInMillis());
		System.out.println(date);
		
		int tmp = 86400000* 3;
		// date -> Calendar
		Date date2 = new Date(tmp); // 0-> 86400000 -> 하루 86400초 -> 밀리초 1/1000
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		System.out.println(cal2.get(Calendar.YEAR) + "-" +(cal2.get(Calendar.MONTH)+1)+"-"+cal2.get(Calendar.DAY_OF_MONTH));  
	}

}
