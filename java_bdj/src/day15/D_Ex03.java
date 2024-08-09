package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class D_Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1~10 사이의 랜덤한 수 6개를 생성해서

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}

		Collections.shuffle(list);
		while(list.size()>6) {
			list.remove(6);
		}
		System.out.println(list);
		
//		HashSet<Integer> set = new HashSet<>();
//		while (set.size() < 5) {
//			set.add(myutils.MyMath.randGen(1, 32));
//		} // 15까지는 정렬 됨
//		
//		System.out.println(set);
	}

}
