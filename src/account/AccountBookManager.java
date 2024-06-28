package account;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import day22.student.Student;
import program.Program;

public class AccountBookManager implements Program {

	List<AccountBook> list = new ArrayList<AccountBook>();
	Scanner sc = new Scanner(System.in);

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("메뉴");
		System.out.println("1. 내역 입력");
		System.out.println("2. 내역 수정");
		System.out.println("3. 내역 삭제");
		System.out.println("4. 내역 조회");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");

	}

	@Override
	public void runMenu(int menu) {
		// TODO Auto-generated method stub

		switch (menu) {
			case 1:
				insertAccountBook();
				break;
			case 2:

				updateAccountBook();
				break;
			case 3:
				deleteAccountBook();
				break;
			case 4:
				serachAccountBook();
				break;
			case 5:
				exitPrint();
				break;
			default:
				defaultPrint();

		}

	}

	private AccountBook inputAccountBook() {
		String date, type, group, memo;
		int amount;

		System.out.print("날짜 : ");
		date = sc.next();
		System.out.print("수입/지출 : ");
		type = sc.next();
		System.out.print("분류 (월급 용돈, 부수입, 지출) : ");
		group = sc.next();
		System.out.print("금액 : ");
		amount = sc.nextInt();
		System.out.print("내용 : ");
		sc.nextLine();
		memo = sc.nextLine();

		return new AccountBook(date, type, group, amount, memo);
	}

	private void insertAccountBook() {
		System.out.println("<내역 입력>");
		// <내역 입력>
		// 날짜 : 2024-06-10
		// 수입/지출 : `수입
		// 분류 (월급, 용돈, 부수입): `월급
		// 금액 : `3000000
		// 내용 : `6월 월급

		AccountBook newAccountBook = inputAccountBook();
		if (list.contains(newAccountBook)) {
			System.out.println("이미 등록된 내역입니다.");
			return;
		}
		list.add(newAccountBook);
		System.out.println("내역이 추가되었습니다.");
		Collections.sort(list, (o1, o2) -> o1.getDate().compareTo(o2.getDate()));
	}

	private void updateAccountBook() {
		// TODO Auto-generated method stub
		System.out.println("<내역 수정>");
		if (list.size() == 0) {
			System.out.println("수정할 내역이 없습니다.");
			return;
		}
		System.out.println("날짜 : ");
		String date = sc.next();

		List<Integer> indexList = getIndexList(date);

		if (indexList.size() == 0) {
			System.out.println("해당 날짜에 내역이 없습니다.");
			return;
		}
		System.out.print("내역 선택 : ");
		int index = indexList.get(sc.nextInt() - 1);

		AccountBook newAccountBook = inputAccountBook();
		if (list.contains(newAccountBook) && !list.get(index).equals(newAccountBook)) {
			System.out.println("이미 등록된 내역입니다.");
			return;
		}

		list.add(newAccountBook);
		list.remove(index);
		System.out.println("내역이 수정되었습니다.");
		Collections.sort(list, (o1, o2) -> o1.getDate().compareTo(o2.getDate()));

	}

	private List<Integer> getIndexList(String date) {
		// TODO Auto-generated method stub
		List<Integer> tmp = new ArrayList<Integer>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getDate().equals(date)) {
				tmp.add(i);
				System.out.println(tmp.size() + ". " + list.get(i));
			}
		}
		return tmp;
	}

	private void deleteAccountBook() {
		// TODO Auto-generated method stub
		System.out.println("<내역 삭제>");
		if (list.size() == 0) {
			System.out.println("삭제할 내역이 없습니다.");
			return;
		}
		System.out.println("날짜 : ");
		String date = sc.next();

		List<Integer> indexList = getIndexList(date);

		if (indexList.size() == 0) {
			System.out.println("해당 날짜에 내역이 없습니다.");
			return;
		}
		System.out.print("내역 선택 : ");
		int index = sc.nextInt();

		list.remove(index - 1);
		System.out.println("내역이 삭제되었습니다.");

	}

	private void serachAccountBook() {
		// TODO Auto-generated method stub
		System.out.println("<내역 조회>");
		if (list.size() == 0) {
			System.out.println("조회할 내역이 없습니다.");
			return;
		}
		sc.nextLine();
		System.out.println("날짜 (전체조회 Enter): ");
		String date = sc.nextLine();

		for (AccountBook tmp : list) {
			if (tmp.getDate().contains(date)) {
				System.out.println(tmp);
			}
		}
	}

	private void exitPrint() {
		// TODO Auto-generated method stub

		System.out.println("종료합니다.");
	}

	private void defaultPrint() {
		// TODO Auto-generated method stub
		System.out.println("잘못된 메뉴를 선택하셨습니다.");

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String fileName = "src/account/date.txt";
		load(fileName);
		int menuNum;

		do {
			printMenu();
			menuNum = sc.nextInt();
			runMenu(menuNum);

		} while (menuNum != 5);

		save(fileName);

	}

	@Override
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

	@Override
	@SuppressWarnings("unchecked")
	public void load(String fileName) {
		try (
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(
						fis)) {
			list = (List<AccountBook>) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
