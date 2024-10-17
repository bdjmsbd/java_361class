package day20.socket2;

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

public class ServerEx02 {

	// 클라이언트가 연결되면 클라이언트가 보낸 값을 입력받고
	// 서버에서 클라이언트에게 값을 전송하고 종료하는 프로그램
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. 포트번호 설정
		int port = 8080;

		try {
			// 2. 서버용 소켓 객체 생성
			ServerSocket sS = new ServerSocket(port);

			System.out.println("[대기 중] ..........");
			// 3. 클라이언트 연결 대기
			// 4. 요청 수락 후 소켓 객체 생성
			Socket s = sS.accept();
			System.out.println("[연결성공] .........");

			// 클라이언트에서 보낸 문자열들을 읽어오는 작업
			InputStream is = s.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);

			String str = ois.readUTF();
			// -1 이면 읽기 종료

			System.out.println("클라이언트에서 보낸 문자열 : " + str);

			System.out.println("[수신성공] .........");
			// 서버에서 클라이언트로 문자열들을 전송
			OutputStream os = s.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			System.out.print("전송할 내용 : ");
			String sendStr = sc.nextLine();
			oos.writeUTF(sendStr);
			oos.flush(); // 출력 버퍼에 남아있는 게 있다면 마저 전송

			System.out.println("[전송성공] .........");
			
			ois.close();
			is.close();
			oos.close();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
