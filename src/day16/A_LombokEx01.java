package day16;

import lombok.*;

public class A_LombokEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.setName("홍");
		t.setNumber("1234");
		System.out.println(t);
		
		Test t2 = new Test("bdj");
		System.out.println(t2);
		
		var a = "abcc";
		
	}

}

@Data
@AllArgsConstructor // 모든 멤버변수를 필요로 하는 생성자
@NoArgsConstructor // 기본 생성자
@RequiredArgsConstructor // 반드시 필요한 멤버 변수들을 매개변수로 갖는 생성자
class Test {
	@NonNull // 위치
	private String name; 
	
	private String number, address;
	


}