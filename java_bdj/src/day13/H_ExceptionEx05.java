package day13;

public class H_ExceptionEx05 {

	public static void main(String[] args) throws MyException {

		test();
	}

	public static void test() throws MyException {
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			String str = new Object(){}.getClass().getEnclosingMethod().getName();
			throw new MyException(str, "0으로 나눌 수 없습니다.");
		}
	}

}

class MyException extends Exception {

	String who;

	public MyException(String message, String who) {
		super(message);
		this.who = who;
	}

	@Override
	public String getMessage() {
		return who + " : " + super.getMessage();
	}

}