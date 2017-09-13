package com.im.status.service;

import com.im.status.base.model.RespModel;
import com.im.status.base.model.StatusException;
import com.im.status.model.request.RegisterParam;

/**
 * Created by zhizhuang.yang on 2017/9/12.
 */
public interface UserService {


    public String register(RegisterParam registerParam)throws StatusException;

    public RespModel<String> sendCode(String userName,String type)throws StatusException;


}
