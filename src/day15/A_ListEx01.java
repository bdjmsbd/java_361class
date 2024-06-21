package day15;

import java.util.ArrayList;

public class A_ListEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> list = new ArrayList<String>();
		
		// add(객체): 객체를 리스트에 추가, 컬렉션 인터페이스에 구현
		// add(번지, 객체): 특정 번지에 객체를 추가, 리스트 인터페이스에서 구현 
		// set은 특정 번지 접근 불가. 
		// 기본적으로 add는 뒤에 순차적으로 추가되지만 특정 번지에 넣기도 가능하다.
		
		
		list.add("안녕");
		list.add("Hello");
		list.add("안녕");
		list.add(0,"Hi");
		
		// remove(객체) : 리스트에서 주어진 객체와 일치하는 객체를 제거. 컬렉션 인터페이스
		// 중복된 객체가 있을 경우에 앞에서부터 제거
		// remove(번지) : 특정 번지에 있는 객체를 삭제하고 삭제된 객체를 반환(리스트 인터페이스)
		// 정수 값은 인덱스 위치를 가르키므로 특정 정수를 삭제 할땐 
		// remove(Integer.valueOf(정수값))을 이용해서 해당값에 접근해준다.
		
		System.out.println(list.remove("H"));
		System.out.println(list.remove("Hi"));
		System.out.println(list.remove(0));
		
		// get(객체) : 특정 번지에 있는 객체를 가져옴. 리스트 인터페이스
		System.out.println(list.get(0));
		
		// clear : 리스트의 모든 객체를 비워줌 
//		list.clear();
		System.out.println(list);
		
		// contains(객체) : 리스트에 특정 객체가 있는 지 알려줌. 컬렉션
		System.out.println("리스트 Hi? " + list.contains("Hi"));
		System.out.println("리스트 Hello? " + list.contains("Hello"));
		
		// indexOf(객체) : 특정 객체가 몇 번지에 있는지 알려줌. <리스트>
		System.out.println("indexOf Hi? " + list.indexOf("Hi"));
		System.out.println("indexOf Hello? " + list.indexOf("Hello"));
		System.out.println(list);
	
		
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(3);
		list2.add(5);
		list2.add(7);
		list2.add(9);
		System.out.println(list2);
		
		list2.remove(Integer.valueOf(9));
		System.out.println(list2);
//		list2.removeAll(Integer.valueOf(1));
		
		

	}

}
