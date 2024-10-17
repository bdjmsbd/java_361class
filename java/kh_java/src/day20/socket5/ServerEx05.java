package day20.socket5;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerEx05 {

	// 클라이언트가 연결되면 클라이언트가 보낸 값을 입력받고
	// 서버에서 클라이언트에게 값을 전송하고 종료하는 프로그램
	public static void main(String[] args) {
		// 1. 포트번호 설정
		int port = 8080;
//		List<ObjectOutputStream> list = new ArrayList<>();
		try {
			// 서버용 소켓 객체 생성
			ServerSocket sS = new ServerSocket(port);
			System.out.println("[연결 대기중]");
			while (true) {
				Socket s = sS.accept();
				System.out.println("[클라이언트 연결 성공]");
				Server server = new Server(s);
				server.receive();

//				server.send();
//				server.receive();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("예외발생");
		}

	}

}
