package day18.homework;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Schedule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -723161367245908008L;
	private String date;
	private String content;
	private String details;
	@Override
	public String toString() {
		return date + " : " + content
				+ "(" + details + ")";
	}

	
}
