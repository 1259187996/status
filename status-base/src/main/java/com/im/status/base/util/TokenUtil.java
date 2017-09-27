package com.im.status.base.util;

import com.im.status.base.encryption.MD5Util;

/**
 * Created by zhizhuang.yang on 2017/9/27.
 */
public class TokenUtil {

    /**
     * 根据用户id生成一个Token令牌
     * @param userId
     * @return
     */
    public static String getToken(String userId){
        return MD5Util.MD5(userId).toUpperCase();
    }

}
