package day08.homework;

import java.util.Arrays;

public class MethodEx03 {

	public static void main(String[] args) {
		// 배열에 랜덤으로 1~9 사이의 중복되지 않는 수를 생성하고
		// 콘솔에 출력하는 코드를 작성하세요. 단. 메소드 이용
		// homework ex01, ex02 + day08.Ex05
		int min =1, max=45;
		int num = MethodEx01.inputNum();  //inputNum();
		int randList[] = MethodEx01.createArray(num);  //allocateSize(num);

		randList = my.MyMath.numGen(min, max, randList);
		Arrays.sort(randList);
		Arrays.sort(new int[]{1,2,3});
		System.out.println(Arrays.toString(randList));
	}

}
