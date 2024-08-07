package db.student.controller;

import java.util.Scanner;

import db.student.model.vo.StudentVO;
import db.student.service.StudentServiceImp;
import db.student.service.SubjectServiceImp;

// ctrl + shift + o
public class StudentController { // 인터페이스로 선언.

	private StudentServiceImp studentService = new StudentServiceImp();
	private SubjectServiceImp subjectService = new SubjectServiceImp();

	private Scanner scan;

	public StudentController(Scanner scan) {
		this.scan = scan;
	}

	public void insertStudent() {

		// 입력한 정보를 이용하여 객체를 생성
		StudentVO std = inputStudentExpand();

		// 학생 추가에 성공하면 성공했다고 알림, 실패하면 실패했다고 알림
		if (studentService.insertStudent(std)) {
			System.out.println("학생이 추가되었습니다.");
		} else {
			System.out.println("이미 등록된 학생 정보여서 추가하지 못했습니다.");
		}
	}

	private StudentVO inputStudentExpand() {
		StudentVO std = inputStudent();

		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		std.setSt_name(name);
		return std;
	}

	private StudentVO inputStudent() {
		// 학년, 반, 번호, 이름을 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		return new StudentVO(grade, classNum, num, "");
	}

	public void updateStudent() {

		StudentVO std = inputStudent();

		if (studentService.contains(std)) {
//			System.out.println("일치하는 학생이 없습니다.");
			return;
		}

		StudentVO newStd = inputStudentExpand();

		if (studentService.updateStudent(std, newStd)) {
			System.out.println("학생 정보를 수정했습니다.");
			return;
		}
		System.out.println("이미 등록된 학생 정보로 수정할 수 없습니다.");
	}

	public void deleteStudent() {

		StudentVO std = inputStudent();

		if (studentService.contains(std)) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}

		if (studentService.deleteStudent(std)) {
			System.out.println("학생 정보를 삭제했습니다.");
			return;
		}

	}

	public void selectStudent() {

		StudentVO std = inputStudent();

		StudentVO dbStd = studentService.selectStudent(std);
		if (dbStd == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println(dbStd);

		// 학생 성적을 가져옴

		// 가져온 학생 성적을 출력

	}

}
