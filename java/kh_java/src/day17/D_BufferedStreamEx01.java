package day17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class D_BufferedStreamEx01 {

	// 한 글자씩 받아오기 보단 한 문장씩 받아오기에 속도가 더 빠름
	public static void main(String[] args) {

		String fileName = "src/day17/charStream.txt";
		// filename이 아닌 객체를 넣어줘야한다.
		try (BufferedReader br = new BufferedReader(
				new FileReader(fileName))) {
			String str;
//			do {
//				str = br.readLine();
//				System.out.println(str);
//			} while (str != null);

			while ((str = br.readLine()) != null) {

				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
