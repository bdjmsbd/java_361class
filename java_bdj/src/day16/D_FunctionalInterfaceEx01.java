package day16;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import day05.G_ArrayCoptEx01;
import lombok.AllArgsConstructor;
import lombok.Data;

public class D_FunctionalInterfaceEx01 {

	public static void print(List<Person> list, Consumer<Person> c) {
		for (Person tmp : list) {
			c.accept(tmp);
		}
	}

	// 매개변수 없이 생성해서 리턴할 때 사용
	public static Person randomPerson(Supplier<Person> p) {
		return p.get();
	}

	public static Integer randomNumber(Supplier<Integer> p) {
		return p.get();
	}

	// Function<Person, String> f Person input -> String output 형태
	public static void print2(List<Person> list, Function<Person, String> f) {
		for (Person tmp : list) {
			System.out.println(f.apply(tmp));
		}
	}

	public static Integer print22(List<Person> list, Function<Person, Integer> f) {
		int sum = 0;
		for (Person tmp : list) {
			sum += f.apply(tmp);
		}
		return sum;
	}

	// apply
	// apply 안에 인자가 들어오면 해당 인자를 람다식에서 사용한다.
	// set 함수는 특정 index에 해당 값을 넣는 것
	// 쉽게 말해 return 받은 list를 그냥 통으로 set 한 것.
	// a unary operator that always returns its input argument
	// input 과 output이 동일한 형태여야 한다.
	// 나이를 올려서 Person 객체를 넘겨줌. 그걸 그대로 받아서 list에 반영함
	public static void increaseAge(List<Person> list, UnaryOperator<Person> oper) {
		for (int i = 0; i < list.size(); i++) {
			list.set(i, oper.apply(list.get(i)));
		}
	}

//	increaseAge(list, (p1) -> {
//		p1.setAge(p1.getAge() + 1);
//		return p1;
//	});

	public static void print3(List<Person> list, Predicate<Person> p) {

		for (Person tmp : list) {
			if (p.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> list = new ArrayList<>();
		list.add(new Person("홍길동", "1", 21));
		list.add(new Person("고길동", "2", 40));
		list.add(new Person("둘리", "3", 10000));

		print(list, (c) -> {
			System.out.println(c.getName() + c.getNum());
		});

		print(list, c -> System.out.println(c.getName()));

		print(list, c -> System.out.println(c));

		Person p = randomPerson(() -> {
			int min = 0, max = 10000;
			int r = my.MyMath.randGen(min, max);
			return new Person("", "", r);
		});
		System.out.println(p);

		int i = randomNumber(() -> {
			return my.MyMath.randGen(0, 10000);
		});
		System.out.println(i);

		print2(list, (p1) -> p1.getName());

		increaseAge(list, (p1) -> {
			p1.setAge(p1.getAge() + 1);
			return p1;
		});
		System.out.println(list);

		print3(list, p1 -> p1.getAge() > 30);

		print22(list, (p1) -> p1.getAge());

		UnaryOperator<Integer> absolute = num -> num >= 0 ? num : -num;
		UnaryOperator<Integer> doubleNumber = num -> num * 2;

		System.out.println(absolute.andThen(doubleNumber).apply(-15));
	}

}

@Data
@AllArgsConstructor
class Person {

	private String name;
	private String num;
	private int age;

	@Override
	public String toString() {
		return num + " " + name + "(" + age + ")";
	}

}