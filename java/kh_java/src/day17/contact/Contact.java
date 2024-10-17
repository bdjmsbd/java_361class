package day17.contact;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact implements Serializable {

	/**
	 * 파일 입출력을 받을 것이기에 serializable 구현
	 */

	private static final long serialVersionUID = -679919533951862214L;
	private String number;
	private String name;

	@Override
	public String toString() {
		return name + " : " + number;
	}

}
