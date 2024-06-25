package day20.socket4;

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

	private Socket s;
	private final static String EXIT = "-1";

	public void receive() {

		Thread t = new Thread(() -> {
			try {
				ObjectInputStream ois = new ObjectInputStream(
						s.getInputStream());
				while (true) {
					String chat = ois.readUTF();
					if (chat.equals(EXIT)) {
						break;
					}
					System.out.print("내용 : " + chat);
				}

//				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		t.start();
	}

	public void send() {
		Thread t = new Thread(() -> {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(
						s.getOutputStream());
				Scanner sc = new Scanner(System.in);
				while (true) {

					System.out.print("입력 : ");
					String chat = sc.nextLine();
					oos.writeUTF(chat);
					oos.flush();
					if (chat.equals(EXIT)) {
						System.out.println("종료");
						break;
					}
				}
//				oos.close();
//				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t.start();
	}

}
