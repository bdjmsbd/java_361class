package day12;

public class D_InterfaceEx01 {

	public static void main(String[] args) {
		Dog1 dog = new Dog1();
		dog.sleep();
		dog.bark();

		// intreface는 객체로 만들 수 없다.
//	AnimalAction aa= new AnimalAction();
		AnimalAction aa = new Dog1();
		aa.bark();
		System.out.println(aa.num + " " + aa.num2);
		System.out.println(AnimalAction.num + " " + AnimalAction.num2);

	}
}

interface AnimalAction {
	// 굳이 public final static을 안붙여도 됨
	public final static int num = 10;
	int num2 = 20;
	
	// 굳이 public abstract 안써도 알아서 반영됨
	public abstract void bark();

	default void sleep() {
		System.out.println("잠을 잡니다.");

	}

	void eat(String feed);

}

abstract class Animal2 implements AnimalAction {

	String name;
}

class Dog1 extends Animal2 {

	@Override
	public void bark() {
		// TODO Auto-generated method stub
		System.out.println("멍멍");

	}

	@Override
	public void eat(String feed) {
		// TODO Auto-generated method stub

	}

}