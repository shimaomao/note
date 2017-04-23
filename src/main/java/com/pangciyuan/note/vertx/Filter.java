package com.pangciyuan.note.vertx;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pangciyuan.note.common.enums.ReslutEnum;
import com.pangciyuan.note.common.util.StringUtil;

import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Session;

@Service
public class Filter {
	private Logger log = Logger.getLogger(Filter.class);

	void verifyData(RoutingContext context) {
		String body = context.getBodyAsString();
		if (!StringUtil.isEmpty(body) && !StringUtil.isJsonString(body)) {

			Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON));
			return;
		}
		context.next();
	}

	void verifySession(RoutingContext context) {
		Session session = context.session();
		String userId = session.get("userId");
		if (StringUtil.isEmpty(userId)) {
			log.info("未登录，请求无效");
			Send.send(context, new Reslut(ReslutEnum.NO_LOGIN));
		}
		context.next();

	}

}
