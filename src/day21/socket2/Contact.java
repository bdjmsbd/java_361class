package day21.socket2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact {

	private String number;
	private String name;

	@Override
	public String toString() {
		return name + " : " + number;
	}

}


