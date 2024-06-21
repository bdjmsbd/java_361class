package day12;

import java.util.regex.Pattern;

public class I_RegexEx01 {

	public static void main(String[] args) {
		// 영문자와 숫자
		// ^\w{5,8}$

		// 영문자와 숫자, 특수문자(!@#?) 5~8자
		// => ^[a-zA-Z+0-9!@#?]{5,8}$
		// => ^[a-zA-Z0-9-_]{5,20}$

		// http:// 또는 https://
		// ^(http:// | https://)
		// ^(https?://)
		
		// [a-zA-Z0-9] : \w와 같음
		// [ㄱ-힣] : 모든 한글
		
		// 전화번호
		// ^[0-9]{1,4}[-]?[0-9]{1,4}[-]?[0-9]{1,4}$
		// ^[0-9]{1,4}-[0-9]{1,4}-[0-9]{1,4}$
		
		// 아이디, 알파벳 + 숫자,	첫글자 알파뱃,	5글자이상 10글자 이하
		// ^[a-zA-Z]{1,1}[a-z0-9]{4,9}$
		
		// 비밀번호, 알파벳 1개이상, 숫자 1개이상, 8글자 이상, 20글자 이하
		// ^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,20}$
		// ^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,20}$
		// final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,20}$\n"
		
		String regex1 = "^\\w{5,8}";
		String str1 = "abc123";
		System.out.println(str1 + "은 정규표현식" + regex1 + "에 맞습니까? " + Pattern.matches(regex1, str1));

		String str2 = "abc123!";
		System.out.println(str2 + "은 정규표현식" + regex1 + "에 맞습니까? " + Pattern.matches(regex1, str2));

		String regex2 = "^[a-zA-Z+0-9!@#?]{5,8}$";
		System.out.println(str2 + "은 정규표현식" + regex2 + "에 맞습니까? " + Pattern.matches(regex2, str2));
		
		String regex3 = "^(https?://)";
//		String str3 = "https://regex101.com/";
		String str3 = "https://";
		
		System.out.println(str3 + "http:// 또는 https:// 으로 시작합니까? " + Pattern.matches(regex3, str3));
		str3 = "http://";
		System.out.println(str3 + "http:// 또는 https:// 으로 시작합니까? " + Pattern.matches(regex3, str3));
		
	}

}
