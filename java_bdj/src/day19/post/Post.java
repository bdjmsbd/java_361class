package day19.post;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4786880421856675293L;

	@NonNull
	private String title;
	@NonNull
	private String content;
	@NonNull
	private String id;
	@NonNull
	private String password;

	private String date;

	private int viewCount = 0;

	private static int count = 0;

	private int last_count;
	
	private int num;

//	public void increasView() {
//		viewCount++;
//	}

	// num만 넣고 종료하면 다시 실행했을 때 
	// 삭제된 부분이 다 날아감.. 
	public static void setCount(int saveCount) {
		count = saveCount;
//		System.out.println("count : " + count);
	}
	
	public static int getCount() {
		return count;
//		System.out.println("count : " + last_count);
	}

	@Override
	public String toString() {
		// toString은 게시물 열람시만 호출
		// 따라서 조회수는 해당 함수 호출될 때 마다 증가.
		String post;
		post = "--------------------\n";
		post += num + ">제목 : " + title + "\n(작성자: " + id + ")"
				+ "(조회수: " + ++viewCount + ")";
		post += "\n(" + date + ")";
		post += "\n내용 : " + content;
		return post;
	}

	public Post(String title,
			String content, String id,
			String password) {
		this.title = title;
		this.content = content;
		this.id = id;
		this.password = password;
		this.num = ++count;
	}

}
