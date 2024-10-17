package day07;


import java.util.Scanner;

public class C_Exam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 최대 단어 10개를 저장할 수 있는 배열을 이용하여 
		 * 원하는 단어를 입력하면 단어를 배열에 추가하는 코드를 작성
		 * 
		 */
		final String EXIT = "-1";
		
		Scanner scan = new Scanner(System.in);
		String wordList[] = new String[10], inputWord;
		int wordCount =0;
		do {
			System.out.print("단어입력 (종료: -1) : ");
			
			inputWord = scan.next();
			if(inputWord.equals(EXIT)) {
				System.out.println("메뉴로 돌아갑니다.");
				break;
			}
			
			if(wordCount == wordList.length) {
				System.out.println("단어를 추가하지 못했습니다.");
				continue;
			}
			wordList[wordCount++] = inputWord;
			System.out.println("단어를 추가했습니다.");
			
		}while(true);
		

		scan.close();

	}

}
