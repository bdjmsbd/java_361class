package kr.kh.spring3.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCriteria extends Criteria {

	private int co_num;

	public PostCriteria(int co_num, int page,
			String search, String type, int perPageNum) {
		
		super(page, perPageNum, search, type);

		this.co_num = co_num;
	}
	
	@Override
	public String toString() {
		return "[co_num=" + co_num + "] " + super.toString();
	}

}
