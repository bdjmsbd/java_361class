package day18;

public class A_ThreadEx01 {

	public static void main(String[] args) {
		// thread 클래스를 생성하여 thread를 이용하는 예제

		MyThread1 t = new MyThread1();
		t.start();
//		MyThread2 t2 = new MyThread2();
//		t2.start();

		for (int i = 0; i < 10000; i++) {
			System.out.print("|");
		}
	}

}

class MyThread1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.print("-");
		}
	}

}
//
//class MyThread2 extends Thread {
//
//	@Override
//	public void run() {
//		for (int i = 0; i < 10000; i++) {
//			if(i%100 == 0)
//			System.out.println();
//		}
//	}
//
//}