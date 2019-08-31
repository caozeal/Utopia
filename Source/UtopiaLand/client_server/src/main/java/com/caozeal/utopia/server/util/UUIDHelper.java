package com.caozeal.utopia.server.util;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author baon
 * @date 2010-1-25
 */
public class UUIDHelper {
	
	private static final Logger logger = LoggerFactory.getLogger(UUIDHelper.class);

	/**
	 * 得到uuid
	 * 
	 * @return
	 */
	public static String getUuid() {
		try {
			UUID uuid = UUID.randomUUID();
			return MD5Helper.encrypt(uuid.toString());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return "";
	}

	public static String digest(String s) {
		try {
			return MD5Helper.encrypt(s);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return "";
	}

	public static String byte2hex(byte[] data) {
		return MD5Helper.byte2hex(data);
	}

	public static char[] encodeHex(byte[] data) {
		return Hex.encodeHex(data);
	}
}
