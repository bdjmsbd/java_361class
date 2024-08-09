package day19;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_Ex01 {

//	public static void save(String fileName,
//			List<String> list) {
//		try (ObjectOutputStream oos = new ObjectOutputStream(
//				new FileOutputStream(fileName))) {
//			oos.writeObject(list);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) {

		// 리스트에 문자열 5개 입력받아 저장하는 예제
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			System.out.print(i + 1 + ". 문자열 입력 : ");
			list.add(sc.next());
		}

//		String fileName = "src/day19/Ex01.txt";
//		save(fileName, list);

		// 문자열 A를 입력받아 리스트에 A를 포함하는 문자열들을 출력하는 예제

		System.out.print("검색할 문자열 입력 : ");
		String str = sc.next();
		
//		if (list.contains(str))
//			System.out.println(str);
		
		for (String tmp : list) {
			if (tmp.contains(str)) {
				System.out.println(tmp);
			}
		}

	}

}
