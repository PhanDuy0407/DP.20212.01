package helper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import utils.Utils;

public class Security {
	private static Security single_instance = null;

	// variable of type String
	public String s;

	// private constructor restricted to this class itself
	private Security() {
	}

	// static method to create instance of Singleton class
	public static Security getInstance() {
		if (single_instance == null)
			single_instance = new Security();

		return single_instance;
	}

	public String md5Encryption(String message) {
		String digest = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hash = md.digest(message.getBytes(StandardCharsets.UTF_8));
			// converting byte array to Hexadecimal String
			StringBuilder digestSB = new StringBuilder(2 * hash.length);
			for (byte b : hash) {
				digestSB.append(String.format("%02x", b & 0xff));
			}
			digest = digestSB.toString();
		} catch (NoSuchAlgorithmException ex) {
			Utils.getLogger(Utils.class.getName());
			digest = "";
		}
		return digest;
	}
}
