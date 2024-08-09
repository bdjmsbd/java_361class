package day20.socket5;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.ref.Cleaner.Cleanable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientEx05 {

	public static void main(String[] args) {
		// 서버는 연결만 돕고 클라이언트 끼리 채팅하도록 하는 프로그램 
		// 192.168.30.206 8080 강사님 : 192.168.30.199 5001
		String ip = "192.168.30.206";
		int port = 8080;

		try {
//			List<Socket> sockets = new ArrayList<Socket>();
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
