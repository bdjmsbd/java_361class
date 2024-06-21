package day18;

public class A_ThreadEx02 {

	public static void main(String[] args) {
		// thread 클래스를 생성하여 thread를 이용하는 예제
		// implements Runnable을 사용하는 예제

		MyThread2 mt = new MyThread2();
		
		Thread t = new Thread(mt);
		t.start();

		for (int i = 0; i < 10000; i++) {
			System.out.print("|");
		}
	}

}



class MyThread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.print("-");
		}
	}

}