package com.pangciyuan.note.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtils {
	private static ApplicationContext context = null;

	public static ApplicationContext getContext() {
		if (context == null)
			synchronized (ApplicationContextUtils.class) {
				if (context == null)
					context = new ClassPathXmlApplicationContext(new String[] { "config/application-config.xml" });
			}
		return context;
	}
}
