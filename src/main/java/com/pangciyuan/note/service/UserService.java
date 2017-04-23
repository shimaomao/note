package com.pangciyuan.note.service;

import com.alibaba.fastjson.JSONObject;
import com.pangciyuan.note.model.UserInfo;
import com.pangciyuan.note.vertx.Reslut;

public interface UserService {
	/**
	 * 验证用户名是否重复
	 * 
	 * @param userName
	 * @return
	 */
	Reslut checkUserName(String userName);

	/**
	 * 注册
	 * 
	 * @param userName
	 * @return
	 */
	Reslut signUp(UserInfo userInfo);

	/**
	 * 登录
	 * 
	 * @param userInfo
	 * @return
	 */
	Reslut signIn(UserInfo userInfo);

	/**
	 * 查找用户
	 */
	Reslut getUserById(Integer userId);

	/**
	 * 更新用户
	 * 
	 * @param userId
	 * @return
	 */
	Reslut updateUserById(UserInfo user);
	
	/**
	 * 修改密码
	 */
	Reslut updatePwd(Integer userId,JSONObject requestData);

}
