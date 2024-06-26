package day21.socket2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import day17.contact.Contact;
import program.Program;

public class ClientManager implements Program {

	private Scanner sc = new Scanner(System.in);
	private List<Contact> list = new ArrayList<Contact>();

	private String fileName = "D:\\git\\java_class361\\src\\day21/socket2/client.txt";
	private String ip = "192.168.30.206";
	private int port = 8080;

	@Override
	public void printMenu() {

		System.out.println("메뉴");
		System.out.println("1. 연락처 추가");
		System.out.println("2. 연락처 수정");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 연락처 확인");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 :");

	}

	private void runMenu(ContactType ct) {
		// TODO Auto-generated method stub
		switch (ct) {
			case REGIST:
				regist();
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
				break;
		}

	}

	private void regist() {
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

	private void search() {
		List<Contact> tmpList = searchByName();

		if (tmpList.size() == 0)
			System.out.println("검색한 단어가 없습니다.");
		else
			System.out.println(tmpList);

	}

	private List<Contact> searchByName() {
		sc.nextLine();
		System.out.print("검색할 단어 입력 [전체검색 Enter] : ");
		String tmpStr = sc.nextLine();
		List<Contact> tmpList = list.stream()
				.filter(p -> p.getName().contains(tmpStr))
				.collect(Collectors.toList());

		return tmpList;
	}

	@Override
	public void runMenu(int menu) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		load();

		ContactType ct = ContactType.REGIST;

		do {
			printMenu();
			int menuNum = sc.nextInt();
			ct = ContactType.fromValue(menuNum);
			runMenu(ct);
		} while (!ct.equals(ContactType.EXIT));

		save();

	}

	@SuppressWarnings("resource")
	public void save() {
		try {
			Socket socket = new Socket(ip, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("save");
			oos.writeObject(list);
			oos.flush();

//			oos.close();
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			save(fileName);
		}
	}

	@Override
	public void save(String fileName) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
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
	public void load() {
		try {
			Socket socket = new Socket(ip, port);
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeUTF("load");
			oos.flush();

			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			list = (List<Contact>) ois.readObject();

		} catch (IOException e) {
			load(fileName);
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			load(fileName);
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			list = (List<Contact>) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
