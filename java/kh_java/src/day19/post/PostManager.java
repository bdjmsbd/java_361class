package day19.post;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class PostManager implements Program {

	Scanner sc = new Scanner(System.in);
	List<Post> list = new ArrayList<Post>();
	final static int ERROR = -1;

	public void printBar() {
		System.out.println("--------------------");
	}

	@Override
	public void printMenu() {
		printBar();
		System.out.println("메뉴");
		System.out.println("1.게시글 등록"); // regist
		System.out.println("2.게시글 수정"); // update
		System.out.println("3.게시글 삭제"); // delete
		System.out.println("4.게시글 조회"); // search
		System.out.println("5.종료"); // exit
		printBar();
		System.out.print("선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		// TODO Auto-generated method stub

	}

	public void runMenu(PostType mt) throws Exception {
		// TODO Auto-generated method stub
		switch (mt) {
			case REGIST:
				regist();
				break;
			case UPDATE:
				update();
				break;
			case DELETE:
				delete();
				break;
			case SEARCH:
				search();
				break;
			case EXIT:
				break;
		}
	}

	public boolean checkPassword(Post post) {

		System.out.print("비밀번호 입력 : ");
		String password = sc.next();
		if (!post.getPassword()
				.equals(password)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return false;
		}
		return true;
	}

	private void delete() {
		// TODO Auto-generated method stub
		System.out.println("게시물 삭제");

		int postNumber = getpostNumber();

		if (postNumber == ERROR) {
			return;
		}
		if (checkPassword(list.get(postNumber))) {
			list.remove(postNumber);
			printBar();
			System.out.println("삭제가 완료되었습니다.");
		}

	}

	public int getpostNumber() {

		if (list.size() == 0) {
			System.out.println("등록된 게시물이 없습니다");
			return ERROR;
		}
		sc.nextLine();
		System.out.print("검색할 제목이나 내용을 입력하세요 : ");
		String searchStr = sc.nextLine();

		List<Integer> index = new ArrayList<Integer>();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getContent().contains(searchStr)
					|| list.get(i).getTitle().contains(searchStr)
					|| searchStr.equals("")) {
				index.add(i);
				System.out.println(
						index.size() + ". " + list.get(i).getTitle()
								+ "(작성자: "
								+ list.get(i).getId() + ")"
								+ "(조회수: "
								+ list.get(i).getViewCount() + ")");
			}

		}
		if (index.size() == 0) {
			System.out.println("검색어가 일치하는 게시물이 없습니다.");
			return ERROR;
		}
		System.out.print("게시물 번호 입력 : ");
		int num = sc.nextInt();
		if (num > index.size() || num <= 0) {
			System.out.println("번호를 올바르게 입력하세요.");
			return ERROR;
		}
		return index.get(num - 1);
	}

	private void update() {
		// TODO Auto-generated method stub
		System.out.println("게시물 수정");

		int postNumber = getpostNumber();
		if (postNumber == ERROR) {
			return;
		}

		if (checkPassword(list.get(postNumber))) {

			Post tmp = regpost();
			list.get(postNumber).setTitle(tmp.getTitle());
			list.get(postNumber).setContent(tmp.getContent());
			list.get(postNumber).setId(tmp.getId());
			list.get(postNumber).setPassword(tmp.getPassword());

			printBar();
			System.out.println("수정이 완료되었습니다.");
		}
	}

	private void search() {
		// TODO Auto-generated method stub

		System.out.println("게시물 조회");

		int postNumber = getpostNumber();
		System.out.print("게시글 확인하시겠습니까?(y/n) : ");
		String yesOrNo = sc.next();
		if (yesOrNo.equals("y")) {
			System.out.println(list.get(postNumber));
			printBar();
			System.out.println("메뉴로 돌아가려면 엔터를 치세요.");
			sc.nextLine();
			sc.nextLine();
		}

	}

	public Post regpost() {
		String title, content, password, id;
		printBar();
		sc.nextLine();
		System.out.print("제목 : ");
		title = sc.nextLine();
		System.out.print("내용 : ");
		content = sc.nextLine();
		System.out.print("작성자 : ");
		id = sc.nextLine();
		System.out.print("비밀번호 : ");
		password = sc.nextLine();

		return new Post(title, content, id, password);
	}

	private void regist() {
		// TODO Auto-generated method stub
		System.out.println("게시물 등록");

		list.add(regpost());
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm");

		list.get(list.size() - 1).setDate(format.format(date));

		Collections.sort(list, (o1,o2) -> o1.getDate().compareTo(o2.getDate()));

		printBar();
		System.out.println(list.get(list.size() - 1).getNum()
				+ "번 게시물이 등록 되었습니다.");

	}

	@Override
	public void run() {

		String fileName = "src/day19/post/data.txt";
		load(fileName);

		int menuNum;

		PostType bt = PostType.REGIST;

		do {
			printMenu();
			try {
				menuNum = sc.nextInt();
				printBar();
				bt = PostType.fromValue(menuNum);
				runMenu(bt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (bt != PostType.EXIT);
		save(fileName);
	}

	@Override
	public void save(String fileName) {

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(fileName))) {
			oos.write(Post.getCount()); // count만 따로 저장
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public void load(String fileName) {
		try (
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(
						fis)) {
			int count = ois.read(); // 따로 저장된 count만 먼저 불러옴
			Post.setCount(count);
			list = (List<Post>) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
