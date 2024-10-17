package day15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class C_HashSetEx02 {

	public static void main(String[] args) {
		// HashSet
		// 향상된 for문을 이용하여 
		// set에 저장된 값을 가져오기
		
		HashSet<Integer> set = new HashSet<>();
		
		set.add(1);
		set.add(3);
		set.add(9);
		set.add(7);
		set.add(5);
		set.add(null);
		
		for(Integer tmp : set) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		HashSet<String> set2 = new HashSet<>();
		set2.add("A");
		set2.add("D");
		set2.add("C");
		Iterator<String> it = set2.iterator();
		while(it.hasNext()) {
			String num = it.next();
			System.out.print(num + " ");
		}
	
		
	}

}
