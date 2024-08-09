package day07;

//import java.util.Arrays;
import java.util.Scanner;

public class B_ArrayEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3학생의 국어, 영어, 수학 성적을 입력받고
		// 각 학생으 ㅣ평균을 구하는 코드를 작성하세요.
		Scanner scan = new Scanner(System.in);
		int[][] student = new int[3][3];
		int[] scrSum = new int[3];
		int[] subSum = new int[3];

		for (int i = 0; i < student.length; i++) {
			System.out.print("학생" + (i + 1) + "의 국어,영어,수학 성적을 입력(50 60 70) : ");
			for (int j = 0; j < student.length; j++) {
				student[i][j] = scan.nextInt();
				scrSum[i] += student[i][j];
			}
		}

		for (int i = 0; i < scrSum.length; i++)

			System.out.printf("학생%d의 평균 : %.2f\n", i + 1, (double) scrSum[i] / 3);

		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < student.length; j++) {
				subSum[i] += student[j][i];
			}
		}
		for (int i = 0; i < subSum.length; i++)
			System.out.printf("%s 평균 : %.2f\n", i == 0 ? "국어" : i == 1 ? "영어" : "수학", (double) subSum[i] / 3);

		scan.close();

		
	}

}
