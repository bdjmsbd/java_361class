package day14;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class C_EqualsEx01 {

	// Object.equals 예제
	// equal은 객체가 다르면 기본적으로 false를 리턴하지만
	// equal 오버라이딩을 통해 비교 변수의 타입만 확인하고 equal 비교값 리턴 가능
	public static void main(String[] args) {

		List<?>[] lists = new List<?>[2];
		lists[0] = Arrays.asList(1);
		lists[1] = Arrays.asList("A");
		for (List<?> list : lists) {
			System.out.println(list);
		}

		PhoneNumber pn1 = new PhoneNumber("010-1234-5678");

		System.out.println(pn1.equals(1));
		System.out.println(pn1.equals("010-2222-3333"));
		System.out.println(pn1.equals("010-1234-5678"));
	}

}

class PhoneNumber {

	public String number;

	public PhoneNumber(String number) {
		super();
		this.number = number;
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
		if (getClass() != obj.getClass()) {
			// obj의 type이 String이라면 단순 비교하겠다.
//			if (obj instanceof String) { 
//				return number.equals(obj);
//			}
			return false;
		}
		PhoneNumber other = (PhoneNumber) obj;
		return Objects.equals(number, other.number);

	}

}
