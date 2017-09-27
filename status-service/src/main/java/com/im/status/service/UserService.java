package com.im.status.service;

import com.im.status.base.exception.StatusException;
import com.im.status.base.model.RespModel;
import com.im.status.model.request.RegisterParam;
import com.im.status.model.response.LoginResp;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhizhuang.yang on 2017/9/12.
 */
public interface UserService {


    public RespModel<String> register(RegisterParam registerParam)throws StatusException;

    public RespModel<String> sendCode(String userName,String type)throws StatusException;

    public RespModel<LoginResp> login(String username, String password, HttpServletRequest request)throws StatusException;

    public void logout(String token)throws StatusException;
}
