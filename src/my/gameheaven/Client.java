package my.gameheaven;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

// 연결된 소켓을 이용하여 데이터를 주고 받는 클래스
@AllArgsConstructor
public class Client {

	private Socket socket;
	private final static String EXIT = "-1";
	private static Scanner sc = new Scanner(System.in);

	public void run() {

		// Thread t = new Thread(() -> {
		try {
			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());

			while (true) {
				String msg = ois.readUTF();
				readMessage(msg);
			}

			// ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// });
		//
		// t.start();
	}

	private void readMessage(String message) {
		// TODO Auto-generated method stub
		String[] tmpMsg = message.split(Tag.splitTag);
		String tag = tmpMsg[0];
		String msg = "";
		// tag랑 msg를 같이 보냈다면
		if (tmpMsg.length == 2) {
			msg = tmpMsg[1];
		}

		switch (tag) {
			case Tag.loginTag :
				if (!msg.equals("")) {
					System.out.println(msg);
				}
				inputUserLogin();
				break;
			case Tag.menuTag :
				System.out.print(msg);
				int menu = sc.nextInt();
				String menuMsg = Tag.menuTag + Tag.splitTag + menu;
				
				send(menuMsg);

				break;
			default :

		}

	}

	public void printLoginMenu() {

		System.out.println("<로그인>");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
		System.out.print("메뉴선택 : ");
	}

	private void inputUserLogin() {
		// ID와 Password를 입력해서 서버에 전송

		// System.out.println("<로그인>");
		// System.out.println("1. 로그인");
		// System.out.println("2. 회원가입");
		// System.out.println("3. 종료");
		// System.out.print("메뉴선택 : ");
		printLoginMenu();
		int menu = sc.nextInt();

		if (menu == 3) {
			return; // 종료(구현예정)
		}

		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();

		String msg = id + " " + password;
		if (menu == 1) {
			msg = Tag.loginTag + Tag.splitTag + msg;
		} else {
			msg = Tag.joinTag + Tag.splitTag + msg;
		}
		send(msg);
	}

	public void send(String message) {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream());

			// message = sc.nextLine();
			oos.writeUTF(message);
			oos.flush();

			// if (message.equals(EXIT)) {
			// System.out.println("종료");
			// }

			// oos.close();
			// sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
