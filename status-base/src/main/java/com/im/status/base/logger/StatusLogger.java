package com.im.status.base.logger;

import org.apache.log4j.Logger;

/**
 * Created by zhizhuang.yang on 2016/11/14.
 */
public class StatusLogger {

	private Logger logger;

	
	/**
	 * 构造方法，初始化Log4j的日志对象
	 */
	private StatusLogger(Logger log4jLogger) {
		logger = log4jLogger;
	}

	/**
	 * 获取构造器，根据类初始化Logger对象
	 * 
	 * @param classObject Class对象
	 * @return Logger对象
	 */
	public static StatusLogger getLogger(Class classObject) {
		return new StatusLogger(Logger.getLogger(classObject));
	}

	/**
	 * 获取构造器，根据类名初始化Logger对象
	 * 
	 * @param loggerName 类名字符串
	 * @return Logger对象
	 */
	public static StatusLogger getLogger(String loggerName) {
		return new StatusLogger(Logger.getLogger(loggerName));
	}

	public void debug(Object object) {
		logger.debug(object);
	}

	public void debug(Object object, Throwable e) {
		logger.debug(object, e);
	}

	public void info(Object object) {
		logger.info(object);
	}

	public void info(Object object, Throwable e) {
		logger.info(object, e);
	}

	public void warn(Object object) {
		logger.warn(object);
	}

	public void warn(Object object, Throwable e) {
		logger.warn(object, e);
	}

	public void error(Object object) {
		logger.error(object);
	}

	public void error(Object object, Throwable e) {
		logger.error(object, e);
	}

	public void fatal(Object object) {
		logger.fatal(object);
	}

	public String getName() {
		return logger.getName();
	}

	public Logger getLog4jLogger() {
		return logger;
	}

	public boolean equals(StatusLogger newLogger) {
		return logger.equals(newLogger.getLog4jLogger());
	}
}