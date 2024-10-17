package day13;

import java.text.MessageFormat;

public class E_MessageFormatEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String format1 = "({0},{2},{1})";
		int x = 1, y = 10, z = 20;

		String res1 = MessageFormat.format(format1, x, y, z);
		System.out.println(res1);

		int grade = 1, classNum = 3, num = 27;
		String name = "bdj";
		String format2 = "{0}학년 {1}반 {2}번 이름: {3}";
		String res2 = MessageFormat.format(format2, grade,classNum,num,name);
		System.out.println(res2);
	}

}
