package day20;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class A_IpEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			InetAddress address = InetAddress
					.getByName("www.naver.com"); // .getByName("localhost");
			System.out.println(address);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			InetAddress address = InetAddress
					.getByName("www.naver.com");
			System.out.println(address);
			
			InetAddress [] list = InetAddress.getAllByName("www.naver.com");
			System.out.println(Arrays.toString(list));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
