package day03;

import java.util.Scanner;

public class A3_Exam03 {

	static String K_PASS = "합격";
	static String K_FAIL = "불합격";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int score1, score2;
		System.out.printf("과목1 성적 입력 : ");
		score1 = scan.nextInt();
		System.out.printf("과목2 성적 입력 : ");
		score2 = scan.nextInt();
		
		System.out.println("결과 : " + ((
				(((double)score1+score2)/2)>=60 && 
				(score1>=40) && 
				(score2>=40))?K_PASS:K_FAIL));
		
//		System.out.println("결과 : " + ((
//				(((double)score1+score2)/2)<60)?"불합격":
//				(score1<40)?"불합격":
//				(score2<40)?"불합격":"합격"));

		scan.close();
	}

}
