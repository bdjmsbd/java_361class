package programmers;

// 옹아리
public class babbling_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String babbling [] = new String[] {"aya", "yee", "u", "maa", "wyeoo"};
		
		String joka[] = new String[] { "aya", "ye", "woo", "ma" };
		

		int answer = 0;
		for (int i = 0; i < babbling.length; i++) {
			for (int j = 0; j < joka.length; j++) {
				babbling[i] = babbling[i].replaceAll(joka[j], "-");
			}
			babbling[i] = babbling[i].replaceAll("-", "");
			if (babbling[i].equals(""))
				answer++;
		}
		
		System.out.println(answer);

	}

}
