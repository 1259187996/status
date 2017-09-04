/**
 * Created by zhizhuang.yang on 2017/9/4.
 */
public enum RespCode {

    SUCCESS("200", "成功"),

    DATA_NOT_EXIST("404","请求对象不存在"),

    SYSTEM_EXCEPTION("500", "系统异常"),

    QUERY_PARAM_ERROR("499", "查询参数有误"),

    LOGIN_USER_NOT_EXIST("501", "账号不存在"),

    LOGIN_PASSWORD_ERROR("502", "账号密码不正确"),

    REGISTEER_USER_EXIST("510", "注册账号已存在"),

    REGISTEER_USER_NOT_EXIST("511", "该账号尚未注册"),

    SMS_CODE_ERROR("513", "验证码错误"),

    MESSAGE_SEND_FAIL("512", "短信发送失败"),

    USER_UNLOGIN("514", "用户尚未登录");

    /**
     * @param returnCode
     * @param codeDesc
     */
    private RespCode(String returnCode, String codeDesc) {
        this.returnCode = returnCode;
        this.codeDesc = codeDesc;
    }

    /** 返回码 */
    private String returnCode;

    /** 返回码说明 */
    private String codeDesc;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }
}
