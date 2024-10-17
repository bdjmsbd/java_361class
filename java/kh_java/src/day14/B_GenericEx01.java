package day14;

import java.util.Arrays;

public class B_GenericEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array<String> list1 = new Array<>(10);
		list1.set(0, "안녕");
		list1.set(1, "사과");
		
//		String[] t = list1.getList();
//		for(Array<String> tmp: list1) {
//			if(tmp != null)
//				System.out.println(tmp);
//		}
//		
		for (int i = 0; i < 10; i++) {
			if(list1.get(i) != null)
				System.out.println(list1.get(i));
		}
		//list1.print();
		
		Array<Integer> list2 = new Array<>(10);
		list2.set(0, 1);
		list2.set(1, 20);
		
		for (int i = 0; i < 10; i++) {
			if(list2.get(i) != null)
				System.out.println(list2.get(i));
		}
//	list2.print();
		
		String [] list3 = new String[10];
		list3[0] = "안녕";
		list3[1] = "귤";
		
		Integer [] list4 = new Integer[10];
		list4[0] = 100;
		list4[1] = 1000;

		printArray(list3);
		printArray(list4);


	}
	
	public static <T> void printArray(T[] array) {
		for(T element : array) {
			if(element != null)
			System.out.println(element);
		}
	}

}

class Array<T> {

//	private String list[];
	private T list[];

	public void setList(T[] list) {
		this.list = list;
	}

	public T[] getList() {
		return list;
	}

	@SuppressWarnings("unchecked")
	public Array(int size) {
		list = (T[]) new Object[size];
	}

	public void set(int index, T data) {
		if (index >= list.length || index < 0) {
			return;
		}
		list[index] = data;
	}

	public T get(int index) {
		if (index >= list.length || index < 0) {
			return null;
		}
		return list[index];
	}

	public void print() {
		for (int i = 0; i < list.length; i++) {
			if(list[i]!=null)
				System.out.println(list[i]);
		}
	}

}

class test <A,B>{
	
}