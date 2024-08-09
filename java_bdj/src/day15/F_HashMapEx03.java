package day15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class F_HashMapEx03 {

	public static void main(String[] args) {
		// Map의 다형성과 Map의 활용
		HashMap<Integer, Object> map = new HashMap<>();

		map.put(0, "고길동");
		map.put(1, 123);
		map.put(2, new Scanner(System.in));
		
		System.out.println(map);
		
		HashMap<String, Object> map2 = new HashMap<>();
		map2.put("title", "안녕");
		map2.put("age", 21);
		System.out.println(map2);
	}

}
