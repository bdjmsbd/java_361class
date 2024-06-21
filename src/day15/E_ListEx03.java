package day15;

import java.util.ArrayList;
import java.util.Objects;

public class E_ListEx03 {

	public static void main(String[] args) {
		// 연락처 클래스를 이용한 List 예제
		// indexOf, remove, contains
		ArrayList<Contact> list = new ArrayList<>();

		Contact c1 = new Contact("홍길동", "010-1234-5678");
		Contact c2 = new Contact("고길동", "010-1234-5678");
		list.add(c1);

		System.out.println(list);
		list.remove(c2);
		System.out.println(list);

		list.add(new Contact(c1));
		c2.name = "나길동";
		System.out.println(list);
	}

}

class Contact {

	public String name, number;

	public Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}

	// 복사 생성자를 이용하역 객체를 리스트에 저장하고 밖에서 수정 
	public Contact(Contact c) {
		this.name = c.name;
		this.number = c.number;
	}

	@Override
	public String toString() {
		return name + " : " + number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(number, other.number);
	}

}