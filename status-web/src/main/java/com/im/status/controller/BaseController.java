package com.im.status.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * BaseController
 * 基础的Controller
 * @author yang.zhizhuang
 * @version $Id: RequestParamUtils.java, v 1.0 2016-12-29
 */
public class BaseController {

        private Logger logger = Logger.getLogger(BaseController.class);

        protected void writerResponse(HttpServletResponse response, Object params) {
            response.setContentType(Const.JSON_CONTENT_TYPE);
            try {
                String returnStr = entityToJSON(params).toString();
                logger.info(returnStr);
                response.getWriter().write(returnStr);
            } catch (IOException e) {
                logger.error(e);
            }
        }

        /**
         * 实体的值转成Map对象的值(不带斜杠)
         *
         * @param source
         */
        public static Map<String, Object> entityToMap(Object source) {
            Map<String, Object> dest = new HashMap<String, Object>();

            Class clzss = source.getClass();

            dest = doEntityToMap(source,clzss,dest);

            return dest;
        }

        protected <T> T getJsonRequestCapital(HttpServletRequest request, Class<T> clazz) {

            JSONObject json = getParam(request);
            try {
                return jsonToEntity(json, clazz);
            } catch (Exception e) {
                // TODO: handle exception
                logger.error(e);
                return null;
            }

        }

        /**
         * Request转成JSON对象的值(不带斜杠)
         *
         * @param source
         */
        @SuppressWarnings("unchecked")
        public static JSONObject getParam(HttpServletRequest request) {
            Map<String,Object> map = request.getParameterMap();

            JSONObject dest = JSONObject.fromObject(map);

            return dest;
        }

        /**
         * JSON对象的值转成实体的值
         *
         * @param source
         */
        @SuppressWarnings("unchecked")
        public static <T> T jsonToEntity(JSONObject source,Class<T> clazz)throws Exception {
            return (T) JsonUtils.readJSON2Object(source.toString(), clazz);
        }

        /**
         * 实体的值转成JSON对象的值(不带斜杠)
         *
         * @param source
         */
        public static JSONObject entityToJSON(Object source) {
            JSONObject dest = new JSONObject();

            Class clzss = source.getClass();

            dest = doEntityToJSON(source,clzss,dest);

            return dest;
        }

        /**
         * 递归执行实体转换JSON
         * @param source
         * @param clzss
         * @param dest
         * @return
         */
        public static JSONObject doEntityToJSON(Object source,Class clzss,JSONObject dest){
            Field[] fields = clzss.getDeclaredFields();
            if(fields.length==0){
                try{
                    if(clzss.getSuperclass().getDeclaredFields().length==0)
                        return dest;
                }catch (Exception e){
                    return dest;
                }
            }
            try {
                for (Field field : fields) {
                    dest.put(field.getName(), getFieldValue(source,clzss, field.getName()));
                }
                dest = doEntityToJSON(source,clzss.getSuperclass(),dest);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return dest;
        }

        /**
         * 递归执行实体转换Map
         * @param source
         * @param clzss
         * @param dest
         * @return
         */
        public static Map<String,Object> doEntityToMap(Object source,Class clzss,Map<String,Object> dest){
            Field[] fields = clzss.getDeclaredFields();
            if(fields.length==0){
                try{
                    if(clzss.getSuperclass().getDeclaredFields().length==0)
                        return dest;
                }catch (Exception e){
                    return dest;
                }
            }
            try {
                for (Field field : fields) {
                    dest.put(field.getName(), getFieldValue(source,clzss, field.getName()));
                }
                dest = doEntityToMap(source,clzss.getSuperclass(),dest);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return dest;
        }

        /**
         * 获取字段的值
         *
         * @param fieldName
         * @return
         */
        public static Object getFieldValue(Object source,Class clzss, String fieldName) {

            StringBuilder sb = new StringBuilder();

            //将字段首字母大写
            String firstWord = fieldName.substring(0, 1).toUpperCase();
            sb.append(firstWord);
            sb.append(fieldName.substring(1, fieldName.length()));

            final String methodName = "get" + sb.toString();

            Method[] methods = clzss.getDeclaredMethods();
            try {
                for (Method method : methods) {
                    // 调用对应的方法
                    if (methodName.equals(method.getName())) {
                        return method.invoke(source, new Object[]{});
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return null;

        }

        /**
         * 赋予字段的值
         *
         * @param fieldName
         * @return
         */
        public static void setFieldValue(Class clzss, String fieldName,Object fieldValue) {

            StringBuilder sb = new StringBuilder();

            //将字段首字母大写
            String firstWord = fieldName.substring(0, 1).toUpperCase();
            sb.append(firstWord);
            sb.append(fieldName.substring(1, fieldName.length()));

            final String methodName = "set" + sb.toString();

            Method[] methods = clzss.getDeclaredMethods();
            try {
                for (Method method : methods) {
                    // 调用对应的方法
                    if (methodName.equals(method.getName())) {
                        method.invoke(clzss,fieldValue);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        /**
         * 得到request对象
         */
        public HttpServletRequest getRequest() {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            return request;
        }

        public static void logBefore(Logger logger, String interfaceName){
            logger.info(interfaceName+" start");
        }

        public static void logAfter(Logger logger){
            logger.info("end");
        }

        protected void failed(Result result,String error_message) {
            result.setCode(RespCode.SYSTEM_EXCEPTION.getReturnCode());
            result.setMsg(RespCode.SYSTEM_EXCEPTION.getCodeDesc()+error_message);
        }


}
