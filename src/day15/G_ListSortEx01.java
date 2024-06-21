package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class G_ListSortEx01 {

	public static void main(String[] args) {
		// List를 이용하여 정렬하는 방법

		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("고길동");
		list.add("둘리");

		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		// collection.sort(컬렉션, Comparator 객체)
		// 새로운 익명(이름이 필요없는) 클래스를 만들어서 객체를 이용
		// comparator 인터페이스의 compare 추상 메소드를 오버라이딩하고 코드에 따라
		// 정별방식 바뀜
//		Collections.sort(list, new Comparator<String>() {
//
//			@Override // 함수를 안에서 구현하네?
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				return -o1.compareTo(o2);
//			}
//
//		});
		Collections.sort(list,(o1,o2)-> -o1.compareTo(o2));
		System.out.println(list);

		List<Student> stds = new ArrayList<>();
		stds.add(new Student("2024160003", "홍길동"));
		stds.add(new Student("2024160002", "고길동"));
		stds.add(new Student("2024160001", "둘리"));

//		Collections.sort(stds, new Comparator<Student>() {
//
//			@Override
//			public int compare(Student o1, Student o2) {
//				// TODO Auto-generated method stub
//				return o1.number.compareTo(o2.number);
//			}
//	});
		
		Collections.sort(stds, (o1, o2) -> o1.number.compareTo(o2.number));
		System.out.println(stds);

	}

}

class Student {

	public String number, name;

	public Student(String number, String name) {

		this.number = number;
		this.name = name;
	}

	@Override
	public String toString() {
		return number + " : " + name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(number, other.number);
	}

}