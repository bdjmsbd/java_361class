package day15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class F_HashMapEx02 {

	public static void main(String[] args) {
		// Map을 이용한 반복문 예제

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("2024160001", "고길동");
		map.put("2024160002", "홍길동");
		map.put("2024160003", "임꺽정");

		// 방법1. keySet을 이용
		// key값만 set에 넣어두고
		// get(key)로 value를 얻어옴
		Set<String> set = map.keySet();

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
		// 방법2. EntrySet을 이용.
		// Entry 클래스를 이용하여 set으로 만들고, 
		// 마찬가지로 getkey와 getvalue 얻어옴
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();
		while(it2.hasNext()) {
			Map.Entry<String, String> tmp = it2.next();
			String key = tmp.getKey();
			String value = tmp.getValue();
			System.out.println(key + " : " + value);}
	}

}
