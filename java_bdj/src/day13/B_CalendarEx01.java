package day13;

import java.util.Calendar;

public class B_CalendarEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year + "-" + (month+1) + "-" + day);

	}

}
