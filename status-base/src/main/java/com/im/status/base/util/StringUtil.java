package com.im.status.base.util;

/**
 * @author zhizhuang.yang
 * @date 2017年9月13日
 * @version 1.0.0
 * @description 字符串工具类
 */
public class StringUtil {
    private static final int INDEX_NOT_FOUND = -1;
    private static final String EMPTY = "";
    private static final int PAD_LIMIT = 8192;



    /**
     * 如果字符串没有超过最长显示长度返回原字符串，否则从开头截取指定长度并加...返回
     * @param str
     * @param length
     * @return
     */
    public static String limitLengthString(String str, int length) {
        if (str == null) {
            return "";
        } else if (str.length() > length) {
            if(length<3){
                return str.substring(0, length);
            }
            return str.substring(0, length - 3) + "...";
        } else {
            return str;
        }
    }

    /**
     * 功能：切换字符串中的所有字母大小写(大小写互换)
     * @param str
     * @return
     */
    public static String swapCase(String str) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        char[] buffer = str.toCharArray();

        boolean whitespace = true;

        for (int i = 0; i < buffer.length; i++) {
            char ch = buffer[i];
            if (Character.isUpperCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
                whitespace = false;
            } else if (Character.isTitleCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
                whitespace = false;
            } else if (Character.isLowerCase(ch)) {
                if (whitespace) {
                    buffer[i] = Character.toTitleCase(ch);
                    whitespace = false;
                } else {
                    buffer[i] = Character.toUpperCase(ch);
                }
            } else {
                whitespace = Character.isWhitespace(ch);
            }
        }
        return new String(buffer);
    }

    /**
     * 截取一个字符串的前几个
     * @param str
     * @param len
     * @return
     */
    public static String left(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(0, len);
    }
    /**
     * 从右边截取字符串.（取手机号后4位）
     * @param str
     * @param len
     * @return
     */
    public static String right(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(str.length() - len);
    }
    /**
     * 反转字符串
     * @param str
     * @return
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }
    /**
     * 检查是否都是大写.
     *
     * @param cs
     * @return
     */
    public static boolean isAllUpperCase(String cs) {
        if (cs == null || StringUtil.isEmpty(cs)) {
            return false;
        }
        int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isUpperCase(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查字符串是否全部为小写
     *
     * @param cs
     * @return
     */
    public static boolean isAllLowerCase(String cs) {
        if (cs == null || isEmpty(cs)) {
            return false;
        }
        int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isLowerCase(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 移除指定结尾的子字符串
     *
     * @param str
     * @param remove
     * @return
     */
    public static String removeEnd(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (str.endsWith(remove)) {
            return str.substring(0, str.length() - remove.length());
        }
        return str;
    }

    /**
     * 判断字符串非空
     *
     * @param chkStr
     * @return
     */
    public static boolean isEmpty(String chkStr) {
        if (chkStr == null) {
            return true;
        } else {
            return "".equals(chkStr.trim()) ? true : false;
        }
    }
}
