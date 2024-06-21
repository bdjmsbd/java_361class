package day04;

public class B_WhileEx08 {

	public static void main(String[] args) {
		
		int num1 = 68, num2 = 45435424;
		int gcd = 1;
		int count = 0;
		while(count++<((num1>num2)?num2:num1)) 
			if(num2%count==0 && num1%count==0)
				gcd = count;
		
		System.out.println(gcd);

		
	}
}
