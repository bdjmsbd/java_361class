package day17;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class B_ByteStreamEx02 {

	public static void main(String[] args) {
		// Byte기반 입출력 Stream 예제

		// true 기존 파일 이어서 씀
		// false 새로 만들어서 덮어 씀
		try(FileOutputStream fos= new FileOutputStream("src/day17/byteStream3.txt",true)) {
			for(char ch = 'A'; ch <= 'Z'; ch++) {
				fos.write(ch);
			}
			fos.write('\n');
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		


	}

}
