package com.im.status.controller;

import com.im.status.base.constants.Const;
import com.im.status.base.logger.StatusLogger;
import com.im.status.base.model.Page;
import com.im.status.base.model.RespCode;
import com.im.status.base.model.RespModel;
import com.im.status.base.util.JsonUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * BaseController
 * 基础的Controller
 * @author yang.zhizhuang
 */
public class BaseController {

    private StatusLogger logger = StatusLogger.getLogger(BaseController.class);


    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        return request;
    }

    /**
     * 成功方法,直接返回数据
     * @param response
     * @param data
     */
    protected <T>void success(HttpServletResponse response, T data) {
        RespModel<T> respModel = new RespModel<>();
        respModel.setRespCode(RespCode.SUCCESS.getReturnCode());
        respModel.setRespDesc(RespCode.SUCCESS.getCodeDesc());
        respModel.setRespData(data);
        this.writeResponse(response,respModel);
    }

    /**
     * 成功方法,直接返回数据（带分页）
     * @param response
     * @param data
     * @param page
     */
    protected <T>void success(HttpServletResponse response, T data, Page page) {
        RespModel<T> respModel = new RespModel<>();
        respModel.setRespCode(RespCode.SUCCESS.getReturnCode());
        respModel.setRespDesc(RespCode.SUCCESS.getCodeDesc());
        respModel.setPage(page);
        respModel.setRespData(data);
        this.writeResponse(response,respModel);
    }

    /**
     * 成功方法,直接返回数据
     * @param response
     * @param respModel
     */
    protected <T>void writeResponse(HttpServletResponse response, RespModel<T> respModel) {
        response.setContentType(Const.JSON_CONTENT_TYPE);
        try {
            String returnStr = JsonUtils.entityToJSON(respModel).toString();
            logger.info(returnStr);
            response.getWriter().write(returnStr);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    /**
     * 失败方法，赋予respModel失败值
     * 整体异常，无法判断时
     * @param respModel
     * @param error_message
     */
    protected void failed(RespModel respModel, String error_message) {
        respModel.setRespCode(RespCode.SYSTEM_EXCEPTION.getReturnCode());
        respModel.setRespDesc(RespCode.SYSTEM_EXCEPTION.getCodeDesc()+error_message);
    }

    /**
     * 失败方法，赋予respModel失败值
     * 知道具体异常情况时
     * @param respModel
     * @param respCode
     */
    protected void failed(RespModel respModel, RespCode respCode) {
        respModel.setRespCode(respCode.getReturnCode());
        respModel.setRespDesc(respCode.getCodeDesc());
    }


}
