package day03;

public class B_IfEx01 {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int num = 3; 
//		
//		if( num%2 != 0 )
//			System.out.println("홀수(odd number)");
//		else
//			System.out.println("짝수(even number)");	
//
//	}
	
	public static void main(String[] args) {
		//else if 
		int num = 3;
		if(num == 0)
			System.out.println(num);
		else if(num>0)
			System.out.println(num+"는 양수");
		else
			System.out.println(num+"는 음수");
		

	}

}
