package day02;

public class L_ComparisonOperatorEx01 {

	public static void main(String[] args) {

		int num1 = 10, num2 = 20;

		System.out.printf("%d < %d : %b\n",num1,num2,num1<num2);
		System.out.printf("%d > %d : %b\n",num1,num2,num1>num2);
		System.out.printf("%d <= %d : %b\n",num1,num2,num1 <= num2);
		System.out.printf("%d >= %d : %b\n",num1,num2,num1 >= num2);
		System.out.printf("%d == %d : %b\n",num1,num2,num1 == num2);
		System.out.printf("%d != %d : %b\n",num1,num2,num1 != num2);
		
		
		// 단순 == 비교 연산자는 주소를 ㅡ비교하기 때문에 문자열이 같아도 다르다고 판별할 수 있다
		// 따라서 스트링 비교는 equals. 함수를 사용할 것 
		String str1 = "abc", str2 ="abc", str3 = new String("abc");
		
		/*
		System.out.println("str1 == str2 : " + (str1 == str2));
		System.out.println("str1 == str3 : " + (str1 == str3));
		System.out.println("str2 == str3 : " + (str2 == str3));
		 */
		
		System.out.println("str1 == str2 : " + (str1.equals(str2)));
		System.out.println("str1 == str3 : " + (str1.equals(str3)));
		System.out.println("str2 == str3 : " + (str2.equals(str3)));
		

	}

}
