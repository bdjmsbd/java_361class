package day02;

public class M_LogicalOperatorEx01 {

	public static void main(String[] args) {
		//논리 연산자 예제
		
		int score = 85;
		boolean isB = false;
		
		isB = (score>=80)&&(score<90);
		
		System.out.println(isB);
		
		int sub1 = 60, 
			sub2 = 100, 
			sub3 = 30, 
			sub4 = 80;
		
		boolean isFail = false; 
		isFail = (sub1<40 || sub2<40 || sub3<40 || sub4<40);
		
		System.out.println("과락이 있습니까? : " + (isFail?"Yes":"No"));
		
		////////////////////////////////////////////////////////////
		
		int age = 20; 
		boolean isMinor = false;
		
	
		isMinor = !(age >= 19);
		System.out.println("미성년자 입니까? : " + (isMinor?"Yes":"No"));
	}
	
}
