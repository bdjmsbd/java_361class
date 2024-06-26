package day21.socket1;

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
import java.util.List;
import java.util.Scanner;

import day19.post.Post;
import program.Program;

// 속담을 관리하는 프로그램
public class ClientManager implements Program {

	private Scanner sc = new Scanner(System.in);
	private String fileName = "src/day21/socket1/client.txt";

	private List<String> list = new ArrayList<>();

	private String ip = "192.168.30.206";
	private int port = 8080;

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("메뉴");
		System.out.println("1. 속담추가");
		System.out.println("2. 속담삭제");
		System.out.println("3. 속담조회");
		System.out.println("4. 종료");
		System.out.print("메뉴선택 : ");

	}

	@Override
	public void runMenu(int menu) throws Exception {

		switch (menu) {
			case 1:
				insert();
				break;
			case 2:
				delete();
				break;
			case 3:
				print();
				break;
		}

	}

	private void insert() {
		// TODO Auto-generated method stub
		sc.nextLine();
		System.out.print("속담 입력 : ");
		String str = sc.nextLine();
		for (String tmp : list) {
			if (tmp.equals(str))
				System.out.println("이미 등록된 속담입니다.");
			return;
		}
		list.add(str);
		System.out.println("속담을 추가했습니다.");

	}

	private void delete() {
		// TODO Auto-generated method stub
		print();

		System.out.print("삭제할 속담 선택 : ");
		int index = sc.nextInt() - 1;

		try {
			list.remove(index);
			System.out.println("속담을 삭제하였습니다.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("잘못된 속담을 선택했습니다.");
		}

	}

	private void print() {
		// TODO Auto-generated method stub
		if (list.size() == 0) {
			System.out.println("등록된 속담이 없습니다.");
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 + "." + list.get(i));
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stu

		load();
		int menu = 1;
		do {
			printMenu();
			try {
				menu = sc.nextInt();
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (menu != 4);
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
			list = (List<String>) ois.readObject();

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
//			int count = ois.read(); // 따로 저장된 count만 먼저 불러옴
//			Post.setCount(count);
			list = (List<String>) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
