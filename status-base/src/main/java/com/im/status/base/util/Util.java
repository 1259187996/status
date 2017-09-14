package com.im.status.base.util;

import java.util.Random;
import java.util.UUID;

/**
 * @author zhizhuang.yang
 * @version 1.0.0
 * @date 2017年9月13日
 * @description 基础工具类
 */
public class Util {

    //生成验证码
    public static String getMessageCode(){
        Random random = new Random();
        return String.valueOf(100000+random.nextInt(899999));
    }

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.print(getUUID());
    }

}
