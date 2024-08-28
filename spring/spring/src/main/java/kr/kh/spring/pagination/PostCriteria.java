package kr.kh.spring.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCriteria extends Criteria {

	private String co_num;

	public PostCriteria(String co_num, String pageStr,
			String search, String type, int perPageNum) {
		
		super(getPage(pageStr), perPageNum, search, type);

		this.co_num = co_num;
	}
	
	private static int getPage(String pageStr) {
		int page;
		try {
			page = Integer.parseInt(pageStr);
		} catch (Exception e) {
			page = 1;
		}
		return page;
	}

	@Override
	public String toString() {
		return "[co_num=" + co_num + "] " + super.toString();
	}
	
	

}
