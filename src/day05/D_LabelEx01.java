package day05;

public class D_LabelEx01 {

	public static void main(String[] args) {
		/*
		 * 라벨링 break A하면 바깥쪽 반복문으로도 빠져나갈 수 있다
		 */
		int i, j, k;

		A: for (i = 1; i <= 5; i++) {
			B: for (j = 1; j <= 5; j++) {
				for (k = 1; k <= 5; k++) {
					System.out.printf("%2d ", i * j *k);
					if (k == 3)
						break A;
				}
			}
			System.out.println();
		}

	}

}
