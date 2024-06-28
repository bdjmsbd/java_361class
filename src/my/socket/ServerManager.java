package my.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lombok.AllArgsConstructor;
import lombok.Data;
import program.Program;

@Data
@AllArgsConstructor
public class ServerManager implements Program {

	private int port;

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runMenu(int menu) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("resource")
	@Override
	public void run() {

		try {
			// 서버용 소켓 객체 생성
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("[연결 대기중]");
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("[클라이언트 연결 성공]");
				Server server = new Server(socket);
				server.receive();

//				server.send();
//				server.receive();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("예외발생");

		}
	}

	@Override
	public void save(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(String fileName) {
		// TODO Auto-generated method stub

	}

}
