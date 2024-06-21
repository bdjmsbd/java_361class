package day15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class C_HashSetEx01 {

	public static void main(String[] args) {
		// HashSet
		
		HashSet<Integer> set = new HashSet<>();
		
		// add(객체) : 객체를 set에 추가, 중복인 경우 false 리턴
		System.out.println(set.add(1));
		System.out.println(set.add(1));
		
		System.out.println(set);
		
		// remove(객체) : 제거, 없으면 false
		set.add(3);
		set.add(5);
		set.add(7);
		
		System.out.println(set.remove(1));
		System.out.println(set);
		
		// contains(객체) : 있으면 true, 없으면 false
		
		System.out.println(set.contains(5));
		
		// size(): 저장된 개수
		System.out.println(set.size());
		
		ArrayList<Integer> list = new ArrayList<>();
		// addAll(col) : 컬렉션에 있는 원소들을 추가
		list.addAll(set);
		list.add(8);
		list.add(9);
		list.add(10);
		
		// shuffle(arrayList) : 안에 원소를 섞어줌 
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		
	}

}
