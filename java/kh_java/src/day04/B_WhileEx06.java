package day04;

public class B_WhileEx06 {
	
	public static void main(String[] args) {

		// 12의 약수를 출력
		int num = 12;
		int count = 0;
		
//		반복횟수
//		규칙성
//		반복문 종료 후
		
		while(count++<num)
			System.out.print((num%count==0)?count + ((num != count)?", ":"\n"):"");
	}
}
