package day08;

import java.util.Arrays;

public class C_MethodEx05 {

	//isExist
	public static boolean contains(int num, int[] numArray) {
		if(numArray==null) return false; 
		// null 일 경우 '없다' 리턴
		// 참조 연산은 null 처리 습관화
		for (int tmp : numArray)
			if (tmp == num)
				return true;
		return false;
	}

	public static void main(String[] args) {

		// 정수 배열이 주어지고 주어진 배열에 원하는 정수가 있는 지 없는지 확인
		// 메서드를 이용하여

		int min = 1, max = 20;
		int numList[] = new int[10];
		numList = myutils.MyMath.numGen(min, max, numList);
		int myNum = 10;

		System.out.println(contains(myNum, numList) ? "있다" : "없다");
		System.out.println(Arrays.toString(numList));
	}

}

