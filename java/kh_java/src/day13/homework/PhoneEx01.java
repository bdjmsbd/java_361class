package day13.homework;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneEx01 {

	public static boolean isExistPNum(Phone tmpPInfo, Phone[] pInfo, int pNumCount) {

		for (int i = 0; i < pNumCount; i++) {
			if (tmpPInfo.equals(pInfo[i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidPNum(Phone tmpPInfo) {

		String regex = "^0[\\d]{1,2}-[\\d]{3,4}-[\\d]{4}$";
		return Pattern.matches(regex, tmpPInfo.getpNumber());

	}

	public static int showMenu(Scanner sc) {

		int menuNum;
		System.out.println("| 연락처 메뉴 |");
		System.out.print("| 1. 추가 ");
		System.out.print("| 2. 수정 ");
		System.out.print("| 3. 검색 ");
		System.out.print("| 4. 삭제 ");
		System.out.print("| 5. 종료 |\n");
		System.out.print("메뉴 선택 : ");
		try {
			menuNum = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("올바른 입력번호가 아닙니다.");
			// e.printStackTrace();
			// e.getMessage(); e.toString()
			menuNum = -1;
			sc.next();
		}

		return menuNum;
	}

	public static Phone[] expandPInfo(Phone[] pInfo, int newMax) {
		Phone tmp[] = new Phone[newMax];
		System.arraycopy(pInfo, 0, tmp, 0, pInfo.length);
		return tmp;
	}

	/**
	 * 
	 * @param pInfo
	 * @param pNumCount
	 * @param sc
	 * @return
	 */
	public static boolean insertPInfo(Phone[] pInfo, int pNumCount, Scanner sc) {

		Phone tmpPInfo = tmpPInfoGen(false, sc);

		boolean isExist = isExistPNum(tmpPInfo, pInfo, pNumCount);
		boolean isValid = isValidPNum(tmpPInfo);
		if (!isValid) {
			System.out.println("유효하지 않는 번호입니다.");
			return true;
		}
		if (isExist) {
			System.out.println("이미 존재하는 번호입니다.");
			return true;
		}

		pInfo[pNumCount] = tmpPInfo;
		return false;
	}

	public static Phone tmpPInfoGen(boolean isSearch, Scanner sc) {

		String name, pNum;

		sc.nextLine();
		System.out.print("이름 입력 :");
		name = sc.nextLine();
		if (isSearch) {
			return new Phone(name);
		}
		System.out.print("번호 입력 (010-1234-5678):");
		pNum = sc.nextLine();

		return new Phone(name, pNum);
	}

	public static void sortPInfoList(Phone[] pInfo, int pNumCount) {
		// bubble~ 젤 큰거 맨 뒤로
		for (int i = 0; i < pNumCount - 1; i++) {
			for (int j = 0; j < pNumCount - 1 - i; j++) {
				if (pInfo[j].getName().compareTo(pInfo[j + 1].getName()) > 0) {
					pInfo[j + 1] = my.utils.swap(pInfo[j], pInfo[j] = pInfo[j + 1]);
				}
			}
		}
	}

	public static void printPInfo(Phone[] pInfo, int pNumCount, String searchName) {
		for (int i = 0; i < pNumCount; i++) {
			if (pInfo[i].getName().contains(searchName))
//				pInfo[i].toString();
				System.out.println(pInfo[i]);
		}
		System.out.println("---------------------");
	}

	public static void updatePInfo(Phone[] pInfo, int pNumCount, Scanner sc) {

		Phone tmpPInfo = tmpPInfoGen(true, sc);
		int indexPNum = indexOfPNum(pInfo, tmpPInfo, pNumCount);

		if (indexPNum == -1) {
			System.out.println("수정할 연락처가 없습니다.");
		} else {

			int selectIndex = selectDuplicatedPNum(tmpPInfo.getName(), pInfo, pNumCount, sc);

			tmpPInfo = tmpPInfoGen(false, sc);
			boolean isExist = isExistPNum(tmpPInfo, pInfo, pNumCount);
			boolean isValid = isValidPNum(tmpPInfo);
			if (!isValid) {
				System.out.println("유효하지 않는 번호입니다.");
				return;
			} // 같은 번호로 이름만 수정할 경우 반영
			if (isExist && !tmpPInfo.equals(pInfo[selectIndex])) {
				System.out.println("이미 존재하는 번호입니다.");
				return;
			}
			pInfo[selectIndex].updatePInfo(tmpPInfo);
			System.out.println("수정 완료");
		}
	}

	public static int indexOfPNum(Phone[] pInfo, Phone tmpPInfo, int pNumCount) {
		int indexPNum = -1;
		for (int i = 0; i < pNumCount; i++) {
			if (pInfo[i].getName().contains(tmpPInfo.getName())) {
				// if (pInfo[i].getName().equals(tmpPInfo.getName())) {
				indexPNum = i;
			}
		}
		return indexPNum;
	}

	public static int selectDuplicatedPNum(String searchName, Phone[] pInfo, int pNumCount, Scanner sc) {
		int dupIndexList[] = new int[pNumCount];
		int dupCount = 0;
		for (int i = 0; i < pNumCount; i++) {
			if (pInfo[i].getName().contains(searchName)) {
				dupIndexList[dupCount++] = i;
			}
		}

		int selectNum;
		for (int i = 0; i < dupCount; i++) {
			System.out.println(i + 1 + "번.");
//			pInfo[dupIndexList[i]].toString();
			System.out.println(pInfo[dupIndexList[i]]);
		}
		do {
			System.out.print("연락처의 번호를 선택하세요 : ");
			selectNum = sc.nextInt();
			if (selectNum <= dupCount && selectNum > 0) {
				return (dupIndexList[selectNum - 1]);
			} else
				System.out.println("번호를 잘 못 입력했습니다");
		} while (true);

	}

	public static void searchPInfo(Phone[] pInfo, int pNumCount, Scanner sc) {

		Phone tmpPInfo = tmpPInfoGen(true, sc);
		int indexPNum = indexOfPNum(pInfo, tmpPInfo, pNumCount);

		if (indexPNum == -1) {
			System.out.println("조회할 연락처가 없습니다");
		} else {
			printPInfo(pInfo, pNumCount, tmpPInfo.getName());
		}
	}

	public static boolean deletePInfo(Phone[] pInfo, int pNumCount, Scanner sc) {

		Phone tmpPInfo = tmpPInfoGen(true, sc);
		int indexPNum = indexOfPNum(pInfo, tmpPInfo, pNumCount);
		if (indexPNum == -1) {
			System.out.println("삭제할 연락처가 없습니다");
		} else {

			int selectIndex = selectDuplicatedPNum(tmpPInfo.getName(), pInfo, pNumCount, sc);

			for (int i = selectIndex; i < pNumCount - 1; i++) {
				pInfo[i] = pInfo[i + 1];
			}
			pInfo[pNumCount - 1] = null;
			System.out.println("삭제 완료");
			return true;
		}

		return false;
	}

	/**
	 * => /** +enter
	 * 
	 * @param menuNum
	 * @param pInfo
	 * @param pNumCount
	 * @param sc
	 * @return
	 */
	public static int runMenu(int menuNum, Phone[] pInfo, int pNumCount, Scanner sc) {

		switch (menuNum) {
			case 1:
				System.out.println("번호 추가");

				boolean isExist = insertPInfo(pInfo, pNumCount, sc);
				if (!isExist) {
					System.out.println("연락처를 등록 했습니다");
					pNumCount++;
					sortPInfoList(pInfo, pNumCount);
				}

				break;
			case 2:
				System.out.println("번호 수정");
				if (pNumCount != 0) {
					updatePInfo(pInfo, pNumCount, sc);
					// (ph, pNCount);
				} else
					System.out.println("수정 불가 (번호 없음)");
				break;
			case 3:
				System.out.println("연락처 조회 (전체 조회 enter)");
				if (pNumCount != 0) {
					searchPInfo(pInfo, pNumCount, sc);
				} else
					System.out.println("조회 불가 (번호 없음)");
				break;
			case 4:
				System.out.println("연락처 삭제");
				if (pNumCount != 0) {
					if (deletePInfo(pInfo, pNumCount, sc))
						pNumCount--;
				} else
					System.out.println("삭제 불가 (번호 없음)");
				break;
			case 5:
				System.out.println("종료");
				break;
		}
		return pNumCount;
	}

	public static void main(String[] args) {
		// 연락처 관리를 위한 프로그램을 만드세요.
		// 메뉴
		// 1. 연락처 추가
		// 2. 연락처 수정
		// 3. 연락처 삭제
		// 4. 연락처 검색
		// 5. 프로그램 종료
		// 메뉴선택

		// 1. 선택
		// 이름: bdj
		// 연락처: 010-1111-1111
		// ------------
		// 등록이 완료됐습니다.

		// 1. 선택
		// 이름: bdj
		// 연락처: 010-1234-1111
		// ------------
		// 등록이 완료됐습니다.

		// 1. 선택시 =>
		// 이름: bdj
		// 연락처: 010-1234-1111
		// ------------
		// 등록이 완료됐습니다.

		// 1. 선택시 =>
		// 이름: jkm
		// 연락처: 010-1234-1111
		// ------------
		// 이미 등록된 번호입니다.

		// 2. 선택시 =>
		// 이름: j
		// ------------
		// 1. jkm : 010-1234-1111
		// 2. jjj : 010-2662-6666
		// 번호선택 : 1
		// 이름: jbd
		// 번호: 010-2662-6666
		// -------------------
		// 이미 등록된 번호입니다. -> 아니라면 수정이 완료되었습니다.

		// 3. 선택시 =>
		// 이름: j
		// 1. jkm : 010-1234-1111
		// 2. jjj : 010-2662-6666

		Scanner sc = new Scanner(System.in);

		int max = 10;
		Phone[] ph = new Phone[max];
		int menuNum;
		int pNCount = 0;

		do {
			menuNum = showMenu(sc);
			pNCount = runMenu(menuNum, ph, pNCount, sc);
			if (ph.length == pNCount) {
				System.out.println("휴대폰 저장 번호 확장");
				ph = expandPInfo(ph, ph.length + max);
			}
		} while (menuNum != 5);

		sc.close();

	}

}

class Phone {

	private String name, pNumber;
	// [\d]{2,3}-[\d]{3,4}-[\d]{3,4}

	public Phone(String name, String pNumber) {
		this.name = name;
		this.pNumber = pNumber;
//		setpNumber(pNumber);
	}

	public Phone(String name) {
		this.name = name;
		this.pNumber = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpNumber() {

		return pNumber;
	}

	public void setpNumber(String pNumber) throws Exception {
		String regex = "^0[\\d]{1,2}-[\\d]{3,4}-[\\d]{4}$";
		if (Pattern.matches(regex, pNumber))
			this.pNumber = pNumber;
		else {
//			System.out.println("주어진 번호는 올바른 형태가 아닙니다.");
			throw new Exception("주어진 번호는 올바른 형태가 아닙니다.");
		}
	}

	public void print() {
		System.out.println("---------------------");
		System.out.println("이름 : " + name);
		System.out.println("번호 : " + pNumber + "");
//		System.out.println("---------------------");
	}

	@Override
	public String toString() {
		return name + " : " + pNumber;
	}

	public void updatePInfo(Phone pInfo) {
		this.name = pInfo.name;
		this.pNumber = pInfo.pNumber;
//		setpNumber(pInfo.pNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		return Objects.equals(pNumber, other.pNumber);
	}

}
