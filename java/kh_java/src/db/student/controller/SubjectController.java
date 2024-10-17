package db.student.controller;

import java.util.ArrayList;
import java.util.Scanner;

import db.student.model.vo.SubjectVO;
import db.student.service.StudentServiceImp;
import db.student.service.SubjectServiceImp;

// ctrl + shift + o
public class SubjectController { // 인터페이스로 선언.

	private SubjectServiceImp subjectService = new SubjectServiceImp();
	private StudentServiceImp studentService = new StudentServiceImp();

	private Scanner scan;

	public SubjectController(Scanner scan) {
		this.scan = scan;
	}

	public void insertSubject() {

		System.out.print("과목 : ");
		scan.nextLine();

		String subject = scan.nextLine();

		if (subjectService.insertSubject(subject)) {

		} else {

		}

	}

	public void updateSubject() {
		// 수정할 과목을 입력
		System.out.print("과목 : ");
		scan.nextLine();
		String subject = scan.nextLine();

		// 새 과목명 입력
		System.out.print("새 과목 : ");
		String newSubject = scan.nextLine();

		// 수정할 과목이 있는지 없는지 확인해서 없으면 알림 문구 출력후 종료
		if (subjectService.updateSubject(subject, newSubject)) {
			System.out.println("과목을 수정했습니다.");
		} else {
			System.out.println("입력한 과목으로 수정할 수 없습니다.");
		}
	}

	public void deleteSubject() {
		// 삭제할 과목을 입력
		System.out.print("과목 : ");
		scan.nextLine();
		String subject = scan.nextLine();

		// 삭제할 과목이 있는지 없는지 확인해서 없으면 알림 문구 출력후 종료
		if (subjectService.deleteSubject(subject)) {
			System.out.println("과목을 삭제했습니다.");
		} else {
			System.out.println("등록되지 않은 과목입니다.");
		}

	}

	public void searchSubject() {

		ArrayList<SubjectVO> list = subjectService.selectSubjectNameList();

		if (list.size() == 0) {
			System.out.println("등록된 과목이 없습니다.");
			return;
		} else {
			for (SubjectVO subject : list) {
				System.out.println(subject.getSu_name());
			}
		}
	}

}
