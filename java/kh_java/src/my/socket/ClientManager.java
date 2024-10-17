package my.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import lombok.AllArgsConstructor;
import lombok.Data;
import program.Program;

@Data
@AllArgsConstructor
public class ClientManager implements Program {

	private String ip;
	private int port;

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runMenu(int menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {

		System.out.println("[서버 연결 요청]");
		try (Socket s = new Socket(ip, port)) {
			System.out.println("[서버 연결 성공]");
			// 서버로 문자열 전송
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

			Message m = new Message("WELCOME", "hihihihi");
			oos.writeObject(m);
			oos.flush();

//			for (String tmp : list) {
//				oos.writeUTF(tmp);
//			}
//			oos.flush();
//			System.out.println("[전송 완료]");

//			String message;
//			sendMessage(oos, message);
			receive(ois, oos);
//			oos.close();
//			ois.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void receive(ObjectInputStream ois, ObjectOutputStream oos) {

		while (true) {
			
//			String type;
//			String message;
			try {
				Message msg = (Message) ois.readObject();
				
				System.out.println("서버에서 보낸 타입 : " + msg.getType());
				System.out.println("서버에서 보낸 메세지 : " + msg.getMessage());
				
				if(msg.getType().equals("exit")) {
					System.out.println("종료합니다.");
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

//		oos.close();

	}

	private void sendMessage(ObjectOutputStream oos, String message) {
		// TODO Auto-generated method stub
		try {
			oos.writeUTF(message);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
