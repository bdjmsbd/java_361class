package my.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {

	private static List<ObjectOutputStream> list = new ArrayList<>();

	private static String EXIT = "-1";

	private Socket socket;

	public void receive() {

		Thread t = new Thread(() -> {
			try {
				ObjectInputStream ois = new ObjectInputStream(
						socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(
						socket.getOutputStream());
				list.add(oos);
				Message WelcomeMessage = new Message("WELCOME", "접속되었습니다.");
				send(oos, WelcomeMessage);
//				id = ois.readUTF();
//				boolean isFirst = true;
				while (true) {
//					
					Message msg = (Message) ois.readObject();
//					msg.setType(ois.readUTF());
//					msg.setMessage(EXIT)
					if(msg.getType().equals("WELCOME")) {
						System.out.println(msg.getMessage());
					}
//					if (!chat.equals(EXIT)) {
//						System.out.print(chat = (id + ">> " + chat + "\n"));
//						for (ObjectOutputStream tmp : list) {
//							if (tmp != oos) {
//								send(tmp, chat);
//							}
//						}
//					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("님이 나갔습니다.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				System.out.println("해결불가 에러발생");
				e.getMessage();
			}

		});
		t.start();

	}

	public void send(ObjectOutputStream oos, Message message) {
		if (oos == null) {
			return;
		}

		try {
			synchronized (oos) {
				oos.writeObject(message);
//				oos.writeUTF(message);
				oos.flush();
			}
		} catch (IOException e) {
			list.remove(oos);
		}

	}

}
