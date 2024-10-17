package programmers;

public class SkillCheckLevel1 {

	public static int solution(String t, String p) {
		int answer = 0;
		int length = p.length();
		for (int i = 0; i <= t.length() - length; i++) {
			String numStr = t.substring(i, length+i);
			long num = Integer.parseInt(numStr);
			long pNum = Integer.parseInt(p);
			if (num <= pNum)
				answer++;
		}
		return answer;
	}

	public static void main(String[] args) {

		String a = "abc";
		String b = a.substring(0, 3);
		System.out.println(b);
		
		System.out.println(solution("3141592","271"));

	}

}
