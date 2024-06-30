package my.gameheaven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import lombok.Data;

@Data
public class Baseball {

	// <변수>
	// player1, player2
	// 게임 카운트
	// 차례 (누가 게임할 순서인 지)
	private int turnCount = 1;
	private String player1;
	private String player2;
	private String currentTurn;

	// 현재 차례, 0 or 1

	private List<Integer> number;

	private String gameResult = "";
	private String winner;
	private String loser;

	private int min = 1;
	private int max = 9;

	public Baseball(String player1, String player2) {

		this.player1 = player1;
		this.player2 = player2;
		gameResult = "<게임을 시작합니다.>\n";
		gameResult += "<" + player1 + " vs " + player2 + ">\n";

		randomGen();
		gameResult += "<랜덤 번호를 생성합니다.>\n";

		// 차례
		// currentTurnInit();
		currentTurn = player1;

		//
		gameResult += "<" + turnCount++ + "차 시도>\n";
		gameResult += "<" + currentTurn + "의 차례입니다.>\n";
		gameResult += "<숫자 3개를 입력해주세요.(예: 3 6 9) > : ";
	}

	private void currentTurnInit() {
		int turn = (int) (Math.random() * 2);
		if (turn == 0) {
			currentTurn = player1;
		} else
			currentTurn = player2;

	}

	public boolean isEnd() {
		if (winner != null) {
			return true;
		}
		return false;
	}

	public String getResult() {
		String tmp = gameResult;
		gameResult = "";
		return tmp;
	}

	public void turnNext() {

		if (currentTurn.equals(player1)) {
			currentTurn = player2;
		} else {
			currentTurn = player1;
		}
	}
	// <메소드>
	// 랜덤 번호 생성
	public void randomGen() {

		HashSet<Integer> baseSet = new HashSet<>();
		while (baseSet.size() < 3) {
			baseSet.add((int) (Math.random() * (max - min + 1) + min));
		}

		number = new ArrayList<Integer>(baseSet);
	}

	public void Play(List<Integer> userNum) {

		String result;
		int s = 0, b = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (number.get(i) == userNum.get(j)) {
					if (i == j) {
						s++;
					} else
						b++;
				}
			}
		}
		if (s == 0 && b == 0)
			// System.out.println("Out");
			result = "Out!";
		else if (s == 3) {
			// System.out.println("정답");
			result = "정답";
			winner = currentTurn;
			loser = (currentTurn.equals(player1) ? player2 : player1);
			// break;
		} else {
			// System.out.println(((s == 0) ? "" : s + "S") + ((b == 0) ? "" : b
			// + "B"));
			result = ((s == 0) ? "" : s + "S") + ((b == 0) ? "" : b + "B");
		}

		if (winner != null) {
			gameResult = "<게임이 끝났습니다. 승자는 : " + currentTurn + "님 입니다.>";
			return;
		}

		turnNext();

		gameResult += "<입력 " + userNum + ", 결과 : " + result + "> 입니다. \n";
		gameResult += "<" + turnCount + "차 시도>\n";
		gameResult += "<" + currentTurn + "의 차례입니다.>\n";
		gameResult += "<숫자 3개를 입력해주세요.(예: 3 6 9) > : ";

	}
	public void run(String message) {

		List<String> strNum = new ArrayList<String>();
		strNum = Arrays.asList(message.split(" "));
		List<Integer> userNum = new ArrayList<Integer>();
		for (String tmp : strNum) {
			userNum.add(Integer.parseInt(tmp));
		}

		Play(userNum);

	}
	// 입력 값에 따른 출력

	// 정답 유무, 1S2B, Out

	/**/
}
