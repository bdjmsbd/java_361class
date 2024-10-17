package account;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2160513585203484996L;
	// 날짜 : 2024-06-10
	// 수입/지출 : `수입 // expenses and income
	// 분류 (월급, 용돈, 부수입): `월급
	// 금액 : `3000000
	// 내용 : `6월 월급
	private String date;
	private String type;
	private String group;
	private int amount;
	private String memo;

	@Override // 날짜, 타입, 분류가 같으면 같은 것.
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountBook other = (AccountBook) obj;
		return Objects.equals(date, other.date) && Objects.equals(group, other.group) && Objects.equals(type, other.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, group, type);
	}

	@Override
	public String toString() {
		return date + " | " + type + " | " + group + " | " + amount + " | " + memo;
	}

}
