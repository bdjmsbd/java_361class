package db.student.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

// VO: Value Object의 약자로 값 자체를 표현하는 객체
public class ScoreVO {

	private int sc_key; // 성적 기본키
	private int sc_midTerm;
	private int sc_finalTerm;
	private int sc_performance;
	private int sc_st_key;
	private int sc_su_key;
	
	public ScoreVO(int sc_midTerm, int sc_finalTerm, int sc_performance, int sc_st_key, int sc_su_key) {
		this.sc_midTerm = sc_midTerm;
		this.sc_finalTerm = sc_finalTerm;
		this.sc_performance = sc_performance;
		this.sc_st_key = sc_st_key;
		this.sc_su_key = sc_su_key;
	}

	public ScoreVO(int midterm, int finals, int performace) {
		this.sc_midTerm = midterm;
		this.sc_finalTerm = finals;
		this.sc_performance = performace;
	}
	


}
