package com.im.status.base.exception;

import com.im.status.base.model.RespCode;
import com.im.status.base.model.RespModel;

import java.io.Serializable;

/**
 * Created by zhizhuang.yang on 2017/9/12.
 */
public class StatusException extends Exception implements Serializable{

    private static final long serialVersionUID = 1L;

    private RespCode respCode;

    public StatusException(RespModel respModel, String error_message){
        super(error_message);
        this.respCode.setReturnCode(RespCode.SYSTEM_EXCEPTION.getReturnCode());
        this.respCode.setCodeDesc(RespCode.SYSTEM_EXCEPTION.getCodeDesc()+":"+error_message);
    }

    public StatusException(RespModel respModel, RespCode respCode){
        super(respCode.getCodeDesc());
        this.respCode = respCode;
    }

    public RespCode getRespCode() {
        return respCode;
    }

    public void setRespCode(RespCode respCode) {
        this.respCode = respCode;
    }
}
