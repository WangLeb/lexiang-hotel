package com.lexiang.common.utill;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.alibaba.fastjson.JSON;
import com.lexiang.common.constants.Message;
import com.lexiang.common.constants.ResponseConstants;

/**
 * @description 封装response
 * @author 王乐
 * @date 2019-2-6
 */
public class RequestUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);

	/**
	 * 
	 * @param response response返回
	 * @param contentType 返回格式
	 * @param exception 捕捉的错误信息
	 * @param status 返回HTTP状态码
	 * @throws IOException 
	 */
	public static void sendFailRequst(HttpServletResponse response,String contentType,Exception exception,HttpStatus status) throws IOException {
		
		logger.info("登录失败");
		response.setContentType(ResponseConstants.COTENT_TYPE_UTF_8);
		response.getWriter().write(JSON.toJSONString(new Message().error("").addMeta("description", exception.getMessage())));
		response.setStatus(status.value());
		 
		
	}
	
	/**
	 * 
	 * @param response response返回
	 * @param contentType 返回格式
	 * @param content 用户的认证信息
	 * @throws IOException
	 */
	public static void sendSuccessRequst(HttpServletResponse response,HttpServletRequest reuquest,String contentType,Object content ) throws IOException {

        
		//String origin = reuquest.getHeader("Origin");
		logger.info("登录成功");
		
		//response.setHeader("Access-Control-Allow-Origin", origin);
		response.setContentType(ResponseConstants.COTENT_TYPE_UTF_8);
		response.getWriter().write(JSON.toJSONString(content));
		
	}

}
