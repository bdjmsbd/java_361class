package day12;

public class E_InterfaceInhritanceEx01 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	


}

interface InterfacePA {

	void print();
	default void test1() {};

}

interface InterfacePB {

	void print();
	void test2();

}
// interface는 다중 상속이 가능 구현부가 없고, 사용시 구현해주면 되기 때문에
interface InterfaceC extends InterfacePA, InterfacePB {

}

class ClassA {

	void print() {
	}

	void test1() {
	}

}

class ClassB {

	void print() {
	}

	void test2() {
	}

}

// Class는 다중 상속이 안됨. 
// class ClassC extends ClassA, ClassB{}