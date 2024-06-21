package day18.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MemberScheduleManager {

	private List<Member> list = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);

	public void printMainMenu() {

		System.out.println("---------------------");
		System.out.println("메인 메뉴");
		System.out.println("1.회원 관리");
		System.out.println("2.일정 관리");
		System.out.println("3.프로그램 종료");
		System.out.print("메뉴 선택 : ");

	}

	public void printMemberMenu() {

		System.out.println("---------------------");
		System.out.println("회원 메뉴");
		System.out.println("1.회원 추가");
		System.out.println("2.회원 수정");
		System.out.println("3.회원 삭제");
		System.out.println("4.이전으로");
		System.out.print("메뉴 선택 : ");

	}

	public void printScheduleMenu() {

		System.out.println("---------------------");
		System.out.println("일정 메뉴");
		System.out.println("1.일정 추가");
		System.out.println("2.일정 수정");
		System.out.println("3.일정 삭제");
		System.out.println("4.일정 확인");
		System.out.println("5.이전으로");
		System.out.print("메뉴 선택 : ");

	}

	public void runMainMenu(int menu) {
		// TODO Auto-generated method stub
		int menuNum;

		switch (menu) {
			case 1:
				System.out.println("1.회원 관리");
				printMemberMenu();
				menuNum = sc.nextInt();
				runMemberMenu(menuNum);
				break;
			case 2:
				System.out.println("2.일정 관리");
				printScheduleMenu();
				menuNum = sc.nextInt();
				runScheduleMenu(menuNum);
				break;
			case 3:
				System.out.println("3.프로그램 종료");
				break;
			default:
				System.out.println("잘못된 메뉴 번호입니다.");
		}

	}

	public void runMemberMenu(int menu) {

		switch (menu) {
			case 1:
				System.out.println("1.회원 추가");
				insertMember();
				break;
			case 2:
				System.out.println("2.회원 수정");
				updateMember();
				break;
			case 3:
				System.out.println("3.회원 삭제");
				deleteMember();
				break;
			case 4:
				System.out.println("4. 이전으로");
				break;
			default:
				System.out.println("잘못된 메뉴 번호입니다.");
		}

	}

	public void runScheduleMenu(int menu) {
		// TODO Auto-generated method stub

		switch (menu) {
			case 1:
				System.out.println("1.일정 추가");
				insertSchedule();
				break;
			case 2:
				System.out.println("2.일정 수정");
				updateSchedule();
				break;
			case 3:
				System.out.println("3.일정 삭제");
				deleteSchedule();
				break;
			case 4:
				System.out.println("4.일정 확인");
				searchSchedule();
				break;
			case 5:
				System.out.println("5. 이전으로");
				break;
			default:
				System.out.println("잘못된 메뉴 번호입니다.");
		}
	}

	private void searchSchedule() {
		// TODO Auto-generated method stub

		Member tmp = checkID();

		if (tmp != null) {
			String date;

			System.out.print("날자(yyyy-MM-dd) : ");
			date = sc.nextLine();

			for (int i = 0; i < tmp.getSchedules()
					.size(); i++) {
				if (tmp.getSchedules().get(i).getDate()
						.contains(date))
					System.out.println(
							i + 1 + ". " + tmp.getSchedules().get(i));
			}

		} else {
			System.out.println("등록되지 않은 회원입니다.");
		}

	}

	private void deleteSchedule() {

		Member tmp = checkID();
		if (tmp != null) {

			String date;
			System.out.print("날자(yyyy-MM-dd) : ");
			date = sc.nextLine();

			List<Integer> scheduleSize = new ArrayList<Integer>();
			for (int i = 0; i < tmp.getSchedules().size(); i++) {
				if (tmp.getSchedules().get(i).getDate()
						.contains(date)) {
					scheduleSize.add(i);
					System.out.println(scheduleSize.size() + ". "
							+ tmp.getSchedules().get(i));
				}
			}
			if (scheduleSize.size() > 0) {
				System.out.print("삭제할 일정 선택 : ");
				int updateNum = sc.nextInt() - 1;

				tmp.getSchedules().remove(updateNum);
				System.out.println("삭제가 완료 되었습니다.");
			} else {
				System.out.println("삭제할 일정이 없습니다.");
			}
		} else {
			System.out.println("등록되지 않은 회원입니다.");
		}

	}

	private void updateSchedule() {

		Member tmp = checkID();
		if (tmp != null) {

			String date;
			System.out.print("날자(yyyy-MM-dd) : ");
			date = sc.next();

			List<Integer> scheduleIndex = new ArrayList<Integer>();
			for (int i = 0; i < tmp.getSchedules().size(); i++) {
				if (tmp.getSchedules().get(i).getDate()
						.contains(date)) {
					scheduleIndex.add(i);
					System.out.println(scheduleIndex.size() + ". "
							+ tmp.getSchedules().get(i));
				}
			}

			if (scheduleIndex.size() > 0) {
				System.out.print("수정할 일정 선택 : ");
				int updateNum = sc.nextInt() - 1;

				Schedule updateSchedule = regScheduleInfo();
				tmp.getSchedules().set(updateNum, updateSchedule);

				System.out.println("수정이 완료 되었습니다.");
			} else {
				System.out.println("수정할 일정이 없습니다.");
			}
		} else {
			System.out.println("등록되지 않은 회원입니다.");
		}

	}

	private void insertSchedule() {

		Member tmp = checkID();

		if (tmp != null) {
			Schedule newSchedule = regScheduleInfo();
			tmp.insertSchedules(newSchedule);
			System.out.println("일정이 추가되었습니다.");
		} else {
			System.out.println("등록되지 않은 회원입니다.");
		}

	}

	private Member checkID() {
		/*
		 * 
		 * Member tmp = checkID(); if (tmp != null) { } else {
		 * System.out.println("등록되지 않은 회원입니다."); }
		 */
		String id;

		System.out.println("아이디 : ");
		id = sc.next();

		for (Member tmp : list) {
			if (tmp.getId().equals(id)) {

				return tmp;
			}
		}
		return null;
	}

	private void deleteMember() {

		String id;

		System.out.println("아이디 : ");
		id = sc.next();

		boolean isIDExist = false;
		for (Member tmp : list) {
			if (tmp.getId().equals(id)) {
				list.remove(tmp);
				System.out.println("삭제가 완료 되었습니다.");
				isIDExist = true;
				break;
			}
		}
		if (!isIDExist) {
			System.out.println("등록되지 않은 회원입니다.");
		}

	}

	private void updateMember() {

		String id, newName;

		System.out.println("아이디 : ");
		id = sc.next();

		boolean isIDExist = false;
		for (Member tmp : list) {
			if (tmp.getId().equals(id)) {
				System.out.println("수정할 이름 : ");
				newName = sc.next();
				tmp.setName(newName);

				System.out.println("수정이 완료 되었습니다.");
				isIDExist = true;
				break;
			}
		}
		if (!isIDExist) {
			System.out.println("등록되지 않은 회원입니다.");
		}

	}

	private void insertMember() {
		// 추가할 회원 정보 입력
		// 아이디 : abc13
		// 이름 : 홍길동
		// 아이디가 있는 지 검사 후 없다면
		// 회원이 추가 됐습니다.
		// 이미 등록된 아이디입니다.(종료)

		Member newMember = regMemberInfo();

		boolean isIDExist = false;
		for (Member tmp : list) {
			if (tmp.getId().equals(newMember.getId())) {
				isIDExist = true;
				break;
			}
		}
		if (isIDExist) {
			System.out.println("이미 등록된 아이디입니다.");
		} else {
			list.add(newMember);
			System.out.println("회원이 추가 됐습니다.");
		}

	}

	private Schedule regScheduleInfo() {

		sc.nextLine();
		String date, content, detail;
		System.out.print("날짜(yyyy-MM-dd hh:mm) : ");
		date = sc.nextLine();
		System.out.print("일정 : ");
		content = sc.nextLine();
		System.out.print("상세 : ");
		detail = sc.nextLine();

		return new Schedule(date, content, detail);
	}

	private Member regMemberInfo() {

		String newID, newName;
		System.out.println("추가할 회원 정보 입력");
		System.out.print("아이디 : ");
		newID = sc.next();
		System.out.print("이름 : ");
		newName = sc.next();

		return new Member(newID, newName);
	}

	public void run() {
		String fileName = "src/day18/homework/schedule.txt";

		load(fileName);

		System.out.println(list);

		int menuNum = -1;
		do {

			printMainMenu();

			try {
				menuNum = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("올바른 메뉴 번호를 입력하세요.");
				sc.nextLine();
				continue;
			}

			sc.nextLine();
			runMainMenu(menuNum);

		} while (menuNum != 3);

		save(fileName);
	}

	public void save(String fileName) {

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(fileName))) {
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void load(String fileName) {
		try (
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(
						fis)) {

			list = (List<Member>) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
