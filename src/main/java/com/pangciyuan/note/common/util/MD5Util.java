package com.pangciyuan.note.common.util;

/**
 * ********************************************** md5 类实现了RSA Data Security,
 * Inc.在提交给IETF 的RFC1321中的MD5 message-digest 算法。
 * ***********************************************
 */
public class MD5Util {
	public static String encrypt(String str) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(str.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
	
}
