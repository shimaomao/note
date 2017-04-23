package com.pangciyuan.note.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pangciyuan.note.common.enums.ReslutEnum;
import com.pangciyuan.note.common.util.StringUtil;
import com.pangciyuan.note.model.UserInfo;
import com.pangciyuan.note.service.UserService;
import com.pangciyuan.note.vertx.Reslut;
import com.pangciyuan.note.vertx.Send;

import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Session;

@Service
public class UserFacade {

	@Autowired
	private UserService userService;

	public void checkUserName(RoutingContext context) {
		Send.send(context, userService.checkUserName(context.request().getParam("userName")));
	}

	public void signUp(RoutingContext context) {
		String jsonStr = context.getBodyAsString();
		UserInfo user = JSONObject.parseObject(jsonStr, UserInfo.class);
		Send.send(context, userService.signUp(user));
	}

	public void signOut(RoutingContext context) {
		context.session().destroy();
		Send.send(context, new Reslut(true));
	}

	public void signIn(RoutingContext context) {
		String jsonStr = context.getBodyAsString();
		if (StringUtil.isEmpty(jsonStr)) {
			Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON));
			return;
		}
		UserInfo user = JSONObject.parseObject(jsonStr, UserInfo.class);
		Session session = context.session();
		Reslut signIn = userService.signIn(user);
		if (signIn.getCode().equals(ReslutEnum.SUCCESS.getCode())) {
			session.put("userId", signIn.getData());
			signIn.setData(true);
		}
		Send.send(context, signIn);
	}

	public void getUserSign(RoutingContext context) {
		Session session = context.session();
		Integer userId = session.get("userId");
//		userId = 5;
		if (userId == null)
			Send.send(context, new Reslut(false));
		else
			Send.send(context, userService.getUserById(userId));
	}

	public void updateUser(RoutingContext context) {
		Session session = context.session();
		String body = context.getBodyAsString();
		if (StringUtil.isEmpty(body)) {
			Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON));
			return;
		}
		try {
			String jsonStr = context.getBodyAsString();
			UserInfo user = JSONObject.parseObject(jsonStr, UserInfo.class);
			user.setUserId(session.get("userId"));
			Send.send(context, userService.updateUserById(user));
		} catch (Exception e) {
			Send.send(context, new Reslut(ReslutEnum.REQUEST_BODY_NOT_JSON));
		}
	}

	public void updatePwd(RoutingContext context) {
		Session session = context.session();
		Integer userId = session.get("userId");
//		userId=5;
		String jsonStr = context.getBodyAsString();
		Send.send(context, userService.updatePwd(userId, JSONObject.parseObject(jsonStr)));
	}

}
