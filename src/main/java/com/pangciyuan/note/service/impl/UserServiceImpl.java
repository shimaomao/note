package com.pangciyuan.note.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pangciyuan.note.common.enums.ReslutEnum;
import com.pangciyuan.note.common.util.MD5Util;
import com.pangciyuan.note.mapper.NoteBookMapper;
import com.pangciyuan.note.mapper.UserInfoMapper;
import com.pangciyuan.note.model.NoteBook;
import com.pangciyuan.note.model.UserInfo;
import com.pangciyuan.note.model.UserInfoExample;
import com.pangciyuan.note.service.UserService;
import com.pangciyuan.note.vertx.Reslut;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private NoteBookMapper noteBookMapper;

    @Override
    public Reslut checkUserName(String userName) {
        UserInfoExample example = new UserInfoExample();
        example.or().andUserNameEqualTo(userName);
        // 如果等于0，返回true
        return new Reslut(userInfoMapper.countByExample(example) == 0);
    }

    @Override
    public Reslut signUp(UserInfo userInfo) {
        userInfo.setCreateTime(new Date());
        userInfo.setIsDelete(new Byte("0"));
        userInfo.setUserPassWord(MD5Util.encrypt(userInfo.getUserPassWord()));
        // 添加默认笔记本
        NoteBook record = new NoteBook();
        record.setCreateTime(new Date());
        record.setNoteBookType(1);
        record.setNoteBookName("默认笔记本");
        userInfoMapper.insertSelective(userInfo);
        UserInfoExample example = new UserInfoExample();
        example.or().andUserNameEqualTo(userInfo.getUserName());
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        record.setUserId(userInfos.get(0).getUserId());
        noteBookMapper.insertSelective(record);
        return new Reslut(true);
    }

    @Override
    public Reslut signIn(UserInfo userInfo) {
        UserInfoExample example = new UserInfoExample();
        example.or().andUserNameEqualTo(userInfo.getUserName())
                .andUserPassWordEqualTo(MD5Util.encrypt(userInfo.getUserPassWord()))
                .andIsDeleteNotEqualTo(new Byte("1"));
        List<UserInfo> selectByExample = userInfoMapper.selectByExample(example);
        if (selectByExample.size() == 1) {
            // 登录成功
            userInfo = selectByExample.get(0);
            return new Reslut(userInfo.getUserId());
        }
        return new Reslut(ReslutEnum.LOGIN_ERROR, false);
    }

    @Override
    public Reslut getUserById(Integer userId) {
//         userId =12;
        return new Reslut(userInfoMapper.selectByPrimaryKey(userId));
    }

    @Override
    public Reslut updateUserById(UserInfo user) {
//         user.setUserId(12);
        return new Reslut(userInfoMapper.updateByPrimaryKeySelective(user));
    }

    @Override
    public Reslut updatePwd(Integer userId, JSONObject requestData) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if (MD5Util.encrypt(requestData.getString("oldPwd")).equals(userInfo.getUserPassWord())) {
            // 修改密码
            userInfo.setUserPassWord(MD5Util.encrypt(requestData.getString("newPwd")));
            return new Reslut(userInfoMapper.updateByPrimaryKeySelective(userInfo));
        } else {
            return new Reslut(4010, "原密码错误！本次操作已记录在案！", false);
        }
    }

}
