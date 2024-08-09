package day20.socket4;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx04 {

	// 클라이언트가 연결되면 클라이언트가 보낸 값을 입력받고
	// 서버에서 클라이언트에게 값을 전송하고 종료하는 프로그램
	public static void main(String[] args) {
		// 1. 포트번호 설정
		int port = 8080;

		try (ServerSocket sS = new ServerSocket(port)) {
			// 서버용 소켓 객체 생성

			Socket s = sS.accept();
			System.out.println("[클라이언트 연결 성공]");
			Client server = new Client(s);

			server.send();
			server.receive();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("예외발생");
		}

	}

}
