package com.lexiang.file.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;


/**
 * 
 * @author wangle
 * @date 2019-1-30
 *
 */
public interface FileService{

	
	/**
	 * 
	 * @param request
	 * @param path
	 * @param ip
	 * @return 返回富文本上传的图片
	 */
    JSONObject ueUpload(HttpServletRequest request,String path,String ip,String port);
    
    
    /**
     * 
     * @param files
     * @param path
     * @param ip
     * @return 上传汇款凭证的图片集合
     */
    JSONObject fileUpload(MultipartFile[] files,String path,String ip,String port);
}
