package day03;
import java.util.Scanner;

public class D_ScannerEx03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// 3학생의 성적을 한 번에 입력받기
		int score1 = scan.nextInt();
		int score2 = scan.nextInt();
		int score3 = scan.nextInt();
		System.out.println("세 학생의 성적 : " + score1 + ", " + score2 + ", " + score3);
		
		scan.close();	
	}

}
