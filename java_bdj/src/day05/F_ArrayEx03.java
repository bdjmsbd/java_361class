package day05;


public class F_ArrayEx03 {

	public static int randGen(int min, int max) {
		
		return (int) (Math.random() * (max - min + 1) + min);
	}
	
	public static void main(String[] args) {
		// 1~10 사의의 랜덤한 수 3개를 저장하고 출력
		
		int min = 1, max = 10;
		int [] randNum = new int[3];
		for(int i=0; i<randNum.length; i++) {
			randNum[i]=randGen(min,max);
			//System.out.printf(randNum[i]+ " ");
		}
		
		for(int i=0; i<randNum.length; i++) {
			System.out.printf(randNum[i]+ " ");
		}
				
		
	}

}
