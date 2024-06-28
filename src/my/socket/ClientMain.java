package my.socket;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "192.168.30.206";
		int port = 8080;

		ClientManager cm = new ClientManager(ip, port);
		cm.run();
	}

}
