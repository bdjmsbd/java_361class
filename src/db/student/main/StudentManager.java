package db.student.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import db.student.controller.ScoreController;
import db.student.controller.StudentController;
import db.student.controller.SubjectController;
import program.Program;

public class StudentManager implements Program {

	private Scanner scan = new Scanner(System.in);

	private StudentController studentController = new StudentController(scan);
	private SubjectController subjectController = new SubjectController(scan);
	private ScoreController scoreController = new ScoreController(scan);

	@Override
	public void printMenu() {
		System.out.print(
				"메뉴\n"
						+ "1. 학생 관리\n"
						+ "2. 과목 관리\n"
						+ "3. 종료\n"
						+ "메뉴 선택 : ");
	}

	@Override
	public void run() {

		int menu;
		do {
			printMenu();

			menu = nextInt();

			try {
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (menu != 3);
	}

	public int nextInt() {
		try {
			return scan.nextInt();
		} catch (InputMismatchException e) {
			scan.nextLine();// 잘못 입력한 값을 입력 버퍼에 비워줌
			return Integer.MIN_VALUE;// int의 가장 작은 수를 리턴
		}
	}

	@Override
	public void runMenu(int menu) {

		switch (menu) {
			case 1:
				student();
				break;
			case 2:
				subject();
				break;
			case 3:
				exit();
				break;
			default:

		}

	}

	private void student() {
		int menu;
		do {
			printStudentMenu();
			menu = nextInt();
			runStudentMenu(menu);
		} while (menu != 5);

	}

	private void printStudentMenu() {
		System.out.print(
				"학생 관리 메뉴\n"
						+ "1. 학생 추가\n"
						+ "2. 학생 수정\n"
						+ "3. 학생 삭제\n"
						+ "4. 학생 조회\n"
						+ "5. 이전으로\n"
						+ "메뉴 선택 : ");
	}

	private void runStudentMenu(int menu) {
		switch (menu) {
			case 1:
//			studentInsert();
				studentController.insertStudent();
				break;
			case 2:
			studentUpdate();
				//studentController.updateStudent();
				break;
			case 3:
//			studentDelete();
				studentController.deleteStudent();
				break;
			case 4:
//			studnetSearch();
				studentController.selectStudent();
				break;
			case 5:
				prev();
				break;
			default:

		}

	}

	private void studentUpdate() {
		int menu;
		do {
			printStudentUpdateMenu();
			menu = nextInt();
			runStudentUpdateMenu(menu);
		} while (menu != 5);

	}

	private void printStudentUpdateMenu() {
		System.out.print(
				"학생 수정 메뉴\n"
						+ "1. 학생 정보 수정\n"
						+ "2. 성적 추가\n"
						+ "3. 성적 수정\n"
						+ "4. 성적 삭제\n"
						+ "5. 이전으로\n"
						+ "메뉴 선택 : ");

	}

	private void runStudentUpdateMenu(int menu) {
		switch (menu) {
			case 1:
				//studentInfoUpdate();
				studentController.updateStudent();
				break;
			case 2:
				//insertSubejctScore();
				scoreController.insertScore();
				break;
			case 3:
				//updateSubjectScore();
				scoreController.updateScore();
				break;
			case 4:
				scoreController.deleteScore();
				//deleteSubjectScore();
				break;
			case 5:
				prev();
				break;
			default:
				defaultPrint();
		}

	}

	private void prev() {
		System.out.println("이전으로 돌아갑니다.");
	}
	
	private void defaultPrint() {
		System.out.println("올바른 메뉴를 선택하세요.");
	}
	
	private void subject() {

		int menu;
		do {
			printSubjectMenu();
			menu = nextInt();
			runSubjectMenu(menu);
		}while(menu != 5);
		
	}

	private void printSubjectMenu() {
		System.out.print("과목 관리 메뉴\n"
				+ "1. 과목 추가\n"
				+ "2. 과목 수정\n"
				+ "3. 과목 삭제\n"
				+ "4. 과목 확인\n"
				+ "5. 이전으로\n"
				+ "메뉴 선택 : ");
	}

	private void runSubjectMenu(int menu) {
		switch (menu) {
			case 1:
//				insertSubject();
				subjectController.insertSubject();
				break;
			case 2:
				//updateSubject();
				subjectController.updateSubject();
				break;
			case 3:
				//deleteSubject();
				subjectController.deleteSubject();
				break;
			case 4:
				subjectController.searchSubject();
				break;
			case 5:
				prev();
				break;
			default:
				defaultPrint();
		}

	}

//
//	private void insertSubject() {
//		//과목명을 입력
//		System.out.print("과목 : ");
//		scan.nextLine();
//		String subject = scan.nextLine();
//		//과목 리스트에 등록된 과목인지 확인해서 등록되었으면 안내문구 출력 후 종료
//		if(subjectList.contains(subject)) {
//			System.out.println("이미 등록된 과목입니다.");
//			return;
//		}
//		//과목 리스트에 과목을 추가
//		subjectList.add(subject);
//		System.out.println("과목을 추가했습니다.");
//	}
//
//
//	private void updateSubject() {

//	}
//
//
//	private void deleteSubject() {
//		//삭제할 과목명을 입력
//		System.out.print("과목 : ");
//		scan.nextLine();
//		String subject = scan.nextLine();
//		//리스트에서 과목을 삭제해서 성공하면 알림문구 출력 후 종료
//		if(subjectList.remove(subject)) {
//			System.out.println("과목을 삭제했습니다.");
//			return;
//		}
//		//실패하면 알림문구 출력
//		System.out.println("등록되지 않은 과목입니다.");
//	}
//
//
//	private void searchSubject() {
//		System.out.println("과목 목록");
//		for(String subject : subjectList) {
//			System.out.println(subject);
//		}
//		
//	}
//
//
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
		
	}

	@Override
	public void save(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(String fileName) {
		// TODO Auto-generated method stub

	}

}
