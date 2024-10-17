package day17.contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import program.Program;

public class ContactManager implements Program {

	private List<Contact> list = new ArrayList<Contact>();
	private Scanner sc = new Scanner(System.in);

	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;

	@Override
	public void printMenu() {

		System.out.println("---------------------");
		System.out.println("메뉴");
		System.out.println("1.연락처 추가");
		System.out.println("2.연락처 수정");
		System.out.println("3.연락처 삭제");
		System.out.println("4.연락처 검색");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");

	}

	@Override
	public void runMenu(int menu) {
		// TODO Auto-generated method stub
		switch (menu) {
			case INSERT:
				insert();
				break;
			case UPDATE:
				update();
				break;
			case DELETE:
				delete();
				break;
			case SEARCH:
				search();
				break;
			case EXIT:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴 번호입니다.");
		}

	}

	private void update() {

		List<Contact> tmpList = searchByName();

		if (tmpList.size() == 0) {
			System.out.println("검색한 단어가 없습니다.");
		} else {
			for (int i = 0; i < tmpList.size(); i++) {
				System.out
						.println((i + 1) + "번. " + tmpList.get(i));
			}
			System.out.print("수정 할 번호 입력 : ");
			int index = sc.nextInt() - 1;
			if (index >= tmpList.size() || index < 0) {
				System.out.println("수정 취소 (번호를 잘 못 입력했습니다.)");
				return;
			}
			Contact tmp = regInfo();

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(tmpList.get(index))) {
					long count = list.stream()
							.filter(p -> p.getNumber()
									.equals(tmp.getNumber()))
							.count();
					if (count == 0 || list.get(i).getNumber()
							.equals(tmp.getNumber())) {
						list.set(i, tmp);
						System.out.println("수정되었습니다.");
						Collections.sort(list,
								(o1, o2) -> o1.getName()
										.compareTo(o2.getName()));
					} else {
						System.out.println("이미 등록된 번호입니다.");
					}
					return;
				}
			}
		}
	}

	private void delete() {
		// TODO Auto-generated method stub
		List<Contact> tmpList = searchByName();
		if (tmpList.size() == 0) {
			System.out.println("검색한 단어가 없습니다.");
		} else {
			for (int i = 0; i < tmpList.size(); i++) {
				System.out
						.println((i + 1) + "번. " + tmpList.get(i));
			}
			System.out.print("삭제 할 번호 입력 : ");
			int index = sc.nextInt() - 1;
			if (index >= tmpList.size() || index < 0) {
				System.out.println("삭제 취소 (번호를 잘 못 입력했습니다.)");
				return;
			}

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(tmpList.get(index))) {
					list.remove(i);
					System.out.println("삭제되었습니다.");
					return;
				}
			}
		}
	}

	private void insert() {
		// 이름, 번호를 입력 받고 등록된 번호인 지 확인 후
		// 이미 등록되었다면 출력 후 종료. 등록되지 않았으면 등록한다.

		Contact reg = regInfo();
		if (list.stream()
				.filter(p -> p.getNumber().equals(reg.getNumber()))
				.count() != 0) {
			System.out.println("이미 등록된 번호입니다.");
		} else {
			list.add(reg);
			System.out.println("등록 되었습니다.");
			Collections.sort(list,
					(o1, o2) -> o1.getName().compareTo(o2.getName()));
		}

	}

	private Contact regInfo() {

		String regNum, regName;
		System.out.println("이름 입력 : ");
		regName = sc.next();
		System.out.println("번호 입력 : ");
		regNum = sc.next();

		return new Contact(regNum, regName);
	}

	private List<Contact> searchByName() {

		// 원하는 단어를 입력하면 입력한 단어가 포함된 연락처를 콘솔에 출력
		System.out.print("검색할 단어 입력 [전체검색 Enter] : ");
		String tmpStr = sc.nextLine();
		System.out.println("---------------------");
		List<Contact> tmpList = list.stream()
				.filter(p -> p.getName().contains(tmpStr))
				.collect(Collectors.toList());

		return tmpList;
	}

	private void search() {

		List<Contact> tmpList = searchByName();

		if (tmpList.size() == 0)
			System.out.println("검색한 단어가 없습니다.");
		else
			System.out.println(tmpList);
//		boolean isExist = false;
//		for (Contact tmp : list) {
//			if (tmp.getName().contains(tmpStr)) {
//				System.out.println(tmp);
//				isExist = true;
//			}
//		}
//		if (!isExist)
//			System.out.println("검색한 단어가 없습니다.");

	}

	@Override
	public void run() {
		String fileName = "src/day17/contact/contact.txt";

		load(fileName);

		System.out.println(list);
		// javadoc -> 특정한 배열에 의해 백업된 고정된 크기의 List를 반환
		// asList로 List에 값을 넣어주면 그 후에 값이 추가가 안됨
		// new ArrayList<> 다시 할당해주기!
//		list = new ArrayList<>(Arrays.asList(
//				new Contact("010-1111-2222", "홍길동"),
//				new Contact("010-2222-3333", "고길동"),
//				new Contact("010-1234-5678", "둘리"),
//				new Contact("010-4444-2222", "하니")));
//		System.out.println(list);
		int menuNum = -1;
		do {

			printMenu();

			try {
				menuNum = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("올바른 메뉴 번호를 입력하세요.");
				sc.nextLine();
				continue;
			}

			sc.nextLine();
			runMenu(menuNum);

		} while (menuNum != 5);

		save(fileName);
	}

	@Override
	public void save(String fileName) {

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(fileName))) {
//			for (Contact tmp : list) {
//				oos.writeObject(tmp);
//			}
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
	@Override
	public void load(String fileName) {
		try (
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(
						fis)) {

			list = (List<Contact>) ois.readObject();

//			Contact tmp;
//			do {
//				tmp = (Contact) ois.readObject();
//				if (tmp != null) {
//					list.add(tmp);
//				}
//			} while (tmp != null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
