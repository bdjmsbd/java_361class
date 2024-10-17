package day03;

import java.util.Scanner;

public class A2_Exam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int score1, score2, score3;
		System.out.print("학생1 성적 입력 : ");
		score1 = scan.nextInt();
		System.out.print("학생2 성적 입력 : ");
		score2 = scan.nextInt();
		System.out.print("학생3 성적 입력 : ");
		score3 = scan.nextInt();
				
		int sum = score1+score2+score3;
		double avg = ((double)sum)/3;
//		System.out.println("총점 : " + sum +". 평균 : " + avg);
		
		System.out.println("총점 : " + sum +". 평균 : " + String.format("%.7f", avg));
		
//		int sum;
//		double avg;
//		for(int i=0; i<3; i) {
//			int score;
//			System.out.print("학생" + (++i)+" 성적 입력 : ");
//			score = scan.nextInt();
//			sum += score;
//		}
//		avg = ((double)sum)/3;
//		System.out.println("총점 : " + sum +". 평균 : " + avg);

		scan.close();
	}

}
