package day20.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 192.168.30.206
		String ip = "192.168.30.206";
		int port = 8080;

		// 1. 소켓을 생성하고 대기
		System.out.println("[서버 연결 요청]");
		try (Socket s = new Socket(ip, port)) {
			System.out.println("[서버 연결 성공]");
			// 서버로 문자열 전송
			OutputStream os = s.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			System.out.print("전송할 내용 : ");
			String tmp = sc.nextLine();
			oos.writeUTF(tmp);

			oos.flush(); // 버퍼에 남아있는 것 마저 전송
			System.out.println("[전송 완료]");
			// 서버에서 문자열 수신
			InputStream is = s.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);

			String receiveStr = ois.readUTF();

			System.out.println("서버에서 보낸 문자열 : " + receiveStr);

			System.out.println("[수신 완료]");
			
			oos.close();
			os.close();
			ois.close();
			is.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
