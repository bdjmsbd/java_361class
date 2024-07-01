package day24;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Data;
import lombok.NoArgsConstructor;
import program.Program;

public class Exam {

	public static void ex01() {
		int num1 = 4;
		double num2 = num1;

		int num3 = (int) num2;
		// 실수형과 정수형의 차이로 에러 발생 => 자동 자료형변환
		// int로 타입캐스팅 소수 부분을 날려서 정수로 => 명시적 형변환
	}

	public static void ex02() {
		int num1 = 1, num2 = 2;
		double res = num1 / num2;

		System.out.println(num1 + " / " + num2 + " = " + res);
		// 정수 사칙연산 정수 => 정수
		// 정수 하나를 명시적 형변환
		double res2 = (double) num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + res2);

	}

	public static void ex03() {
		// 홀수 짝수 판별
		int num = 2;
		if (num % 2 == 0)
			;
		{
			System.out.println("짝수");
		}
		if (num % 2 != 0)
			;
		{
			System.out.println("홀수");
		}
		// 세미콜론 지워
		if (num % 2 == 0) {
			System.out.println("짝수");
		}
		if (num % 2 != 0) {
			System.out.println("홀수");
		}
	}

	public static void ex04() {
		// 성적 판별

		int score = 80;
		if (score >= 90 || score <= 100) {
			System.out.println("A");
		}

		// or -> and
		if (score >= 90 && score <= 100) {
			System.out.println("A");
		}

	}

	public static void ex05() {
		// exit를 입력 받으면 종료.
		Scanner sc = new Scanner(System.in);
		boolean res = false;
		while (res) {
			System.out.print("문자열 입력 : ");
			String str = sc.next();
			if (str == "exit") {
				continue;
			}
			System.out.println(str);
		}
		//////////////////////////////////
		res = true;
		while (res) {
			System.out.print("문자열 입력 : ");
			String str = sc.next();
			if (str.equals("exit")) {
				break;
			}

			System.out.println(str);
		}
	}

	public static void ex06() {
		// 1부터 10까지 작성하는 코드
		for (int i = 0; i <= 10;)
			System.out.println(i);

		// 증감 연산자 추가
		for (int i = 0; i < 10;)
			System.out.println(i++ + 1);
	}

	public static void ex07() {
		// 1부터 10까지 합 구하기
		int sum = 0;

		// 세미콜론 지우자

	}

	// ex11
	public static int sum(int n1, int n2) {
		return n1 + n2;
	}

	// ex13
	public static void ex13() {
		PointC[] pts = new PointC[3];
		for (int i = 0; i < pts.length; i++) {
			pts[i] = new PointC();
			pts[i].setX(i + 1);
			pts[i].setY(i + 1);
			pts[i].print();
		}
	}

	// ex14
	public static void ex14() {

		List<PointD> list = new ArrayList<PointD>();
		list.add(new PointD(1, 1));
		list.add(new PointD(1, 10));

		list.add(new PointD(1, 1));
		list.add(new PointD(1, 0));

	}

	// ex15
	public static void ex15() {
		TestProgram tp = new TestProgram();
		tp.run();
	}

	public static void ex16() {
		// 이름과 나이를 저장하고 관리하는 클래스를 만들기
		String name = "홍길";
		int age = 21;
		Person p1 = new Person(name, age);
		String fileName = "src/day24/data.txt";

		// try 안쪽에 넣어주면 close를 알아서 해준다. 오 !
		// 다운캐스팅은 자동으로 이뤄지지 않는다.
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(p1);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person p2 = new Person();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			p2 = (Person) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(p2.toString());

	}

	public static void ex17() {
		// filewriter
		// 바이트 단위로 읽어오는 녀석.
		// 객체 생성 할 때 true 값을 넘겨주면
		// 파일이 있다면 이어서 작성한다.
		try (FileWriter fw = new FileWriter("src/day24/ex17.txt", true)) {
			fw.write('a');
			fw.write('\n');
			fw.write('c');
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

//		ex02();
//		ex03();
//		ex04();
//		ex05();
//		ex06();
//		ex07();
//		Point p1 = new Point(10, 20);
//		p1.print();
//		Point p2 = new Point();
//		p2.print();

//		int res = sum(1, 2);
//		System.out.println(res);
//		Exam e = new Exam();

//		ex15();
//		ex16();
		ex17();
	}

//	private static int sum(int i, int j) {
//		return i + j;
//	}

}

@Data
@NoArgsConstructor
class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

}

class PointD {

	int x, y;

	public PointD(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

// 추상메소드 구현
// 추상클래스로 변신
class TestProgram implements Program {

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runMenu(int menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("프로그램을 실행했습니다.");
	}

	@Override
	public void save(String fileName) {

	}

	@Override
	public void load(String fileName) {
		// TODO Auto-generated method stub

	}

}

@Data
class PointC {

	private int x, y;

	public void print() {
		System.out.println(x + " , " + y);
	}

	public PointC(int i, int j) {
		// TODO Auto-generated constructor stub
		x = i;
		y = j;
	}

	public PointC() {
		// TODO Auto-generated constructor stub
	}

}

class Point {

	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
	}

	public void print() {
		System.out.println("(" + x + "," + y + ")");
	}

}
