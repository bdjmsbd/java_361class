package day05;

public class C_AlphabetEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 알파벳 순서대로 출력
		 */
//		char ch = 'a';
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j <= i; j++)
//				System.out.print(ch++);
//			ch = 'a';
				System.out.print((char)('a'+j));
			System.out.println();
		}
		
		for (char ch1 = 'a'; ch1 <= 'z'; ch1++) {
			for (char ch2 = 'a'; ch2 <= ch1; ch2++)
				System.out.print(ch2);
			System.out.println();
		}


	}

}
