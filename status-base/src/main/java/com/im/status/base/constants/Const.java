package com.im.status.base.constants;

/**
 * @description 常量类
 * @author zhizhuang.yang
 * @date 2017-9-4 13:29:02
 * @version 1.0.0
 */
public class Const {

    public static final String JSON_CONTENT_TYPE = "application/json;charset=UTF-8";			//返回数据编码类型
    public static final String SMS_SIGN_NAME = "Yzz云";											//短信签名
    public static final String SMS_TEMPLATE_CODE = "SMS_65125092";								//短信模板码
    public static final String SMS_APP_KEY = "24621813";										//短信App key
    public static final String SMS_APP_SECRET = "29e8f2ca4135f5e0167606ccba5d7217";				//短信app secret
    public static final String SMS_URL = "http://gw.api.taobao.com/router/rest";				//短信地址
    public static final String MESSAGE_TYPE_REGISTER = "register";								//注册时发送验证码
    public static final String MESSAGE_TYPE_FORGET = "forget";									//忘记密码时发送验证码
    public static final int MESSAGE_OUT_TIME = 1800;											//验证码过期时间
    public static final String MD5_DEFAULT_SALT = "status";                                     //MD5加密默认盐值


}
