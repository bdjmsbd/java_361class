package day21.socket2;

public enum ContactType {

	REGIST(1),
	UPDATE(2),
	DELETE(3),
	SEARCH(4),
	EXIT(5);

	private final int value;

	private ContactType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static ContactType fromValue(int value) {
		for (ContactType tmp : ContactType.values()) {
			if (tmp.getValue() == value) {
				return tmp;
			}
		}
		throw new IllegalArgumentException("회원 기능을 잘못 선택했습니다.");
	}

}
