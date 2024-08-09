package day06;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class C_ArrayEx06 {

	public static void main(String[] args) {
		// 4과목의 성적을 입력받아 배열에 저장하고
		// 과락이 없고(40점 미만) 평균이 60점 넘으면 Pass 아니면 Fail

		int[] scores = new int[4];
		Scanner scan = new Scanner(System.in);
		
		System.out.print("4과목의 성적을 입력하세요(예: 60 60 40 70) : ");
		for (int i = 0; i < scores.length; i++) {
			scores[i] = scan.nextInt();
		}
		
		//System.out.println( Arrays.toString(scores) );

		int sum = 0;
		boolean isPass = true;
		for (int tmp : scores) {
			if (tmp < 40) {
				isPass = false;
				break;
			}
			sum += tmp;
		}
		if (isPass && sum / scores.length < 60)
			isPass = false;

		System.out.println((isPass) ? "Pass" : "Fail");

		scan.close();

	}

}
