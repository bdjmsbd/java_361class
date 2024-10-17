package day20.socket3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 192.168.30.206
		String ip = "192.168.30.206";
		int port = 8080;

		try {
			Socket s = new Socket(ip, port);

			System.out.println("[서버 연결 성공]");
			Thread sendThread = new Thread(() -> {

				try {
					OutputStream os = s.getOutputStream();
					ObjectOutputStream oos = new ObjectOutputStream(
							os);

					while (true) {
						System.out.print("내용 : ");
						String sendStr = sc.nextLine();

						oos.writeUTF(sendStr);
						oos.flush();
						if (sendStr.equals("-1")) {
							System.out.println("클라이언트 전송을 종료합니다.");
							break;
						}
					}
//					oos.close();
//					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});
			sendThread.start();
			Thread receiveThread = new Thread(() -> {

				try {
					InputStream is = s.getInputStream();
					ObjectInputStream ois = new ObjectInputStream(is);
					while (true) {
						String receiveStr = ois.readUTF();
						if (receiveStr.equals("-1")) {
							System.out.println("서버가 전송을 중단했습니다.");
							break;
						}
						System.out.println(
								"서버로 부터 받은 메세지 : " + receiveStr);
					}
//					ois.close();
//					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			receiveThread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		// 1. 소켓을 생성하고 대기
//		System.out.println("[서버 연결 요청]");
//		try (Socket s = new Socket(ip, port)) {
//			System.out.println("[서버 연결 성공]");
//			// 서버로 문자열 전송
//			OutputStream os = s.getOutputStream();
//			ObjectOutputStream oos = new ObjectOutputStream(os);
//
//			System.out.print("전송할 내용 : ");
//			String tmp = sc.nextLine();
//			oos.writeUTF(tmp);
//
//			oos.flush(); // 버퍼에 남아있는 것 마저 전송
//			System.out.println("[전송 완료]");
//			// 서버에서 문자열 수신
//			InputStream is = s.getInputStream();
//			ObjectInputStream ois = new ObjectInputStream(is);
//
//			String receiveStr = ois.readUTF();
//
//			System.out.println("서버에서 보낸 문자열 : " + receiveStr);
//
//			System.out.println("[수신 완료]");
//			
//			oos.close();
//			os.close();
//			ois.close();
//			is.close();
//
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
