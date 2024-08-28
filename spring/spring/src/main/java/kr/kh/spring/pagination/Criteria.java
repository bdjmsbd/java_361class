package kr.kh.spring.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Criteria {

	private int page = 1;
	private int perPageNum = 10; // 현재 페이지의 최대 컨텐츠 수

	private String search = "";
	private String type; // 검색 타입

	public Criteria(int page, int perPageNum, String search, String type) {

		this.page = page;
		this.perPageNum = perPageNum;
		this.search = search == null ? "" : search;
		this.type = type == null ? "all" : type;

	}

	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
}