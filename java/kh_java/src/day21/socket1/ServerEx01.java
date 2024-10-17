package day21.socket1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerEx01 {

	public static void main(String args[]) {
		int port = 8080;
		String fileName = "src/day21/socket1/server.txt";

		try {
			ServerSocket sS = new ServerSocket(port);
			while (true) {
				Socket s = sS.accept();

				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

				String type = ois.readUTF();
				if (type.equals("save")) {
					receive(ois, fileName);
//					list = (List<String>) ois.readObject();
//					save(list, fileName);
					System.out.println("저장 완료");
				} else if (type.equals("load")) {
					send(oos, fileName);
					System.out.println("불러오기 완료");
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void send(ObjectOutputStream oos, String fileName) {
		// TODO Auto-generated method stub
		List<String> list = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream fois = new ObjectInputStream(fis);
			list = (List<String>) fois.readObject();
			System.out.println(list);
			oos.writeObject(list);
			oos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				oos.writeObject(new ArrayList<String>());
				oos.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void receive(ObjectInputStream ois, String fileName) {
		// TODO Auto-generated method stub
		List<String> list = null;

		try {
			list = (List<String>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream foos = new ObjectOutputStream(fos);

			foos.writeObject(list);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
