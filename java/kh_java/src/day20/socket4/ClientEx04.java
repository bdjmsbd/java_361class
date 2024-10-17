package day20.socket4;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.ref.Cleaner.Cleanable;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx04 {

	public static void main(String[] args) {
		// 192.168.30.206
		String ip = "192.168.30.206";
		int port = 8080;

		try {
			Socket s = new Socket(ip, port);
			System.out.println("[서버 연결 성공]");
			Client client = new Client(s);

			client.send();
			client.receive();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
