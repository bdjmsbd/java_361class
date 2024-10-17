package day05;

public class E_RandomEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// random 함수에서 max-min+1 의미 풀어서 설명
		int min = 1, max = 7;
		int randNum = (int) (Math.random() * (max - min + 1) + min);
		System.out.println("랜덤 수 : " + randNum);

	}

}
