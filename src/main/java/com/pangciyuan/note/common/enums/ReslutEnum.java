package com.pangciyuan.note.common.enums;

public enum ReslutEnum {
	/**
	 * 成功
	 */
	SUCCESS(2000, "SUCCESS"),
	/**
	 * 参数格式化异常
	 */
	REQUEST_BODY_NOT_JSON(4101, "Invalid HTTP request "),
	/**
	 * 未登录
	 */
	NO_LOGIN(4102, "未登录"),
	/**
	 * 登录失败,用户名或密码错误
	 */
	LOGIN_ERROR(4102, "登录失败,用户名或密码错误"),

	;

	// 成员变量
	/**
	 * code
	 */
	private int code;
	/**
	 * msg
	 */
	private String msg;

	private ReslutEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
