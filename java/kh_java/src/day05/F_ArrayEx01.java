package day05;

public class F_ArrayEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 5명의 학생 성적을 저장하기 위한 변수를 선언
//		int a[],b,c = new int[5];
//		int[] e,f,g;

//		int a[] = new int[5];
//		int[] b= new int[5];

		// 5명의 학생 성적을 저장
		int[] scores1 = new int[5];
		int scores2[] = new int[5];

		int[] scores = new int[] { 1, 2, 3, 4, 5 };
		int scores3[] = new int[] { 1, 2, 3, 4, 5 };
		
		scores1[0] = 1;
		scores1[1] = 2;
		scores1[2] = 3;
		scores1[3] = 4;
		scores1[4] = 5;
		
		for(int i =0; i<scores1.length;i++) {
			scores1[i]=i+1;
			System.out.println(scores1[i]);
		}

		/*
		* 
		*/

	}

}
