package com.pangciyuan.note.common;

public class Constants {
	// jar 内部默认的配置文件路径
	public static final String CONFIG_INSIDE = "/properties/conf.properties";
	// jar 外部的配置文件默认路径
	public static final String CONFIG_OUTSIDE = "conf.properties";
	// 默认的jar内部的log4j 路径
	public static final String LOG4J_INSIDE = "/properties/log4j.properties";
	// 默认redis hashName
	public static final String REDIS_KEY = "VCS_REDIS";
	// 默认的http端口号码
	public static final String HTTP_PORT_DEF = "8083";
	// 默认的redis地址
	public static final String REDIS_HOST_DEF = "127.0.0.1";
	// 默认的redis端口号
	public static final String REDIS_PORT_DEF = "6379";
	// 默认的token——reids db索引
	public static final String REDIS_TOKEN_DEF = "4";
	// 默认的reids db索引
	public static final String REDIS_DB_DEF = "0";
	// config 里 redis_host 的key
	public static final String REDIS_HOST = "REDIS_HOST";
	// config 里 HTTP_PORT 的key
	public static final String HTTP_PORT = "HTTP_PORT";
	// config 里 REDIS_PORT 的key
	public static final String REDIS_PORT = "REDIS_PORT";
	// config 里 log4j_path 的key
	public static final String LOG4J_PATH = "LOG4J_PATH";
	// 静态资源地址
	public static final String STATIC_RESOURES = "/note/*";
	/* 注册登录页面请求接口 */

	// 验证用户是否已经存在
	public static final String CHECK_USERNAME = "/login/check/:userName";
	// 注册
	public static final String SIGN_UP = "/login/SignUp";
	// 登录
	public static final String SIGN_IN = "/login/SignIn";
	//退出登录
	public static final String SIGN_OUT = "/login/SignOut";
	// 获取登录信息
	public static final String GET_USER_BY_SIGN = "/user/signUser";
	/** 用户base */
	public static final String USER_INFO = "/user/info";
	public static final String USER_UPDATE_PWD="/user/pwd";

	// 笔记本base
	public static final String NOTE_BOOK = "/notej/notebook";
	// 删除笔记本
	public static final String NOTE_BOOK_DELETE = "/notej/notebook/:bookId";
	// 获取用户的笔记，根据笔记本
	public static final String GET_NOTE_LIST_BY_BOOKID = "/notej/note/:bookId";
	// 笔记base
	public static final String NOTE = "/notej/note";
	// 删除笔记
	public static final String NOTE_DELETE = "/notej/note/:noteId";
	//分享笔记
	public static final String SHARE_NOTE = "/notej/note/:noteId/share";
	//查看分享
	public static final String S_S = "/s/:uri";


}
