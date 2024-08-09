package day21.socket2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientMain {

	public static void main(String[] args) {
		/*
		 * 연락처 관리 프로그램을 구현하세요. 단, 불러오기랑 저장은 소켓 통신을 활용해서 작성 메뉴 1. 연락처 추가 2. 연락처 수정 3. 연락처
		 * 삭제 4. 연락처 확인 5. 프로그램 종료 메뉴 선택 :
		 */

		/*
		 * try { System.out.println(InetAddress.getLocalHost().getHostAddress()); }
		 * catch (UnknownHostException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */ // 내 ip 불러오기
		ContactManager cm = new ContactManager();
		cm.run();

	}

}
