package my.gameheaven;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import program.Program;

@Data
// @AllArgsConstructor
@RequiredArgsConstructor
public class Server implements Program {

	private static List<ObjectOutputStream> oosList = new ArrayList<>();
	private static List<ObjectInputStream> oisList = new ArrayList<>();
	private static List<User> loginedUser = new ArrayList<User>();
	private static List<User> totalUser = new ArrayList<User>();
	private static int userCount = 0;

	private static String EXIT = "-1";

	@NonNull
	private Socket socket;

	private ObjectOutputStream oos;

	private void sendUserLogin(String message) {
		// 클라이언트가 처음 accept 하였을 때
		// Id와 Password를 입력하도록 요청한다.

		message = Tag.loginTag + Tag.splitTag + message;
		send(message);

	}

	public void send(String message) {
		if (oos == null) {
			return;
		}

		try {
			/* synchronized (oos) */ {
				oos.writeUTF(message);
				oos.flush();
			}
		} catch (IOException e) {
			oosList.remove(oos);
			userCount--;
		}

	}
	public String getMenu() {
		String menu = "미니게임천국\n" + "1. 오목\n" + "2. 사탕찾기\n" + "3. 타자연습\n"
				+ "4. 빙고\n" + "5. 전적 조회\n" + "6. 종료\n" + "메뉴 선택 : ";
		return menu;
	}

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runMenu(int menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {

		totalUser.add(new User("bdj", "1234"));

		Thread t = new Thread(() -> {
			try {
				// ObjectInputStream ois = new ObjectInputStream(
				// socket.getInputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());
				oosList.add(oos);
				// oisList.add(ois);
				userCount++;
				sendUserLogin("");
				while (true) {
					ObjectInputStream ois = new ObjectInputStream(
							socket.getInputStream());
					String msg = ois.readUTF();
					// if (!msg.equals(EXIT)) {
					// // 종료
					// }
					readMessage(msg);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// System.out.println(id + "님이 나갔습니다.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println("해결불가 에러발생");
				e.getMessage();
			}

		});
		t.start();

	}

	private void readMessage(String message) {

		String[] tmpMsg = message.split(Tag.splitTag);
		String tag = tmpMsg[0];
		String msg = "";
		// tag랑 msg를 같이 보냈다면
		if (tmpMsg.length == 2) {
			msg = tmpMsg[1];
		}

		switch (tag) {
			case Tag.loginTag :
				receiveUserLogin(msg);
				break;
			case Tag.joinTag :
				receiveUserJoin(msg);
				break;
			case Tag.menuTag :
				runMenu(msg);
				break;
			default :

		}

	}

	private void runMenu(String message) {
		// message는 String 형태의 정수로 들어온다.
		int menu = Integer.parseInt(message);
		switch (menu) { // 게임 이름은 가제목
			case 1 : // A(오목)
				// runA();
				break;
			case 2 : // B(사탕찾기)
				// runB();
				break;
			case 3 : // C(타자연습)
				// runC();
				break;
			case 4 : // D(빙고)
				// runD();
				break;
			case 5 : // 전적조회
				break;
			case 6 :
				// exit(); 종료, 클라이언트 연결끊기 구현예정
				break;
		}

	}

	private void receiveUserJoin(String message) {
		// message는 id + " " + password로 형태
		// id가 totalUser에 있는 지 확인 후 없다면 id 등록
		// 이미 있는 id라면 재로그인
		String[] tmp = message.split(" ");
		String id = tmp[0];
		String password = tmp[1];
		userJoin(id, password);

	}

	private void userJoin(String id, String password) {

		String msg = null;
		User joinUser = new User(id, password);
		// for (int i = 0; i < totalUser.size(); i++) {
		// if (totalUser.get(i).getId().equals(id))
		// System.out.println("이미 등록된 아이디입니다.니다.");
		// }
		if (totalUser.contains(joinUser)) {
			msg = "이미 등록된 아이디입니다.";
			sendUserLogin(msg);
			return;
		}

		totalUser.add(joinUser);
		msg = "회원가입 되었습니다. 로그인하세요.";
		sendUserLogin(msg);
	}

	private void receiveUserLogin(String message) {
		// message는 id + " " + password로 형태
		// 서버는 list(db)에서 로그인 정보를 확인
		// id가 없다면 새로 등록.
		// id가 있는데 password가 없다면 로그인 실패. <종료>
		String[] tmp = message.split(" ");
		String id = tmp[0];
		String password = tmp[1];
		userLogin(id, password);

	}

	private void userLogin(String id, String password) {

		// totalUser에서 아이디와 비밀번호가 일치한 지
		// 현재 접속한 유저인 지
		String msg = null;
		if (totalUser.size() == 0) {
			msg = "등록된 유저가 없습니다.";
			sendUserLogin(msg);
			return;

		} else if (loginedUser.contains(id)) {
			msg = "이미 접속한 유저입니다.";
			sendUserLogin(msg);
			return;
		}

		User loginUser = getUser(id, password);
		if (loginUser == null) {
			msg = "아이디 혹은 비밀번호가 일치하지 않습니다.";
			sendUserLogin(msg);
			return;
			// 재로그인 요구.

		} else {
			// loginedUser 객체에 추가
			// 게임을 선택할 수 있도록 메뉴판 제공
			// "<로그인 성공>";
			loginedUser.add(loginUser);
			msg = "<로그인 성공>\n";
			msg = msg + getMenu();
			msg = Tag.menuTag + Tag.splitTag + msg;
			send(msg);
		}
	}

	private User getUser(String id, String password) {
		// 입력받은 id와 password로
		// id가 일치할 때 password도 일치한다면 해당하는 객체 반환
		// 없다면 null 반환
		for (User tmp : totalUser) {
			if (tmp.getId().equals(id) && tmp.isValidPassword(password)) {
				return tmp;
			}
		}
		return null;
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
