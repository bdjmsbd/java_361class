package day04;

public class B_WhileEx05 {
	
	public static void main(String[] args) {

		int num = 10, sum = 0;
		
		int count = 0;
		while(count++< num)
			sum += (count%2==0)?count:0;
		System.out.print(sum);
		
	}
}
