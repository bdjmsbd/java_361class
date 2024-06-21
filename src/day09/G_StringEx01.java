package day09;

import java.util.Arrays;

public class G_StringEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello world";
		System.out.println(str + "의 3번째 문자 : " + str.charAt(2));
		
		String str2 = "hello world";
		System.out.println(str +"과 " + str2 + "는 같나요?" + str.equals(str2)) ;
		
		// indexOf : 시작번지 반환 없으면 -1
		System.out.println(str +"에서 world의 시작 번지는? "+ str.indexOf("world"));
		
		// contains : 문자열이 있는 지 
		System.out.println(str +"에서 world가 있습니까? "+ str.contains("world"));
		
		// replace 찾은 문자열은 교체할 문자로 변환
		System.out.println(str +"에서 o를 찾아서 0로 수정 "+ str.replace("o", "0"));
		System.out.println(str +"에서 o를 찾아서 0로 수정 "+ str.replaceAll("o", "0"));
		
	  String str5 = "aaabbbccccabcddddabcdeeee";
	  
	  String result1 = str5.replace("abc", "왕");
	  String result11 = str5.replace("[abc]", "왕");
	  String result2 = str5.replaceAll("[abc]", "왕");
	  
	  System.out.println("replace result->"+ result1);
	  System.out.println("replaceAll result->"+ result2);
	  
		// substring : index 번지부터 문자열 추출
		System.out.println(str +"에서 부분 문자열 "+ str.substring(0,str.length()));
		System.out.println(str +"에서 부분 문자열 "+ str.substring(3));
		

		//toLowerCaser() : 소문자로
		//toUpperCaser() : 대문자로
		
		//trim() : 맨앞, 맨뒤 공백제거
		
		// valueOf : 무엇을 넣든 해당 값을 문자열로 반환
		boolean a = true;
		String c = str.valueOf(a);
		System.out.println(str +"에서 부분 문자열 "+ c);
		if(str.valueOf(a)==c) {
			System.out.println();
		}
		
		// split, String을 받아 String[]로 반환, 표현식을 기준으로 문자열 추출
		String fruit = "오렌지,사과,바나나,폳,수박";
		String [] fruits = fruit.split(",");
		System.out.println(Arrays.toString(fruits));
		
	}

}
