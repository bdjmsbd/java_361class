package day05;

import java.util.Scanner;

public class F_ArrayEx02 {

	public static void main(String[] args) {
		// 학생 세 명의 성적을 저장하는 배열 생성
		// 학생 3명의 성적을 콘솔을 통해 입력받고 출력하는 코드 작성
		
		Scanner scan = new Scanner(System.in);
		int [] scores = new int[3];
		for(int i = 0; i < scores.length; i++) {
			System.out.print(i+1 + "번 째 학생의 성적을 입력 : ");
			scores[i] = scan.nextInt();
		}
		for(int i = 0; i < scores.length; i++)
			System.out.println(i+1 + "번 째 성적 :"+ scores[i] + " ");
		
		int sum = 0;
		for(int i = 0; i < scores.length; i++)
			sum += scores[i];
		
		System.out.println(scores.length + "학생의 성적 평균 :"+ (double)sum/scores.length);
		
		scan.close();
		
	}

}
