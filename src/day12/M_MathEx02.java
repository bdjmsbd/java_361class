package day12;

public class M_MathEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3.14를 소수점 2번째 자리에서 올림하는 코드를 작성하세요. 
		
		double pi = 3.14;
		double res = Math.ceil(pi*10)/10;
		System.out.println("3.14를 소수점 두 번째 자리에서 올림하기 : " + res);
		
		// 소수점 n번째 자리에서 반올림이라면?
		double num = 12.3456789;
		int n = 5;
		double ress = Math.round(num*Math.pow(10, n-1)) / Math.pow(10, n-1);
		System.out.println("소수점 n번째 자리에서 올림 : " + ress);

	}

}
