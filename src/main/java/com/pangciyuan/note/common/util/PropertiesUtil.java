package com.pangciyuan.note.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.pangciyuan.note.App;
import com.pangciyuan.note.common.Constants;

public class PropertiesUtil {

	private static final Logger log = Logger.getLogger(PropertiesUtil.class);

	public static Properties getProperties(String fileDir) {
		Properties prop = null;
		if (prop == null) {
			prop = new Properties();
			try {
				InputStream stream = App.class.getResourceAsStream(fileDir);
				if (stream != null)
					prop.load(stream);
				else {
					log.error("getProperties error , " + fileDir + " not fand");
					return null;
				}
			} catch (FileNotFoundException e) {
				System.out.println(fileDir + " not found");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println(fileDir + " load error");
				e.printStackTrace();
			}
		}
		return prop;
	}

	public static Properties getProperties() {
		return getProperties(Constants.CONFIG_OUTSIDE) != null ? getProperties(Constants.CONFIG_OUTSIDE)
				: getProperties(Constants.CONFIG_INSIDE);
	}

	public static Integer getIntPropertie(String key, String def) {
		return Integer.parseInt(getProperties().getProperty(key, def));
	}

	public static String getPropertie(String key, String def) {
		return getProperties().getProperty(key, def);
	}

	public static String getPropertie(String fileDir, String key, String def) {
		return getProperties(fileDir).getProperty(key, def);
	}

	public static int getIntPropertie(String fileDir, String key, String def) {
		return Integer.parseInt(getProperties(fileDir).getProperty(key, def));
	}
}
