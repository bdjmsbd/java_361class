package day10;

import java.util.Scanner;

public class A_VocabularyEx01 {

	// 메뉴판 출력
	// 단어가 있는 지 확인( 인덱스 추출 메소드)
	// 단어 의미 출력
	// 단어 의미 수정
	// 단어 삭제

	public static int showMenu(Scanner sc) {

		int menuNum;

		System.out.println("| 단어장 메뉴 |");
		System.out.print("| 1. 추가 ");
		System.out.print("| 2. 수정 ");
		System.out.print("| 3. 검색 ");
		System.out.print("| 4. 삭제 ");
		System.out.print("| 5. 종료 |\n");
		System.out.print("메뉴 선택 : ");
		menuNum = sc.nextInt();

		return menuNum;
	}

	public static void insertWord(Phone[] words, int wordCount, Scanner sc) {

		Phone tmpWord = tmpWordGen(false, sc);

		words[wordCount] = tmpWord;
		System.out.println("단어를 등록 했습니다");

	}

	public static void updateWord(Phone[] words, int wordCount, Scanner sc) {

		Phone tmpWord = tmpWordGen(true, sc);
		int indexWord = indexOfWord(words, tmpWord, wordCount);

		if (indexWord == -1) {
			System.out.println("수정할 단어가 없습니다.");
		} else {

			int selectIndex = selectDuplicatedWord(words[indexWord].getWord(), words, wordCount, sc);

			tmpWord = tmpWordGen(false, sc);
			words[selectIndex].updateWord(tmpWord);

			System.out.println("수정 완료");
		}
	}

	public static void searchWord(Phone[] words, int wordCount, Scanner sc) {

		Phone tmpWord = tmpWordGen(true, sc);
		int indexWord = indexOfWord(words, tmpWord, wordCount);

		if (indexWord == -1) {
			System.out.println("조회할 단어가 없습니다");
		} else {
			printWordAll(words, wordCount, words[indexWord].getWord());
			//words[indexWord].print();
		}
	}

	public static boolean deleteWord(Phone[] words, int wordCount, Scanner sc) {

		Phone tmpWord = tmpWordGen(true, sc);
		int indexWord = indexOfWord(words, tmpWord, wordCount);
		if (indexWord == -1) {
			System.out.println("삭제할 단어가 없습니다");
		} else {

			int selectIndex = selectDuplicatedWord(words[indexWord].getWord(), words, wordCount, sc);

			for (int i = selectIndex; i < wordCount - 1; i++) {
				words[i] = words[i + 1];
			}
			words[wordCount - 1] = null;
			System.out.println("삭제 완료");
			return true;
		}

		return false;
	}

	public static int indexOfWord(Phone[] words, Phone tmpWord, int wordCount) {
		int indexWord = -1;
		for (int i = 0; i < wordCount; i++) {
			if (words[i].getWord().equals(tmpWord.getWord())) {
				indexWord = i;
			}
		}
		return indexWord;
	}

	public static Phone tmpWordGen(boolean isSearch, Scanner sc) {

		String word, meaning, pos;

		sc.nextLine();
		System.out.print("단어 입력 :");
		word = sc.nextLine();
		if (isSearch) {
			return new Phone(word);
		}
		System.out.print("품사 입력 :");
		pos = sc.nextLine();
		System.out.print("뜻 입력 :");
		meaning = sc.nextLine();

		return new Phone(word, pos, meaning);
	}

	public static Phone[] expandWords(Phone[] words, int newMax) {
		Phone tmp[] = new Phone[newMax];
		System.arraycopy(words, 0, tmp, 0, words.length);
		return tmp;
	}
	// wordlist에서 searchword가 없다면 전체 출력. 
	// searchword가 있다면 해당 단어만 출력
	public static void printWordAll(Phone[] words, int wordCount, String searchWord) {
		for (int i = 0; i < wordCount; i++) {
			if (searchWord == null)
				words[i].print();
			else if (words[i].getWord().equals(searchWord))
				words[i].print();
		}
		System.out.println("---------------------");
	}

	public static void sortWordList(Phone[] words, int wordCount) {
		// bubble~ 젤 큰거 맨 뒤로
		for (int i = 0; i < wordCount - 1; i++) {
			for (int j = 0; j < wordCount - 1 - i; j++) {
				if (words[j].getWord().compareTo(words[j + 1].getWord()) > 0) {
					words[j + 1] = myutils.utils.swap(words[j], words[j] = words[j + 1]);
				}
			}
		}
	}

	public static int selectDuplicatedWord(String searchWord, Phone[] words, int wordCount, Scanner sc) {
		int dupIndexList[] = new int[wordCount];
		int dupCount = 0;
		for (int i = 0; i < wordCount; i++) {
			if (words[i].getWord().equals(searchWord)) {
				dupIndexList[dupCount++] = i;
			}
		}

		int selectNum;
		for (int i = 0; i < dupCount; i++) {
			System.out.println(i + 1 + "번.");
			words[dupIndexList[i]].print();
		}
		do {
			System.out.print("단어의 번호를 선택하세요 : ");
			selectNum = sc.nextInt();
			if (selectNum <= dupCount && selectNum > 0) {
				return (dupIndexList[selectNum - 1]);
			} else
				System.out.println("번호를 잘 못 입력했습니다");
		} while (true);

	}
//	public static boolean checkWord(Word[] list, String word, int index) {
//		if(list.length <= index || index < 0 ) {
//			return false;
//		}
//		if(list[index] == null) {
//			return false;
//		}
//		return list[index].getWord().equals(word);
//	}

	public static void main(String[] args) {
		// 영어 단어를 관리하기 위한 Word 클래스를 만들고
		// 필요한 멤버변수 들을 선언 해보세요.

		Scanner sc = new Scanner(System.in);
		
		int menuNum;
		int wordCount = 0;
		final int wordMax = 2;
		Phone[] words = new Phone[wordMax];

		do {
			menuNum = showMenu(sc);

			switch (menuNum) {
				case 1:
					System.out.println("단어 추가");
					if (words.length == wordCount) {
						System.out.println("단어장 크기 확장");
						words = expandWords(words, words.length + wordMax);
					}
					insertWord(words, wordCount++, sc);
					sortWordList(words, wordCount);

					break;
				case 2:
					System.out.println("단어 수정");
					if (wordCount != 0) {
						updateWord(words, wordCount, sc);
						sortWordList(words, wordCount);
					} else
						System.out.println("수정 불가 (단어 없음)");
					break;
				case 3:
					System.out.println("단어 조회");
					if (wordCount != 0) {
						searchWord(words, wordCount, sc);
					} else
						System.out.println("조회 불가 (단어 없음)");
					break;
				case 4:
					System.out.println("단어 삭제");
					if (wordCount != 0) {
						if (deleteWord(words, wordCount, sc))
							wordCount--;
					} else
						System.out.println("삭제 불가 (단어 없음)");
					break;
				case 5:
					System.out.println("단어장 종료");
					break;
				case 10:
					System.out.println("모든 단어 출력");
					printWordAll(words, wordCount, null);
					break;
			}
		} while (menuNum != 5);

		sc.close();
	}
}

class Phone {
	private String word, pos, meaning;

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public Phone(String word, String pos, String meaning) {
		this.word = word;
		this.pos = pos;
		this.meaning = meaning;
	}

	public Phone(String word) {
		this.word = word;
	}

	public void updateWord(Phone word) {
		this.word = word.word;
		this.pos = word.pos;
		this.meaning = word.meaning;
	}

	public void print() {
		System.out.println("---------------------");
		System.out.print("단어 : " + word);
		System.out.println("(품사 : " + pos + ")");
		System.out.println("뜻 : " + meaning + "");
		System.out.println("---------------------");
	}

}
