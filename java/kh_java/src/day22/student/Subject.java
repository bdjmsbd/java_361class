package day22.student;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Subject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1442786639115209920L;
	@NonNull
	private String name;
	// 학년, 학기, 중간, 기말, 수행평가
	@NonNull
	private int grade, seme;
	private int mTerm, fTerm, pEval;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return grade == other.grade && Objects.equals(name, other.name) && seme == other.seme;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, grade, seme);
	}

	@Override
	public String toString() {
		return name + " : " + grade + "학년 " + seme + "학기, 중간:" + mTerm + " 기말:" + fTerm + " 수행:" + pEval + ", 통합:" + getTotal();
	}

	public void updateScore(int mTerm, int fTerm, int pEval) {
		this.mTerm = mTerm;
		this.fTerm = fTerm;
		this.pEval = pEval;
	}

	public double getTotal() {

		return mTerm * 0.4 + fTerm * 0.5 + pEval * 0.1;
	}

}
