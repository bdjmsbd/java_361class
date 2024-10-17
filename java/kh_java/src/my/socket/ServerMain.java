package my.socket;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 8080;

		ServerManager sm = new ServerManager(port);
		sm.run();

	}

}
