package day04;

public class A_VariableEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float num1 = 0.123456789f;
		double num2 = 0.12345678012345671;
		
		System.out.printf("%.20f\n%.20f",num1, num2);
		
		/*
		 * 	0.******** float은 9자리에서 8자리 반올림 뒤에는 쓰레기값
		 * 	0.12345679104328156000
		 * 	0.**************** double 17-> 16 반올림 뒤에는 쓰레기값 
			0.12345678012345670000
		 * */
		
	

	}

}
