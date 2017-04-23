package com.pangciyuan.note.vertx;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

import io.vertx.ext.web.RoutingContext;

public class Send {
	private static final Logger log = Logger.getLogger(Send.class);

	// 发送响应
	public static void send(RoutingContext context, Reslut reslut) {
		// 请求地址
		log.info("本次请求处理完成，返回处理结果");
		log.info("请求路径 url:" + context.request().absoluteURI());
		log.info("请求参数 body:" + context.getBodyAsString());
		log.info("请求方法 method:" + context.request().method().name());
		log.info("请求token  token:" + context.request().getHeader("token"));
		if (reslut == null)
			reslut = new Reslut();
		context.response().putHeader("content-type", "application/json").end(JSON.toJSONString(reslut));
		log.info("返回数据 reslut:" + JSON.toJSONString(reslut));

	}
}
