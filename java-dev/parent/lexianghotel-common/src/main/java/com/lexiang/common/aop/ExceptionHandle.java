package com.lexiang.common.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lexiang.common.constants.Message;
/**
 * <p>
 *  自定义监听处理全局错误
 * </p>
 *
 * @author 王乐
 * @since 2019-03-24
 */


@RestControllerAdvice
public class ExceptionHandle {

	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Message handle(Exception e) {
		logger.info("dssdasdasdasd");
		logger.info("全局捕捉的失败信息为【"+e.toString()+"】");
		//e.printStackTrace();
		return new Message().error("").addMeta("message", e.getMessage());
	}

}
