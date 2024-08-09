package day12;

class A_InheritanceEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c = new Child();
		run(c);
//		c.run();

	}

	public static void run(Parent parent) {
		// TODO Auto-generated method stub
		if (parent != null) {
			parent.run();
		}
	}

//	public static void run() {
//		System.out.println("실행합니다.");
//	}
}

//Parent는 개발자들이 자주 쓰는 클래스(가정)
//이 클래스에는 run이라는 메소드가 있다고 가정
class Parent {

	public void run() {
		System.out.println("실행합니다.");
	}

}

class Child extends Parent {

	@Override
	public void run() {
		System.out.println("오버라이드하여 실행합니다.");
	}
}