package my.gameheaven;

import lombok.Data;

@Data
public class Room {

	// 두 명의 사용자 관리
	private ConnectedUser roomManager; // 방장
	private ConnectedUser player; // 참여한 플레이어

	// 게임 객체 생성
	private Baseball baseball;
	// private Othergame othergame;
	// ..

	private boolean isPlaying = false;
	private String gameTitle;
	private String roomTitle;

	public Room(ConnectedUser roomManager, String gameTitle, String roomTitle) {

		this.roomManager = roomManager;
		this.gameTitle = gameTitle;
		this.roomTitle = roomTitle;

	}

	// public void runGame() {
	//
	// gameInit();
	//
	// }
	public String getCurrentTurn() {
		String msg = "";

		switch (gameTitle) {
			case Tag.baseBall :
				msg = baseball.getCurrentTurn();
				break;
		}
		return msg;
	}
	public String gameRun(String message) {

		String msg = "";
		switch (gameTitle) {
			case Tag.baseBall :
				if (!isPlaying) {
					msg = baseball.getResult();
					isPlaying = true;
				} else {
					baseball.run(message);
					msg = baseball.getResult();
				}
				break;
		}

		return msg;
	}

	public void gameInit() {

		switch (gameTitle) {
			case Tag.baseBall :
				baseball = new Baseball(roomManager.getUserId(),
						player.getUserId());
				break;
		}

	}

	public void enterRoom(ConnectedUser player) {

	}

	@Override
	public String toString() {
		return "[" + gameTitle + "]" + " " + roomTitle + " <방장:"
				+ roomManager.getUserId() + ">";
	}

}
