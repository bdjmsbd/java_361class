package day13;

public class F_Ex01 {

	public static void main(String[] args) {
		// 다음과 같은 책 제목들이 있을 때 원하는 단어를 검색해서
		// 해당 단어가 있는 책을 출력하는 코드를 작성하세요.
		// 일치하는 책이 없는 경우 일치하는 책이 없습니다라고 출력

		String[] books = { "자바의 정석", "혼자하는 자바", "혼자하는 C", "수학의 정석", "누구나 하는 C" };
		String searchStr = "누구";

		boolean isExist = false;
//		for (String tmp : books) {
//			String tmpStr = tmp.replace(searchStr, "");
//			if (!tmpStr.equals(tmp)) {
//				System.out.println(tmp);
//				isExist = true;
//			}
//		}
//		if (!isExist)
//			System.out.println("일치하는 책이 없습니다.");

		isExist = false;
		for (String book : books) {
			if (book.contains(searchStr)) {
				System.out.println(book);
				isExist = true;
			}
//			if (book.indexOf(searchStr) >= 0) {
//				System.out.println(book);
//				isExist = true;
//			}
		}
		if (!isExist)
			System.out.println("일치하는 책이 없습니다.");
	}

}
