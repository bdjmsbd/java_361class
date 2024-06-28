package my.gameheaven;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {
	
	public static String getServerIp() {

		InetAddress local = null;
		try {
			local = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		if (local == null) {
			return "";
		} else {
			String ip = local.getHostAddress();
			return ip;
		}

	}

	public static void main(String[] args) {

		String ip = getServerIp(); //"172.30.1.77";
		int port = 5001;

		try {
			// List<Socket> sockets = new ArrayList<Socket>();
			Socket socket = new Socket(ip, port);
			System.out.println("[서버 연결 성공]");
			Client client = new Client(socket);

			// client.send();
			client.run();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
