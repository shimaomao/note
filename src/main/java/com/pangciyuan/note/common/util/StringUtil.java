package com.pangciyuan.note.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.alibaba.fastjson.JSON;

public class StringUtil {

	final static int BUFFER_SIZE = 4096;

	public static boolean isEmpty(String str) {
		if (str != null && str != "" && !str.equals("null") && str.length() > 0)
			return false;
		return true;
	}

	public static boolean isLong(String str) {
		boolean b = false;
		if (!isEmpty(str)) {
			try {
				Long.parseLong(str);
				b = true;
			} catch (Exception e) {
				// not is long
				System.out.println("this " + str + " not is long");
			}
		}
		return b;
	}

	public static boolean isJsonString(String str) {
		boolean b = false;
		if (!isEmpty(str)) {
			if (str.charAt(0) == '{' || str.charAt(0) == '[')
				try {
					JSON.parse(str);
					b = true;
				} catch (Exception e) {
					// not is long
					System.out.println("this " + str + " not is jsonString");
				}
		}
		return b;
	}

	public static boolean isInt(String str) {
		boolean b = false;
		if (!isEmpty(str)) {
			try {
				Integer.parseInt(str);
				b = true;
			} catch (Exception e) {
				// not is int
				System.out.println("this " + str + " not is int");
			}
		}
		return b;
	}

	public static String getJsonString(Object object) {
		String StringValue;
		if (object.getClass().equals(String.class))
			StringValue = String.valueOf(object);
		else
			StringValue = JSON.toJSONString(object);
		return StringValue;
	}

	/**
	 * 获取网址的最后一部分
	 * 
	 * @param url
	 * @return
	 */
	public static String getLastPartOfUrl(String url) {
		if (isEmpty(url))
			return "";
		if (url.lastIndexOf("/") == url.length() - 1)
			url = url.substring(0, url.length() - 1);
		return url.substring(url.lastIndexOf("/") + 1);
	}

	public static String InputStreamTOString(InputStream in, int count) {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		outStream.write(data, 0, count);
		data = null;
		try {
			return new String(outStream.toByteArray(), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static String InputStreamTOString(InputStream in) {

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		try {
			while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
				outStream.write(data, 0, count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		data = null;
		try {
			return new String(outStream.toByteArray(), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
