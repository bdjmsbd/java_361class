package day17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F_ObjectStreamEx01 {

	public static void main(String[] args) {

		String fileName = "src/day17/objectStream.txt";
		List<E_Point> points = Arrays.asList(
				new E_Point(1, 10, 1),
				new E_Point(3, 3, 2),
				new E_Point(5, 5, 3),
				new E_Point(10, 5, 4));

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(fileName))) {
			for (E_Point tmp : points) {
				oos.writeObject(tmp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<E_Point> points2 = new ArrayList<E_Point>();

		try (
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(
						fis)) {
			E_Point tmp;

			do {
				tmp = (E_Point) ois.readObject();
				if (tmp != null) {
					points2.add(tmp);
				}
			} while (tmp != null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(points2);
	}

}
