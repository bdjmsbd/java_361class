package day17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class B_ByteStreamEx01 {

	public static void main(String[] args) {
		// Byte기반 입출력 Stream 예제

		FileInputStream fis = null;
		FileInputStream fis2 = null;
		try {
			fis = new FileInputStream("src/day17/byteStream.txt");
			int data = fis.read();
			System.out.println(data);
			System.out.println((char) data);

			data = fis.read();
			System.out.println(data);

			fis2 = new FileInputStream(
					"src/day17/byteStream2.txt");
			do {
				data = fis2.read();
				System.out.print((char) data);
			} while (data != -1);

		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("데이터를 읽어올 수 없습니다.");
//			e.printStackTrace();
		} finally {

			try {
//				if (fis != null)
					fis.close();
//				if (fis2 != null)
					fis2.close();
			} catch (IOException e) {
				System.out.println("파일을 닫을 없습니다.");
			}
		}

	}

}
