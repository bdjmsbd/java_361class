package my.gameheaven;

public class Tag {

	/* 각 메시지를 구분하기 위한 태그 */
	final static String splitTag = "::";

	final static String loginTag = "LOGIN"; // 로그인
	final static String loginSuccessTag = "LOGINSUCCESS"; // 로그인 성공
	final static String loginFAILTag = "LOGINFAIL"; // 로그인 실패
	final static String joinTag = "JOIN"; // 회원가입
	final static String menuTag = "MENU"; // 메뉴
	
	final static String overTag = "OVER"; // 중복확인
	final static String viewTag = "VIEW"; // 회원정보조회
	final static String changeTag = "CHANGE"; // 회원정보변경
	final static String rankTag = "RANK"; // 전적조회(전체회원)
	final static String croomTag = "CROOM"; // 방생성
	final static String vroomTag = "VROOM"; // 방목록
	final static String uroomTag = "UROOM"; // 방유저
	final static String eroomTag = "EROOM"; // 방입장
	final static String cuserTag = "CUSER"; // 접속유저
	final static String searchTag = "SEARCH"; // 전적조회(한명)
	final static String pexitTag = "PEXIT"; // 프로그램종료
	final static String rexitTag = "REXIT"; // 방퇴장
	final static String omokTag = "OMOK"; // 오목
	final static String winTag = "WIN"; // 승리
	final static String loseTag = "LOSE"; // 패배
	final static String recordTag = "RECORD"; // 전적업데이트

}
