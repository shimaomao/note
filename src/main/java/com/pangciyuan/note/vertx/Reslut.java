package com.pangciyuan.note.vertx;

import com.pangciyuan.note.common.enums.ReslutEnum;

public class Reslut {

	private Integer code;
	private String msg;
	private Object data;

	public Reslut() {
		this.code = ReslutEnum.SUCCESS.getCode();
		this.msg = ReslutEnum.SUCCESS.getMsg();
		this.data = new Object();
	}

	public Reslut(Object object) {
		this.code = ReslutEnum.SUCCESS.getCode();
		this.msg = ReslutEnum.SUCCESS.getMsg();
		this.data = object;
	}

	public Reslut(ReslutEnum reslutEnum) {
		this.code = reslutEnum.getCode();
		this.msg = reslutEnum.getMsg();
		this.data = new Object();
	}

	public Reslut(ReslutEnum reslutEnum, Object object) {
		this.code = reslutEnum.getCode();
		this.msg = reslutEnum.getMsg();
		this.data = object;
	}

	public Reslut(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
		this.data = new Object();
	}

	public Reslut(Integer code, String msg, Object object) {
		this.code = code;
		this.msg = msg;
		this.data = object;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
