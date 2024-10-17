package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class A_StreamEx01 {

	public static void main(String[] args) {

		List<Person> list = Arrays.asList(
				new Person("홍길동", 21, "남"),
				new Person("임꺽정", 40, "남"),
				new Person("유관순", 18, "여"),
				new Person("황진이", 20, "여"));
//		list.add(new Person("g",0,"f"));

		Stream<Person> stream = list.stream();

		stream.filter(p -> p.getAge() >= 20)
				.filter(p -> p.getGender().equals("남"))
				.forEach(p -> System.out.println(p));

		// Stream은 재사용이 불가하다.
		// java.lang.IllegalStateException
//		stream.filter(p -> p.getAge() >= 20)
//		.filter(p -> p.getGender().equals("남"))
//		.forEach(p -> System.out.println(p));

		stream = list.stream();
		stream.map((p) -> p.getName())
				.forEach(p -> System.out.println(p));

		stream = list.stream();
		long c = stream.filter(p -> p.getGender().equals("여"))
				.count();
		System.out.println("등록된 여성의 수 : " + c);

		stream = list.stream();
		long c2 = stream.filter(p -> p.getAge() >= 20).count();
		System.out.println("등록된 성인의 수 : " + c2);

		stream = list.stream();

//		OptionalDouble ageAver = stream
//				.mapToInt(p -> p.getAge()).average();
		OptionalDouble ageAver = stream
				.mapToInt(Person::getAge).average();

		// result가 0일 떄 나이 평균이 0인 지, 없어서 0인 지 구분할 수 없기에 조치
		if (ageAver.isPresent())
			System.out
					.println("나이 평균 : " + ageAver.getAsDouble());
		else
			System.out.println("리스트에 사람이 없습니다");
		
		stream = list.stream();
		List<Person> list2 = stream.filter(p->p.getAge()>20).collect(Collectors.toList());
		System.out.println(list2);

	}

}

@Data
@AllArgsConstructor
class Person {

	private String name;
	private int age;
	private String gender;

}