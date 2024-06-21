package day12;

import java.util.StringTokenizer;

public class H_StringTokenizerEx01 {

		// split은 한번에 배열로 만들어준다. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fruit = "사과,포도,배, , , ㅓㅓ";
		StringTokenizer st =new StringTokenizer(fruit,",");
		while(st.hasMoreTokens()) { // 토큰이 있다면
			String token = st.nextToken(); // 가져온다
			System.out.println(token);
		}
		
	}

}
