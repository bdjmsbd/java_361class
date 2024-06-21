package day17;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class E_Point implements Serializable {

	/**
	 * 이름이 같은 클래스여도 serialVersionUID가 다르면 읽어오지 못함
	 */
	private static final long serialVersionUID = -7073881827606857457L;

	private int x, y;
	
	// file IO할 때 값을 가져오지도 읽지도 않을거야
	transient int i;

}
