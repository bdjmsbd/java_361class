package day22.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import program.Program;

// indexOf는 equals 메소드를 통해서 인덱스를 불러온다.
// => equals를 오버로딩하면 indexOf를 쉽게 활용할 수 있다.

public class StudentManager implements Program {

	List<Student> list = new ArrayList<Student>();
	List<String> subjectList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	final int FULL = 1;
	final int SEMI = 2;
	final int SCORE = 3;
	final int NUMBER_INIT = -1;
	final int FAILED_INDEXOF = -1;

	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 관리");
		System.out.println("2. 과목 관리");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");

	}

	public void printStudentMenu() {
		System.out.println("<학생 관리메뉴>");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 학생 조회");
		System.out.println("5. 이전으로");
		System.out.print("메뉴 선택 : ");

	}

	public void printStudentUpdateMenu() {
		System.out.println("<학생 정보 수정>");
		System.out.println("1. 학생 정보 수정");
		System.out.println("2. 성적 추가");
		System.out.println("3. 성적 수정");
		System.out.println("4. 성적 삭제");
		System.out.println("5. 이전으로");
		System.out.print("메뉴 선택 : ");

	}

	public void printSubjectMenu() {
		System.out.println("<과목 관리메뉴>");
		System.out.println("1. 과목 추가");
		System.out.println("2. 과목 수정");
		System.out.println("3. 과목 삭제");
		System.out.println("4. 과목 조회");
		System.out.println("5. 이전으로");
		System.out.print("메뉴 선택 : ");

	}

	public void runStudentUpdateMenu(int menu) {

		switch (menu) {
			case 1:
				updateStudent();
				break;
			case 2:
				insertSubjectScore();
				break;
			case 3:
				updateSubjectScore();
				break;
			case 4:
				deleteSubjectScore();
				break;
			case 5:
				prevPrint();
				break;
			default:
				defaultPrint();
		}
	}

	@Override
	// 콘솔에 입력받아 정수로 저장하는 메소드
	// success 실패시 NUMBER_INIT
	public void runMenu(int menu) {
		int menuNum = NUMBER_INIT;

		switch (menu) {
			case 1:
				do {
					printStudentMenu();
					try {
						menuNum = sc.nextInt();
						runStudentMenu(menuNum);
					} catch (Exception e) {
						defaultPrint();
						sc.nextLine();
					}

				} while (menuNum != 5);
				break;
			case 2:
				do {
					printSubjectMenu();
					try {
						menuNum = sc.nextInt();
						runSubjectMenu(menuNum);
					} catch (Exception e) {
						defaultPrint();
						sc.nextLine();
					}
				} while (menuNum != 5);
				break;
			case 3:
				exitPrint();
				break;
			default:
				defaultPrint();
		}

	}

	public void runSubjectMenu(int menu) {

		switch (menu) {
			case 1:
				insertSubject();
				break;
			case 2:
				updateSubject();
				break;
			case 3:
				deleteSubject();
				break;
			case 4:
				searchSubject();
				break;
			case 5:
				prevPrint();
				break;
			default:
				defaultPrint();
		}
	}

	private void insertSubjectScore() {
		// 학생 정보( 학년, 반, 번호) 입력 객체 생성
		System.out.println("<학생 성적 추가>");

		if (subjectList.size() == 0) {
			System.out.println("[등록된 과목이 없습니다.]");
			return;
		}
		Student studentInfo = inputStudentInfo(SEMI);
		int index = list.indexOf(studentInfo);

		if (index == -1) {
			System.out.println("[등록된 학생이 없습니다.]");
			return;
		}
		for (Subject subject : list.get(index).getSubjectList()) {
			System.out.println(subject);
		}

		Subject newSubject = inputSubjectInfo(FULL);
		if (!subjectList.contains(newSubject.getName())) {
			System.out.println("[등록된 과목이 아닙니다. 과목 등록을 먼저 해주세요.]");
			return;
		}
		if (list.get(index).getSubjectList().contains(newSubject)) {
			System.out.println("[과목 성적이 이미 등록되어 있습니다.]");
			return;
		}

		list.get(index).getSubjectList().add(newSubject);
		System.out.println("[과목 성적이 등록되었습니다.]");

	}

	private Subject inputSubjectInfo(int type) {
		// TODO Auto-generated method stub

		// 학년, 학기, 과목명, 중간 ,기말, 수행평가 입력 후 객체 생성
		int grade, semester, mTerm, fTerm, pv;
		grade = semester = mTerm = fTerm = pv = 0;
		String name = "";
		sc.nextLine();
		do {
			try {

				if (type == FULL || type == SEMI) {
					System.out.print("과목명 입력 : ");
					name = sc.nextLine();
					System.out.print("학년 입력 : ");
					grade = sc.nextInt();
					System.out.print("학기 입력 : ");
					semester = sc.nextInt();
					if (type == SEMI) {
						return new Subject(name, grade, semester);
					}
				} // Score Only
				System.out.print("중간 입력 : ");
				mTerm = sc.nextInt();
				System.out.print("기말 입력 : ");
				fTerm = sc.nextInt();
				System.out.print("수행평가 입력 : ");
				pv = sc.nextInt();
				return new Subject(name, grade, semester, mTerm, fTerm, pv);

			} catch (Exception e) {
				System.out.println("제대로 입력하세요.");
				sc.nextLine();
			}
		} while (true);

	}

	private void updateSubjectScore() {
		// TODO Auto-generated method stub
		System.out.println("<학생 성적 수정>");

		if (subjectList.size() == 0) {
			System.out.println("[등록된 과목이 없습니다.]");
			return;
		}
		Student studentInfo = inputStudentInfo(SEMI);
		int studentIndex = list.indexOf(studentInfo);

		if (studentIndex == FAILED_INDEXOF) {
			System.out.println("[등록된 학생이 없습니다.]");
			return;
		}
		for (Subject subject : list.get(studentIndex).getSubjectList()) {
			System.out.println(subject);
		}

		Subject updateSubject = inputSubjectInfo(SEMI);
		if (!subjectList.contains(updateSubject.getName())) {
			System.out.println("[등록된 과목이 아닙니다.]");
			return;
		}

		if (!list.get(studentIndex).getSubjectList().contains(updateSubject)) {
			System.out.println("[등록된 과목 성적이 없습니다.]");
			return;
		}

		// 검색한 학생이 있고, 검색한 과목이 있고, 학생이 해당 과목의 성적이 있으면
		// 학생 성적 수정 조건에 부합한다.

		int subjectIndex = list.get(studentIndex).getSubjectList().indexOf(updateSubject);
		Subject scoreSubject = inputSubjectInfo(SCORE);
		list.get(studentIndex).getSubjectList().get(subjectIndex)
				.updateScore(scoreSubject.getMTerm(), scoreSubject.getFTerm(), scoreSubject.getPEval());

		System.out.println("[과목 성적이 수정 되었습니다.]");

	}

	private void deleteSubjectScore() {
		// 학생 정보를 입력하여 객체를 생성
		// 학생 리스트에서 학생 객체가 몇번지에 있는 지 번지를 가져옴
		// 번지가 유효하지 않으면 종료
		// 번지에 있는 학생 객체를 가져옴
		// 학생의 과목 리스트를 가져옴
		// 삭제할 과목, 학년, 학기 정보 입력
		// 과목이 과목리스트에 없으면 종료
		// 과목이
		System.out.println("<학생 성적 삭제>");

		if (subjectList.size() == 0) {
			System.out.println("[등록된 과목이 없습니다.]");
			return;
		}
		Student studentInfo = inputStudentInfo(SEMI);
		int index = list.indexOf(studentInfo);

		if (index == FAILED_INDEXOF) {
			System.out.println("[등록된 학생이 없습니다.]");
			return;
		}
		for (Subject subject : list.get(index).getSubjectList()) {
			System.out.println(subject);
		}

		Subject deleteSubject = inputSubjectInfo(SEMI);
		if (!subjectList.contains(deleteSubject.getName())) {
			System.out.println("[등록된 과목이 아닙니다.]");
			return;
		}
		if (!list.get(index).getSubjectList().contains(deleteSubject)) {
			System.out.println("[등록된 과목 성적이 없습니다.]");
			return;
		}

		list.get(index).getSubjectList().remove(deleteSubject);
		System.out.println("[과목 성적이 삭제되었습니다.]");

	}

	private void prevPrint() {
		System.out.println("[이전으로 돌아갑니다.]");
	}

	private void defaultPrint() {
		System.out.println("[잘못된 메뉴를 입력하였습니다.]");
	}

	private void exitPrint() {
		System.out.println("[프로그램을 종료합니다.]");
	}

	public String inputSubject() {

//		Subject tmp = new Subject(null);
		System.out.print("과목명 입력 : ");
		String tmp = sc.next();

		return tmp;
	}

	private void insertSubject() {
		// 과목명 입력
		// 과목리스트에 있는 지 확인
		// 과목 리스트에 과목을 추가
		System.out.println("<과목 추가>");

		String tmpSubject = inputSubject();
		if (subjectList.contains(tmpSubject)) {
			System.out.println("[이미 등록된 과목입니다.]");
			return;
		}
		subjectList.add(tmpSubject);
		System.out.println("[과목이 등록되었습니다.]");

	}

	private void updateSubject() {
		System.out.println("<과목 수정>");

		String tmpSubject = inputSubject();
		if (!subjectList.contains(tmpSubject)) {
			System.out.println("[등록되지 않은 과목입니다.]");
			return;
		}

		String newSubject = inputSubject();
		if (subjectList.contains(newSubject)) {
			System.out.println("[이미 등록된 과목입니다.]");
			return;
		}
		subjectList.remove(tmpSubject);
		subjectList.add(newSubject);

		System.out.println("[과목이 수정되었습니다.]");

	}

	private void deleteSubject() {
		// TODO Auto-generated method stub
		System.out.println("<과목 삭제>");
		String tmpSubject = inputSubject();

		if (subjectList.remove(tmpSubject)) {
			System.out.println("[과목을 삭제했습니다.]");
			return;
		}
		System.out.println("[등록되지 않은 과목입니다.]");

	}

	private void searchSubject() {
		// TODO Auto-generated method stub

		for (String tmp : subjectList) {
			System.out.println(tmp);
		}

	}

	public void runStudentMenu(int menu) {

		int menuNum = NUMBER_INIT;
		switch (menu) {
			case 1:
				insertStudent();
				break;
			case 2:
				do {
//				updateStudent();
					printUpdateStudentMenu();
					try {
						menuNum = sc.nextInt();
						runStudentUpdateMenu(menuNum);
					} catch (Exception e) {
						defaultPrint();
					}
				} while (menuNum != 5);
				break;
			case 3:
				deleteStudent();
				break;
			case 4:
				searchStudent();
				break;
			case 5:
				exitPrint();
				break;
			default:
				defaultPrint();
		}
	}

	public Student inputStudentInfo(int inputType) {

		String name = "";
		int grade, classNum, num;
		do {
			try {
				System.out.print("학년 : ");
				grade = sc.nextInt();
				System.out.print("반 : ");
				classNum = sc.nextInt();
				System.out.print("번호 : ");
				num = sc.nextInt();
				if (inputType == FULL) {
					sc.nextLine();
					System.out.print("이름 : ");
					name = sc.nextLine();
				}
				break;
			} catch (Exception e) {
				System.out.println("[학년, 반, 번호, 이름을 제대로 입력하세요.]");

				sc.nextLine();
			}
		} while (true);

		return new Student(grade, classNum, num, name);
	}

	public Student matchStudent(Student stu) {
		for (Student tmp : list) {
			if (tmp.equals(stu))
				return tmp;
		}
		return null;
	}

	private void insertStudent() {
		System.out.println("<학생 등록>");
		Student tmp = inputStudentInfo(FULL);
		if (list.indexOf(tmp) != FAILED_INDEXOF) {
			System.out.println("[이미 등록되어 있는 학생입니다.]");
			return;
		}
		list.add(tmp);
		System.out.println("[학생이 등록되었습니다.]");

		Collections.sort(list);

	}

	private void printUpdateStudentMenu() {
		System.out.println("<학생 수정 메뉴>");
		System.out.println("1. 학생 정보 수정");
		System.out.println("2. 성적 추가");
		System.out.println("3. 성적 수정");
		System.out.println("4. 성적 삭제");
		System.out.println("5. 이전으로");
		System.out.print("메뉴 선택 : ");
	}

	private void updateStudent() {
		System.out.println("<학생 수정>");

		Student tmp = inputStudentInfo(SEMI);
		int index = list.indexOf(tmp);
		if (index == FAILED_INDEXOF) {
			System.out.println("[등록되어 있지 않은 학생입니다.]");
			return;
		}
		System.out.println("수정할 정보 입력");
		tmp = inputStudentInfo(FULL);
		// list에 이미 있고, 그게 내가 아니라면
		if (list.indexOf(tmp) != FAILED_INDEXOF && !list.get(index).equals(tmp)) {
			System.out.println("[이미 등록되어 있는 학생입니다.]");
			return;
		}
		list.get(index).update(tmp);

		System.out.println("[학생 정보가 수정 되었습니다.]");

		Collections.sort(list);

	}

	private void deleteStudent() {
		System.out.println("<학생 삭제>");

		Student tmp = inputStudentInfo(SEMI);
		Student studentInfo = matchStudent(tmp);
		if (studentInfo == null) {
			System.out.println("[등록되어 있지 않은 학생입니다.]");
			return;
		}
		list.remove(studentInfo);
		System.out.println("[학생 정보가 삭제 되었습니다.]");

	}

	private void searchStudent() {
		System.out.println("<학생 조회>");
		// TODO Auto-generated method stub
//		System.out.println(list);
		for (Student tmp : list)
			System.out.println(tmp);

	}

	@Override
	public void run() {

		String fileName = "src/day22/student/data.txt";
		load(fileName);

		int menuNum = NUMBER_INIT;
		do {
			printMenu();
			try {
				menuNum = sc.nextInt();
				runMenu(menuNum);
			} catch (Exception e) {
				defaultPrint();
			}

		} while (menuNum != 3);

		save(fileName);

	}

	@Override
	public void save(String fileName) {

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(fileName))) {
			oos.writeObject(list);
			oos.writeObject(subjectList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public void load(String fileName) {
		try (
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(
						fis)) {
			list = (List<Student>) ois.readObject();
			subjectList = (List<String>) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
