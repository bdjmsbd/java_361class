package day18.homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2820111516820421233L;

	@NonNull
	private String id;
	@NonNull
	private String name;

	private List<Schedule> schedules = new ArrayList<>();

	public void insertSchedules(Schedule newSchedule) {
		schedules.add(newSchedule);
	}

	public String str(String a, String b) {
		return a + b;
	}

	@Override
	public String toString() {

		return id + "(" + name + ")\n" + ((schedules.size()!=0)?(""+schedules):"[null]") +"\n";
	}

}
