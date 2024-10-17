package day20.socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ClientEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 192.168.30.206
		String ip = "192.168.30.206";
		int port = 8080;

		List<String> list = new ArrayList<String>();
		list.add("21");
		list.add("100");
		list.add("23");
		list.add("-1");
		// 1. 소켓을 생성하고 대기
		System.out.println("[서버 연결 요청]");
		try (Socket s = new Socket(ip, port)) {
			System.out.println("[서버 연결 성공]");
			// 서버로 문자열 전송
			OutputStream os = s.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			for (String tmp : list) {
				oos.writeUTF(tmp);
			}
			oos.flush(); // 버퍼에 남아있는 것 마저 전송
			System.out.println("[전송 완료]");
			// 서버에서 문자열 수신
			InputStream is = s.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			while (true) {
				String tmp = ois.readUTF();
				if (tmp.equals("-1")) {
					break;
				}
				System.out.println("서버에서 보낸 문자열 : " + tmp);
			}
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
