package day12;

// 동물 클래스, 강아지 고양이
public class B_AbstractClassEx01 {

	public static void main(String[] args) {

//		Animal animal = new Animal();
		// Animal는 추상클래스여서 객체 생성 불가
		
		Cat cat = new Cat();
		cat.bark();
		
		Dog dog = new Dog();
		
		Tiger tgr = new Tiger();
		
		// 추상클래스는 배열로 생성이 가능하다
		// 업캐스팅 
		Animal [] animals = new Animal[3];
		animals[0]= cat;
		animals[1] =dog;
		animals[2] =tgr;
		
		for(Animal tmp : animals) {
			tmp.bark();
		}
	}

}

abstract class Animal {
	public String name;
	public String species;

	public void sleep() {
		System.out.println("잠을 잡니다.");
	}

	public void eat(String food) {
		System.out.println(food + " 먹이를 먹습니다.");
	}

//	public void bark() {
//		System.out.println("동물이 짖습니다.");
//	}

	// bark() 메소드는 animal 클래스를 상속 받는 모든 클래스들이
	// 오버라이딩을 해야하기 때문에 굳이 구현할 필요가 없다.
	// 오버라이딩 이유 -> 짖는건 다달라서
	// 추상 메소드가 하나라도 있으면 클래스도 추상 클래스로 바꿔야한다.
	// 자식 클래스 또한 추상 클래스로 만들거나 
	// ## 올바른 선택 아님, 추상이 되면 객체 생성 불가
	// 추상 메서드를 오버라이딩해서 구현해줘야 한다.
	// #이클립스 에러에 다 뜨는 내용
	public abstract void bark();
}

class Cat extends Animal {
	public Cat() {
		name = "고양이";
		species = "고양이과";
	}

	@Override
	public void bark() {
		// TODO Auto-generated method stub
		System.out.println("냐옹");
	}

}

class Dog extends Animal {
	public Dog() {
		name = "강아지";
		species = "개과";
	}

	@Override
	public void bark() {
		// TODO Auto-generated method stub
		System.out.println("멍멍");
	}
}

class Tiger extends Animal {
		public Tiger() {
			name = "호랑이";
			species = "고양이과";
		}

		@Override
		public void bark() {
			// TODO Auto-generated method stub
			System.out.println("어흥");
		}
}
