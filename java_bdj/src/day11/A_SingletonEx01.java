package day11;

public class A_SingletonEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Singleton sl =  Singleton.getInstance();
		sl.message();
		Singleton sl2 =  Singleton.getInstance();
		sl2.message();

		System.out.println(sl);
		System.out.println(sl2);
	}

}

class Singleton{
	private static Singleton instance = new Singleton();
	
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		return instance;
	}
	public void message() {
		System.out.println("싱글톤입니다. ");
	}
}
