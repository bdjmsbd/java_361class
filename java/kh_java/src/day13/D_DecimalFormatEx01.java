package day13;

import java.text.DecimalFormat;

public class D_DecimalFormatEx01 {

	public static void main(String[] args) {
		
		int num1 = 123456789;
		
		DecimalFormat df = new DecimalFormat("0000000000");
		System.out.println(df.format(num1));
		
		int num2 = 123456789;
		
		DecimalFormat df2 = new DecimalFormat(",###");
		System.out.println(df2.format(num2));
		
		double num3 = 0.12;
		
		DecimalFormat df3 = new DecimalFormat("#.##%");
		System.out.println(df3.format(num3));
		
		double num4 = 654321.234;
		//소수점 날림
		DecimalFormat df4 = new DecimalFormat("\u00A4,###");
		//DecimalFormat df4 = new DecimalFormat("\u00A4#,###");
		System.out.println(df4.format(num4));
		
		double num5 = 654.326;
		//반올림 처리
		DecimalFormat df5 = new DecimalFormat("#.##");
		System.out.println(df5.format(num5));
	}

}
