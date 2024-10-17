package programmers;

public class dicegame_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 3, b = 4, c = 6, d = 4;
		int answer = 0;
		int arr[] = new int[7];

		arr[a]++;
		arr[b]++;
		arr[c]++;
		arr[d]++;
		// [0,0,0,0,0,0] => [0,4,0,0,0,0] => [1,0,0,0,0,3]
		// [0,2,2,0,0,0] => [2,0,0,1,1,0] => [1,1,1,1,0,0]
		// 4, 3-1, 2-2, 2-1-1, 1-1-1-1
		

		A: for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 4) {
				answer = i * 1111;
			}
			else if (arr[i] == 3) {
				for (int j = 1; j < arr.length; j++) {
					if (arr[j] == 1)
						answer = (10 * i + j) * (10 * i + j);
				}
			}
			else if (arr[i] == 2) {
				for (int j = 1; j < arr.length; j++) {
					if (arr[j] == 2 && i != j) {
						answer = (i + j) * ((j>i)?(j - i):(i-j));
						break A;
					}
					else if (arr[j] == 1) {
						for (int k = j+1; k < arr.length; k++) {
							if (arr[k] == 1) {
								answer = j * k;
								break A;
							}
						}
					}
				}
			}
		}
		if (answer == 0) {
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] == 1) {
					answer = i;
					break;
				}
			}
		}
		
		System.out.println(answer);
//		boolean same4, same31, same22, same211, same1111;
//		for (int i = 1; i < arr.length; i++) {
//			if (i == a)
//				arr[i]++;
//			if (i == b)
//				arr[i]++;
//			if (i == c)
//				arr[i]++;
//			if (i == d)
//				arr[i]++;
//		}

	}

}
