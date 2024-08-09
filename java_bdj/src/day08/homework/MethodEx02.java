package day08.homework;

import java.util.Arrays;

public class MethodEx02 {
	public static void main(String[] args) {
		// 1~9사이의 랜덤한 수를 배열에 저장하여 콘솔에 출력하는 코드를 작성하세요.
		// 메서드 이용
		// 
		
		int [] numList = new int[5];
		for (int i = 0; i < numList.length; i++) 
			numList[i] = my.MyMath.randGen(1,9);
		//numList = myutils.MyMath.numGen(1, 9, numList);
		System.out.println(Arrays.toString(numList));
	}

}
