package day12;


public class G_StringBufferEx01 {

	public static void main(String[] args) {
		// String과 StringBuffer의 차이 
		// 수정을 자주한다면 Buffer가 적합. 
		// StringBuilder도 있는데 단일 쓰레드에서만 사용하기에 잘 안씀
		StringBuilder sp = new StringBuilder("world");
		
		StringBuffer sb = new StringBuffer("Hello World");
		sb.append("!");
		System.out.println(sb);
		sb.insert(0,"\"");
		sb.insert(sb.length(),"\""); // sb.append("\"")
		System.out.println(sb);
		sb.delete(6, sb.length()-1);
		System.out.println(sb);
		
		String str = "Hello World";
		str=str.concat("!");
		System.out.println(str);
	}

}
