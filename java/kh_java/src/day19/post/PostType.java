package day19.post;

public enum PostType {

	REGIST(1),
	UPDATE(2),
	DELETE(3),
	SEARCH(4),
	EXIT(5);

	private final int value;

	private PostType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static PostType fromValue(int value) {
		for (PostType tmp : PostType.values()) {
			if (tmp.getValue() == value) {
				return tmp;
			}
		}
		throw new IllegalArgumentException("회원 기능을 잘못 선택했습니다.");
	}

}
