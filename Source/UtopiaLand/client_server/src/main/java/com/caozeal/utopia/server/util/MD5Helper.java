package com.caozeal.utopia.server.util;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Helper {

	public static String encrypt(String str) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");

		md5.update(str.getBytes(Charset.forName("utf-8")));
		byte[] abResult = md5.digest();

		return byte2hex(abResult);
	}

	public static String byte2hex(byte[] data) {
		if (data == null) {
			return null;
		}
		return new String(Hex.encodeHex(data));
	}
}
