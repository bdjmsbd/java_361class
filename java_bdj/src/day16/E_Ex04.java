package day16;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;

public class E_Ex04 {

	public static Integer sumScore(List<Student> list, Function<Student, Integer> f) {
		int sum = 0;
		for (Student tmp : list) {
			sum += f.apply(tmp);
		}
		return sum;
	}

	public static void printScore(List<Student> list, Function<Student, String> f) {
		for (Student tmp : list) {
			System.out.println(f.apply(tmp));
		}
	}

	public static void printSearch(List<Student> list, Predicate<Student> p) {

		for (Student tmp : list) {
			if (p.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}

//	public static int sumScore

	public static void main(String[] args) {

		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 1, "홍길동", 100, 20, 30));
		list.add(new Student(1, 1, 2, "고길동", 100, 100, 100));
		list.add(new Student(1, 2, 1, "둘리", 60, 60, 70));

		// 국어 평균, 영어 평균, 수학 평균을 계산해서 출력하는 코드를 작성하세요.
		int sum[] = new int[3];
		double avg[] = new double[3];

		sum[0] = sumScore(list, (p) -> p.getKor());
		sum[1] = sumScore(list, (p) -> p.getEng());
		sum[2] = sumScore(list, (p) -> p.getMath());

		for (int i = 0; i < avg.length; i++) {
			avg[i] = sum[i] / (double) avg.length;
		}

		String str = "평균 : 국어 {0}, 영어 {1}, 수학 {2}\n";
		System.out.println(MessageFormat.format(str, avg[0], avg[1], avg[2]));

		// 각 학생의 국어, 영어, 수학 성적을 출력하는 코드를 작성하세요.
		printScore(list, p -> MessageFormat.format("{3} : 국어 {0}, 영어 {1}, 수학 {2}", p.getEng(), p.getEng(), p.getMath(), p.getName()));

		// 국어 성적 80점 이상 출력
		System.out.println("<국어 성적 80점 이상>");
		printSearch(list, p -> p.getKor() > 80);
		// 1학년 1반 학생들을 출력하는 코드를 작성
		System.out.println("<1학년 1반 학생들>");
		printSearch(list, p -> p.getGrade() == 1 && p.getClassNum() == 1);
		// 1학년 1반 1번 학생을 출력하는 코드를 작성.
		System.out.println("<1학년 1반 1번 학생>");
		printSearch(list, p -> p.getGrade() == 1 && p.getClassNum() == 1 && p.getNum() == 1);

		// 정렬
		Collections.sort(list, (o1, o2) -> {
			if (o1.getGrade() != o2.getGrade())
				return o1.getGrade() - o2.getGrade();
			else if (o1.getClassNum() != o2.getClassNum())
				return o1.getClassNum() - o2.getClassNum();
			else
				return o1.getNum() - o1.getNum();
		});

		System.out.println();
		// 전체학생 출력
		printSearch(list, p -> true);
		
		// 영어 성적순으로 출력
		Collections.sort(list, (o1, o2) -> -(o1.getEng() - o2.getEng()));
		printSearch(list, p -> true);
	}

}

@Data
@AllArgsConstructor
class Student {

	private int grade, classNum, num;
	private String name;
	private int kor, eng, math;

	@Override
	public String toString() {
		return name + " => 국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + math;
	}

}