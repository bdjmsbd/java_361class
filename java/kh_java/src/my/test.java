package my;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import lombok.Data;

public class test {

	public static void main(String[] args) {
//		p p = new p();
//		System.out.println(p.s);
//		ArrayList<po> p = new ArrayList<po>();
//		p.add(new po("h"));
//		System.out.println(p.get(0));
//		String a = po.AOS;
//		System.out.println(a);
//		po.AOS = "gh";
//		System.out.println(po.AOS);


		try {
			FileWriter fw = new FileWriter("src/my/data.txt");
//			fw.write(97);
//			fw.write(65);
//			fw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

@Data
class po {

	public static String AOS = "oo";

	String s;

	@Override
	public String toString() {
		return "p [s=" + s + "]";
	}

	po(String s) {
		this.s = s;

	}

}
