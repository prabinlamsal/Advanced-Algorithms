package advanced;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.util.*;

public class GenMD5 {

	Scanner sc;
	MessageDigest md;
	
	public void generateMD5() throws NoSuchAlgorithmException {
		sc = new Scanner(System.in);
		md = MessageDigest.getInstance("MD5");
		String org = sc.next();
		md.update(org.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		System.out.println(sb.toString());
		sc.close();
	}
	
	public static void main(String[] args) throws IOException, Exception {		
		GenMD5 md5 = new GenMD5();
		md5.generateMD5();
	}

}
